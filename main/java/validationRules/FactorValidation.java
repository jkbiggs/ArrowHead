package main.java.validationRules;

import main.java.IValidationResult;

public class FactorValidation implements IValidationResult {
	
	private String value;
	private final String failMessage = "Value is not a valid decimal number";
	
	public FactorValidation(String value) {
		this.value = value;
	}
	
	@Override
	public boolean passes() {
		int decimalIndex = value.indexOf(".");
		decimalIndex++;  //increment to move to the digit following the decimal
		
		String regex = "\\d+";
		
		if (value.substring(decimalIndex).matches(regex)) {
			return true;
		}
		
		return false;
	}

	@Override
	public String getMessage() {
		return failMessage;
	}

}
