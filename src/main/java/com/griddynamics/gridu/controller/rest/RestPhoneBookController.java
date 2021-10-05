package com.griddynamics.gridu.controller.rest;

import com.griddynamics.gridu.dto.PhoneBookRequest;
import com.griddynamics.gridu.dto.PhoneBookResponse;
import com.griddynamics.gridu.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("api/v1/customers")
public class RestPhoneBookController {

    @Autowired
    private PhoneBookService phoneBookService;

    @GetMapping
    public Map<String, Set<String>> getPhoneBookRecords() {
        return phoneBookService.findAll();
    }

    @GetMapping("/{name}")
    public Set<String> getPhonesByName(@PathVariable String name) {
        return phoneBookService.getByName(name);
    }

    @PutMapping("/{name}")
    public PhoneBookResponse addPhone(@PathVariable String name, @RequestParam("phoneNumber") String phoneNumber) {
        return phoneBookService.updateRecord(name, phoneNumber);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public PhoneBookResponse createNewRecord(@RequestBody PhoneBookRequest phoneBook) {
        return phoneBookService.saveRecord(phoneBook);
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByName(@PathVariable String name) {
        phoneBookService.deleteByName(name);
    }
}
