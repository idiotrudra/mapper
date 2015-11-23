package com.idiot.rudra.example.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.idiot.rudra.example.Department;
import com.idiot.rudra.example.Employee1;
import com.idiot.rudra.example.Employee2;
import com.idiot.rudra.mapper.IMapper;

/**
 * This class is for testing employee mapper. 
 * all the fields should be copied successfully in target object.
 * @author IdiotRudra
 * @date Nov 23, 2015
 */
public class TestEmployeeMapper {

	@Test
	public void testMap() {
		Employee1 e1 = new Employee1();
		e1.setName("employee");
		e1.setLastName("employeeLastName");
		e1.setRole("employeeRole");
		Department d = new Department();
		d.setDepartmentId("departMentId");
		d.setDepartmentName("DepartmentName");
		e1.setD(d);
		IMapper<Employee1, Employee2> mapper = new EmployeeMapper();
		Employee2 e2 = mapper.map(e1, new Employee2());
		assertEquals(e1.getName(), e2.getName());
		assertEquals(e1.getLastName(), e2.getLastName());
		assertEquals(e1.getRole(), e2.getRole());
		assertEquals(e1.getD().getDepartmentId(), e2.getD().getDepartmentId());
		assertEquals(e1.getD().getDepartmentName(), e2.getD()
				.getDepartmentName());
	}

}
