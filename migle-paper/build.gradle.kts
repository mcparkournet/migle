dependencies {
	implementation(project(":migle-core"))
}

gradlePlugin {
	plugins {
		create("migle-paper") {
			id = "net.mcparkour.migle.migle-paper"
			implementationClass = "net.mcparkour.migle.MiglePaperPlugin"
		}
	}
}
