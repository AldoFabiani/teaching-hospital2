package it.uniroma3.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.Employee;

public class EmployeeFormValidator implements Validator {
	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Employee.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		Employee emp = (Employee) obj;
		
		if(emp.getSalary() <=0){
			errors.rejectValue("salary", "negativeValue", new Object[]{"'salary'"}, "salary can't be negative");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "department", "department.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobTitle", "jobTitle.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "salary", "salary.required");
	}
}
