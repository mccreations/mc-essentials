plugins {
    id("plugin-conventions")
}

dependencies {
    implementation(libs.cloud.annotations)
    implementation(libs.cloud.paper)
    implementation(libs.commons)
    annotationProcessor(libs.commons)
    implementation(libs.guice)
    compileOnly(libs.paper.api)
}

bukkit {
    main = "${project.group}.${project.projectDir.parentFile.name}.plugin.WorkbenchesLoader"
}
