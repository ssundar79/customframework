package com.custom.framework;

import com.custom.framework.module.Module;


public final class CustomInjection {

	private CustomInjection() {
		
	}
	
    public static CustomFramework getFramework(final Module module) {
        module.configure();
        return new CustomFramework(module);
    }
}