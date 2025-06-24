package com.cs.cakeshop.service.serviceImpl;

import com.cs.cakeshop.Dto.GetAllUserDto;
import com.cs.cakeshop.Dto.UserRegistrationDto;
import com.cs.cakeshop.bcrypt.BcryptEncoderConfig;
import com.cs.cakeshop.entity.Users;
import com.cs.cakeshop.repository.UsersRepository;
import com.cs.cakeshop.service.UsersService;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final BcryptEncoderConfig passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository,
                            BcryptEncoderConfig passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Users createUser(UserRegistrationDto userData) throws BadRequestException {
        // Validate email uniqueness
        if (usersRepository.existsByEmail(userData.getEmail())) {
            logger.error("Email already registered: {}", userData.getEmail());
            throw new BadRequestException("Email already registered: " + userData.getEmail());
        }

        // Create new user
        Users user = new Users();
        user.setName(userData.getName());
        user.setEmail(userData.getEmail());
        user.setPassword(passwordEncoder.encode(userData.getPassword()));

        // Set creation timestamp
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        user.setCreatedAt(now.format(formatter));

        // Set default role if not provided
        user.setRole(userData.getRole() != null ? userData.getRole() : "ROLE_USER");

        // Generate and set user ID
        user.setUserRepository(usersRepository); // Needed for ID generation

        return usersRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GetAllUserDto> getAllUsers() {
        return usersRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private GetAllUserDto convertToDto(Users user) {
        return new GetAllUserDto(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }

    @Override
    @Transactional
    public void updateUser(String userId, UserRegistrationDto userRegistrationDto) {
        Users user = usersRepository.findByUserId(userId);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "User not found with ID: " + userId);
        }

        // Update name if provided
        if (userRegistrationDto.getName() != null &&
                !userRegistrationDto.getName().isEmpty()) {
            user.setName(userRegistrationDto.getName());
        }

        // Update role if provided
        if (userRegistrationDto.getRole() != null &&
                !userRegistrationDto.getRole().isEmpty()) {
            user.setRole(userRegistrationDto.getRole());
        }

        // Update password if provided
        if (userRegistrationDto.getPassword() != null &&
                !userRegistrationDto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        }

        usersRepository.save(user);
    }
}
