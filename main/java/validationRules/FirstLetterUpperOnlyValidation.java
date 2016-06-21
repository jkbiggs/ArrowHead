package main.java.validationRules;

import main.java.IValidationResult;

public class FirstLetterUpperOnlyValidation implements IValidationResult {
	
	private String value;
	private final String failMessage = "Value's first letter is not uppercase";
	
	public FirstLetterUpperOnlyValidation(String value) {
		this.value = value;
	}
	
	
	@Override
	public boolean passes() {
		String firstLetter = value.substring(0,1);
		String firstLetterUpper = value.substring(0,1).toUpperCase();
		
		if (firstLetter.equals(firstLetterUpper)) {
			return true;
		}
		
		return false;
	}

	@Override
	public String getMessage() {
		return failMessage;
	}

}
