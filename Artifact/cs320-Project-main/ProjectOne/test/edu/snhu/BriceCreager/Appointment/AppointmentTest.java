package edu.snhu.BriceCreager.Appointment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppointmentTest {
	
	final String VALIDATE_ID = "0123456789";
	final String VALIDATE_DESCRIPTION = "0123456789";
	final String VALIDATE_DATE="04/01/2026";
	final String VALIDATE_DATE_BAD="04D01D2026";
	final String VALIDATE_TEN_CHAR = "0123456789";
	final String VALIDATE_ELEVEN_CHAR = "01234567890";
	final String VALIDATE_FIFTY_CHAR = "01234567890123456789012345678901234567890123456789";
	final String VALIDATE_FIFTYONE_CHAR = "012345678901234567890123456789012345678901234567890";
	final String VALIDATE_NULL = null;
	final String VALIDATE_EMPTY = "";
	final String VALIDATE_PAST_DATE="04/01/2024";
	final String VALIDATE_CURRENT_DATE="04/01/2025";
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Test id
	///////////////////////////////////////////////////////////////////////////////////////////////
//	appointment ID
//	- unique - done
//	- required - done
//	- no longer than 10 - done
//	- no null - done
//	- not updatable 
//	- not empty - done
	
	@Test
	public void testId_withValidId_IsSuccessfully() {
		Appointment myAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		Assertions.assertEquals(VALIDATE_ID, myAppointment.getId());
	}
	
	@Test
	public void testId_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment(VALIDATE_ELEVEN_CHAR,VALIDATE_DESCRIPTION,VALIDATE_DATE));	
	}
	
	@Test
	public void testId_withNullValue_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment(VALIDATE_NULL,VALIDATE_DESCRIPTION,VALIDATE_DATE));
	}
	
	@Test
	public void testId_withNoCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Appointment(VALIDATE_EMPTY,VALIDATE_DESCRIPTION,VALIDATE_DATE));
		}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Test description
	///////////////////////////////////////////////////////////////////////////////////////////////
//	appointment	description 
//	- required - done
//	- no longer than 50 - done
//	- no null - done
//	- not empty - done
	
	@Test
	public void testDescription_withValidId_IsSuccessfully() {
		Appointment myAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		Assertions.assertEquals(VALIDATE_DESCRIPTION, myAppointment.getDescription());
	}
	
	@Test
	public void testDescription_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		Appointment myAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myAppointment.setDescription(VALIDATE_FIFTYONE_CHAR));
	}
	
	@Test
	public void testDescription_withNullValue_throwsIllegalArgumentException() {
		Appointment myAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myAppointment.setDescription(VALIDATE_NULL));
	}
	
	@Test
	public void testDescription_withNoCharacters_throwsIllegalArgumentException() {
		Appointment myAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myAppointment.setDescription(VALIDATE_EMPTY));
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Test Date
	///////////////////////////////////////////////////////////////////////////////////////////////
//	appointment	Date
//	- required - done
//	- not in past
//	- no null - done
//	- not empty
	
	@Test
	public void testDate_withValidId_IsSuccessfully() {
		Appointment myAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		Assertions.assertEquals(VALIDATE_DATE, myAppointment.getAppointmentDate());
	}
	@Test
	public void testDate_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		Appointment myAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myAppointment.setAppointmentDate(VALIDATE_ELEVEN_CHAR));
	}
	
	@Test
	public void testDate_withNullValue_throwsIllegalArgumentException() {
		Appointment myAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myAppointment.setAppointmentDate(VALIDATE_NULL));
	}
	
	@Test
	public void testDate_withNoCharacters_throwsIllegalArgumentException() {
		Appointment myAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myAppointment.setAppointmentDate(VALIDATE_EMPTY));
	}
	
	@Test
	public void testDate_withInvalidFormat_throwsIllegalArgumentException() {
		Appointment myAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myAppointment.setAppointmentDate(VALIDATE_DATE_BAD));
	}
	
	@Test
	public void testDate_withPastDate_throwsIllegalArgumentException() {
		Appointment myAppointment = new Appointment(VALIDATE_ID,VALIDATE_DESCRIPTION,VALIDATE_DATE);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myAppointment.setAppointmentDate(VALIDATE_PAST_DATE));
	}
	
}
