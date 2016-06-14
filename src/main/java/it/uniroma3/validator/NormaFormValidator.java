package it.uniroma3.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.Norma;


public class NormaFormValidator implements Validator {
	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return Norma.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		Norma norma = (Norma) obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "norma.nome.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "norma.descrizione.required");
	
	}
}
