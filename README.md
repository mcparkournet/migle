# Migle

Migle is a Gradle plugin, which generates Minecraft plugin attributes file, based on Gradle build file configuration. Currently, it supports following plugin types:

* [Bukkit](https://plugins.gradle.org/plugin/net.mcparkour.migle.migle-bukkit)
* [Bungee](https://plugins.gradle.org/plugin/net.mcparkour.migle.migle-bungee)
* [Velocity](https://plugins.gradle.org/plugin/net.mcparkour.migle.migle-velocity)

## Usage

Add the following block to Gradle build file:

```kotlin
plugins {
    id("net.mcparkour.migle.migle-bukkit") version "1.1.2"
}
```

Then, add to plugin configuration attributes to set:

```kotlin
migleBukkit {
    main = "net.mcparkour.foo.FooPlugin"
    apiVersion = ApiVersion.VERSION_1_16
    author = "MCParkour"
    website = "https://www.mcparkour.net/"
    depend = listOf("bar")
}
```

By default, plugin sets name, version and description attributes using project properties.
