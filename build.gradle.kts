plugins {
	`kotlin-dsl` apply false
	id("com.gradle.plugin-publish") version "0.10.1" apply false
}

subprojects {
	apply {
		plugin("org.gradle.kotlin.kotlin-dsl.base")
		if (project.name != "migle-core") {
			plugin("org.gradle.java-gradle-plugin")
			plugin("com.gradle.plugin-publish")
		}
	}

	repositories {
		jcenter()
	}

	dependencies {
		"implementation"("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.9")
	}
}
