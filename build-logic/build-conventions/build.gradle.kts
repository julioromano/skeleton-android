plugins {
  `kotlin-dsl`
}

dependencies {
  implementation(libs.plugin.android)
  implementation(libs.plugin.kotlin)
  implementation(libs.plugin.kotlin.compose)
  implementation(libs.plugin.google.ksp)
  implementation(libs.plugin.kotlinter)
}
