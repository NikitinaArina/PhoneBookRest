package com.griddynamics.gridu.service;

import com.griddynamics.gridu.dto.PhoneBookRequest;
import com.griddynamics.gridu.dto.PhoneBookResponse;
import com.griddynamics.gridu.repo.InMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class PhoneBookServiceImpl implements PhoneBookService {

    @Autowired
    private InMemoryRepository inMemoryRepository;

    @Override
    public Map<String, Set<String>> findAll() {
        return inMemoryRepository.findAll();
    }

    @Override
    public Set<String> getByName(String name) {
        return inMemoryRepository.findAllPhonesByName(name);
    }

    @Override
    public PhoneBookResponse saveRecord(PhoneBookRequest phoneBook) {
        return inMemoryRepository.saveRecord(phoneBook);
    }

    @Override
    public PhoneBookResponse updateRecord(String name, String phone) {
        return inMemoryRepository.updateRecord(name, phone);
    }

    @Override
    public void deleteByName(String name) {
        inMemoryRepository.deleteByName(name);
    }
}
