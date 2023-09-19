import org.springframework.boot.gradle.tasks.aot.ProcessAot

plugins {
    java
}

dependencies {
    api(project(":infra:infra-opensearch"))
}

tasks.jar {
    enabled = false
}

tasks.bootJar {
    enabled = true
    archiveFileName.set("boot.jar")
}
