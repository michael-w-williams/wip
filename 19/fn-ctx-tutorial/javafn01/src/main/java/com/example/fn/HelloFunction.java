package com.example.fn;

import com.fnproject.fn.api.FnConfiguration;
import com.fnproject.fn.api.RuntimeContext;


public class HelloFunction {
	/* Vars for Env Variables */
	private String dbDriver;	// DB_DRIVER
	private String dbType;		// DB_TYPE
	private String dbHost;		// DB_HOST
	private String dbUser;		// DB_USER
	private String dbPassword;	// DB_PASSWORD
	
	@FnConfiguration
	public void config(RuntimeContext ctx) {
		dbDriver = ctx.getConfigurationByKey("DB_DRIVER")
					.orElse("oracle.jdbc.driver.OracleDriver");
		dbType = ctx.getConfigurationByKey("DB_TYPE")
				.orElse("jdbc:oracle:");
		dbHost = ctx.getConfigurationByKey("DB_HOST")
				.orElse("//localhost/DBName");
		dbUser = ctx.getConfigurationByKey("DB_USER")
				.orElse("admin");
		dbPassword = ctx.getConfigurationByKey("db-password")
				.orElse("your-password");
		
	}
	
    public String handleRequest(String input) {
    	String resultStr = "";
        String name = (input == null || input.isEmpty()) ? "world"  : input;

        resultStr = resultStr + "Hello " + name + "!\n";
        resultStr = resultStr + "JDBC Driver: " + dbDriver + "\n";
        resultStr = resultStr + "JDBC URL: " + dbType + dbHost + "\n";
        resultStr = resultStr + "JDBC User: " + dbUser + "\n";
        resultStr = resultStr + "JDBC Passwd: " + dbPassword + "\n";
        
        return resultStr;
    }

}