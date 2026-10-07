package com.agent772.createvoidtank.content.voidtank;

import com.agent772.createvoidtank.config.ModConfig;
import com.agent772.createvoidtank.content.VoidFluidHandler;
import com.agent772.createvoidtank.registry.ModMountedStorageTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.simibubi.create.api.contraption.storage.fluid.WrapperMountedFluidStorage;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import org.jetbrains.annotations.Nullable;

/**
 * A Void Tank while it is part of a moving contraption. Create collects the fluid storage of every
 * mounted block into the contraption's fluid inventory, which is what Drill Drains, Portable Fluid
 * Interfaces and other contraption fluid users fill. This storage voids everything it is given, like the
 * placed Void Tank does.
 * <p>
 * Heat sources and redstone cannot be checked while moving, so the tank keeps the activation state it
 * had when the contraption was assembled. Turning off {@code voidOnContraptions} also stops tanks on
 * contraptions that are already moving.
 */
public class VoidTankMountedStorage extends WrapperMountedFluidStorage<VoidFluidHandler> {

    public static final MapCodec<VoidTankMountedStorage> CODEC = Codec.BOOL.optionalFieldOf("active", true)
            .xmap(VoidTankMountedStorage::new, storage -> storage.active);

    private final boolean active;

    public VoidTankMountedStorage(boolean active) {
        super(ModMountedStorageTypes.VOID_TANK.get(),
                new VoidFluidHandler(() -> active && ModConfig.VOID_ON_CONTRAPTIONS.get()));
        this.active = active;
    }

    @Override
    public void unmount(Level level, BlockState state, BlockPos pos, @Nullable BlockEntity be) {
        // Nothing is stored, so there is nothing to write back to the placed tank.
    }
}
