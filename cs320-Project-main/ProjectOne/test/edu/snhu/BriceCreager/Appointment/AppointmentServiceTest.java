package edu.snhu.BriceCreager.Appointment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppointmentServiceTest {

//Appointment Service Requirements		
//	- add appointments with a unique appointment ID
//	- delete appointments per appointment ID
	
	private AppointmentService service;
	
	@BeforeEach
	public void setup() {
		service = new AppointmentService();
	}
	
	final String VALIDATE_ID = "0123456789";
	final String VALIDATE_DESCRIPTION = "0123456789";
	final String VALIDATE_DATE="04/01/2026";
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Add
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAdd_withNewElement_successfullyAdds() {
		Appointment newAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		service.add(newAppointment);
		Assertions.assertEquals(service.get(newAppointment.getId()), newAppointment);
	}

	@Test
	public void testAdd_withDuplicateElement_throwsIllegalArgumentException() {
		Appointment newAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		service.add(newAppointment);
		Assertions.assertNotNull(service.get(newAppointment.getId()));
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.add(newAppointment));
		
	}

	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Delete
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@Test
	public void testDelete_withCurrentElement_succesfullyRemoved() {
		Appointment newAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		service.add(newAppointment);
		service.delete((newAppointment.getId()));
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.get(newAppointment.getId()));
		
	}
	
}
