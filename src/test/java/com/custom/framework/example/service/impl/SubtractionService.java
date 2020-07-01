package com.custom.framework.example.service.impl;

import com.custom.framework.example.service.CalculatorService;

public class SubtractionService implements CalculatorService {

	@Override
	public int calculate(int firstNumber, int secondNumber) {
		return firstNumber - secondNumber;
	}

}
