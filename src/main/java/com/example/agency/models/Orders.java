package com.example.agency.models;

import com.example.agency.models.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Clients client;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "order_date")
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "services_id")
    private Services service;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

}
