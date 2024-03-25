plugins {
    java
    war
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.payaza"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("io.springfox:springfox-boot-starter:3.0.0")
    implementation("org.flywaydb:flyway-core")
    runtimeOnly("com.h2database:h2")
    implementation("org.json:json:20240303")
    implementation("com.google.code.gson:gson:2.10.1")

    compileOnly("org.projectlombok:lombok")

    annotationProcessor("org.projectlombok:lombok")

    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
