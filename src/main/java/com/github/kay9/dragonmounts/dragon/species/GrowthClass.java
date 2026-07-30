package com.github.kay9.dragonmounts.dragon.species;

public enum GrowthClass implements SpeciesCategory
{
    RAPID("rapid"),
    STANDARD("standard"),
    SLOW("slow"),
    EXTENDED("extended"),
    FIXED("fixed");

    private final String serializedName;

    GrowthClass(String serializedName)
    {
        this.serializedName = serializedName;
    }

    @Override
    public String serializedName()
    {
        return serializedName;
    }
}
