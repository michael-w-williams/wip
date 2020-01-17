# Fn-Context Testing Notes
My notes for the Fn-Context tutorial.

## Fn Context Command Reference
### Cheat Sheet
* Create: `fn c ctx <context-name> --api-url http://<host>:<port> --registry <docker-hub-id>`
* Delete: `fn d ctx <context-name>`
* List: `fn ls <context-name>`
* Update (Add) Name/Value: `fn up ctx DB_URL jdbc:mysql`
* Update (Delete) Name/Value: `fn up ctx --delete DB_URL`



### Manage Fn Contexts

#### Create a new Context
Creates a new Fn context with the name and data provided.
* Long Form: `fn create context <context-name> --api-url http://<host>:<port> --registry <docker-hub-id>`
* Short Form: `fn c ctx <context-name> --api-url http://<host>:<port> --registry <docker-hub-id>`
* Usage example: `fn c ctx my-ctx --api-url http://localhost:8080 --registry youridhere`

#### Delete a Context
Deletes an Fn context with the specified name.
* Long Form:`fn delete context <context-name>`
* Short Form: `fn d ctx <context-name>`
* Usage Example: `fn d ctx my-ctx`

#### Get a list of Contexts
Gets a list of all contexts on this system.
* Long Form: `fn list <context-name>`
* Short Form: `fn ls <context-name>`
* Usage Example: `fn ls ctx`

#### Update (Add) Data to your Context
Add key value data to your context.
* Long Form:
* Short Form: `fn u ctx DB_URL jdbc:mysql`
* Usage Example: `fn u ctx DB_URL jdbc:mysql`

#### Update (Delete) Data to your Context
Add key value data to your context.
* Long Form:
* Short Form: `fn u ctx --delete DB_URL`
* Usage Example: `fn u ctx --delete DB_URL`




#### Sample series of usage commands
* create context
* list context
* Delete context


#### Template




## Commands to Setup Context
* Create context
    * `fn c ctx my-ctx --api-url http://localhost:8080 --registry michaelwwilliams`
* Select context
    * `fn u ctx my-ctx`
* Get list of contexts
    * `fn ls ctx`
