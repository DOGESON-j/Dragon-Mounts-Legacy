package com.github.kay9.dragonmounts.client;

import com.github.kay9.dragonmounts.DragonMountsLegacy;
import com.github.kay9.dragonmounts.dragon.experimental.PlaceholderDragon;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PlaceholderDragonRenderer
        extends MobRenderer<PlaceholderDragon, PlaceholderDragonModel>
{
    public static final ModelLayerLocation MODEL_LOCATION =
            new ModelLayerLocation(
                    DragonMountsLegacy.id("placeholder_dragon"),
                    "main"
            );

    private static final ResourceLocation TEXTURE =
            DragonMountsLegacy.id(
                    "textures/entity/placeholder_dragon.png"
            );

    public PlaceholderDragonRenderer(
            EntityRendererProvider.Context context
    )
    {
        super(
                context,
                new PlaceholderDragonModel(
                        context.bakeLayer(MODEL_LOCATION)
                ),
                1.2F
        );
    }

    @Override
    public ResourceLocation getTextureLocation(
            PlaceholderDragon dragon
    )
    {
        return TEXTURE;
    }

    @Override
    protected void scale(
            PlaceholderDragon dragon,
            PoseStack poseStack,
            float partialTick
    )
    {
        float ageScale = dragon.getAgeScale();
        poseStack.scale(ageScale, ageScale, ageScale);
    }
}
