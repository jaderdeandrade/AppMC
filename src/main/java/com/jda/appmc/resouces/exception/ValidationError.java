package com.jda.appmc.resouces.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {


	private static final long serialVersionUID = 1L;
	

	private List<FieldMessage> errors = new ArrayList<>();
	



	public ValidationError(Long timestamp, Integer status, String error, String message, String path,
			List<FieldMessage> errors) {
		super(timestamp, status, error, message, path);
		this.errors = errors;
	}


	public List<FieldMessage> getErrors() {
		return errors;
	}


	public void addError(String fieldName, String mensagem) {
		errors.add(new FieldMessage(fieldName, mensagem));
	}
}
