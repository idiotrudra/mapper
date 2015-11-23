package com.idiot.rudra.example.mapper;

import com.idiot.rudra.example.Employee1;
import com.idiot.rudra.example.Employee2;
import com.idiot.rudra.mapper.AbstractMapper;

/**
 * Mapper for employee Object. 
 * 
 * @author IdiotRudra
 * @date Nov 23, 2015
 */
public class EmployeeMapper extends AbstractMapper<Employee1, Employee2>{

	public void addMyChild() {
		addChild(new DepartmentMapper());
	}
	
	@Override
	public void mapInternal(Employee1 s, Employee2 d) {
		d.setName(s.getName());
		d.setLastName(s.getLastName());
		d.setRole(s.getRole());
	}

}
