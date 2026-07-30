package com.github.kay9.dragonmounts.dragon.species;

public enum TamingClass implements SpeciesCategory
{
    ITEM("item"),
    CONDITIONAL("conditional"),
    QUEST("quest"),
    NEVER("never");

    private final String serializedName;

    TamingClass(String serializedName)
    {
        this.serializedName = serializedName;
    }

    @Override
    public String serializedName()
    {
        return serializedName;
    }
}
