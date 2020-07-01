package com.custom.framework.example;

import com.custom.framework.annotation.Injection;
import com.custom.framework.example.service.CalculatorService;


public class FieldInjection {

	@Injection
	private CalculatorService calculatorService;


	public String processNumbers(int firstNumber, int secondNumber) {
		int number = calculatorService.calculate(firstNumber, secondNumber);
		return String.valueOf(number);
	}
}