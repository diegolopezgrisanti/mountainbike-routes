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
	val JUNIT = "5.11.3"
	val ASSERTJ = "3.26.3"
	val MOCKITO = "5.14.2"

	annotationProcessor("org.projectlombok:lombok:$LOMBOK")

	compileOnly("org.projectlombok:lombok:$LOMBOK")

	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.postgresql:postgresql:$POSTGRESQL")
	implementation("org.flywaydb:flyway-core:$FLYWAY")

	testCompileOnly("org.projectlombok:lombok:$LOMBOK")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation(platform("org.junit:junit-bom:$JUNIT"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	testImplementation("org.assertj:assertj-core:$ASSERTJ")
	testImplementation("org.mockito:mockito-core:$MOCKITO")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
