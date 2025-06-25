package com.cs.cakeshop.controller;

import com.cs.cakeshop.Dto.request.DiscountRequestDto;
import com.cs.cakeshop.Dto.response.DiscountResponseDto;
import com.cs.cakeshop.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @PostMapping("/create-Discount")
    public ResponseEntity<DiscountResponseDto> createDiscount(@RequestBody DiscountRequestDto requestDto) {
        DiscountResponseDto response = discountService.createDiscount(requestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiscountResponseDto> getDiscountById(@PathVariable Long id) {
        DiscountResponseDto response = discountService.getDiscountById(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<DiscountResponseDto> getDiscountByCode(@PathVariable String code) {
        DiscountResponseDto response = discountService.getDiscountByCode(code);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-All-Discounts")
    public ResponseEntity<List<DiscountResponseDto>> getAllDiscounts() {
        List<DiscountResponseDto> discounts = discountService.getAllDiscounts();
        return ResponseEntity.ok(discounts);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<DiscountResponseDto>> getDiscountsByStatus(@PathVariable String status) {
        List<DiscountResponseDto> discounts = discountService.getDiscountsByStatus(status);
        return ResponseEntity.ok(discounts);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<DiscountResponseDto>> getDiscountsByType(@PathVariable String type) {
        List<DiscountResponseDto> discounts = discountService.getDiscountsByType(type);
        return ResponseEntity.ok(discounts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiscountResponseDto> updateDiscount(@PathVariable Long id, @RequestBody DiscountRequestDto requestDto) {
        DiscountResponseDto response = discountService.updateDiscount(id, requestDto);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscount(@PathVariable Long id) {
        discountService.deleteDiscount(id);
        return ResponseEntity.noContent().build();
    }
}
