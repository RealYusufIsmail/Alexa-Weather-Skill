plugins {
    id("java")
}

group = "io.github.realyusufismail"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.amazon.alexa:ask-sdk:2.44.0")
    implementation("com.amazonaws:aws-lambda-java-log4j2:1.5.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    manifest {
        attributes(
            "Implementation-Title" to project.name,
            "Implementation-Version" to project.version,
            "Main-Class" to "io.github.realyusufismail.WeatherSkillHandler"
        )
    }
}