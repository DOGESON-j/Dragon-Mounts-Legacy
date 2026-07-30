package com.github.kay9.dragonmounts.dragon.species;

public enum ScaleClass implements SpeciesCategory
{
    SMALL("small"),
    STANDARD("standard"),
    LARGE("large"),
    TITAN("titan");

    private final String serializedName;

    ScaleClass(String serializedName)
    {
        this.serializedName = serializedName;
    }

    @Override
    public String serializedName()
    {
        return serializedName;
    }
}
