plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.spring") version "2.1.0"
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.4"
    id("java")
}

group = "com.bank"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_21

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Starter for WebFlux (required by Spring Cloud Gateway)
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // Spring Cloud Gateway (API Gateway functionality)
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")

    // Spring Boot Actuator (for monitoring and observability)
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Spring Security (for authentication & authorization)
    implementation("org.springframework.boot:spring-boot-starter-security")

    // ✅ Resilience4J (for circuit breaking & fault tolerance)
    implementation("io.github.resilience4j:resilience4j-spring-boot3:2.2.0")

    // ✅ Spring Cloud Config Client (for centralized configuration)
    implementation("org.springframework.cloud:spring-cloud-starter-config")

    // ✅ Lombok (to reduce boilerplate code)
    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // ✅ Testing Dependencies
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
