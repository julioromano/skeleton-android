# skeleton-android
## Template skeleton for quick bootstrap of an Android app

This is a project template to quickly bootstrap an Android app with the following characteristics:
- JDK17 toolchain
- 100% Kotlin (no 'java' dirs)
- 100% Jetpack Compose (no fragments)
- LeakCanary
- Gradle convention plugins
- Gradle version catalog
- Gradle typesafe project accessors
- Mend Renovate configuration
- Github action to run checks on every push/PR
- Dagger + Hilt
- Single activity with
  - Splashscreen
  - Edge to edge layout
  - Compose Material 3 Theme with palette generated from http://m3.material.io
  - androidx NavHost for navigation
  - Sample e2e test
- One empty feature module with
  - Compose UI
  - Sample unit and integration tests
