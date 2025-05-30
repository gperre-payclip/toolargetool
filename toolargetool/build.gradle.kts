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
}

dependencies {
    // Clip
    implementation(clipLibs.clip.lint.checks)

    // Kotlin
    implementation(clipLibs.kotlin.stdlib)

    // Tests
    testImplementation(clipLibs.junit4)
    testImplementation(clipLibs.mockk)
    testImplementation(clipLibs.mockito.kotlin)
    testImplementation(clipLibs.coroutines.test)
    testImplementation(clipLibs.junit.jupiter)
    androidTestImplementation(clipLibs.androidx.test.ext)
    androidTestImplementation(clipLibs.androidx.test.espresso.core)
}
