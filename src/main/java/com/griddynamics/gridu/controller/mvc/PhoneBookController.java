package com.griddynamics.gridu.controller.mvc;

import com.griddynamics.gridu.dto.PhoneBookRequest;
import com.griddynamics.gridu.dto.PhoneBookResponse;
import com.griddynamics.gridu.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("customers")
public class PhoneBookController {

    @Autowired
    private PhoneBookService phoneBookService;

    @GetMapping
    @ResponseBody
    public Map<String, Set<String>> getPhoneBookRecords() {
        return phoneBookService.findAll();
    }

    @GetMapping("/{name}")
    @ResponseBody
    public Set<String> getPhonesByName(@PathVariable String name) {
        return phoneBookService.getByName(name);
    }

    @PostMapping("/")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public PhoneBookResponse savePhoneRecord(@RequestBody PhoneBookRequest phoneBookRequest) {
        return phoneBookService.saveRecord(phoneBookRequest);
    }

    @PostMapping("delete/{name}")
    public @ResponseBody String deleteByName(@PathVariable String name) {
        phoneBookService.deleteByName(name);
        return "success";
    }

    @PostMapping("update/{name}")
    @ResponseBody
    public PhoneBookResponse updatePhoneRecord(@PathVariable String name, @RequestParam("phoneNumber") String phoneNumber) {
        return phoneBookService.updateRecord(name, phoneNumber);
    }
}
