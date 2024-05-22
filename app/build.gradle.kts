plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android") version "2.51"
    id ("kotlin-kapt")
    id ("kotlin-android-extensions")
    id ("kotlin-android")
    id ("kotlin-parcelize")

}

android {
    namespace = "com.b3g.fawri.minibank"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.b3g.fawri.minibank"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    dataBinding.enable = true
    viewBinding.enable = true
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //SDP - a scalable size unit ->https://github.com/intuit/sdp
    implementation ("com.intuit.sdp:sdp-android:1.1.0")
    //SSP - a scalable size unit for texts -> https://github.com/intuit/ssp
    implementation("com.intuit.ssp:ssp-android:1.1.0")
//ARIndicatorView is Android library for showing indicators in RecyclerView and ViewPager. -> https://github.com/MartinStamenkovski/ARIndicatorView
    implementation ("com.github.martinstamenkovski:ARIndicatorView:2.0.0")

    //Mockito
    implementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    implementation("androidx.arch.core:core-testing:2.2.0")
//
    implementation ("androidx.viewpager2:viewpager2:1.0.0")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")

    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-android-compiler:2.51")
    kapt("androidx.hilt:hilt-compiler:1.2.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation ("com.google.android.material:material:1.12.0")
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    //sweet alert dialog
    implementation ("com.github.f0ris.sweetalert:library:1.5.6")

}