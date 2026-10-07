package com.agent772.createvoidtank.registry;

import com.agent772.createvoidtank.CreateVoidTank;
import com.agent772.createvoidtank.content.voidtank.VoidTankMountedStorageType;
import com.simibubi.create.api.contraption.storage.fluid.MountedFluidStorageType;
import com.tterrag.registrate.util.entry.RegistryEntry;

public class ModMountedStorageTypes {

    public static final RegistryEntry<MountedFluidStorageType<?>, VoidTankMountedStorageType> VOID_TANK = CreateVoidTank.REGISTRATE
            .mountedFluidStorage("void_tank", VoidTankMountedStorageType::new)
            .register();

    public static void init() {
    }
}
