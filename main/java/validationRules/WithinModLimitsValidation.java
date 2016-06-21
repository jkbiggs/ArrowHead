package main.java.validationRules;

import main.java.IValidationResult;

public class WithinModLimitsValidation implements IValidationResult {
	
	private String value;
	private final String failMessage = "Value is not within limits for a mod factor";
	
	public WithinModLimitsValidation(String value) {
		this.value = value;
	}
	
	
	@Override
	public boolean passes() {
		double val = Double.parseDouble(value);
		
		if (val >= 1.0 && val <= 3.5) {
			return true;
		}
		return false;
	}

	@Override
	public String getMessage() {
		return failMessage;
	}

}
