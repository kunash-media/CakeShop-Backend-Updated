package com.cs.cakeshop.controller;

import com.cs.cakeshop.Dto.request.StaffRequestDto;
import com.cs.cakeshop.Dto.response.StaffResponseDto;
import com.cs.cakeshop.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/create-staff")
    public ResponseEntity<StaffResponseDto> createStaff(@RequestBody StaffRequestDto requestDto) {
        StaffResponseDto response = staffService.createStaff(requestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffResponseDto> getStaffById(@PathVariable Long id) {
        StaffResponseDto response = staffService.getStaffById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-all-staff")
    public ResponseEntity<List<StaffResponseDto>> getAllStaff() {
        List<StaffResponseDto> response = staffService.getAllStaff();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffResponseDto> updateStaff(@PathVariable Long id,
                                                        @RequestBody StaffRequestDto requestDto) {
        StaffResponseDto response = staffService.updateStaff(id, requestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable Long id) {
        staffService.deleteStaff(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<StaffResponseDto> getStaffByEmail(@PathVariable String email) {
        StaffResponseDto response = staffService.getStaffByEmail(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<StaffResponseDto>> getStaffByStatus(@PathVariable String status) {
        List<StaffResponseDto> response = staffService.getStaffByStatus(status);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<StaffResponseDto>> getStaffByRole(@PathVariable String role) {
        List<StaffResponseDto> response = staffService.getStaffByRole(role);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<StaffResponseDto>> searchStaffByName(@RequestParam String name) {
        List<StaffResponseDto> response = staffService.searchStaffByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}


