# Upstream Baseline Validation

Date: 2026-07-30

## Baseline

- Repository: DOGESON-j/Dragon-Mounts-Legacy
- Upstream: MWall541/Dragon-Mounts-Legacy
- Commit: 3c4c74e93b6fdf96d7b619e9657335b3b4077921
- Platform: macOS Apple Silicon arm64
- Java: OpenJDK 21.0.12
- Gradle wrapper: Gradle 8.5

## Untouched Build Result

Status: FAILED

Command:

    ./gradlew clean build --no-daemon

Failure stage: Gradle dependency resolution, before Java compilation.

Missing dependency:

    org.lwjgl:lwjgl-freetype:3.3.3:natives-macos-patch

Gradle searched Maven Central for the patched native artifact but did not
resolve it.

No source changes were present during this test.

## Interpretation

This is an upstream build-environment/repository-resolution failure on macOS
Apple Silicon. It is not currently evidence of a Dragon Mounts Java source
compilation failure.
