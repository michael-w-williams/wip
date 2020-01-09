# Fn Context Commands

## Fn Context Command Reference
### Cheat Sheet
* Create: `fn c ctx <context-name> --api-url http://<host>:<port> --registry <docker-hub-id>`
* Delete: `fn d ctx <context-name>`
* List: `fn ls <context-name>`
* Update (Add) Name/Value: `fn up ctx <key> <value>`
* Update (Delete) Name/Value: `fn up ctx --delete <key>`

### Usage Examples
* Create: `fn c ctx my-ctx --api-url http://localhost:8080 --registry youridhere`
* Delete: `fn d ctx my-ctx`
* List: `fn ls ctx`


### Detailed Commands
* **Create** a new Fn context with the name and data provided.
    * `fn create context <context-name> --api-url http://<host>:<port> --registry <docker-hub-id>`
* **Delete** an Fn context with the specified name.
    * `fn delete context <context-name>`
* **List** all contexts on this system.
    * `fn list <context-name>`


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



## Commands to Setup Context
* Create context
    * `fn c ctx my-ctx --api-url http://localhost:8080 --registry michaelwwilliams`
* Select context
    * `fn u ctx my-ctx`
* Get list of contexts
    * `fn ls ctx`
