plugins {
    id("publishing-conventions")
}

repositories {
    maven("https://jitpack.io/")
}

dependencies {
    compileOnlyApi(libs.commons)
    compileOnlyApi(libs.event.api)
    compileOnly(libs.paper.api)
}