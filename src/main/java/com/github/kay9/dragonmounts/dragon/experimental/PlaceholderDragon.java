package com.github.kay9.dragonmounts.dragon.experimental;

import com.github.kay9.dragonmounts.dragon.TameableDragon;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

/**
 * Architecture-test entity used to verify that an independent dragon body
 * can reuse the existing taming, riding, flight, AI, and persistence systems.
 */
public class PlaceholderDragon extends TameableDragon
{
    public PlaceholderDragon(EntityType<? extends PlaceholderDragon> type, Level level)
    {
        super(type, level);
    }
}
