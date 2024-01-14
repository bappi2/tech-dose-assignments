package org.mmefta.javastreamdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private int id;
    private String firstName;
    private int age;
    private String gender;
    private String dept;
    private String city;
    private int rank;
    private List<String> contacts;
}
