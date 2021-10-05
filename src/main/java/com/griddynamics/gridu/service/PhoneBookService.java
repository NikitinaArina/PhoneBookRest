package com.griddynamics.gridu.service;

import com.griddynamics.gridu.dto.PhoneBookRequest;
import com.griddynamics.gridu.dto.PhoneBookResponse;
import com.griddynamics.gridu.exceptions.NoSuchEntityException;

import java.util.Map;
import java.util.Set;

public interface PhoneBookService {

    Map<String, Set<String>> findAll();

    Set<String> getByName(String name) throws NoSuchEntityException;

    PhoneBookResponse saveRecord(PhoneBookRequest phoneBook);

    PhoneBookResponse updateRecord(String name, String phone) throws NoSuchEntityException;

    void deleteByName(String name) throws NoSuchEntityException;
}
