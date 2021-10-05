package com.griddynamics.gridu.repo;

import com.griddynamics.gridu.dto.PhoneBookRequest;
import com.griddynamics.gridu.dto.PhoneBookResponse;
import com.griddynamics.gridu.exceptions.NoSuchEntityException;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public interface InMemoryRepository {

    Map<String, Set<String>> findAll();

    Set<String> findAllPhonesByName(String name) throws NoSuchEntityException;

    void deleteByName(String name) throws NoSuchElementException;

    PhoneBookResponse saveRecord(PhoneBookRequest phoneBook);

    PhoneBookResponse updateRecord(String name, String phone) throws NoSuchElementException;
}
