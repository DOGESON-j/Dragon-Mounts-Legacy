# Species Schema

## Status

Draft v0.

## Purpose

This document defines the stable vocabulary used to describe production dragon
species in the Archipelago project.

This phase defines contracts only. It does not register production entities,
add natural spawning, implement eggs, alter breeding, or introduce franchise
assets.

## Species Definition

Every production species must define:

- `species_id`
- `entity_type_id`
- `body_class`
- `locomotion_profile`
- `scale_class`
- `growth_class`
- `rarity_class`
- `taming_class`
- `spawn_class`

These fields describe different concerns and must not be merged into one
general category.

## Stable Species Identifier

`species_id` is the permanent identity of a species.

Requirements:

- use a namespaced resource identifier
- use lowercase characters
- use underscores between words
- do not encode rarity, region, age, or temporary balance information
- do not reuse an identifier after removing a species
- do not silently rename an identifier after it has appeared in a saved world

Display names, translations, textures, models, and balance values may change
without changing `species_id`.

The final namespace for project-owned species will be decided separately.
Display names must not be treated as runtime identifiers.

## Entity Type Identifier

`entity_type_id` identifies the registered Minecraft entity type responsible
for constructing the species.

An entity type is a code-owned registration. Data files may reference an
existing entity type but may not create a new entity type by themselves.

A species may share an entity type with another species only when all of the
following are compatible:

- body dimensions
- eye height
- interaction dimensions
- rider position
- movement controller assumptions
- navigation assumptions
- animation contract
- persistence contract

A materially different body must receive an explicit entity boundary.

## Body Classes

Body classes describe the broad physical and movement contract of a species.
They do not determine its final model or appearance.

### `winged_tetrapod`

Four primary walking limbs plus a separate pair of wings.

May reuse mechanics proven by the existing generic dragon foundation when the
dimensions and rider contract are compatible.

### `winged_biped`

Two primary walking limbs with wings acting as the second major limb pair.

Requires its own body configuration and must not inherit tetrapod positioning
without validation.

### `flightless_biped`

Two primary walking limbs with no functional flight contract.

May use jumping, sprinting, climbing, or pack movement, but must not receive
flying navigation automatically.

### `serpentine`

A long body without the standard four-leg locomotion contract.

Requires custom dimensions, movement assumptions, interaction geometry, and
animation.

A body class is not permission to share a model. Each materially distinct
production body still receives an explicit model and renderer.

## Locomotion Profiles

A locomotion profile describes the movement systems a species supports.

A species may declare more than one compatible locomotion value.

### `ground`

Supports ordinary terrestrial navigation.

### `flight`

Supports controlled aerial movement and flying navigation.

Requires a compatible body, animation, takeoff, landing, and rider contract.

### `aquatic`

Supports primary or meaningful movement through water.

Requires explicit water navigation, breathing rules, rider placement, and
land-behavior decisions.

### `burrowing`

Supports movement through terrain or authored underground pathways.

Requires explicit collision, block-interaction, navigation, and world-safety
rules.

### `climbing`

Supports movement across steep or vertical surfaces.

Requires explicit navigation and attachment behavior.

Locomotion values must not be inferred only from appearance. A winged body does
not automatically receive functional flight.

## Scale Classes

Scale describes interaction size independently from body shape, growth speed,
rarity, and spawn policy.

### `small`

Uses dimensions below the normal mount scale.

### `standard`

Uses the ordinary production mount scale.

### `large`

Requires larger dimensions and reviewed rider positioning.

### `titan`

Exceeds normal mount geometry.

Requires explicit dimensions, eye height, tracking range, interaction
geometry, rider rules, collision review, and persistence policy.

## Growth Classes

Growth classes describe lifecycle timing policy rather than current age.

### `rapid`

Reaches adulthood faster than the normal foundation lifecycle.

### `standard`

Uses the normal project growth lifecycle.

### `slow`

Reaches adulthood more slowly than the standard lifecycle.

### `extended`

Uses an extended growth lifecycle beyond the standard slow category.

### `fixed`

Does not use normal hatchling-to-adult growth.

Exact durations are balance values and will be defined after the schema is
implemented.

## Rarity Classes

Rarity describes encounter scarcity. It does not decide how a species spawns.

### `common`

Expected to be encountered regularly inside an appropriate region.

### `uncommon`

Present in appropriate regions but encountered less consistently.

### `rare`

Requires deliberate exploration or favorable conditions.

### `legendary`

Extremely limited and protected from ordinary population behavior.

Rarity must not encode population cardinality. Quest and world uniqueness
belong to `spawn_class`.

## Taming Classes

Taming describes the allowed ownership path.

### `item`

May be tamed through an approved item-based interaction.

### `conditional`

Requires defined behavioral, environmental, trust, or progression conditions.

### `quest`

May become owned only through a controlled quest or authored progression path.

### `never`

Cannot become player-owned.

A species marked `never` must not become tame through breeding, eggs, commands
intended for ordinary gameplay, or fallback generic behavior.

## Spawn Classes

Spawn classification defines the source and persistence policy of encounters.

### `regional`

Uses a persistent regional population and an approved habitat definition.

### `rare_roamer`

Uses limited encounter opportunities outside normal regional density.

### `quest_unique`

Created only through an explicit quest or authored progression event.

Must not use normal natural-spawn population logic.

### `world_unique`

At most one active world instance may exist under ordinary gameplay rules.

Must define how absence, unloading, death, and world reload are handled.

### `world_unique_boss`

A world-unique hostile encounter with explicit boss lifecycle rules.

Must not naturally respawn unless a later design document explicitly allows
it.

### `disabled`

Has no ordinary gameplay spawn source.

Used for test fixtures, development-only entities, migrations, or unfinished
content.

## Entity-to-Species Binding

Each production species must have an explicit binding between:

- stable species identifier
- registered entity type
- body class
- body configuration
- locomotion profile
- scale class
- growth policy
- rarity policy
- taming policy
- spawn policy

The binding must be deterministic. Loading the same saved species identifier
must resolve to the same entity and body contract.

Egg hatching, spawn eggs, breeding, commands, natural spawning, and quest
creation must eventually use the same binding path instead of independently
hardcoding entity types.

## Placeholder Rule

`PlaceholderDragon` remains a development fixture.

Its classification is:

- non-production
- spawn class `disabled`
- excluded from natural spawning
- excluded from production eggs
- excluded from production breeding
- excluded from final balancing
- excluded from franchise assets

The placeholder does not establish a permanent species identifier, body
class, locomotion profile, or scale class.

## Validation Rules

A future schema implementation must reject or report:

- missing required fields
- malformed identifiers
- unknown category values
- references to unregistered entity types
- unique species assigned population spawning
- untameable species assigned ordinary taming behavior
- locomotion behavior assigned without a compatible body contract
- aquatic or burrowing movement without an explicit movement contract
- titan scale without reviewed dimensions, tracking, and collision rules
- entity sharing with incompatible dimensions or rider positioning
- accidental use of the placeholder as production content

## Deferred Work

The following remain intentionally undefined:

- production species assignments
- final namespace migration
- numerical growth durations
- population density
- regional habitat definitions
- nest generation
- egg routing
- breeding compatibility
- boss implementation
- model and texture assets
- combat balance
- breath abilities
