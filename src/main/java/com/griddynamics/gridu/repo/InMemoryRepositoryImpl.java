package com.griddynamics.gridu.repo;

import com.griddynamics.gridu.dto.PhoneBookRequest;
import com.griddynamics.gridu.dto.PhoneBookResponse;
import com.griddynamics.gridu.exceptions.NoSuchEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class InMemoryRepositoryImpl implements InMemoryRepository {

    @Autowired
    private Map<String, Set<String>> data;

    @Override
    public Map<String, Set<String>> findAll() {
        return data;
    }

    @Override
    public Set<String> findAllPhonesByName(String name) {
        if (!data.containsKey(name))
            throw new NoSuchEntityException("There is no record with name " + name);
        return data.get(name);
    }

    @Override
    public void deleteByName(String name) throws NoSuchEntityException {
        if (data.containsKey(name)) {
            data.remove(name);
        } else throw new NoSuchEntityException("There is no record with name " + name);
    }

    @Override
    public PhoneBookResponse saveRecord(PhoneBookRequest phoneBook) {
        PhoneBookResponse phoneBookResponse = new PhoneBookResponse(phoneBook.getName(), new HashSet<>(List.of(phoneBook.getPhone())));
        data.put(phoneBookResponse.getName(), phoneBookResponse.getPhones());
        return phoneBookResponse;
    }

    @Override
    public PhoneBookResponse updateRecord(String name, String phone) throws NoSuchEntityException {
        if (data.containsKey(name)) {
            Set<String> phones = data.get(name);
            phones.add(phone);
            data.replace(name, phones);
            return new PhoneBookResponse(name, phones);
        } else throw new NoSuchEntityException("There is no record with name " + name);
    }
}