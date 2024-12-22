import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    alias(libs.plugins.spring.boot) 
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.noarg)
    alias(libs.plugins.flyway)
    alias(libs.plugins.openapi)
}

val javaVersion = JavaVersion.VERSION_21

group = "ding"
version = "0.0.1-SNAPSHOT"
description = "miniMiniMoney"
java.sourceCompatibility = javaVersion

noArg{
    annotations(
        "jakarta.persistence.Entity"
    )
}

dependencies {
    implementation(libs.bundles.spring.boot.starter)
    implementation(libs.jackson.kotlin)
    implementation(platform(libs.spring.cloud.dependencies))
    implementation(libs.spring.cloud.openfeign)
    implementation(platform(libs.spring.cloud.aws))
    implementation(libs.flyway)
    implementation(libs.kotlin.reflect)
    implementation(libs.gson)
    implementation(libs.kotlin.stdlib)
    implementation(libs.swagger)
    implementation(libs.springdoc)
    runtimeOnly(libs.postgresql)
    testImplementation(libs.wiremock)
    testImplementation(libs.assertj)
    testImplementation(libs.spring.boot.test)
    testImplementation(libs.spring.security.test)
    testImplementation(libs.h2)
}

sourceSets {
    main {
        java {
            srcDir("src/main/kotlin")
            srcDir("${layout.buildDirectory.get()}/generated/sources/openapi/miniminimoney/kotlin")
        }
    }
}

flyway {
    url = "jdbc:postgresql://localhost:15432/miniminimoney"
    user = "admin"
    password = "abc123"
}

tasks{

    val generateOpenApiDocs = "generateOpenApiDocs"

    register<GenerateTask>(generateOpenApiDocs){
        group = "openapi"
        description = "Generate OpenAPI documentation"
        generatorName = "kotlin-spring"
        packageName = "com.ding.miniminimoney"

        inputSpec = "${projectDir}/src/main/resources/miniminimoney.yaml"
        outputDir = "${layout.buildDirectory.get()}/generated/sources/openapi/miniminimoney"
        apiPackage = "${packageName.get()}.api.generated"
        modelPackage = "${packageName.get()}.model.generated"
        apiNameSuffix.set("Api")
        typeMappings.put("string-date", "Instant")
        importMappings.put("Instant", "java.time.Instant")

        globalProperties.put("apis", "")
        globalProperties.put("models", "")

        configOptions.put("basePackage", packageName.get())
        configOptions.put("annotationLibrary", "none")
        configOptions.put("deletegatePattern", "true")
        configOptions.put("documentationProvider", "none")
        configOptions.put("useSpringBoot3", "true")
        configOptions.put("sourceFolder", "kotlin")
        configOptions.put("useTags", "true")
        configOptions.put("useBeanValidation", "true")
        configOptions.put("useSwaggerUI", "false")
        configOptions.put("modelMutable", "false")
        configOptions.put("modelNameSuffix", "DTO")
        configOptions.put("interfaceOnly", "false")

    }


    compileKotlin{
        dependsOn(generateOpenApiDocs)

        compilerOptions{
            jvmTarget.set(JvmTarget.JVM_21)
            freeCompilerArgs.add("-Xjsr305=strict")
            javaParameters = true
        }
    }
}


