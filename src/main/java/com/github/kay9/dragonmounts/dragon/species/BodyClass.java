package com.github.kay9.dragonmounts.dragon.species;

public enum BodyClass implements SpeciesCategory
{
    WINGED_TETRAPOD("winged_tetrapod"),
    WINGED_BIPED("winged_biped"),
    FLIGHTLESS_BIPED("flightless_biped"),
    SERPENTINE("serpentine");

    private final String serializedName;

    BodyClass(String serializedName)
    {
        this.serializedName = serializedName;
    }

    @Override
    public String serializedName()
    {
        return serializedName;
    }
}
