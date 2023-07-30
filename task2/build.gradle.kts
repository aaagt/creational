plugins {
    application
}


application {
    mainClass.set("aaagt.creational.logger.Main")
}


dependencies {
    val junitVersion: String by project
    val mockitoVersion: String by project

    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    // https://mvnrepository.com/artifact/org.mockito/mockito-core
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
}


tasks.test {
    useJUnitPlatform()
}


tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
