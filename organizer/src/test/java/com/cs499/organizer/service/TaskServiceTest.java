package com.cs499.organizer.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cs499.organizer.model.Task;

//Task Service Requirements

//The task service shall be able to add tasks with a unique ID.
//The task service shall be able to delete tasks per task ID.
//The task service shall be able to update task fields per task ID. The following fields are updatable:
	//Name
	//Description

public class TaskServiceTest {
	
	private TaskService service;
	
	@BeforeEach
	public void setup() {
		service = new TaskService();
	}
	
	final String VALIDATE_ID = "0123456789";
	final String VALIDATE_NAME = "0123456789";
	final String VALIDATE_DESCRIPTION = "0123456789";
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Add
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void testAdd_withNewElement_successfullyAdds() {
		Task newTask = new Task(VALIDATE_ID,VALIDATE_NAME,VALIDATE_DESCRIPTION);
		service.add(newTask);
		Assertions.assertEquals(service.get(newTask.getId()), newTask);
	}

	@Test
	public void testAdd_withDuplicateElement_throwsIllegalArgumentException() {
		Task newTask = new Task(VALIDATE_ID,VALIDATE_NAME,VALIDATE_DESCRIPTION);
		service.add(newTask);
		Assertions.assertNotNull(service.get(newTask.getId()));
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.add(newTask));
		
	}

	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Delete
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void testDelete_withCurrentElement_succesfullyRemoved() {
		Task newTask = new Task(VALIDATE_ID,VALIDATE_NAME,VALIDATE_DESCRIPTION);
		service.add(newTask);
		service.delete((newTask.getId()));
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.get(newTask.getId()));
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Edit
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void testUpdateName_withValidId_successfullyUpdates() {
		String testName1 = "john";
		String testName2 = "jake";
		Task newTask = new Task(VALIDATE_ID,testName1,VALIDATE_DESCRIPTION);
		service.add(newTask);
		service.updateName(VALIDATE_ID,testName2);
		Task updatedTask = service.get(VALIDATE_ID);
		Assertions.assertEquals(testName2, updatedTask.getName());
	}
	@Test
	public void testUpdateDescription_withValidId_successfullyUpdates() {
		String TestDescription1 = "john";
		String TestDescription2 = "jake";
		Task newTask = new Task(VALIDATE_ID,VALIDATE_NAME,TestDescription1);
		service.add(newTask);
		service.updateDescription(VALIDATE_ID,TestDescription2);
		Task updatedTask = service.get(VALIDATE_ID);
		Assertions.assertEquals(TestDescription2, updatedTask.getDescription());
	}
}