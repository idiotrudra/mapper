package com.idiot.rudra.example;

public class Department {

	private String departmentName;
	private String departmentId;
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName
				+ ", departmentId=" + departmentId + "]";
	}
	
}
