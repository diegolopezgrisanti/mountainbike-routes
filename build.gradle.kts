plugins {
	java
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.dalg"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	val FLYWAY = "9.11.0"
	val LOMBOK = "1.18.34"
	val POSTGRESQL = "42.7.4"


	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.postgresql:postgresql:$POSTGRESQL")
	implementation("org.flywaydb:flyway-core:$FLYWAY")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	compileOnly("org.projectlombok:lombok:$LOMBOK")

	annotationProcessor("org.projectlombok:lombok:$LOMBOK")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
