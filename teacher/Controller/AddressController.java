package com.example.teacher.Controller;

import com.example.teacher.Api.ApiResponse;
import com.example.teacher.Dto.AddressDto;
import com.example.teacher.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity gerAll(){
        return ResponseEntity.status(200).body(addressService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid AddressDto addressDto){
        addressService.addAdress(addressDto);
        return ResponseEntity.status(200).body(new ApiResponse("add success"));
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @Valid AddressDto addressDto){
        addressService.updateAdress(addressDto);
        return ResponseEntity.status(200).body(new ApiResponse("update success"));
    }

}
