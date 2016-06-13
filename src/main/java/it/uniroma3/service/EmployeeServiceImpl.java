package it.uniroma3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.dao.EmployeeDao;
import it.uniroma3.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	public List<Employee> listEmployee() {
		return this.employeeDao.listEmployee();
	}
	
	@Override
	public void insertEmployee(Employee employee) {
		this.employeeDao.insertEmployee(employee);		
	}
	
	@Override
	public void deleteEmployee(Integer empId) {
		this.employeeDao.deleteEmployee(empId);
	}
}
