package com.griddynamics.gridu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneBookResponse {

    private String name;
    private Set<String> phones;
}
