package com.camelman

import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.images.builder.ImageFromDockerfile
import org.testcontainers.utility.DockerImageName

internal class PostgresContainer(image: DockerImageName) : PostgreSQLContainer<PostgresContainer>(image)

internal class RedisContainer(image: DockerImageName) : GenericContainer<RedisContainer>(image)

internal class PythonContainer(image: ImageFromDockerfile) : GenericContainer<PythonContainer>(image)