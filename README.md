# Kotlin spring example

A fresh cloud application using Kotlin and Spring that includes a single web application.

## Docker

Building with docker.

```bash
docker build -t kotlin-spring-starter . 
```

_Note_ - use `--platform linux/amd64` for deploying to google cloud.

```bash
docker build --platform linux/amd64 -t kotlin-spring-starter . 
```

## Deploy with Fresh Cloud

Deploy the kotlin-spring-starter to an existing fresh cloud application cluster.

Create a `.env_app.sh` file.

```bash
export GCP_PROJECT_ID=
export GCP_ZONE=
export GCP_CLUSTER_NAME=
export GCP_SERVICE_ACCOUNT_JSON=

export REGISTRY_DOMAIN=
export REGISTRY_PASSWORD=
export REGISTRY_CLUSTER_NAME=
export DOMAIN=
export EMAIL_ADDRESS=

export APP_NAME=kotlin-spring-starter
export APP_IMAGE_NAME=kotlin-spring-starter
export APP_CONFIGURATION_PATH=./deployments/kotlin-spring-starter.yaml
export APP_PIPELINE_CONFIGURATION_PATH=/deployments/kotlin-spring-starter-pipeline-configuration.yaml
export APP_PIPELINE_PATH=/deployments/kotlin-spring-starter-pipeline.yaml
```

Source the file.

```bash
source .env_app.sh
```

Run the below fresh cloud commands.

```bash
~/go/bin/freshctl clusters gcp configure
~/go/bin/freshctl clusters gcp create-service-account
~/go/bin/freshctl pipelines deploy
```

That's a wrap for now.