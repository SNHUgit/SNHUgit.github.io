package com.cs499.organizer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Setter;
import lombok.Getter;
import lombok.AccessLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//Appointment class models an appointment.
//Includes:
//- database mapping
//- data validation

@Entity
@Table(name = "appointment")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name = "description", nullable = false, length = 500)
    @NotBlank(message = "Description cannot be empty")
    @Size(max = 500, message = "Description must be 500 characters or less")
    private String description;

    @Column(name = "appointment_date", nullable = false)
    @Future(message = "Date must be in the future")
    @NotNull(message = "Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
