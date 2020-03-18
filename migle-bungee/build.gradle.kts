plugins {
	`java-gradle-plugin`
	id("com.gradle.plugin-publish")
}

dependencies {
	compileOnly(project(":migle-core"))
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.10.3")
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.10.3")
}

gradlePlugin {
	plugins {
		create("migle-bungee") {
			id = "net.mcparkour.migle.migle-bungee"
			displayName = "MigleBungee"
			description = "Bungee plugin Gradle plugin"
			implementationClass = "net.mcparkour.migle.BungeeMiglePlugin"
		}
	}
}

pluginBundle {
	website = "https://github.com/mcparkournet/migle"
	vcsUrl = "https://github.com/mcparkournet/migle.git"
	tags = listOf("bungee", "bungeecord", "waterfall")
}

tasks.jar {
	from(zipTree(project(":migle-core").tasks.jar.get().archiveFile.get().asFile))
}
