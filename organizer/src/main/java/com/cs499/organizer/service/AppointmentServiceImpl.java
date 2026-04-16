package com.cs499.organizer.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.cs499.organizer.dao.AppointmentRepository;
import com.cs499.organizer.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Appointment service implementation handles appointment logic.
//Includes:
//- saving appointments
//- searching appointments
//- sorting appointments

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
	this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> findAll() {
	return appointmentRepository.findAll();
    }

    @Override
    public Appointment findById(int id) {
	Optional<Appointment> appointmentCheck = appointmentRepository.findById(id);
	Appointment appointment = null;
	if (appointmentCheck.isPresent()) {
	    appointment = appointmentCheck.get();
	} else {
	    throw new RuntimeException("Did not find appointment id - " + id);
	}
	return appointment;
    }

    @Override
    public Appointment save(Appointment appointment) {
	return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteById(int id) {
	appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> findByDate(Date date) {
	return appointmentRepository.findByDate(date);
    }

    @Override
    public List<Appointment> findByDescriptionContaining(String description) {
	return appointmentRepository.findByDescriptionContaining(description);
    }

    // Returns all appointments in the selected sort order.
    @Override
    public List<Appointment> findAllSorted(String sort) {
        if ("asc".equals(sort)) {
            return appointmentRepository.findAllByOrderByDateAsc();
        } else {
            return appointmentRepository.findAllByOrderByDateDesc();
        }
    }

    // Searches appointments by description and keeps the selected sort order.
    
    @Override
    public List<Appointment> searchAndSortByDescription(String searchAppointment, String sort) {
        if ("asc".equals(sort)) {
            return appointmentRepository.findByDescriptionContainingOrderByDateAsc(searchAppointment);
        } else {
            return appointmentRepository.findByDescriptionContainingOrderByDateDesc(searchAppointment);
        }
    }

}
