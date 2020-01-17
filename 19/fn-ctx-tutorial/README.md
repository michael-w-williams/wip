# Using Configuration Variables in your Functions
In addition to the normal variables you use in function creation, Fn allows you to pass configuration data, created with the CLI, into your function.  This data, along with other automatically generated information, is converted into environment variables and are made available to your function's context. This tutorial covers how to set your own configuration variables and how to use them in a function.

## Function Scenario
In this tutorial, you create a `java-cfg-fn` function that displays configuration data passed to the function. For the example, let's use some database information that we might need in a function.

* `DB_HOST_URL` displays the hostname and path to the database.
* `DB_USER` is the user name used to connect to the database.
* `DB_PASSWORD` is the password for our database user.

> As you make your way through this tutorial, look out for this icon.
![User input icon](images/userinput.png) Whenever you see it, it's time for you to
perform an action.


## What Variable Spaces are Available for my Function?
There are several Fn variable spaces where you put and get data for your function.

* **Application space:** Variables stored in an application are available to all functions that are deployed to that application.
    * Example: 
* **Function space:** Variables stored for a function are only available to that function.
* **Default space:** By default, a number of environment variables are automatically generated in an Fn Docker image. The section that follows details the automatically generated variables.

#### Default Space Variables
Here is the list of automatically generated variables in the default space that are available to your functions.

|Fn Generated Var|Sample Value|Description|
|----------------|------------|-----------|
|[FN_APP_ID]|01NNNNNNNNNG8G00GZJ0000001|The application ID for the app the current function is contained in.|
|[FN_FN_ID]|01DYNNNNNNNG8G00GZJ0000002|The ID of the current function|
|[FN_FORMAT]|http-stream|(Deprecated). Communications protocol.|
|[FN_LISTENER]|unix:/tmp/iofs/lsnr.sock|The Unix socket address (prefixed with "unix:") on the file system that the FDK should create to listen for requests. The platform will guarantee that this directory is writable to the function. FDKs must not write any other data than the unix socket to this directory.|
|[FN_MEMORY]|128|The maximum memory of the function in MB.|
|[FN_TYPE]|sync|The type of function. Always `sync` currently.|



### Where to set the Variables
For this tutorial, let's set the `DB_HOST_URL` at the application level and the `DB_USER`, and `DB_PASSWORD` variables at the function level. That gives us a little practices setting both types of variables.


## Create the Sample Configuration Function.
Ensure you have the Fn server running to host your function.

### Break this up by variables so we can test each part.

(1) Start the server.

![User input icon](images/userinput.png)
```sh
% fn start
```

(2) Create the `cfg-app` for your function.

![User input icon](images/userinput.png)

```sh
% fn c a cfg-app
```

(3) Create a boilerplate `java-cfg-fn` function.

![User input icon](images/userinput.png)
```sh
% fn init --runtime java java-cfg-fn
```

(4) Change into the `java-cfg-fn` directory.

![User input icon](images/userinput.png)
```sh
% cd java-cfg-fn
```

(5) Remove the `src/test` directory so we don't have to update our tests.

![User input icon](images/userinput.png)
```sh
% rm -r src/test
```

(6) Add the the `DB_HOST_URL` variable to `cfg-app`.

![User input icon](images/userinput.png)
```sh
% fn cf a cfg-app DB_HOST_URL //myhost/mydb
```

(7) Verify the value has been added.

![User input icon](images/userinput.png)
```sh
% fn ls cf a cfg-app
KEY	VALUE
DB_HOST_URL	//myhost/mydb
```


(8) Modify the "Hello World!" boiler plate example (located in src -> main -> java -> com -> example -> fn -> HelloFunction.java) as described in the next section.

(9) Deploy and invoke your function locally.

![User input icon](images/userinput.png)
```sh
% fn -v dp --app cfg-app --local
```

![User input icon](images/userinput.png)
```sh
% fn iv cfg-app java-cfg-fn
```

Your output should be similar to:
```sh
Hello world!
DB Host URL: //myhost/mydb
DB User: your-db-account
DB Passwd: your-db-password
% fn iv cfg-app java-cfg-fn
```

### Adding the Fn Context to your Function
Update the `HelloFunction` class as shown below. An explanation of the changes follows below.

```Java
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
		
		dbHost = ctx.getConfigurationByKey("DB_HOST_URL").orElse("//localhost/DBName");
		
		dbUser = ctx.getConfigurationByKey("DB_USER").orElse("your-db-account");
				
		dbPassword = ctx.getConfigurationByKey("DB_PASSWORD").orElse("your-db-password");
		
	}
	
    public String handleRequest(String input) {
    	String resultStr = "";
        String name = (input == null || input.isEmpty()) ? "world"  : input;

        resultStr = resultStr + "Hello " + name + "!\n";
        resultStr = resultStr + "DB Host URL: " + dbHost + "\n";
        resultStr = resultStr + "DB User: " + dbUser + "\n";
        resultStr = resultStr + "DB Passwd: " + dbPassword + "\n";
        
        return resultStr;
    }

}
```

First,

```java
import com.fnproject.fn.api.FnConfiguration;
import com.fnproject.fn.api.RuntimeContext;
```


```java
@FnConfiguration
public void config(RuntimeContext ctx) {
    
    dbHost = ctx.getConfigurationByKey("DB_HOST_URL").orElse("//localhost/DBName");
    
    dbUser = ctx.getConfigurationByKey("DB_USER").orElse("your-db-account");
            
    dbPassword = ctx.getConfigurationByKey("DB_PASSWORD").orElse("your-db-password");
    
}
```


## Add the Function Variables and Retest

(5) At the application level, configure the `DB_USER` variable.

```sh
% fn config app connection-app DB_USER superadmin
```

(6) Deploy the application.

```sh
% fn deploy --app connection-app --local
```
(7) At the function level, configure the `DB_PASSWORD` environment variable.

```sh
% fn config function connection-app connection DB_PASSWORD superadmin
```

(8) Invoke the `connection` function.

```sh
% fn invoke connection-app connection
driver: mysqlDriver; url: jdbc:mysql; user: superadmin; password: superadmin
```

## Code walkthrough: Should move before steps

### Add func.yaml


### Update Function for new context above



The entrypoint to the function is specified in `func.yaml` in the `cmd` key.
It is set to `com.example.fn.Connection::getConnection`. The whole class
`Connection` is shown below:

```java
package com.example.fn;

import com.fnproject.fn.api.FnConfiguration;
import com.fnproject.fn.api.RuntimeContext;


public class Connection {
	private String url;
	private String driver;
	private String user;
	private String password;

	@FnConfiguration
    public void config(RuntimeContext ctx) {
		//Set value at the application configuration level
    	url = ctx.getConfigurationByKey("DB_URL")
    			.orElse("jdbc:oracle");
    	//Set value in the func.yaml
    	driver = ctx.getConfigurationByKey("DB_DRIVER")
    			.orElse("OracleDriver");
    	//Set value at the application configuration level
    	user = ctx.getConfigurationByKey("DB_USER")
    			.orElse("admin");
    }


    public String getUrl() {
    	return  url;
    }


    public String getDriver() {
    	return  driver;        
    }


    public String getUser() {
        return  user;        
    }

	//Set value at the function configuration level
    public String getPassword() {
        password = System.getenv().getOrDefault("DB_PASSWORD", "admin");
    	return  password;        
    }

    public String getConnection() {
    	return "driver: " + getDriver() + "; url: " + url + "; user: " + getUser() + "; password: " + getPassword();
    }
}

```

For more information see the [configuration vars documentaion page](https://github.com/fnproject/docs/blob/master/fn/develop/configs.md).
