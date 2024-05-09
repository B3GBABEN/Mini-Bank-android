plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
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

    //Mockito
    implementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    implementation("androidx.arch.core:core-testing:2.2.0")

}