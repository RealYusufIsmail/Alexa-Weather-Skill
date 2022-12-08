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
    // logger
    implementation("ch.qos.logback:logback-classic:1.4.5")
    implementation("ch.qos.logback:logback-core:1.4.5")
    // rest client
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    // json
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.14.0")
    // test
    testImplementation("junit:junit:4.13.2")
}

configurations { all { exclude(group = "org.slf4j", module = "slf4j-log4j12") } }

tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}

//set java version to 11
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
