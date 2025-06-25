package com.cs.cakeshop.service;

import com.cs.cakeshop.Dto.request.StaffRequestDto;
import com.cs.cakeshop.Dto.response.StaffResponseDto;

import java.util.List;

public interface StaffService {

    StaffResponseDto createStaff(StaffRequestDto requestDto);

    StaffResponseDto getStaffById(Long id);

    List<StaffResponseDto> getAllStaff();

    StaffResponseDto updateStaff(Long id, StaffRequestDto requestDto);

    void deleteStaff(Long id);

    StaffResponseDto getStaffByEmail(String email);

    List<StaffResponseDto> getStaffByStatus(String status);

    List<StaffResponseDto> getStaffByRole(String role);

    List<StaffResponseDto> searchStaffByName(String name);
}
