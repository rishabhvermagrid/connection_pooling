package com.rishabh.studentmanagement.Entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private int id;

    private String name;

    private String email;

    private int age;

    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
