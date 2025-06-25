package com.cs.cakeshop.service;

import com.cs.cakeshop.Dto.request.UserRequestDto;
import com.cs.cakeshop.Dto.response.UserResponseDto;

import java.util.List;
public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto getUserById(Long userId);
    UserResponseDto getUserByEmail(String email);
    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto);
    void deleteUser(Long userId);
}
