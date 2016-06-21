package test.java;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.IValidationEngine;
import main.java.IValidationResult;
import main.java.ValidationEngine;

public class ValidationEngineTest
{
	private IValidationEngine validator;
	
	@Before
	public void setUp()
	{
		validator = new ValidationEngine();
	}
	
	@Test
	public void moneyPass()
	{
		final String [] validationTags = new String[]{"notEmpty", "money", "notNegative"};
		final String value = "10.01";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = true;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void moneyFailNotValid()
	{
		final String [] validationTags = new String[]{"notEmpty", "money", "notNegative"};
		final String value = "10.01789";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void moneyFailEmpty()
	{
		final String [] validationTags = new String[]{"notEmpty", "money", "notNegative"};
		final String value = "";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void moneyFailNegative()
	{
		final String [] validationTags = new String[]{"notEmpty", "money", "notNegative"};
		final String value = "-10.01";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorPassWithinModLimits()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "2.7";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = true;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorFailNotValid()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "2.734F";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorPassEqualLowerLimit()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "1.0";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = true;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorPassEqualUpperLimit()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "3.5";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = true;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorFailAboveLimit()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "3.55";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorFailBelowLimit()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "0.95";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorFailEmpty()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorFailNegative()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "-2.0";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void namePassValidFormat()
	{
		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "Bob";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = true;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void nameFailnotAllAlpha()
	{
		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "B2B";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void nameFailfirstLetterNotUpper()
	{
		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "jAson";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void nameFailEmpty()
	{
		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final boolean expected = false;
		final boolean actual = validationResult.passes();
		assertEquals(expected, actual);
	}
	
	@Test
	public void moneyNotValidMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "money", "notNegative"};
		final String value = "10.01789";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is not a valid monetary value";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void moneyEmptyMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "money", "notNegative"};
		final String value = "";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value cannot be empty";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void moneyNegativeMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "money", "notNegative"};
		final String value = "-10.01";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value cannot be negative";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorNotValidMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "2.734F";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is not a valid decimal number";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorAboveLimitMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "3.55";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is not within limits for a mod factor";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorBelowLimitMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "0.95";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value is not within limits for a mod factor";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorEmptyMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value cannot be empty";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void factorNegativeMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "factor", "notNegative", "withinModLimits"};
		final String value = "-2.0";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value cannot be negative";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void nameNotAllAlphaMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "B2B";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value has non alphabetic characters";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void namefirstLetterNotUpperMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "jAson";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value's first letter is not uppercase";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void nameEmptyMessage()
	{
		final String [] validationTags = new String[]{"notEmpty", "allAlpha", "firstLetterUpperOnly"};
		final String value = "";
		final IValidationResult validationResult = validator.validate(value, validationTags);
		
		final String expected = "Value cannot be empty";
		final String actual = validationResult.getMessage();
		assertEquals(expected, actual);
	}
}
