package edu.snhu.BriceCreager.Contact;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
	
	private ContactService service;
	
	@BeforeEach
	public void setup() {
		service = new ContactService();
	}

	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Add
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAdd_withNewElement_successfullyAdds() {
		Contact newContact = new Contact("john","smith", "1234567890","123 dogwood ln.", "4454");
		service.add(newContact);
		Assertions.assertEquals(service.get(newContact.getId()), newContact);
	}
	@Test
	public void testAdd_withDuplicateElement_throwsIllegalArgumentException() {
		Contact newContact = new Contact("john","smith", "1234567890","123 dogwood ln.", "4455");
		service.add(newContact);
		Assertions.assertNotNull(service.get(newContact.getId()));
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.add(newContact));
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Delete
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testDelete_withCurrentElement_succesfullyRemoved() {
		Contact newContact = new Contact("john","smith", "1234567890","123 dogwood ln.", "4456");
		service.add(newContact);
		service.delete((newContact.getId()));
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.get(newContact.getId()));
		
	}
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Edit
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testUpdateFirstName_withValidId_successfullyUpdates() { 
		String testName1 = "john";
		String testName2 = "jake";
		Contact newContact = new Contact(testName1,"smith", "1234567890","123 dogwood ln.", "4456");
		service.add(newContact);
		service.updateFirstName("4456",testName2);
		Contact updatedContact = service.get("4456");
		Assertions.assertEquals(testName2, updatedContact.getFirstName());
	}
	
	@Test
	public void testUpdateLastName_withValidId_successfullyUpdates() {
		String testName1 = "john";
		String testName2 = "jake";
		Contact newContact = new Contact(testName1,"smith", "1234567890","123 dogwood ln.", "4456");
		service.add(newContact);
		service.updateLastName("4456",testName2);
		Contact updatedContact = service.get("4456");
		Assertions.assertEquals(testName2, updatedContact.getLastName());
	}
	
	@Test
	public void testUpdateAddress_withValidId_successfullyUpdates() {
		String testaddress1 = "123 dogwood ln.";
		String testaddress2 = "456 jake alley";
		Contact newContact = new Contact("john","smith", "1234567890",testaddress1, "4456");
		service.add(newContact);
		service.updateAddress("4456",testaddress2);
		Contact updatedContact = service.get("4456");
		Assertions.assertEquals(testaddress2, updatedContact.getAddress());
	}
	
	@Test
	public void testUpdateNumber_withValidId_successfullyUpdates() {
		String testNumber1 = "1234567890";
		String testNumber2 = "0987654321";
		Contact newContact = new Contact("john","smith", testNumber1, "123 dogwood ln.", "4456");
		service.add(newContact);
		service.updateNumber("4456",testNumber2);
		Contact updatedContact = service.get("4456");
		Assertions.assertEquals(testNumber2, updatedContact.getNumber());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Get check Null
	///////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testGet_withBadId_throwsIllegalArgumentException() {
	    Assertions.assertThrows(IllegalArgumentException.class, () -> service.get("BadId"));
	}
}
