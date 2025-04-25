package com.example.controller;

import com.example.dto.AddressDTO;
import com.example.service.AddressManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressManagementController {

    @Autowired
    private AddressManagementService addressManagementService;

    @PostMapping
    public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity.ok(addressManagementService.addAddress(addressDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateAddress(@PathVariable Integer id, @RequestBody AddressDTO addressDTO) {
        addressDTO.setId(id);
        boolean success = addressManagementService.updateAddress(addressDTO);
        return success ? ResponseEntity.ok(success) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        boolean success = addressManagementService.deleteAddress(id);
        return success ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AddressDTO>> getUserAddresses(@PathVariable Integer userId) {
        return ResponseEntity.ok(addressManagementService.getUserAddresses(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable Integer id) {
        AddressDTO addressDTO = addressManagementService.getAddressDetail(id);
        return addressDTO != null ? ResponseEntity.ok(addressDTO) : ResponseEntity.notFound().build();
    }
} 