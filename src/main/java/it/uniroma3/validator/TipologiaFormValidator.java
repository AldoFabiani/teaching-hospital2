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
	public void validate(Object arg0, Errors error) {
		TipologiaEsame tipologia = (TipologiaEsame) arg0;
		if(tipologia.getCosto() <=0){
			error.rejectValue("costo", "negativeValue", new Object[]{"'costo'"}, "Il costo non può essere negativo");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "nome", "tipologia.nome.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "descrizione", "tipologia.descrizione.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "costo", "tipologia.costo.required");
	}
	

}
