package com.example.prac5.Service;

import com.example.prac5.Entity.PhoneNumber;
import com.example.prac5.Repo.PhoneNumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneNumberService {
    private final PhoneNumberRepo phoneNumberRepo;

    @Autowired
    public PhoneNumberService(PhoneNumberRepo phoneBookRepo) {
        this.phoneNumberRepo = phoneBookRepo;
    }

    public List<PhoneNumber> getPhoneNumbers(){
        return phoneNumberRepo.findAll();
    }

    public void savePhoneNumber(PhoneNumber phoneNumber){
        phoneNumberRepo.save(phoneNumber);
    }

    public void deletePhoneNumber(Long id){
        phoneNumberRepo.deleteById(id);
    }

    public PhoneNumber changePhoneNumber(Long id, PhoneNumber phoneNumber) {
        Optional<PhoneNumber> entity = phoneNumberRepo.findById(id);
        if (entity.isPresent()){
            PhoneNumber oldPhoneNumber = entity.get();
            oldPhoneNumber.setName(phoneNumber.getName());
            oldPhoneNumber.setSurname(phoneNumber.getSurname());
            oldPhoneNumber.setPhoneNumber(phoneNumber.getPhoneNumber());
            return phoneNumberRepo.save(oldPhoneNumber);
        }else{
            return phoneNumberRepo.save(phoneNumber);
        }
    }
}
