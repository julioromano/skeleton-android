import java.io.File.separator
import java.io.File.separatorChar

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
      .replace(separatorChar, ':')
  }.toList().toTypedArray()
}

include(*discoverSubprojects())
