plugins {
    alias(clipLibs.plugins.android.library)
    alias(clipLibs.plugins.blaze.configuration)
    id("signing")
}

android {
    namespace = "com.payclip.blaze.toolargetool"

    defaultConfig {
        consumerProguardFile("proguard-rules.pro")
        resourcePrefix("too_large_tool_")
    }

    kotlinOptions {
        jvmTarget = clipLibs.versions.jvmTarget.get()
    }

    composeOptions {
        kotlinCompilerExtensionVersion = clipLibs.versions.androidxComposeCompiler.get()
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

    // Tests
    testImplementation(clipLibs.junit4)
    testImplementation(clipLibs.mockk)
    testImplementation(clipLibs.mockito.kotlin)
    testImplementation(clipLibs.coroutines.test)
    testImplementation(clipLibs.junit.jupiter)
    androidTestImplementation(clipLibs.androidx.test.ext)
    androidTestImplementation(clipLibs.androidx.test.espresso.core)
}
