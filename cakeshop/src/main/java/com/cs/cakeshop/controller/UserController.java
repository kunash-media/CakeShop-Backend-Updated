package com.cs.cakeshop.controller;

import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService userService;
    private final UsersRepository usersRepository;
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    public UsersController(UsersService userService, UsersRepository usersRepository) {
        this.userService = userService;
        this.usersRepository = usersRepository;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserRegistrationResponseDto> registerUser(
            @RequestBody UserRegistrationDto userData) throws BadRequestException {

        logger.info("Registering new user with email: {}", userData.getEmail());

        Users user = userService.createUser(userData);

        UserRegistrationResponseDto response = new UserRegistrationResponseDto(
                user.getUserId(), user.getName(), user.getEmail(), user.getRole()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("details/{userId}")
    public ResponseEntity<?> getUserAccounts(@PathVariable String userId) {
        try {
            Users user = usersRepository.findByUserId(userId);
            if (user == null) {
                return new ResponseEntity<>("User not found with ID: " + userId, HttpStatus.NOT_FOUND);
            }
            UserAccountsResponse response = new UserAccountsResponse(user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error retrieving user accounts: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<?> updateUser(@PathVariable String userId, @RequestBody UserRegistrationDto userRegistrationDto) {
        try {
            userService.updateUser(userId, userRegistrationDto);
            return ResponseEntity.ok().body("User updated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user: " + e.getMessage());
        }
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<List<GetAllUserDto>> getAllUsers() {
        List<GetAllUserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
