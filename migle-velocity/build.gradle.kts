dependencies {
	implementation(project(":migle-core"))
}

gradlePlugin {
	plugins {
		create("migle-velocity") {
			id = "net.mcparkour.migle.migle-velocity"
			displayName = "MigleVelocity"
			description = "Velocity plugin Gradle plugin"
			implementationClass = "net.mcparkour.migle.MigleVelocityPlugin"
		}
	}
}

pluginBundle {
	website = "https://github.com/mcparkournet/migle"
	vcsUrl = "https://github.com/mcparkournet/migle.git"
	tags = listOf("velocity")
}
