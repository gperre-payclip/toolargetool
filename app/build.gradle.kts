plugins {
    alias(clipLibs.plugins.android.application)
    alias(clipLibs.plugins.blaze.configuration)
    id("kotlin-parcelize")
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

    composeOptions {
        kotlinCompilerExtensionVersion = clipLibs.versions.androidxComposeCompiler.get()
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
    implementation(clipLibs.clip.commons)

    // Kotlin
    implementation(clipLibs.kotlin.stdlib)
    implementation(clipLibs.androidx.appcompat)

    //Compose
    implementation(platform(clipLibs.androidx.compose.bom))
    implementation(clipLibs.androidx.compose.runtime.livedata)
    implementation(clipLibs.androidx.compose.material3)
    implementation(clipLibs.androidx.compose.material3.window.size)
    implementation(clipLibs.androidx.compose.ui)
    implementation(clipLibs.androidx.compose.ui.graphics)
    implementation(clipLibs.androidx.compose.ui.tooling)
    implementation(clipLibs.androidx.compose.ui.tooling.preview)
    implementation(clipLibs.androidx.compose.navigation)
    implementation(clipLibs.androidx.lifecycle.runtime.compose)
    implementation(clipLibs.androidx.lifecycle.viewmodel.compose)
    implementation(clipLibs.androidx.activity.compose)

    implementation(project(path = ":toolargetool"))
}
