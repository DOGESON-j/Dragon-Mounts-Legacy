package com.github.kay9.dragonmounts.dragon.species;

public enum RarityClass implements SpeciesCategory
{
    COMMON("common"),
    UNCOMMON("uncommon"),
    RARE("rare"),
    LEGENDARY("legendary");

    private final String serializedName;

    RarityClass(String serializedName)
    {
        this.serializedName = serializedName;
    }

    @Override
    public String serializedName()
    {
        return serializedName;
    }
}
