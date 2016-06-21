package main.java.validationRules;

import main.java.IValidationResult;

public class NotEmptyValidation implements IValidationResult {

	private String value;
	private final String failMessage = "Value cannot be empty";
	
	public NotEmptyValidation(String value) {
		this.value = value;
	}
	
	@Override
	public boolean passes() {
		if (value == null || value.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public String getMessage() {
		return failMessage;
	}

}
