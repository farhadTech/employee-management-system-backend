package com.farhad.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotBlank(message = "Enter firstName:")
    @NotNull
    public String firstName;

    @NotBlank(message = "Enter lastName:")
    @NotNull
    public String lastName;

    @Email(message = "please enter a email:")
    @NotNull
    public String email;

    @Size(
            min = 8, max = 30,
            message = "password should be greater than and 8 and less than 30."
    )
    @NotNull
    public String password;

    public String phone;
    public String address;

    public Employee(String firstName, String lastName, String email, String password, String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }
}
