val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = false
jar.enabled = true

plugins {
    id("java-library")
    id("java-test-fixtures")
}

dependencies {
    api(project(":domain"))
    api(project(":infra:infra-opensearch"))

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    // https://mvnrepository.com/artifact/com.github.kimkevin/hangulparser
    implementation("com.github.kimkevin:hangulparser:1.0.0")
    testImplementation(testFixtures(project(":domain")))
}

kotlin.sourceSets.main {
    setBuildDir("$buildDir")
}
