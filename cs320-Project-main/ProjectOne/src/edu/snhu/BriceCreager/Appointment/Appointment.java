package edu.snhu.BriceCreager.Appointment;

import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Appointment {
	
//Appointment Class Requirements
//	appointment ID
//		- unique
//		- required
//		- no longer than 10
//		- no null
//		- not updatable
//		- not empty
//	appointment	Date
//		- required
//		- not in past
//		- no null
//		- not empty
//	appointment	description 
//		- required
//		- no longer than 50
//		- no null
//		- not empty

	private String id;
	private String description;
	private Date appointmentDate;
	private static final String DATE_PATTERN = "MM/dd/yyyy";
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_PATTERN);
	
	
	public Appointment(String id, String description, String sDate) {
		super();
		setId(id);
		setDescription(description);
		setAppointmentDate(sDate);
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		if (id == null) {
			throw new IllegalArgumentException("id cannot be null");
		}else if (id.length() > 10) {
			throw new IllegalArgumentException("id cannon exceed 10 characters");
		}else if (id.isEmpty()) {
			throw new IllegalArgumentException("id cannot have no characters");
		}
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("description cannot be null");
		}else if (description.length() > 50) {
			throw new IllegalArgumentException("description cannot exceed 50 characters");
		}else if (description.isEmpty()) {
			throw new IllegalArgumentException("description cannot have no characters");
		}
		this.description = description;
	}

	public String getAppointmentDate() {
		String StringDateConverted = DateToString(appointmentDate);
		return StringDateConverted;
	}

	public void setAppointmentDate(String sDate) {
		
        // had to look most everything to do with a data, bit of a hard time understanding that you have to parse a date first
		
		if(sDate == null) {
			throw new IllegalArgumentException("Date cannot be null");
		}else if (sDate.isEmpty()) {
			throw new IllegalArgumentException("Date cannot have no characters");
		}else if (sDate.length() > 10) {
			throw new IllegalArgumentException("Date must be in MM/DD/YYYY format");
		}else if (sDate.charAt(2) != '/' || sDate.charAt(5) != '/') {
		    throw new IllegalArgumentException("Date must be in MM/DD/YYYY format");
		}else{
		
			
		
		try {
            Date parsedDate = DATE_FORMATTER.parse(sDate);
            
            Date today = DATE_FORMATTER.parse(DATE_FORMATTER.format(new Date()));
            
            if(parsedDate.before(today) ) {
    			throw new IllegalArgumentException("Date cannot be in the past");
            }
            
            this.appointmentDate = parsedDate;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Date format must be MM/dd/yyyy");
        }
		}
	
	}
	
	public Appointment(Appointment other) {
	    this(other.id, other.description, DateToString(other.appointmentDate));
	}
	
	private static String DateToString(Date date) {
		//String dateConvert = date.toString();
		//return dateConvert;
		//I had lots of trouble with date, it did not work the way i thought it would in my head and i am not 
		//entirely sure i understand it now but appears to be working properly now. 
		return DATE_FORMATTER.format(date);
	}
	
}
