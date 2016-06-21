package main.java.validationRules;

import main.java.IValidationResult;

public class MonetaryValidation implements IValidationResult {
	
	private String value;
	private final String failMessage = "Value is not a valid monetary value";
	
	public MonetaryValidation(String value) {
		this.value = value;
	}
	
	@Override
	public boolean passes() {
		int decimalIndex = value.indexOf(".");
		decimalIndex++;  //increment to move to the digit following the decimal
		
		if (value.substring(decimalIndex).length() > 2) {
			return false;
		}
		return true;
	}

	@Override
	public String getMessage() {
		return failMessage;
	}
}
