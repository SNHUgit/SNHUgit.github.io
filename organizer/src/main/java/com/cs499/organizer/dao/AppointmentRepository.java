package com.cs499.organizer.dao;

import com.cs499.organizer.entity.Appointment;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{
    List<Appointment> findByDescriptionContaining(String description);
    List<Appointment> findByDate(Date date);
    
    List<Appointment> findAllByOrderByDateAsc();
    List<Appointment> findAllByOrderByDateDesc();

    List<Appointment> findByDescriptionContainingOrderByDateAsc(String description);
    List<Appointment> findByDescriptionContainingOrderByDateDesc(String description);
}
