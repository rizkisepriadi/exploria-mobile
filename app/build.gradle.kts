plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger)
    id("kotlin-parcelize")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    namespace = "com.app.exploria"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.app.exploria"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String", "BASE_URL", "\"https://exploria-backend-14669887025.asia-southeast2.run.app/api/v1/\"")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

secrets {
    propertiesFileName = "secrets.properties"
    defaultPropertiesFileName = "local.defaults.properties"
    ignoreList.add("keyToIgnore")
    ignoreList.add("sdk.*")
}


dependencies {

    implementation(libs.androidx.ui.text.google.fonts)
    implementation (libs.compose.ratingbar)
    implementation(libs.coil.compose)

    //compose
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.android)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.google.android.material)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.navigation.compose)

    //test
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Needed for createComposeRule, but not createAndroidComposeRule:
    debugImplementation(libs.androidx.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)

    implementation(libs.androidx.ui.test.junit4.android)
    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.inline)

    //For runBlockingTest, CoroutineDispatcher etc.
    testImplementation(libs.kotlinx.coroutines.test)

    //For InstantTaskExecutorRule
    testImplementation(libs.androidx.core.testing)

    // Core library
    androidTestImplementation (libs.androidx.core)
    implementation(libs.lottie.compose)
    implementation(libs.shimmer.compose)

    // AndroidJUnitRunner and JUnit Rules
    androidTestImplementation (libs.androidx.test.runner)
    androidTestImplementation (libs.androidx.test.rules)
    androidTestUtil (libs.androidx.test.orchestrator)

    // Assertions
    androidTestImplementation (libs.androidx.test.ext.junit)
    androidTestImplementation (libs.androidx.test.truth)
    androidTestImplementation (libs.google.test.truth)

    // Espresso dependencies
    androidTestImplementation (libs.test.espresso.core)
    androidTestImplementation (libs.test.espresso.contrib)
    androidTestImplementation (libs.test.espresso.intents)
    androidTestImplementation (libs.test.espresso.accessibility)
    androidTestImplementation (libs.test.idling.concurrent)

    implementation(libs.mockito.kotlin)
    implementation (libs.androidx.ui)
    implementation (libs.androidx.ui.test)

    //dagger
    implementation(libs.dagger.hilt)
    implementation(libs.hilt.compose.navigation)
    kapt(libs.dagger.kapt)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)
    implementation(libs.okhttp)
    implementation(libs.converter.scalars)
    implementation(libs.encrypted.preferences)

    //Glide
    implementation(libs.landscapist.glide)

    //room
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    testImplementation(libs.androidx.room.testing)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.datastore.preferences)

    //maps
    implementation (libs.maps.compose)
    implementation (libs.play.services.maps)

    //Paging 3
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.room.paging)
}