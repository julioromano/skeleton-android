import org.gradle.internal.os.OperatingSystem

val separator = if (OperatingSystem.current().isWindows) '\\' else '/'

/**
 * Searches for subprojects' `build.gradle` files and prints their Gradle project path.
 */
private val discoverSubprojects: () -> Array<String> = {
  rootDir.walkBottomUp().filter {
    it.parent != rootDir.path &&
      it.parent != rootDir.path + "${separator}buildSrc" &&
      it.parent != rootDir.path + "${separator}build-logic" &&
      it.parent != rootDir.path + "${separator}build-logic${separator}build-conventions" &&
      it.parent != rootDir.path + "${separator}build-logic${separator}settings-conventions" &&
      it.name == "build.gradle.kts"
  }.map {
    it.path.removePrefix(rootDir.path)
      .removeSuffix("${separator}build.gradle.kts")
      .replace(separator, ':')
  }.toList().toTypedArray()
}

include(*discoverSubprojects())
