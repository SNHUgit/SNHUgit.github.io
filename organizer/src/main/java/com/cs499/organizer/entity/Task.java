package com.cs499.organizer.entity;

import jakarta.persistence.Column;
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
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;

// Task class models a task.
// Includes:
// - database mapping
// - data validation

@Entity
@Table(name="task")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="task_id")
//    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name="name", nullable = false, length = 50)
    @NotBlank(message = "Name cannot be empty")
    @Size(max = 50, message = "Name must be 50 characters or less")
    private String name;

    @Column(name="description", nullable = false, length = 500)
    @NotBlank(message = "Description cannot be empty")
    @Size(max = 500, message = "Description must be 500 characters or less")
    private String description;

}
