plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.spring") version "2.1.0"
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.4"
    id("java")
}

dependencies {
    implementation(project(":common"))

    // Spring Boot Web
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Spring Boot Actuator (Monitoring)
    implementation("org.springframework.boot:spring-boot-starter-actuator")
}
