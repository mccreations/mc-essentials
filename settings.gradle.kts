rootProject.name = "mc-essentials"

dependencyResolutionManagement {
    includeBuild("build-logic")
}

includePluginAndApi(
    "warps"
)

include(
    "workbenches:plugin"
)

fun includePluginAndApi(vararg paths: String) {
    paths.forEach {
        include(
            "$it:api",
            "$it:plugin"
        )
    }
}