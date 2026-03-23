package com.cs499.organizer.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {
	
	final String VALIDATE_FIRSTNAME = "A";
	final String VALIDATE_LASTNAME = "B";
	final String VALIDATE_NUMBER = "0123456789";
	final String VALIDATE_ADDRESS = "C";
	final String VALIDATE_ID = "D";
	final String VALIDATE_NULL = null;
	final String VALIDATE_NINE_CHAR = "012345678";
	final String VALIDATE_TEN_CHAR = "0123456789";
	final String VALIDATE_ELEVEN_CHAR = "01234567890";
	final String VALIDATE_EMPTY = "";
	final String VALIDATE_THIRTYONE_CHAR = "0123456789012345678901234567891";
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Test firstName
	///////////////////////////////////////////////////////////////////////////////////////////////
	// no longer than 10
	// required
	// not null
	// not empty

	@Test
	public void testFirstName_withValidFirstName_IsSuccessfully() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertEquals(VALIDATE_FIRSTNAME, myTestContact.getFirstName());
	}
	
	@Test
	public void testSetFirstName_withNullValue_throwsIllegalArgumentException() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTestContact.setFirstName(VALIDATE_NULL));
	}
	
	@Test
	public void testFirstName_withMoreThanTenMaxCharacters_throwsIllegalArgumentException() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTestContact.setFirstName(VALIDATE_ELEVEN_CHAR));
	}
	
	@Test
	public void testFirstName_withNoCharacters_throwsIllegalArgumentException() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTestContact.setFirstName(VALIDATE_EMPTY));
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Test lastName
	///////////////////////////////////////////////////////////////////////////////////////////////
	// no longer than 10
	// required
	// not null
	// not empty
	
	@Test
	public void testLastName_withValidId_IsSuccessfully() {
		
	
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		
		Assertions.assertEquals(VALIDATE_LASTNAME, myTestContact.getLastName());
	}
	
	@Test
	public void testLastName_withNullValue_throwsIllegalArgumentException() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTestContact.setLastName(VALIDATE_NULL));
	}
	
	@Test
	public void testLastName_withMoreThanTenMaxCharacters_throwsIllegalArgumentException() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTestContact.setLastName(VALIDATE_ELEVEN_CHAR));
	}
	
	@Test
	public void testLastName_withNoCharacters_throwsIllegalArgumentException() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTestContact.setLastName(VALIDATE_EMPTY));
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Test Number
	///////////////////////////////////////////////////////////////////////////////////////////////
	//must be 10 char
	//required
	//not null
	
	@Test
	public void testNumber_withValidId_IsSuccessfully() {
		
	
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		
		Assertions.assertEquals(VALIDATE_NUMBER, myTestContact.getNumber());
	}
	
	@Test
	public void testNumber_withNullValue_throwsIllegalArgumentException() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTestContact.setNumber(VALIDATE_NULL));
	}
	
	@Test
	public void testNumber_withMoreThanTenMaxCharacters_throwsIllegalArgumentException() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTestContact.setNumber(VALIDATE_ELEVEN_CHAR));
	}
	@Test
	public void testNumber_withLessThanTenMaxCharacters_throwsIllegalArgumentException() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTestContact.setNumber(VALIDATE_NINE_CHAR));
	}

	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Test Address
	///////////////////////////////////////////////////////////////////////////////////////////////
	//required
	//no longer than 30 char
	
	@Test
	public void testAddress_withValidId_IsSuccessfully() {
		
	
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		
		Assertions.assertEquals(VALIDATE_ADDRESS, myTestContact.getAddress());
	}
	
	@Test
	public void testAddress_withNullValue_throwsIllegalArgumentException() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTestContact.setAddress(VALIDATE_NULL));
	}
	
	@Test
	public void testAddress_withMoreThanTenMaxCharacters_throwsIllegalArgumentException() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTestContact.setAddress(VALIDATE_THIRTYONE_CHAR));
	}
	
	@Test
	public void testAddress_withNoCharacters_throwsIllegalArgumentException() {
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTestContact.setAddress(VALIDATE_EMPTY));
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Test id
	///////////////////////////////////////////////////////////////////////////////////////////////
	// no longer than 10 
	// not null
	// cannot update
	// required
	// unique 
	
	@Test
	public void testId_withValidId_IsSuccessfully() {
		
		Contact myTestContact = new Contact(VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ID);
		
		Assertions.assertEquals(VALIDATE_ID, myTestContact.getId());
	}
	
	@Test
	public void testId_withNullValue_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact (VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_NULL));
	}
	
	@Test
	public void testId_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact (VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_ELEVEN_CHAR));
	}
	@Test
	public void testId_withNoCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Contact (VALIDATE_FIRSTNAME,VALIDATE_LASTNAME,VALIDATE_NUMBER,VALIDATE_ADDRESS,VALIDATE_EMPTY));
		}
		
	

}