package it.uniroma3.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import it.uniroma3.model.Employee;
public interface EmployeeService {
	
	@Secured({"ROLE_USER", "ROLE_GUEST", "ROLE_ADMIN"})
	public List<Employee> listEmployee();

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public void insertEmployee(Employee employee);
	
	@Secured({"ROLE_ADMIN"})
	public void deleteEmployee(Integer empId);

}
