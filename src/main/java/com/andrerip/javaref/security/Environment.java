package com.andrerip.javaref.security;

import java.io.IOException;
import java.util.Map;

public class Environment {

	public static void main(String[] args) throws IOException {
        System.getenv();  // Sensitive
        System.getenv("myvar");  // Sensitive

        ProcessBuilder processBuilder = new ProcessBuilder();
        Map<String, String> environment = processBuilder.environment();  // Sensitive
        environment.put("VAR", "value");

        Runtime.getRuntime().exec("ping", new String[]{"env=val"});   // Sensitive

	}

}
