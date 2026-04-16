package com.cs499.organizer.service;

import java.util.Date;
import java.util.List;

import com.cs499.organizer.entity.Appointment;

//Appointment service defines appointment operations.
//Includes:
//- CRUD work
//- search
//- sorting

public interface AppointmentService {
    List<Appointment> findAll();
    Appointment findById(int id);
    Appointment save(Appointment appointment);
    void deleteById(int id);
    List<Appointment> findAllSorted(String sort);
    List<Appointment> searchAndSortByDescription(String searchAppointment, String sort);
    List<Appointment> findByDate(Date date);
    List<Appointment> findByDescriptionContaining(String description);
}
