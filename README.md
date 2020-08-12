## Yet Another Covid Alert System (YACAS) - Server

API for the YACAS app.


## Example requests

### Register covid19 case

```sh
curl -X POST 'localhost:8080/cases' \
-H 'Content-Type: application/json' \
-d '{"userId": "123", "disease": "COVID19", "reporter": "SELF"}'
```

### Find cases among contacts

```sh
curl -X POST 'localhost:8080/matches' \
-H 'Content-Type: application/json' \
-d '{"contacts": ["123", "456", "789"]}'
```

Response:
```
{
    "cases": [
        {
            "userId": "1",
            "disease": "COVID19",
            "reporter": "SELF"
        }
    ]
}
```

## Development

## Make targets

You can use `make` to execute common tasks:
```
build-all                      Build all and create docker image
build-mvn                      Build project and install to you local maven repo
build-docker                   Build dev docker image
run-local                      Run the app locally (without docker)
release-dryrun                 Simulate a release in order to detect any issues
release                        Release a new version
```

### Running from within IntelliJ IDEA

When running the application from IDEA, make sure to specify the `-Dmicronaut.environments=local`
VM param in order for micronaut to load config from `application-local.properties`.

Also, as this project uses lombok, make sure you have installed the lombok plugin and that
annotation processing is turned on.

