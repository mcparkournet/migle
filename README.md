# Migle

Migle is a Gradle plugin, which generates Minecraft plugin attributes file, based on Gradle build file configuration. Currently, it supports following plugin types:

* [Paper](https://github.com/PaperMC/Paper)
  * [Gradle plugin](https://plugins.gradle.org/plugin/net.mcparkour.migle.migle-paper)
* [Velocity](https://github.com/VelocityPowered/Velocity)
  * [Gradle plugin](https://plugins.gradle.org/plugin/net.mcparkour.migle.migle-velocity)
* [Waterfall](https://github.com/PaperMC/Waterfall)
  * [Gradle plugin](https://plugins.gradle.org/plugin/net.mcparkour.migle.migle-waterfall)

## Usage

Add the following block to Gradle build file:

```kotlin
plugins {
    id("net.mcparkour.migle.migle-paper") version "1.0.3"
}
```

Then, add to plugin configuration attributes to set:

```kotlin
miglePaper {
    main = "net.mcparkour.foo.FooPlugin"
    apiVersion = ApiVersionAttribute.VERSION_1_14
    author = "MCParkour"
    website = "https://www.mcparkour.net/"
    depend = listOf("bar")
}
```

By default, plugin sets name, version and description attributes using project properties.
