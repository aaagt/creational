plugins {
    application
}


application {
    mainClass.set("aaagt.creational.Main")
}


dependencies {
    val junitVersion: String by project

    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
}


tasks.test {
    useJUnitPlatform()
}
