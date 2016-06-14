package it.uniroma3.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.model.TipologiaEsame;

public class TipologiaFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return TipologiaEsame.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		TipologiaEsame tipologia = (TipologiaEsame) arg0;

		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nome", "tipologia.nome.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "descrizione", "tipologia.descrizione.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "costo", "tipologia.costo.required");
	}
	

}
