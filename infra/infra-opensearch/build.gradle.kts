val jar: Jar by tasks
val bootJar: org.springframework.boot.gradle.tasks.bundling.BootJar by tasks

bootJar.enabled = false
jar.enabled = true

allOpen {
    annotation("org.springframework.data.elasticsearch.annotations.Document")
}

dependencies {
    implementation(project(":domain"))

    implementation("org.opensearch.client:spring-data-opensearch:1.0.1")
    api("org.opensearch.client:spring-data-opensearch-starter:1.0.1")
    // https://mvnrepository.com/artifact/org.opensearch.client/opensearch-rest-high-level-client
    implementation("org.opensearch.client:opensearch-rest-high-level-client:2.6.0")
}
