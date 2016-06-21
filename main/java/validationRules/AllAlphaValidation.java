package main.java.validationRules;

import main.java.IValidationResult;

public class AllAlphaValidation implements IValidationResult {
	
	private String value;
	private final String failMessage = "Value has non alphabetic characters";
	
	public AllAlphaValidation(String value) {
		this.value = value;
	}
	
	@Override
	public boolean passes() {
		String regex = "[a-zA-Z]+";
		
		if (value.matches(regex)) {
			return true;
		}
		
		return false;
	}

	@Override
	public String getMessage() {
		return failMessage;
	}

}
