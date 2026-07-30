# Upstream Baseline

## Candidate repository

- Repository: `MWall541/Dragon-Mounts-Legacy`
- Default branch: `master`
- Pinned baseline commit: `3c4c74e93b6fdf96d7b619e9657335b3b4077921`
- Baseline commit message: `Fix a crash when opening the creative inventory on a ded. server; fixes #259`

## Build target at the pinned baseline

- Minecraft: `1.21`
- Forge: `51.0.33`
- Java: `21`
- Mappings: Parchment `2024.07.28-1.21`
- Build system: ForgeGradle 6, Gradle wrapper
- Mixins: Sponge Mixin
- License: GNU GPL version 3

## Baseline rule

Do not rename packages, mod IDs, resources, or classes before the untouched upstream source builds and launches successfully in both client and dedicated-server development runs.

## Required baseline evidence

- `./gradlew clean build` succeeds.
- Development client reaches the title screen.
- A new single-player world loads.
- Dedicated development server starts.
- A client connects to that server.
- Existing dragon egg, hatch, tame, saddle, ride, takeoff, landing, save, and reload flows are recorded.
- The exact Java and Gradle versions are saved in the audit log.
