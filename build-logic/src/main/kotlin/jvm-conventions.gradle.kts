plugins {
    `java-library`
}

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://repo.papermc.io/repository/maven-public/")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    withSourcesJar()
    withJavadocJar()
}

tasks {
    withType<JavaCompile> {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
        options.compilerArgs.add("-parameters")
    }

    withType<ProcessResources> {
        filteringCharset = Charsets.UTF_8.name()
    }

    withType<Javadoc> {
        options.encoding = Charsets.UTF_8.name()
    }
}