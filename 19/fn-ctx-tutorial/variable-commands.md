# Fn Variable Commands
The Fn CLI can store variable information in the following spaces:

* **Application:**
* **Function:**


## Fn Variable Command Reference
The following sections provide definitions and examples of all the Fn commands related to the Fn context.

### Cheat Sheet
* Create: `fn c ctx <context-name> --api-url http://<host>:<port> --registry <docker-hub-id>`
* Delete: `fn d ctx <context-name>`
* List: `fn ls <context-name>`
* Update (Add) Name/Value: `fn up ctx <key> <value>`
* Update (Delete) Name/Value: `fn up ctx --delete <key>`


## Usage: Setup a new Context
Here are the steps to setup a new context.
* Create context
    * `fn c ctx my-ctx --api-url http://localhost:8080 --registry yourGitHubUserName`
* Use the new context:
    * `fn u ctx my-ctx`
* Get list of contexts:
    * `fn ls ctx`
    * Should show all the contexts that exist with your new context selected.


### Usage Examples
* Create: `fn c ctx my-ctx --api-url http://localhost:8080 --registry youridhere`
* Delete: `fn d ctx my-ctx`
* List: `fn ls ctx`
* Update (Add) Name/Value: `fn u ctx KEY value`
* Update (Delete) Name/Value: `fn u ctx --delete KEY`



### Detailed Command Examples
* **Create** a new Fn context with the name and data provided.
    * `fn create context <context-name> --api-url http://<host>:<port> --registry <docker-hub-id>`
* **Delete** an Fn context with the specified name.
    * `fn delete context <context-name>`
* **List** all contexts on this system.
    * `fn list <context-name>`
* **Add or Update** key/value data in your context.
    * `fn update context <key> <value>`
* **Update (Delete)** a name/value pair from your context.
    * `fn update context --delete <key>`
