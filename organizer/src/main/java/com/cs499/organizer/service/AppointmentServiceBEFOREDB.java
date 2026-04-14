package com.cs499.organizer.service;

import com.cs499.organizer.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentServiceBEFOREDB {

//Appointment Service Requirements		
//		- add appointments with a unique appointment ID - done
//		- delete appointments per appointment ID - done

    private List<Appointment> appointments;

    public AppointmentServiceBEFOREDB() {
	appointments = new ArrayList<>();
    }

    // Add appointment
    public void add(Appointment newAppointment) {
	boolean isDuplicate = false;
	for (Appointment appointment : appointments) {
	    if (appointment.getId().equals(newAppointment.getId())) {
		isDuplicate = true;
		break;
	    }
	}
	if (isDuplicate) {
	    throw new IllegalArgumentException("Cannot add appointment with duplicate id: " + newAppointment.getId());
	}
	appointments.add(newAppointment);
    }

    // Delete Appointment
    public void delete(String id) {
	for (int i = 0; i < appointments.size(); i++) {
	    if (appointments.get(i).getId().equals(id)) {
		appointments.remove(i);
		return;
	    }
	}
    }

    // Get appointment by id
    public Appointment get(String id) {
	Appointment foundAppointment = null;

	for (Appointment appointment : appointments) {
	    if (appointment.getId().equals(id)) {
		foundAppointment = appointment;
		break;
	    }
	}
	if (foundAppointment == null) {
	    throw new IllegalArgumentException("Appointment with ID " + id + " not found.");
	}
	return new Appointment(foundAppointment);
    }

    // Search description
    public List<Appointment> descriptionSearch(String description) {
	List<Appointment> foundAppointments = new ArrayList<>();

	for (Appointment appointment : appointments) {
	    if (appointment.getDescription().toLowerCase().contains(description.toLowerCase())) {
		foundAppointments.add(new Appointment(appointment));
	    }
	}
	return foundAppointments;
    }

    // Get all appointments
    public List<Appointment> getAllAppointment() {
	// make a copy of the list and return the copy
	List<Appointment> appointmentCopy = new ArrayList<>();
	for (Appointment appointment : appointments) {
	    appointmentCopy.add(new Appointment(appointment));
	}
	return appointmentCopy;
    }
    
    // Update appointment fields
    public void updateAppointment(String id, String description, String appointmentDate) {
        for (Appointment appointment : appointments) {
            if (appointment.getId().equals(id)) {
                appointment.setDescription(description);
                appointment.setAppointmentDate(appointmentDate);
                return;
            }
        }
    }

}