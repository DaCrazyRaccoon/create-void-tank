package com.agent772.createvoidtank.content.voidtank;

import com.agent772.createvoidtank.config.ModConfig;
import com.agent772.createvoidtank.config.ModConfig.ActivationMode;
import com.simibubi.create.api.contraption.storage.fluid.MountedFluidStorageType;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import org.jetbrains.annotations.Nullable;

public class VoidTankMountedStorageType extends MountedFluidStorageType<VoidTankMountedStorage> {

    public VoidTankMountedStorageType() {
        super(VoidTankMountedStorage.CODEC);
    }

    @Override
    @Nullable
    public VoidTankMountedStorage mount(Level level, BlockState state, BlockPos pos, @Nullable BlockEntity be) {
        if (!ModConfig.VOID_ON_CONTRAPTIONS.get()) {
            return null; // not part of the contraption's fluid storage
        }
        boolean active = be instanceof VoidTankBlockEntity tank
                ? tank.isActive()
                : ModConfig.ACTIVATION_MODE.get() == ActivationMode.ALWAYS_ACTIVE;
        return new VoidTankMountedStorage(active);
    }
}
