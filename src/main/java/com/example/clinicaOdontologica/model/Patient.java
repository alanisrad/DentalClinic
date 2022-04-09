package com.example.clinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name= "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    @SequenceGenerator(name= "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    private String name;

    private String lastName;

    private String dni;

    private Date entryDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Patient() {
    }

    public Patient(Integer id, String nombre, String apellido, String dni, Date fechaIngreso, Address domicilio) {
        this.id = id;
        this.name = nombre;
        this.lastName = apellido;
        this.dni = dni;
        this.entryDate = fechaIngreso;
        this.address = domicilio;
    }

    public Integer getId() {
        return id;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", entryDate=" + entryDate +
                ", address=" + address +
                '}';
    }
}
