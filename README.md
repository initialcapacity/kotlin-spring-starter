# Kotlin spring starter

A [FreshCloud](https://www.freshcloud.com/) style example using Kotlin and Spring
that includes a single web application with [hexa](https://hexaorchestration.org/) 
and [open policy agent](https://www.openpolicyagent.org/) support
Deployed via [Fresh Cloud](https://www.freshcloud.com/).


The example showcases on the below technologies -
* Language [Kotlin](https://kotlinlang.org)
* Web Framework [Spring](https://spring.io/) and [Freemarker](https://freemarker.apache.org)
* Testing tools [JUnit](https://junit.org/)
* Security orchestration [hexa](https://hexaorchestration.org/)
* Security decision [open policy agent](https://www.openpolicyagent.org/)
* Production [FreshCloud](https://www.freshcloud.com/) on Google's Cloud Platform

## Getting Started

Build with docker.

```bash
docker build -t kotlin-spring-starter . 
```

Note - you'll also need to build the [hexa](https://hexaorchestration.org/) container.

Running with docker compose.

```bash
docker-compose up 
```

## Deployment

Fresh cloud deployment and pipeline files are located in `deployments`.

That's a wrap for now.