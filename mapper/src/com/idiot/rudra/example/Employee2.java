package com.idiot.rudra.example;

public class Employee2 {

	private String name;
	private String lastName;
	private String role;
	private Department2 d;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	@Override
	public String toString() {
		return "Employee2 [name=" + name + ", lastName=" + lastName + ", role="
				+ role + ", d=" + d + "]";
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Department2 getD() {
		return d;
	}
	public void setD(Department2 d) {
		this.d = d;
	}
	
}
