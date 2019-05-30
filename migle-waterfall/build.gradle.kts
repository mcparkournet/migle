dependencies {
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.9")
	compileOnly(project(":migle-core"))
}

@Suppress("UnstableApiUsage")
gradlePlugin {
	plugins {
		create("migle-waterfall") {
			id = "net.mcparkour.migle.migle-waterfall"
			displayName = "MigleWaterfall"
			description = "Waterfall plugin Gradle plugin"
			implementationClass = "net.mcparkour.migle.MigleWaterfallPlugin"
		}
	}
}

pluginBundle {
	website = "https://github.com/mcparkournet/migle"
	vcsUrl = "https://github.com/mcparkournet/migle.git"
	tags = listOf("waterfall")
}

tasks.jar {
	from(zipTree(project(":migle-core").tasks.jar.get().archiveFile.get().asFile))
}
