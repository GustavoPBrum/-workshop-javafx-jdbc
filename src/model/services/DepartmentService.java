package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {
	
	public List<Department> findAll() {
		// Dados temporarios para ter o que retornar (MOCK)
		List<Department> list = new ArrayList<>();
		list.add(new Department(1, "IT"));
		list.add(new Department(2, "Engenharia"));
		list.add(new Department(3, "Books"));
		
		return list;
	}
}
