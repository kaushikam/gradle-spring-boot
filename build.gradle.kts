import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
	id("java")
	id("org.springframework.boot") version ("2.0.5.RELEASE")
	id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

repositories {
	jcenter()
}

tasks.getByName<BootJar>("bootJar") {
	mainClassName = "hello.App"
}

dependencies {
	implementation("org.springframework.boot:spring-boot-dependencies:2.0.5.RELEASE")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	
	components {
		withModule("org.springframework:spring-beans") {
			allVariants {
				withDependencyConstraints {
					filter { it.name == "snakeyaml" }.forEach { it.version { strictly("1.19") } }
				}
			}
		}
	}
}

