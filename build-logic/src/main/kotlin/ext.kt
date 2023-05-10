import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

fun ShadowJar.reloc(vararg dependencies: String) {
    dependencies.forEach { relocate(it, "${project.rootProject.group}.${project.name}.libs.$it") }
}