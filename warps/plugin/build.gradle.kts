import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("plugin-conventions")
}

dependencies {
    implementation(project(":warps:api"))
    implementation(libs.cloud.paper)
    implementation(libs.cloud.annotations)
    implementation(libs.commons)
    annotationProcessor(libs.commons)
    implementation(libs.configurate.yaml)
    implementation(libs.event.api)
    implementation(libs.guice)
    compileOnly(libs.paper.api)
}

tasks {
    withType<ShadowJar> {
        reloc(
            "cloud.commandframework",
            "io.leangen.geantyref",
            "io.github.mccreations.commons",
            "org.spongepowered.configurate",
            "com.google.inject",
            "net.kyori.event",
        )
    }
}

bukkit {
    main = "${project.group}.${project.projectDir.parentFile.name}.plugin.WarpsLoader"
}
