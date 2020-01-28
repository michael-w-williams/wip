## <img src="https://fnproject.io/images/fn-300x125.png" alt="Fn Project Logo" height="21" width="50"> Project Documentation

**[Quickstart](https://github.com/fnproject/fn#quickstart)&nbsp; | &nbsp;[Tutorials](https://fnproject.io/tutorials)&nbsp; |  &nbsp;[Docs](https://github.com/fnproject/docs)&nbsp; | &nbsp;[API](http://petstore.swagger.io/?url=https://raw.githubusercontent.com/fnproject/fn/master/docs/swagger_v2.yml)**


Fn is an event-driven, open source, [Functions-as-a-Service (FaaS)](https://github.com/fnproject/docs/blob/master/fn/general/introduction.md) compute platform that you can run anywhere. 

### Getting Started
* [**Quickstart Tutorial**](https://github.com/fnproject/fn#quickstart)
* [**Fn Installation**](https://fnproject.io/tutorials/install/)
* **Using Fn with Java**
    * [Java Tutorial](https://fnproject.io/tutorials/JavaFDKIntroduction/)
    * [Examples](https://github.com/fnproject/docs/tree/master/fdks/fdk-java)
* **Using Fn with Node.js**
    * [Node Tutorial](https://github.com/fnproject/tutorials/blob/master/node/intro/README.md)
    * [Examples](https://github.com/fnproject/docs/tree/master/fdks/fdk-node)
* **Using Fn with Python**


* **Creating Functions with Docker**



* [**Logging and Debugging Tutorial**](https://github.com/fnproject/tutorials/blob/master/Troubleshooting/README.md)
    * [Function Debugging](https://github.com/fnproject/docs/blob/master/fn/troubleshoot/debug-loglevel.md)


* **Using Fn with Other Languages**
    * Go
    * Ruby
    * C# (Community Supported)


Official:

* [Go](Introduction/README.md)
* [Ruby](ruby/intro/README.md)
* [Python](python/intro/README.md)

Community Supported:

* [C#](csharp/intro/README.md)




## Fn Reference Docs

* [Fn Applications](fn/develop/apps.md): How to group functions together in an application.
* [Fn Tutorials](http://fnproject.io/tutorials) for step-by-step guides to creating apps with Fn. These tutorials range from introductory to more advanced.
* [Config Vars for Functions](fn/develop/configs.md): How to set configuration variables for applications, functions, or in `func.yaml`.
* [Fn Function File Format](fn/develop/func-file.md): All the values that can be used in `func.yaml`.
* [Fn FDKs](fn/develop/fdks.md): Function Development Kits for supported languages.
* [Windows: Running Fn Client for Windows](fn/develop/running-fn-client-windows.md): Run the Fn client on Microsoft Windows.
* [Triggers](fn/develop/triggers.md): Using triggers.
* [Troubleshooting](fn/troubleshoot/README.md): Solutions to common problems when working with Fn.
    * Known Issue: [Trying to invoke a function when using a CentOS based Linux fails with an error message](fn/troubleshoot/known-issues/2019-08-fn-invoke-fails.md)


### Examples
* FDK for Java
    * [Configuration Variables](https://github.com/fnproject/docs/tree/master/fdks/fdk-java/examples/configuration-variables): Set configuration values for applications, function, and in `func.yaml`.
    * [Gradle Build](https://github.com/fnproject/docs/tree/master/fdks/fdk-java/examples/gradle-build): Use a function to build and run a Java app using Gradle.
    * [QR Code](https://github.com/fnproject/docs/blob/master/fdks/fdk-java/examples/qr-code/README.md): Generate QR Codes from data passed to the function.
    * [Regex](https://github.com/fnproject/docs/tree/master/fdks/fdk-java/examples/regex-query): Pass a regex to a function.
    * [Simple Reverse String](https://github.com/fnproject/docs/tree/master/fdks/fdk-java/examples/string-reverse): Reverse the letters in a string.


### Learn More
* [Fn API Reference](http://petstore.swagger.io/?url=https://raw.githubusercontent.com/fnproject/fn/master/docs/swagger_v2.yml)
* [API Clients](fn/develop/clients.md)
* [CLI Docs and Reference](cli/README.md)
    * [CLI Context Commands](fn/operate/context-commands.md)
* [Packaging functions](fn/develop/packaging.md)
* [FAQ](fn/general/faq.md)
* [Pagination](fn/develop/pagination.md)

## For Operators

If you are operating Fn, this section is for you.

### Getting Started

* [Running in Production](fn/operate/production.md)
* [Logging](fn/operate/logging.md)
* [Message Queues](fn/operate/message-queues.md)
* [Metrics](fn/operate/metrics.md)
* [User Interface](fn/operate/ui.md)

### Learn More

* [Docker Configuration](fn/operate/docker.md)
* [Extending Fn](fn/operate/extending.md)
* [Kubernetes Helm Chart for Fn](https://github.com/fnproject/fn-helm/)
* [Operating on Windows](fn/operate/windows.md)
* [Private Registries](fn/operate/private_registries.md)
* [Runtime Options](fn/operate/options.md)

## For Contributors

We love contributions! To get started, please visit our [community page](/community/README.md) and [contributing guidelines](community/CONTRIBUTING.md) page.



## Other Resources

* [Ask your question on StackOverflow](https://stackoverflow.com/questions/tagged/fn) and tag it with `fn`
* Join our [Slack Community](http://slack.fnproject.io)
* Join us at one of our [Fn Events](http://events.fnproject.io) or even speak at one!
* For a full presentation with lots of content you can use in your own presentations, see [The Fn Project Presentation Master](http://deck.fnproject.io)
* Check out our sub-projects: [Flow](https://github.com/fnproject/flow), [UI](https://github.com/fnproject/ui)


## Stay Informed

* [Blog](https://medium.com/fnproject)
* [Twitter](https://twitter.com/fnproject)
* [YouTube](https://www.youtube.com/channel/UCo3fJqEGRx9PW_ODXk3b1nw)
* [Events](http://events.fnproject.io)
