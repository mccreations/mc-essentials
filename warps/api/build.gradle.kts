plugins {
    id("publishing-conventions")
}

dependencies {
    compileOnlyApi(libs.commons)
    compileOnlyApi(libs.event.api)
    compileOnly(libs.paper.api)
}