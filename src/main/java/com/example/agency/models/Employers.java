package com.example.agency.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="employers")
public class Employers {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(name="salary")
    private int salary;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "hire_date")
    private LocalDate hireDate;

}

