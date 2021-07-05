package com.employee;

public class Employee {

	private String id;
	private String name;
	private String username;
	private String password;
	private String address;
	private int phone;
	private String position;

	
	
	public Employee(String id, String name, String username, String password, String address, int phone,
			String position) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.position = position;

	}


	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public int getPhone() {
		return phone;
	}

	public String getPosition() {
		return position;
	}

	

}
