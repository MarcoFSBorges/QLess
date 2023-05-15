import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.openapi.generator") version "6.5.0"
	id("org.springframework.boot") version "3.0.6"
	id("io.spring.dependency-management") version "1.1.0"
	id("org.jetbrains.kotlin.plugin.jpa") version "1.8.21"
	id("org.jetbrains.kotlin.plugin.allopen") version "1.8.21"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
}

group = "pt.isel.leic.ps.qless"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.hibernate.validator:hibernate-validator")
	implementation("org.openapitools:openapi-generator:6.4.0")
	implementation("org.flywaydb:flyway-core:9.16.0")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.4")
	//implementation("org.springframework.boot:spring-boot-starter-batch")
	implementation("org.springframework.boot:spring-boot-starter-hateoas")
	implementation("org.springframework.boot:spring-boot-starter-mail")
	//implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
	//implementation("org.springframework.boot:spring-boot-starter-security")
	//implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.azure.spring:spring-cloud-azure-starter")
	implementation("com.azure.spring:spring-cloud-azure-starter-jdbc-postgresql")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	//implementation("org.flywaydb:flyway-core")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	//implementation("org.springframework.session:spring-session-core")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	//testImplementation("org.springframework.batch:spring-batch-test")
	testImplementation("org.springframework.security:spring-security-test")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:postgresql")
}

dependencyManagement {
	imports {
		mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
		mavenBom("com.azure.spring:spring-cloud-azure-dependencies:${property("springCloudAzureVersion")}")
	}

}

configurations.all{
	exclude(group = "org.apache.logging.log4j", module = "log4j-to-slf4j")
	exclude(group = "ch.qos.logback", module = "logback-classic")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

openApiGenerate{
	generatorName.set("kotlin-spring")
	inputSpec.set("$rootDir/src/main/resources/openapi.yaml")
	outputDir.set("C:\\Users\\afons\\Desktop\\QLess\\QLess\\backend\\jvm\\api")
	packageName.set("pt.isel.leic.ps.qless.webapi")


}
