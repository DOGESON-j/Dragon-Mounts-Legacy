# Architecture Audit

## What the source actually provides

The project centers on one generic `TameableDragon` entity. Dragon breeds are registry/data-driven configurations applied to that shared entity rather than independent species implementations.

The existing entity provides:

- Vanilla-style taming and ownership
- Saddling and riding
- Ground and flying navigation switching
- Player-controlled ascent and descent
- Growth and age scaling
- Breeding and hatchable eggs
- Breed-specific attributes, food, immunities, sounds, size, and simple abilities
- Client animation and camera helpers

## Important constraints

### AI

The wild AI is mainly composed from standard Minecraft goals: melee, owner following, breeding, random strolling, looking around, retaliation, and hunting animals. It is not a territory, flock, migration, nesting, hunting, or boss-behavior framework.

### Models

The renderer and `DragonModel` assume a generic winged tetrapod skeleton:

- One head
- One neck chain
- Four legs
- Two conventional wings
- One tail chain

This cannot represent several planned species without new rigs and likely new entity/rendering paths. Examples include two-headed, serpentine, flightless, aquatic, and titan-scale dragons.

### Breed data

Breed JSON can configure attributes, abilities, egg habitats, immunities, sounds, growth, size, taming items, breeding items, and reproduction limits. It cannot define an entirely new skeleton, advanced attack controller, boss phase system, territory simulation, or spawning ecology by itself.

### Habitats

The existing habitat system scores the surroundings of an egg and can transition that egg to another breed. It is not a wild biome-spawning system.

### Abilities

The ability interface is reusable and supports per-breed factories plus per-entity state. Existing built-in abilities are mostly environment interactions such as frost walking and block effects. A generalized breath/projectile/combat ability layer still needs design.

## Preliminary reuse verdict

Treat Dragon Mounts: Legacy as a candidate mechanics donor and prototype foundation, not as an approved final architecture.

Potentially reusable:

- Riding controls
- Flight movement baseline
- Taming and ownership
- Growth
- Egg persistence and hatching
- Breed registry and serialization
- Camera helpers

Likely to require replacement or major extension:

- Wild AI
- Spawn ecology and nests
- Species-specific rigs and animations
- Breath/projectile attacks
- Pack behavior
- Aquatic navigation
- Serpentine movement
- Titan collision, navigation, and boss phases
- Multiplayer synchronization for advanced attacks
