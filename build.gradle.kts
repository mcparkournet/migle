plugins {
    `kotlin-dsl-base`
    `java-gradle-plugin`
    id("com.gradle.plugin-publish") version "0.12.0" apply false
}

repositories {
    jcenter()
}

subprojects {
    apply {
        plugin("org.gradle.kotlin.kotlin-dsl.base")
    }

    repositories {
        jcenter()
    }
}
