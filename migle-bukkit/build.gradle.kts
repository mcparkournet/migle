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
		create("migle-bukkit") {
			id = "net.mcparkour.migle.migle-bukkit"
			displayName = "MigleBukkit"
			description = "Bukkit plugin Gradle plugin"
			implementationClass = "net.mcparkour.migle.BukkitMiglePlugin"
		}
	}
}

pluginBundle {
	website = "https://github.com/mcparkournet/migle"
	vcsUrl = "https://github.com/mcparkournet/migle.git"
	tags = listOf("bukkit", "spigot", "paper")
}

tasks.jar {
	from(zipTree(project(":migle-core").tasks.jar.get().archiveFile.get().asFile))
}
