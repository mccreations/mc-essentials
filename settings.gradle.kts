rootProject.name = "mc-essentials"

dependencyResolutionManagement {
    includeBuild("build-logic")
}

includePluginAndApi(
    "warps"
)

fun includePluginAndApi(vararg paths: String) {
    paths.forEach {
        include(
            "$it:api",
            "$it:plugin"
        )
    }
}