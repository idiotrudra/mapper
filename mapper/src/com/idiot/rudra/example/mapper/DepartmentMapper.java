package com.idiot.rudra.example.mapper;

import com.idiot.rudra.example.Department2;
import com.idiot.rudra.example.Employee1;
import com.idiot.rudra.example.Employee2;
import com.idiot.rudra.mapper.AbstractMapper;

public class DepartmentMapper extends AbstractMapper<Employee1, Employee2> {

	@Override
	public void mapInternal(Employee1 s, Employee2 d) {
		d.setD(new Department2());
		d.getD().setDepartmentId(s.getD().getDepartmentId());
		d.getD().setDepartmentName(s.getD().getDepartmentName());
	}

}
