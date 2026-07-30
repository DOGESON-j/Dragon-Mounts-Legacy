package com.github.kay9.dragonmounts.client;

import com.github.kay9.dragonmounts.dragon.experimental.PlaceholderDragon;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

/**
 * Deliberately simple test rig. This is not a production dragon model.
 */
public class PlaceholderDragonModel extends EntityModel<PlaceholderDragon>
{
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart leftWing;
    private final ModelPart rightWing;

    public PlaceholderDragonModel(ModelPart root)
    {
        this.root = root;
        ModelPart body = root.getChild("body");
        this.head = body.getChild("head");
        this.leftWing = body.getChild("left_wing");
        this.rightWing = body.getChild("right_wing");
    }

    public static LayerDefinition createBodyLayer()
    {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        PartDefinition body = root.addOrReplaceChild(
                "body",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-8.0F, -6.0F, -12.0F, 16.0F, 12.0F, 24.0F),
                PartPose.offset(0.0F, 15.0F, 2.0F)
        );

        body.addOrReplaceChild(
                "head",
                CubeListBuilder.create()
                        .texOffs(0, 36)
                        .addBox(-6.0F, -5.0F, -8.0F, 12.0F, 10.0F, 10.0F),
                PartPose.offset(0.0F, -1.0F, -12.0F)
        );

        body.addOrReplaceChild(
                "tail",
                CubeListBuilder.create()
                        .texOffs(44, 36)
                        .addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 20.0F),
                PartPose.offset(0.0F, 0.0F, 12.0F)
        );

        body.addOrReplaceChild(
                "left_wing",
                CubeListBuilder.create()
                        .texOffs(0, 58)
                        .addBox(0.0F, -1.0F, -4.0F, 18.0F, 2.0F, 12.0F),
                PartPose.offset(7.0F, -3.0F, 0.0F)
        );

        body.addOrReplaceChild(
                "right_wing",
                CubeListBuilder.create()
                        .texOffs(0, 58)
                        .mirror()
                        .addBox(-18.0F, -1.0F, -4.0F, 18.0F, 2.0F, 12.0F),
                PartPose.offset(-7.0F, -3.0F, 0.0F)
        );

        addLeg(body, "front_left_leg", 5.0F, 4.0F, -7.0F);
        addLeg(body, "front_right_leg", -5.0F, 4.0F, -7.0F);
        addLeg(body, "back_left_leg", 5.0F, 4.0F, 7.0F);
        addLeg(body, "back_right_leg", -5.0F, 4.0F, 7.0F);

        return LayerDefinition.create(mesh, 128, 128);
    }

    private static void addLeg(
            PartDefinition body,
            String name,
            float x,
            float y,
            float z
    )
    {
        body.addOrReplaceChild(
                name,
                CubeListBuilder.create()
                        .texOffs(64, 0)
                        .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F),
                PartPose.offset(x, y, z)
        );
    }

    @Override
    public void setupAnim(
            PlaceholderDragon dragon,
            float limbSwing,
            float limbSwingAmount,
            float ageInTicks,
            float netHeadYaw,
            float headPitch
    )
    {
        head.yRot = netHeadYaw * Mth.DEG_TO_RAD;
        head.xRot = headPitch * Mth.DEG_TO_RAD;

        float flap = Mth.cos(ageInTicks * 0.35F) * 0.18F;

        leftWing.zRot = -0.25F - flap;
        rightWing.zRot = 0.25F + flap;
    }

    @Override
    public void renderToBuffer(
            PoseStack poseStack,
            VertexConsumer vertices,
            int packedLight,
            int packedOverlay,
            int color
    )
    {
        root.render(
                poseStack,
                vertices,
                packedLight,
                packedOverlay,
                color
        );
    }
}
