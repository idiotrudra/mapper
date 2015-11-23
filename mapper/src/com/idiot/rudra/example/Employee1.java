package com.idiot.rudra.example;

public class Employee1 {

	private String name;
	private String lastName;
	private String role;
	private Department d;
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Employee1 [name=" + name + ", lastName=" + lastName + ", role="
				+ role + ", d=" + d + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
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
	public Department getD() {
		return d;
	}
	public void setD(Department d) {
		this.d = d;
	}
	
}
