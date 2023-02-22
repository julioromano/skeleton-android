/**
 * Searches for subprojects' `build.gradle` files and prints their Gradle project path.
 */
private val discoverSubprojects: () -> Array<String> = {
  rootDir.walkBottomUp().filter {
    it.parent != rootDir.path &&
      it.parent != rootDir.path + "/buildSrc" &&
      it.parent != rootDir.path + "/build-logic" &&
      it.parent != rootDir.path + "/build-logic/build-conventions" &&
      it.parent != rootDir.path + "/build-logic/settings-conventions" &&
      it.name == "build.gradle.kts"
  }.map {
    it.path.removePrefix(rootDir.path)
      .removeSuffix("/build.gradle.kts")
      .replace('/', ':')
  }.toList().toTypedArray()
}

include(*discoverSubprojects())
