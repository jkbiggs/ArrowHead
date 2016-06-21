package main.java.validationRules;

import main.java.IValidationResult;

public class NotNegativeValidation implements IValidationResult {

	private String value;
	private final String failMessage = "Value cannot be negative";
	
	public NotNegativeValidation(String value) {
		this.value = value;
	}
	
	@Override
	public boolean passes() {
		return Double.parseDouble(value) > -1;
	}

	@Override
	public String getMessage() {
		return failMessage;
	}

}
