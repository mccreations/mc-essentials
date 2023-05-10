import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("jvm-conventions")
    id("com.github.johnrengelman.shadow")
    id("net.minecrell.plugin-yml.bukkit")
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    withType<ShadowJar> {
        archiveFileName.set("mc-${project.projectDir.parentFile.name}-${project.version}.jar")
    }
}

bukkit {
    name = "mc-${project.projectDir.parentFile.name}"
    version = project.version.toString()
    apiVersion = "1.13"
}