dependencies {
	implementation(project(":migle-core"))
}

gradlePlugin {
	plugins {
		create("migle-velocity") {
			id = "net.mcparkour.migle.migle-velocity"
			implementationClass = "net.mcparkour.migle.MigleVelocityPlugin"
		}
	}
}
