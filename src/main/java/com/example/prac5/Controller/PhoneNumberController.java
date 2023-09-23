package com.example.prac5.Controller;

import com.example.prac5.Entity.PhoneNumber;
import com.example.prac5.Service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneNumberController {
    private final PhoneNumberService phoneNumberService;

    @Autowired
    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }

    @GetMapping("/")
    public List<PhoneNumber> getAllPhoneNumbers(){
        return  phoneNumberService.getPhoneNumbers();
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> newPhoneNumber(@RequestBody PhoneNumber phoneNumber){
        phoneNumberService.savePhoneNumber(phoneNumber);
        return ResponseEntity.ok("Phone number saved successfully");
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deletePhoneNumber(@PathVariable Long id){
        phoneNumberService.deletePhoneNumber(id);
        return ResponseEntity.ok("Phone number deleted successfully");
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PhoneNumber> changePhoneNumber(@PathVariable Long id,
                                                         @RequestBody PhoneNumber phoneNumber){

        return ResponseEntity.ok().body(phoneNumberService.changePhoneNumber(id, phoneNumber));
    }

}
