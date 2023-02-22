dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    gradlePluginPortal()
    google {
      content {
        includeGroupByRegex("android.arch.*")
        includeGroupByRegex("androidx.*")
        includeGroupByRegex("com.android.*")
        includeGroupByRegex("com.google.*")
      }
    }
    mavenCentral()
  }
  versionCatalogs {
    create("libs") {
      from(files("../gradle/libs.versions.toml"))
    }
  }
}

include("build-conventions")
include("settings-conventions")
