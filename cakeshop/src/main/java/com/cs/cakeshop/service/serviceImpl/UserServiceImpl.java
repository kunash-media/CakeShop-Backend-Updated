package com.cs.cakeshop.service.serviceImpl;

import com.cs.cakeshop.Dto.request.UserRequestDto;
import com.cs.cakeshop.Dto.response.UserResponseDto;
import com.cs.cakeshop.entity.UserEntity;
import com.cs.cakeshop.repository.UserRepository;
import com.cs.cakeshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userRequestDto.getName());
        userEntity.setEmail(userRequestDto.getEmail());
        userEntity.setMobileNumber(userRequestDto.getMobileNumber());
        userEntity.setPassword(userRequestDto.getPassword());
        userEntity.setRole(userRequestDto.getRole());

        UserEntity savedUser = userRepository.save(userEntity);
        return convertToResponseDto(savedUser);
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        return convertToResponseDto(userEntity);
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return convertToResponseDto(userEntity);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        userEntity.setName(userRequestDto.getName());
        userEntity.setEmail(userRequestDto.getEmail());
        userEntity.setMobileNumber(userRequestDto.getMobileNumber());
        userEntity.setPassword(userRequestDto.getPassword());
        userEntity.setRole(userRequestDto.getRole());

        UserEntity updatedUser = userRepository.save(userEntity);
        return convertToResponseDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        userRepository.deleteById(userId);
    }

    private UserResponseDto convertToResponseDto(UserEntity userEntity) {
        return new UserResponseDto(
                userEntity.getUserId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getMobileNumber(),
                userEntity.getRole()
        );
    }
}