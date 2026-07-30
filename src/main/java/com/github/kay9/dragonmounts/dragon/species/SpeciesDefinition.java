package com.github.kay9.dragonmounts.dragon.species;

import net.minecraft.resources.ResourceLocation;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Immutable static identity and classification data for one dragon species.
 *
 * <p>Variant appearance, genetics, regional population state, nests, and
 * world-unique enforcement belong to separate runtime systems.</p>
 */
public record SpeciesDefinition(
        ResourceLocation speciesId,
        ResourceLocation entityTypeId,
        BodyClass bodyClass,
        Set<LocomotionType> locomotionProfile,
        ScaleClass scaleClass,
        GrowthClass growthClass,
        RarityClass rarityClass,
        TamingClass tamingClass,
        SpawnClass spawnClass)
{
    public SpeciesDefinition
    {
        Objects.requireNonNull(speciesId, "speciesId");
        Objects.requireNonNull(entityTypeId, "entityTypeId");
        Objects.requireNonNull(bodyClass, "bodyClass");
        Objects.requireNonNull(locomotionProfile, "locomotionProfile");
        Objects.requireNonNull(scaleClass, "scaleClass");
        Objects.requireNonNull(growthClass, "growthClass");
        Objects.requireNonNull(rarityClass, "rarityClass");
        Objects.requireNonNull(tamingClass, "tamingClass");
        Objects.requireNonNull(spawnClass, "spawnClass");

        if (locomotionProfile.isEmpty())
        {
            throw new IllegalArgumentException(
                    "locomotionProfile must contain at least one locomotion type"
            );
        }

        locomotionProfile = Collections.unmodifiableSet(
                EnumSet.copyOf(locomotionProfile)
        );
    }
}
