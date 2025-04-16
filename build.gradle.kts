plugins {
    java
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
    id("io.freefair.lombok") version "8.13.1"
}

group = "com.studentManager"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    runtimeOnly("com.h2database:h2:2.1.214")
    runtimeOnly("com.mysql:mysql-connector-j")
    runtimeOnly("org.postgresql:postgresql")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
