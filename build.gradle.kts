plugins {
    java
}

repositories {
    jcenter()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

version = "1.2.1"

dependencies {

    compile("org.hamcrest:java-hamcrest:2.0.0.0")
    compile("com.google.guava:guava:27.0.1-jre")
    compile("org.junit.jupiter:junit-jupiter-engine:5.4.0")

}
