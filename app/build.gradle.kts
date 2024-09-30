plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // 作为 Xposed 模块使用务必添加，其它情况可选
    autowire(libs.plugins.com.google.devtools.ksp)
    autowire(libs.plugins.org.jetbrains.kotlin.plugin.serialization)
}

android {
    namespace = "io.github.brucezhang1993.warp_loves_play_store"
    compileSdk = 35

    defaultConfig {
        applicationId = "io.github.brucezhang1993.warp_loves_play_store"
        minSdk = 27
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    // 基础依赖
    implementation(com.highcapable.yukihookapi.api)
    // 作为 Xposed 模块使用务必添加，其它情况可选
    compileOnly(de.robv.android.xposed.api)
    // 作为 Xposed 模块使用务必添加，其它情况可选
    ksp(com.highcapable.yukihookapi.ksp.xposed)
    implementation(org.jetbrains.kotlinx.kotlinx.serialization.json)
}