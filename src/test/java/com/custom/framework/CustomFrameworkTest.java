package com.custom.framework;

import static org.junit.Assert.assertEquals;

import com.custom.framework.CustomInjection;
import com.custom.framework.CustomFramework;
import com.custom.framework.example.ConstructorInjection;
import com.custom.framework.example.FieldInjection;
import com.custom.framework.example.service.CalculatorService;
import com.custom.framework.example.service.impl.AdditionService;
import com.custom.framework.example.service.impl.MultiplyService;
import com.custom.framework.example.service.impl.SubtractionService;
import com.custom.framework.module.impl.CustomModule;

import org.junit.Test;

public class CustomFrameworkTest {

	@Test
	public void additionServiceInjection() throws Exception {
		CustomFramework custFrame = CustomInjection.getFramework(new additionServiceInjection());
		FieldInjection example = (FieldInjection) custFrame.inject(FieldInjection.class);

		String processNumbers = example.processNumbers(10, 10);

		assertEquals("20", processNumbers);
	}

	

	@Test
	public void substractionServiceInjection() throws Exception {
		CustomFramework custFrame = CustomInjection.getFramework(new substractionServiceInjection());
		ConstructorInjection example = (ConstructorInjection) custFrame.inject(ConstructorInjection.class);
		
		String processNumbers = example.processNumbers(5, 4);
		
		assertEquals("1", processNumbers);
	}
	
	@Test
	public void multiplyServiceInjection() throws Exception {
		CustomFramework custFrame = CustomInjection.getFramework(new multipleServiceInjection());
		ConstructorInjection example = (ConstructorInjection) custFrame.inject(ConstructorInjection.class);
		
		String processNumbers = example.processNumbers(6, 6);
		
		assertEquals("36", processNumbers);
	}

	private class additionServiceInjection extends CustomModule {

		@Override
		public void configure() {
			createMapping(CalculatorService.class, AdditionService.class);
		}
	}

	

	private class substractionServiceInjection extends CustomModule {
		
		@Override
		public void configure() {
			createMapping(CalculatorService.class, SubtractionService.class);
		}
	}
	
	private class multipleServiceInjection extends CustomModule {
			
			@Override
			public void configure() {
				createMapping(CalculatorService.class, MultiplyService.class);
			}
		}

}
