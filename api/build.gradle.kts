plugins {
    java
}

dependencies {
}

tasks.jar {
    enabled = false
}

tasks.bootJar {
    enabled = true
    archiveFileName.set("boot.jar")
}
