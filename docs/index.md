# Smartclide TD Reusability Index
SmartCLIDE TD Reusability Index Backend Component

## Preconditions to build and run TD Reusability

To build and run the backend service of TD Reusability Index, the following software is required:

- Java (at least version 11)
- Apache Maven (at least version 3.2+)
- Docker (for building and running the final image)

## How to build TD Reusability Index

TD Reusability Index can be built using maven with the following command:

```shell
mvn install
```

In order to build a Docker image of the service that can be deployed, the following commands can be used:

```shell
mvn install
docker build -t ${IMAGE_NAME:IMAGE_TAG} .
```

More specifically:

```shell
mvn install
docker build -t smartclide-td-reusability-index-backend:latest .
```

## How to run TD Reusability Index

All the images of this component can be found [here](https://github.com/eclipse-researchlabs/smartclide-TD-Reusability-Index/pkgs/container/smartclide%2Ftdreusability).

You can run the backend service with the following command:

```shell
docker run smartclide-td-reusability-index-backend:latest
```

### Extra dependencies of TD Reusability Index

This backend has an external dependency with the [TD Interest](https://github.com/eclipse-researchlabs/smartclide-TD-Interest), in order to get the metrics of a specific project.
This dependency is visible through the **[application.properties](https://github.com/eclipse-researchlabs/smartclide-TD-Reusability-Index/blob/main/src/main/resources/application.properties)** file, where there is the following variable:
- interest-service.url
