# Bootstrap Plan

## Repository strategy

Create a personal fork of `MWall541/Dragon-Mounts-Legacy`. Preserve upstream history and GPL notices.

## First branch

`archipelago/bootstrap`

## First commit scope

The first commit must contain documentation and validation scaffolding only. It must not add Toothless, franchise assets, new dragons, or package-wide renames.

Recommended files:

- `docs/upstream-baseline.md`
- `docs/architecture-audit.md`
- `docs/validation-matrix.md`
- `docs/licensing.md`
- `docs/decision-log.md`

## Validation order

1. Build untouched upstream.
2. Launch development client.
3. Launch dedicated development server.
4. Test client/server connection.
5. Exercise the existing dragon lifecycle.
6. Capture failures and stack traces.
7. Confirm whether the baseline is stable enough for a prototype.
8. Only then create a minimal experimental species branch.

## First experimental branch

`experiment/species-entity-boundary`

The experiment should answer one question only:

> Can a second dragon entity and renderer coexist with the generic `TameableDragon` system while reusing flight/riding helpers?

Use an original placeholder dragon name, texture, and model during architecture testing. Do not begin with a franchise character.

## Pass criteria

- Separate entity type registers cleanly.
- Separate renderer and model rig load.
- Existing generic dragons still function.
- New entity can reuse or adapt riding controls.
- Client and dedicated server remain compatible.
- Save/reload preserves the new entity.

## Stop criteria

Stop using the repository as the foundation if introducing one separate species requires invasive edits across the generic entity, animator, renderer, data registry, and network code with no clean extension seam.
