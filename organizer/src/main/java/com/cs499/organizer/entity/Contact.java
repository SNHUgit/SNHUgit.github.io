package com.cs499.organizer.entity;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

// Contact class models a Contact.
// Includes:
// - database mapping
// - data validation

@Entity
@Table(name = "contact")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name = "first_name", nullable = false,length = 50)
    @NotBlank(message = "First name cannot be empty")
    @Size(max = 50, message = "First name must be 50 characters or less")
    private String firstName;

    @Column(name = "last_name", nullable = false,length = 50)
    @NotBlank(message = "Last name cannot be empty")
    @Size(max = 50, message = "Last name must be 50 characters or less")
    private String lastName;

    @Column(name = "number", nullable = false, length = 10)
    @NotBlank(message = "Number cannot be empty")
    @Pattern(regexp = "^\\d{10}$", message = "Number must be exactly 10 digits")
    private String number;

    @Column(name = "address", nullable = false, length = 100)
    @NotBlank(message = "Address cannot be empty")
    @Size(max = 100, message = "Address must be 100 characters or less")
    private String address;
}