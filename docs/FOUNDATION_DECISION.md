# Foundation Decision

## Status

Accepted.

## Decision

Dragon Mounts Legacy will serve as the main technical foundation for the
Archipelago dragon project.

This decision is based on the independent species boundary experiment ending
at commit `beb6665`.

## Evidence

The experiment registered an original placeholder dragon with:

- a separate entity type
- a separate entity subclass
- a separate renderer
- a separate model rig
- a separate original test texture

The placeholder successfully reused the existing:

- breed data
- attributes and AI initialization
- taming
- saddling
- mounting
- rider controls
- takeoff and flight
- landing and dismounting
- entity persistence
- tame and saddle persistence across save and reload

The existing generic dragons remained operational.

The experiment also exposed and repaired an inherited spawn-egg login issue in
commit `7ef67b7`.

## Foundation Boundaries

The following systems are accepted as reusable foundation mechanics:

- `TameableDragon`
- movement controllers
- ground and flying navigation
- rider controls
- camera and mount messaging
- synchronized breed data
- taming and saddle state
- entity persistence
- shared attributes and AI goals

The following systems remain coupled to the original generic dragon and must
be generalized before production species depend on them:

- hatchable egg entity creation
- spawn eggs
- breeding offspring creation
- natural spawning
- renderer-specific layers
- model-specific rider positioning
- model and interaction hitboxes

## Species Architecture Rule

A production species may reuse proven generic mechanics, but materially
different dragon bodies must receive an explicit entity, model, renderer, and
body configuration rather than being forced into the inherited generic model.

Shared code should be extracted only after at least two production species
demonstrate the same requirement.

## Placeholder Status

`PlaceholderDragon` is an architecture test fixture, not a production species.

It must not receive franchise assets, final gameplay balancing, natural
spawning, breeding integration, or production egg behavior.

## Consequence

Proceed with the species foundation layer:

- stable species identifiers
- body-class definitions
- growth categories
- rarity categories
- taming rules
- spawn classifications
- explicit entity-to-species registration boundaries

No franchise species should be implemented until those definitions exist.
