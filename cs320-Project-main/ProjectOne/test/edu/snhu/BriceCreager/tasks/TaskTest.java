package edu.snhu.BriceCreager.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//Task Class Requirements

//The task object shall have a required unique task ID String that cannot be longer than 10 characters. The task ID shall not be null and shall not be updatable.
//The task object shall have a required name String field that cannot be longer than 20 characters. The name field shall not be null.
//The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.

public class TaskTest {

	final String VALIDATE_ID = "0123456789";
	final String VALIDATE_NAME = "0123456789";
	final String VALIDATE_DESCRIPTION = "0123456789";
	final String VALIDATE_TEN_CHAR = "0123456789";
	final String VALIDATE_ELEVEN_CHAR = "01234567890";
	final String VALIDATE_NULL = null;
	final String VALIDATE_EMPTY = "";
	final String VALIDATE_TWENTY_CHAR = "012345678901234567890123456789";
	final String VALIDATE_TWENTYONE_CHAR = "0123456789012345678901234567890";
	final String VALIDATE_FIFTY_CHAR = "01234567890123456789012345678901234567890123456789";
	final String VALIDATE_FIFTYONE_CHAR = "012345678901234567890123456789012345678901234567890";
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Test id
	///////////////////////////////////////////////////////////////////////////////////////////////
	//required - done
	// unique - *****
	// no longer than 10 - done
	// not empty - done
	// not null - done
	
	@Test
	public void testId_withValidId_IsSuccessfully() {
		Task myTask = new Task(VALIDATE_ID,VALIDATE_NAME,VALIDATE_DESCRIPTION);
		Assertions.assertEquals(VALIDATE_ID, myTask.getId());
	}
	
	@Test
	public void testId_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task (VALIDATE_ELEVEN_CHAR, VALIDATE_NAME,VALIDATE_DESCRIPTION));	
	}
	
	@Test
	public void testId_withNullValue_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task (VALIDATE_NULL, VALIDATE_NAME,VALIDATE_DESCRIPTION));
	}
	
	@Test
	public void testId_withNoCharacters_throwsIllegalArgumentException() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task (VALIDATE_EMPTY, VALIDATE_NAME,VALIDATE_DESCRIPTION));
		}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Test name
	///////////////////////////////////////////////////////////////////////////////////////////////
	// required - done
	// no longer than 20 - done
	// not empty - done
	// not null  - done
	
	@Test
	public void testName_withValidId_IsSuccessfully() {
		Task myTask = new Task(VALIDATE_ID,VALIDATE_NAME,VALIDATE_DESCRIPTION);
		Assertions.assertEquals(VALIDATE_NAME, myTask.getName());
	}
	
	@Test
	public void testName_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		Task myTask = new Task(VALIDATE_ID,VALIDATE_NAME,VALIDATE_DESCRIPTION);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTask.setName(VALIDATE_TWENTYONE_CHAR));
	}
	
	@Test
	public void testName_withNullValue_throwsIllegalArgumentException() {
		Task myTask = new Task(VALIDATE_ID,VALIDATE_NAME,VALIDATE_DESCRIPTION);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTask.setName(VALIDATE_NULL));
	}
	
	@Test
	public void testName_withNoCharacters_throwsIllegalArgumentException() {
		Task myTask = new Task(VALIDATE_ID,VALIDATE_NAME,VALIDATE_DESCRIPTION);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTask.setName(VALIDATE_EMPTY));
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	/// Test description
	///////////////////////////////////////////////////////////////////////////////////////////////
	// required - done
	// no longer than 50 - done
	// not empty - done
	// not null  - done
	
	@Test
	public void testDescription_withValidId_IsSuccessfully() {
		Task myTask = new Task(VALIDATE_ID,VALIDATE_NAME,VALIDATE_DESCRIPTION);
		Assertions.assertEquals(VALIDATE_DESCRIPTION, myTask.getDescription());
	}
	
	@Test
	public void testDescription_withMoreThanMaxCharacters_throwsIllegalArgumentException() {
		Task myTask = new Task(VALIDATE_ID,VALIDATE_NAME,VALIDATE_DESCRIPTION);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTask.setDescription(VALIDATE_FIFTYONE_CHAR));
	}
	
	@Test
	public void testDescription_withNullValue_throwsIllegalArgumentException() {
		Task myTask = new Task(VALIDATE_ID,VALIDATE_NAME,VALIDATE_DESCRIPTION);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTask.setDescription(VALIDATE_NULL));
	}
	
	@Test
	public void testDescription_withNoCharacters_throwsIllegalArgumentException() {
		Task myTask = new Task(VALIDATE_ID,VALIDATE_NAME,VALIDATE_DESCRIPTION);
		Assertions.assertThrows(IllegalArgumentException.class, () -> myTask.setDescription(VALIDATE_EMPTY));
	}
	
}
