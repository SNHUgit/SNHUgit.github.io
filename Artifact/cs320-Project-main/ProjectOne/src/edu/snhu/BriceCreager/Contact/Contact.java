package edu.snhu.BriceCreager.Contact;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Contact { 

	private String firstName;
	private String lastName;
	private String Number;
	private String Address;
	private String id;
	
	public Contact(String firstName, String lastName, String number, String address, String id) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setNumber(number);
		setAddress(address);
		setId(id);
	}
	
	public Contact(Contact other) {
		this(other.firstName, other.lastName, other.Number, other.Address, other.id);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null) {
			throw new IllegalArgumentException("First Name cannot be null");
		}else if (firstName.length() > 10) {
			throw new IllegalArgumentException("First Name cannot exceed 10 characters");
		}else if (firstName.isEmpty()) {
			throw new IllegalArgumentException("First Name cannot have no characters");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null) {
			throw new IllegalArgumentException("Last Name cannot be null");
		}else if (lastName.length() > 10) {
			throw new IllegalArgumentException("Last Name cannot exceed 10 characters");
		}else if (lastName.isEmpty()) {
			throw new IllegalArgumentException("Last Name cannot have no characters");
		}
		this.lastName = lastName;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		
		if (number == null) {
			throw new IllegalArgumentException("Number cannot be null");
		}else if (number.length() > 10) {
			throw new IllegalArgumentException("Number must be 10 charecters long");
		}else if (number.length() < 10) {
			throw new IllegalArgumentException("Number must be 10 charecters long");
		}
		
		Number = number;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException("Address cannot be null");
		}else if (address.length() > 30) {
			throw new IllegalArgumentException("Address must be 30 charecters long");
		}else if (address.isEmpty()) {
			throw new IllegalArgumentException("Address cannot have no characters");
		}
		Address = address;
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
			throw new IllegalArgumentException("ID cannot have no characters");
		}
		
		this.id = id;
	}


	
	

}
