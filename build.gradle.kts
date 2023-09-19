import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.aot.ProcessAot

allprojects {
    repositories {
        maven("https://plugins.gradle.org/m2/")
        mavenCentral()
    }
}

plugins {
    id("org.springframework.boot") version "3.1.1"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.8.20"
    id("org.jetbrains.kotlin.plugin.noarg") version "1.8.20"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.graalvm.buildtools.native") version "0.9.23"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.20"
}

group = "com"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.named("processAot") {
    // Use this to safely access the task's properties
    this as ProcessAot

    applicationMainClass.set("com.camelman.CamelmanApplication")
}

tasks.jar {
    enabled = true
}

tasks.bootJar {
    enabled = false
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

subprojects {
    apply {
        plugin("kotlin")
        plugin("io.spring.dependency-management")
        plugin("kotlin-spring") // instead of "kotlin-allopen"
        plugin("org.springframework.boot")
        plugin("kotlin-jpa")
        plugin("jacoco")
        plugin("kotlin-kapt")
        plugin("idea")
        plugin("kotlin-noarg")
        plugin("java")
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        developmentOnly("org.springframework.boot:spring-boot-devtools")
        runtimeOnly("com.h2database:h2")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        annotationProcessor("org.projectlombok:lombok")
        testImplementation("org.springframework.boot:spring-boot-starter-test")

        implementation("au.com.console:kassava:2.0.0")
        implementation("net.logstash.logback:logstash-logback-encoder:7.2")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.kotest:kotest-runner-junit5:5.5.4")
        testImplementation("io.kotest:kotest-assertions-core:5.5.4")
        testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
        testImplementation("io.mockk:mockk:1.12.0")

        // https://hogwart-scholars.tistory.com/entry/Spring-Boot-%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%BB%A8%ED%85%8C%EC%9D%B4%EB%84%88%EB%A1%9C-%ED%85%8C%EC%8A%A4%ED%8A%B8%ED%95%98%EA%B8%B0
        testImplementation("org.testcontainers:testcontainers:1.16.0") // TC 의존성
        testImplementation("org.testcontainers:junit-jupiter:1.16.2") // TC 의존성
        testImplementation("org.testcontainers:postgresql:1.17.6") // PostgreSQL 컨테이너 사용
        testImplementation("org.testcontainers:jdbc:1.16.0") // DB와의 JDBC connection

        // https://medium.com/dev-genius/tremendous-simplification-of-springboot-development-with-testcontainers-dd543fab91ed
        testImplementation("org.springframework.boot:spring-boot-testcontainers")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    sourceSets {
        create("intTest") {
            compileClasspath += sourceSets.main.get().output + sourceSets.test.get().output
            runtimeClasspath += sourceSets.main.get().output + sourceSets.test.get().output

            resources.srcDir(file("src/intTest/resources"))
        }
    }
}
