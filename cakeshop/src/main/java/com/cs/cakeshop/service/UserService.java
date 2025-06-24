package com.cs.cakeshop.service;



import java.util.List;

import com.cs.cakeshop.Dto.GetAllUserDto;
import com.cs.cakeshop.Dto.UserRegistrationDto;
import com.cs.cakeshop.entity.Users;
import org.apache.coyote.BadRequestException;

public interface UsersService {
    Users createUser(UserRegistrationDto userData) throws BadRequestException;
    void updateUser(String userId, UserRegistrationDto userRegistrationDto);
    List<GetAllUserDto> getAllUsers();
}
