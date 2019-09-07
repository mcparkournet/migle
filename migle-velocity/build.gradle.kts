plugins {
	`java-gradle-plugin`
	id("com.gradle.plugin-publish")
}

dependencies {
	compileOnly(project(":migle-core"))
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.9")
}

gradlePlugin {
	plugins {
		create("migle-velocity") {
			id = "net.mcparkour.migle.migle-velocity"
			displayName = "MigleVelocity"
			description = "Velocity plugin Gradle plugin"
			implementationClass = "net.mcparkour.migle.VelocityMiglePlugin"
		}
	}
}

pluginBundle {
	website = "https://github.com/mcparkournet/migle"
	vcsUrl = "https://github.com/mcparkournet/migle.git"
	tags = listOf("velocity")
}

tasks.jar {
	from(zipTree(project(":migle-core").tasks.jar.get().archiveFile.get().asFile))
}
