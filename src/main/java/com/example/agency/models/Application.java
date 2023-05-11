package com.example.agency.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
public class ApplicationService {
    @Id

    @GeneratedValue(strategy= GenerationType.AUTO)
    private int applicationServiceId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "client_email")
    private String clientEmail;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "services")
    private String services;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private int startDate;
}