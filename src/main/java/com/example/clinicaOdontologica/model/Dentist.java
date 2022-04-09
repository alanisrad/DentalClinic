package com.example.clinicaOdontologica.model;

import javax.persistence.*;

@Entity
@Table(name="dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentist_sequence")
    @SequenceGenerator(name= "dentist_sequence", sequenceName = "dentist_sequence", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    private String licenseNumber;

    private String name;

    private String lastName;

    public Dentist() {
    }

    public Dentist(Integer id, String licenseNumber, String name, String lastName) {
        this.id = id;
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "licenseNumber=" + licenseNumber +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
