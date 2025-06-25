package com.cs.cakeshop.service.serviceImpl;

import com.cs.cakeshop.Dto.request.StaffRequestDto;
import com.cs.cakeshop.Dto.response.StaffResponseDto;
import com.cs.cakeshop.entity.StaffEntity;
import com.cs.cakeshop.repository.StaffRepository;
import com.cs.cakeshop.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public StaffResponseDto createStaff(StaffRequestDto requestDto) {
        StaffEntity staff = new StaffEntity();
        staff.setFullName(requestDto.getFullName());
        staff.setEmailAddress(requestDto.getEmailAddress());
        staff.setPhoneNumber(requestDto.getPhoneNumber());
        staff.setRole(requestDto.getRole());
        staff.setStatus(requestDto.getStatus());
        staff.setLastActive(requestDto.getLastActive());

        // Set timestamps if your entity has @PrePersist annotation, these might not be needed
        // staff.setCreatedAt(LocalDateTime.now());
        // staff.setUpdatedAt(LocalDateTime.now());

        StaffEntity savedStaff = staffRepository.save(staff);
        return convertToResponseDto(savedStaff);
    }

    @Override
    public StaffResponseDto getStaffById(Long id) {
        StaffEntity staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found with id: " + id));
        return convertToResponseDto(staff);
    }

    @Override
    public List<StaffResponseDto> getAllStaff() {
        List<StaffEntity> staffEntities = staffRepository.findAll();
        return staffEntities.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public StaffResponseDto updateStaff(Long id, StaffRequestDto requestDto) {
        StaffEntity staff = staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found with id: " + id));

        staff.setFullName(requestDto.getFullName());
        staff.setEmailAddress(requestDto.getEmailAddress());
        staff.setPhoneNumber(requestDto.getPhoneNumber());
        staff.setRole(requestDto.getRole());
        staff.setStatus(requestDto.getStatus());
        staff.setLastActive(requestDto.getLastActive());

        // Update timestamp if your entity has @PreUpdate annotation, this might not be needed
        // staff.setUpdatedAt(LocalDateTime.now());

        StaffEntity updatedStaff = staffRepository.save(staff);
        return convertToResponseDto(updatedStaff);
    }

    @Override
    public void deleteStaff(Long id) {
        if (!staffRepository.existsById(id)) {
            throw new RuntimeException("Staff not found with id: " + id);
        }
        staffRepository.deleteById(id);
    }

    @Override
    public StaffResponseDto getStaffByEmail(String email) {
        StaffEntity staff = staffRepository.findByEmailAddress(email)
                .orElseThrow(() -> new RuntimeException("Staff not found with email: " + email));
        return convertToResponseDto(staff);
    }

    @Override
    public List<StaffResponseDto> getStaffByStatus(String status) {
        List<StaffEntity> staffEntities = staffRepository.findByStatus(status);
        return staffEntities.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StaffResponseDto> getStaffByRole(String role) {
        List<StaffEntity> staffEntities = staffRepository.findByRole(role);
        return staffEntities.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StaffResponseDto> searchStaffByName(String name) {
        List<StaffEntity> staffEntities = staffRepository.findByFullNameContaining(name);
        return staffEntities.stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    private StaffResponseDto convertToResponseDto(StaffEntity staff) {
        StaffResponseDto responseDto = new StaffResponseDto();
        responseDto.setId(staff.getId());
        responseDto.setFullName(staff.getFullName());
        responseDto.setEmailAddress(staff.getEmailAddress());
        responseDto.setPhoneNumber(staff.getPhoneNumber());
        responseDto.setRole(staff.getRole());
        responseDto.setStatus(staff.getStatus());
        responseDto.setLastActive(staff.getLastActive());
        responseDto.setCreatedAt(staff.getCreatedAt());
        responseDto.setUpdatedAt(staff.getUpdatedAt());
        return responseDto;
    }
}