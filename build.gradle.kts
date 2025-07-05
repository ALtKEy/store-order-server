import org.gradle.kotlin.dsl.annotationProcessor
import org.gradle.kotlin.dsl.implementation

plugins {
	kotlin("jvm") version "2.2.0"
	kotlin("plugin.spring") version "2.2.0"
	kotlin("plugin.allopen") version "2.2.0"
	kotlin("plugin.jpa") version "2.2.0"
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.altkey.code"
version = "1.0-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	//
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-aop")
	implementation("org.springframework.boot:spring-boot-starter-websocket")
	implementation("org.springframework.boot:spring-boot-starter-log4j2")
	implementation("org.springframework.boot:spring-boot-starter-undertow")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("com.fasterxml.jackson.module:jackson-module-blackbird:2.19.0")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-graphql")

	implementation("com.linecorp.kotlin-jdsl:jpql-dsl:3.5.5")
	implementation("com.linecorp.kotlin-jdsl:jpql-render:3.5.5")
	implementation("com.linecorp.kotlin-jdsl:spring-data-jpa-support:3.5.5")

	implementation("org.xerial:sqlite-jdbc:3.50.1.0")
	implementation("org.hibernate.orm:hibernate-community-dialects:7.0.4.Final")

	implementation("io.github.oshai:kotlin-logging-jvm:7.0.7")

	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.8")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	configurations.all {
		exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
		exclude(group = "org.springframework.boot", module = "spring-boot-starter-tomcat")
	}
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
