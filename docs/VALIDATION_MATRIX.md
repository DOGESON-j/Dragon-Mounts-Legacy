# Validation Matrix

| Area | Test | Required result |
|---|---|---|
| Build | `./gradlew clean build` | Successful build |
| Client | Development client launch | Reaches title screen |
| World | New single-player world | Loads without crash |
| Server | Dedicated development server | Starts cleanly |
| Multiplayer | Client connects to server | No registry mismatch |
| Egg | Place and activate egg | Persists correctly |
| Hatching | Complete hatch cycle | Dragon entity spawns |
| Taming | Use valid breed food | Ownership syncs |
| Saddle | Equip and remove saddle | State and item persist |
| Riding | Mount and dismount | Camera and controls work |
| Flight | Takeoff, climb, descend, land | Stable movement |
| Save | Exit and reload world | Breed, age, owner, saddle persist |
| Death | Kill dragon | Death animation/removal completes |
| Dedicated server | Open creative inventory | No client disconnect/crash |
| Addon | Load example addon | Egg/model resources load |

## Known upstream risk areas

- Basic AI quality
- Egg and breed synchronization
- Creative inventory behavior on servers
- Example addon reliability
- Rendering compatibility with optimization mods and shaders
