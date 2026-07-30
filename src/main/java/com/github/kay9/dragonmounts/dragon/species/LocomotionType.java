package com.github.kay9.dragonmounts.dragon.species;

public enum LocomotionType implements SpeciesCategory
{
    GROUND("ground"),
    FLIGHT("flight"),
    AQUATIC("aquatic"),
    BURROWING("burrowing"),
    CLIMBING("climbing");

    private final String serializedName;

    LocomotionType(String serializedName)
    {
        this.serializedName = serializedName;
    }

    @Override
    public String serializedName()
    {
        return serializedName;
    }
}
