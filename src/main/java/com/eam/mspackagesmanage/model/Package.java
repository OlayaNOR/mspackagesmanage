package com.eam.mspackagesmanage.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "packages")
@Data
public class Package {

    @Id
    @Column(nullable = false, unique = true, length = 50)
    private String trackingNumber;

    @Column(nullable = false, length = 150)
    private String recipient;        

    @Column(length = 255)
    private String address;          

    @Column(length = 20)
    private String zipCode;          

    @Column(length = 100)
    private String country;          

    @Column(length = 150)
    private String content;        

    @Column(nullable = false)
    private Double weightKg;     

    @Column(length = 150)
    private String update; 
}