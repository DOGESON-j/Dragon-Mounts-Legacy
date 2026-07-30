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

## Build Environment Remediation

A minimal repository configuration was added to `build.gradle`:

    maven {
        name = "Mojang libraries"
        url = "https://libraries.minecraft.net/"
    }

This allowed Gradle to resolve:

    org.lwjgl:lwjgl-freetype:3.3.3:natives-macos-patch

## Remediated Build Result

Status: PASSED

Command:

    ./gradlew clean build --no-daemon --refresh-dependencies

Result:

    BUILD SUCCESSFUL in 2m 14s
    8 actionable tasks: 8 executed

The project successfully completed Java compilation and artifact generation.
No gameplay, entity, rendering, AI, world-generation, or dragon behavior code
was modified.

## Client Runtime Validation

Status: PASSED

The development client successfully:

- Started with Java 21
- Reached the main menu
- Opened the world-selection screen
- Created and loaded a disposable test world
- Connected the player to the integrated Forge server
- Saved the Overworld, Nether, and End successfully

The initial world-selection crash was caused by the bundled example breed
referencing an unregistered custom sound event. Pointing the example breed to
the registered Dragon Mounts ambient sound resolved the failure.

## Dedicated Server Runtime Validation

Status: PASSED

The Forge development dedicated server successfully:

- Started using Java 21
- Loaded Minecraft 1.21, Forge 51.0.33, Dragon Mounts, and the example addon
- Generated and loaded a dedicated-server world
- Reached the ready state
- Remained stable through an automatic world save
- Was terminated with Control+C because Gradle did not forward console input
- Clean dedicated-server shutdown remains unverified
