package main.java;

public interface IValidationEngine
{
	public IValidationResult validate(String value, String[] validationTags);
}
