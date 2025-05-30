plugins {
    alias(clipLibs.plugins.android.application)
    alias(clipLibs.plugins.blaze.configuration)
}

android {
    namespace = "com.payclip.blaze.toolargetool.sample"

    defaultConfig {
        applicationId = "com.payclip.blaze.toolargetool.sample"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    kotlinOptions {
        jvmTarget = clipLibs.versions.jvmTarget.get()
    }

    packaging {
        resources {
            excludes += "AndroidManifest.xml"
        }
    }
}

dependencies {
    // Clip
    implementation(clipLibs.clip.lint.checks)

    // Kotlin
    implementation(clipLibs.kotlin.stdlib)

    implementation(project(path = ":toolargetool"))
}
