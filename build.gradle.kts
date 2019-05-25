plugins {
	`kotlin-dsl`
}

subprojects {
	apply(plugin = "org.gradle.kotlin.kotlin-dsl")

	repositories {
		jcenter()
	}
}
