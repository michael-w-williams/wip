package com.example.fn;

import com.fnproject.fn.api.FnConfiguration;
import com.fnproject.fn.api.RuntimeContext;


public class HelloFunction {
	/* Vars for Env Variables */
	private String dbHost;		// DB_HOST
	private String dbUser;		// DB_USER
	private String dbPassword;	// DB_PASSWORD
	
	@FnConfiguration
	public void config(RuntimeContext ctx) {
		
		dbHost = ctx.getConfigurationByKey("DB_HOST").orElse("//localhost/DBName");
		
		dbUser = ctx.getConfigurationByKey("DB_USER").orElse("your-db-account");
				
		dbPassword = ctx.getConfigurationByKey("DB_PASSWORD").orElse("your-db-password");
		
	}
	
    public String handleRequest(String input) {
    	String resultStr = "";
        String name = (input == null || input.isEmpty()) ? "world"  : input;

        resultStr = resultStr + "Hello " + name + "!\n";
        resultStr = resultStr + "JDBC Host: " + dbHost + "\n";
        resultStr = resultStr + "JDBC User: " + dbUser + "\n";
        resultStr = resultStr + "JDBC Passwd: " + dbPassword + "\n";
        
        return resultStr;
    }

}