package com.github.kay9.dragonmounts.dragon.species;

public enum SpawnClass implements SpeciesCategory
{
    REGIONAL("regional"),
    RARE_ROAMER("rare_roamer"),
    QUEST_UNIQUE("quest_unique"),
    WORLD_UNIQUE("world_unique"),
    WORLD_UNIQUE_BOSS("world_unique_boss"),
    DISABLED("disabled");

    private final String serializedName;

    SpawnClass(String serializedName)
    {
        this.serializedName = serializedName;
    }

    @Override
    public String serializedName()
    {
        return serializedName;
    }
}
