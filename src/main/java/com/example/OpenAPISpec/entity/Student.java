package com.example.OpenAPISpec.entity;

import java.time.LocalDateTime;
// NEW (Spring Boot 3.x)
import jakarta.persistence.*;

/**
 * Student entity representing a student record.
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String className;
    private long phoneNum;

    public Student(Long id,String name, String address, String className, long phoneNum,long version) {
        this.address = address;
        this.className = className;
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
    }


    public Student() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

}
