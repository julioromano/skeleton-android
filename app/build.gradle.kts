import com.android.build.api.variant.VariantOutputConfiguration
import java.time.Instant

plugins {
  id(libs.plugins.android.application.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
  // TODO // id(libs.plugins.google.services.get().pluginId)
  // TODO // id(libs.plugins.google.firebase.crashlytics.get().pluginId)
  // TODO // id(libs.plugins.google.firebase.appDistribution.get().pluginId)
  // TODO // id(libs.plugins.playPublisher.get().pluginId)
  id(libs.plugins.dagger.hilt.get().pluginId)
  id(libs.plugins.kotlinter.get().pluginId)
}

android {
  namespace = "net.marcoromano.skeleton.app" // TODO: Change me!
  // TODO: Uncomment after creating keystore.
  // signingConfigs {
  //     create("release") {
  //         storeFile = file("app.keystore")
  //         storePassword = System.getenv("STORE_PASSWORD")
  //         keyAlias = System.getenv("KEY_ALIAS")
  //         keyPassword = System.getenv("KEY_PASSWORD")
  //         enableV1Signing = true
  //         enableV2Signing = true
  //         enableV3Signing = true
  //         enableV4Signing = true
  //     }
  // }
  buildToolsVersion = libs.versions.android.buildTools.get()
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  defaultConfig {
    applicationId = "net.marcoromano.skeleton" // TODO: Change me!
    minSdk = libs.versions.android.minSdk.get().toInt()
    targetSdk = libs.versions.android.targetSdk.get().toInt()
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    testInstrumentationRunnerArguments["clearPackageData"] = "true"
  }
  buildTypes {
    getByName("debug") {
      versionNameSuffix = "-DEBUG"
    }
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro",
      )
      // TODO: Uncomment after creating keystore.
      // signingConfig = signingConfigs.getByName("release")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  buildFeatures {
    compose = true
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.androidx.compose.compiler.get()
    useLiveLiterals = true
  }
  testOptions {
    execution = "ANDROIDX_TEST_ORCHESTRATOR"
    animationsDisabled = true
  }
  lint {
    warningsAsErrors = true
    disable += "GradleDependency"
  }
}

kotlin {
  jvmToolchain(17)
  compilerOptions {
    allWarningsAsErrors.set(true)
  }
}

androidComponents {
  onVariants { variant ->
    variant.outputs.single {
      it.outputType == VariantOutputConfiguration.OutputType.SINGLE
    }.apply {
      versionCode.set(
        // Set a versionCode that monotonically increases every 10 seconds.
        // It should be more than enough to have virtually unique versionCodes.
        // Overflows on Fri, June 19, 2635 1:20:00 PM GMT
        (Instant.now().epochSecond / 10).toInt(),
      )
      versionName.set(
        // Get the versionName from environmental variable or use a fallback.
        providers.environmentVariable("VERSION_NAME")
          .getOrElse("DEVELOPMENT_VERSION"),
      )
    }
  }
}

// TODO Enable when ready to deploy to play store.
//
// play {
//     serviceAccountCredentials.set(file("gradle-play-publisher-key.json"))
//     defaultToAppBundles.set(true)
//     track.set("internal")
//     releaseStatus.set(ReleaseStatus.DRAFT)
// }

kapt {
  correctErrorTypes = true // Required by dagger-hilt
}

hilt {
  enableAggregatingTask = true
}

dependencies {
  implementation(projects.feature)
  implementation(libs.androidx.activityCompose)
  implementation(libs.androidx.core)
  implementation(libs.androidx.coreSplashscreen)
  implementation(libs.androidx.lifecycleRuntime)
  implementation(libs.androidx.navigation.compose)
  implementation(libs.bundles.androidx.compose)
  implementation(libs.google.accompanistSystemUi)
  implementation(libs.google.daggerHiltAndroid)
  debugImplementation(libs.square.leakcanary)
  implementation(platform(libs.androidx.compose.bom))
  debugImplementation(libs.androidx.composeUiTestManifest)
  debugImplementation(libs.androidx.composeUiTooling)
  kapt(libs.google.daggerHiltCompiler)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.composeUiTestJunit4)
  androidTestImplementation(libs.androidx.testCore)
  androidTestImplementation(libs.androidx.testEspressoCore)
  androidTestImplementation(libs.androidx.testExtJunit)
  androidTestImplementation(platform(libs.androidx.compose.bom))
}
