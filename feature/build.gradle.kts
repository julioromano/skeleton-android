plugins {
  id("conventions.android")
}

android {
  namespace = "net.marcoromano.skeleton.feature"
}

dependencies {
  testImplementation(libs.square.turbine)
}
