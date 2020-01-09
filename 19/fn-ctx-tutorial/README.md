# Using Configuration Variables in your Functions
In addition to the normal variables you use in function creation, Fn allows you to pass configuration data, created with the CLI, into your function.  This data along with other automatically generated information are converted into environment variables and are made available to your function's context. This tutorial covers how to set your own configuration variables and now to use them in a function.

## Function Scenario
In this tutorial, you create a `config-vars` function that displays configuration data passed to the function. For the example, let's use some database information that we might need in a function. 

* `DB_HOST_URL` displays the hostname and path to the database.
* `DB_USER` is the user name used to connect to the datbase.
* `DB_PASSWORD` is the password for our database user.

## What Contexts are Available for my Function?
There are several Fn spaces where you put and get data for your function.

* Application space: 
* Function space:
* Default space:

### Default Space
Put list of auto generated vars here.

### Discuss what Data we will Get here

The `DB_HOST_URL`, `DB_USER`, and `DB_PASSWORD` environment variables are set on different configuration levels.
For example, the value of the `DB_DRIVER` variable is read from the `func.yaml` file in the `config` key. The `DB_URL` and `DB_USER`
environment variables are set in the application configuration level, and the `DB_PASSWORD` environment variable is set in the
function configuration level.

## Step by step: Set the configuration values
Ensure you have the Fn server running to host your function.

### Break this up by variables so we can test each part.

(1) Start the server.

```sh
$ fn start
```

(2) Go to the `configuration-variables` directory.

```sh
$ cd configuration-variables
```

(3) Create an app for the function.

```sh
$ fn create app connection-app
```

(4) At the application level, configure the `DB_URL` environment variable.

```sh
$ fn config app connection-app DB_URL jdbc:mysql
```

(5) At the application level, configure the `DB_USER` environment variable.

```sh
$ fn config app connection-app DB_USER superadmin
```

(6) Deploy the application.

```sh
$ fn deploy --app connection-app --local
```
(7) At the function level, configure the `DB_PASSWORD` environment variable.

```sh
$ fn config function connection-app connection DB_PASSWORD superadmin
```

(8) Invoke the `connection` function.

```sh
$ fn invoke connection-app connection
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
