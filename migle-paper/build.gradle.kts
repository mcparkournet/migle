plugins {
	`java-gradle-plugin`
	id("com.gradle.plugin-publish")
}

dependencies {
	compileOnly(project(":migle-core"))
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.9")
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.9")
}

gradlePlugin {
	plugins {
		create("migle-paper") {
			id = "net.mcparkour.migle.migle-paper"
			displayName = "MiglePaper"
			description = "Paper plugin Gradle plugin"
			implementationClass = "net.mcparkour.migle.PaperMiglePlugin"
		}
	}
}

pluginBundle {
	website = "https://github.com/mcparkournet/migle"
	vcsUrl = "https://github.com/mcparkournet/migle.git"
	tags = listOf("paper")
}

tasks.jar {
	from(zipTree(project(":migle-core").tasks.jar.get().archiveFile.get().asFile))
}
