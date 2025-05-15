plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.hardwareshop"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.hardwareshop"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    //Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    //Navigation
    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("androidx.navigation:navigation-runtime-ktx:2.3.5")
    //Koin
    // Koin main features for Android (Scope,ViewModel ...)
    implementation("io.insert-koin:koin-android:3.5.0")
    // --------------- Koin ---------------
    // Koin Java Compatibility
    implementation("io.insert-koin:koin-android-compat:3.5.0")
    // Koin for Jetpack WorkManager
    implementation("io.insert-koin:koin-androidx-workmanager:3.5.0")
    // Koin for Jetpack Compose
    implementation("io.insert-koin:koin-androidx-compose:3.5.0")
    // --------------- Koin ---------------
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.8.7")
    //RxJava
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.20")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    implementation("com.google.android.gms:play-services-base:17.1.0")
    implementation("com.google.android.gms:play-services-identity:17.0.0")
    implementation("com.google.android.gms:play-services-auth:17.0.0")
    implementation("com.google.android.gms:play-services-auth-api-phone:17.1.0")

    implementation("com.facebook.fresco:fresco:2.5.0")
    implementation("com.intuit.sdp:sdp-android:1.0.6")
    implementation("com.tbuonomo:dotsindicator:4.2")

    //AndroidCharts
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

    implementation("com.akexorcist:round-corner-progress-bar:2.1.2")

    implementation("com.github.mukeshsolanki:android-otpview-pinview:2.1.2")

    implementation("org.greenrobot:eventbus:3.2.0")
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("androidx.browser:browser:1.3.0")
    implementation("com.airbnb.android:lottie:4.0.0")
}