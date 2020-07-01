# Custom-Dependency-Injection-Framework 

This is custom project to build  own dependency injection framework using Java.

It suitable for **constructor** and **field** injection.



#Design considerations:

The two main classes are **CustomModule** and **CustomFramework**.
 
* The **CustomModule** contains interfaces with their implementations .
* The **CustomFramework** performs the injection via java reflection. 
* It checks that the constructor and fields are annotated with **@Injection** annotation.
* **@Injection** annotation is used to perform the Dependency Injection

#Limitations:
Add simple calculator service for add, substract, multiple operation, can be extended to all Math operation.

#Usage Guide:

To Build and Run test

 cd Custom-Dependency-Injection-Framework
 mvn clean install
 
#How to Customise:
##### 1. You have to define how you want to map interfaces to their implementations.

```java
private class additionServiceInjection extends CustomModule {

		@Override
		public void configure() {
			createMapping(CalculatorService.class, AdditionService.class);
		}
	}
```

##### 2. Add **@Injection** annotation to constructor or field.

```java
public class ConstructorInjection {

	private final CalculatorService calculatorService;


	@Injection
	public ConstructorInjection(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}
}
```

OR

```java
public class FieldInjection {

	@Injection
	private CalculatorService calculatorService;
}
```

##### 3. Use **CustomFramework** to get your injected class.

```java
public class SampleDependencyInjection {
    
    public static void main(final String[] args) throws Exception {
        CustomFramework custFrame = CustomInjection.getFramework(new substractionServiceInjection());
		ConstructorInjection example = (ConstructorInjection) custFrame.inject(ConstructorInjection.class);
    }

}
```


 
