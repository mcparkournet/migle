plugins {
	`kotlin-dsl-base`
	`java-gradle-plugin`
	id("com.gradle.plugin-publish") version "0.10.1" apply false
}

subprojects {
	apply {
		plugin("org.gradle.kotlin.kotlin-dsl.base")
	}

	repositories {
		jcenter()
	}
}
