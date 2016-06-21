package main.java;

import main.java.validationRules.AllAlphaValidation;
import main.java.validationRules.FactorValidation;
import main.java.validationRules.FirstLetterUpperOnlyValidation;
import main.java.validationRules.MonetaryValidation;
import main.java.validationRules.NotEmptyValidation;
import main.java.validationRules.NotNegativeValidation;
import main.java.validationRules.WithinModLimitsValidation;

public class ValidationEngine implements IValidationEngine {
	
	@Override
	public IValidationResult validate(String value, String[] validationTags) {
		
		IValidationResult result = null;
		
		// loop through each tag, referencing the corresponding rule
		for (String tag : validationTags) {
			
			switch (tag) {
				case "notEmpty" :
					result = new NotEmptyValidation(value);
					break;
				case "money" :
					result = new MonetaryValidation(value);
					break;
				case "notNegative" :
					result = new NotNegativeValidation(value);
					break;
				case "withinModLimits" :
					result = new WithinModLimitsValidation(value);
					break;
				case "factor" :
					result = new FactorValidation(value);
					break;
				case "allAlpha" :
					result = new AllAlphaValidation(value);
					break;
				case "firstLetterUpperOnly" :
					result = new FirstLetterUpperOnlyValidation(value);
					break;
			}
			
			if (!result.passes()) {
				return result;
			}
		}
		
		return result; // all test passed, will return the latest rule result
	}
}
