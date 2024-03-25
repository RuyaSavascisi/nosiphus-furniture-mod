package com.nosiphus.furniture.core;

import com.mrcrayfish.furniture.tileentity.*;
import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.blockentity.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NosiphusFurnitureMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<BinBlockEntity>> BIN = register("bin", BinBlockEntity::new, () -> new Block[]{ModBlocks.BIN_LIGHT.get(), ModBlocks.BIN_DARK.get()});
    public static final RegistryObject<BlockEntityType<BedsideCabinetBlockEntity>> BEDSIDE_CABINET = register("bedside_cabinet", BedsideCabinetBlockEntity::new, () -> new Block[]{ModBlocks.BEDSIDE_CABINET_STONE.get(), ModBlocks.BEDSIDE_CABINET_ANDESITE.get(), ModBlocks.BEDSIDE_CABINET_DIORITE.get(), ModBlocks.BEDSIDE_CABINET_GRANITE.get(), ModBlocks.BEDSIDE_CABINET_BLACKSTONE.get(), ModBlocks.BEDSIDE_CABINET_DEEPSLATE.get(), ModBlocks.BEDSIDE_CABINET_WHITE_MODERN.get(), ModBlocks.BEDSIDE_CABINET_ORANGE_MODERN.get(), ModBlocks.BEDSIDE_CABINET_MAGENTA_MODERN.get(), ModBlocks.BEDSIDE_CABINET_LIGHT_BLUE_MODERN.get(), ModBlocks.BEDSIDE_CABINET_YELLOW_MODERN.get(), ModBlocks.BEDSIDE_CABINET_LIME_MODERN.get(), ModBlocks.BEDSIDE_CABINET_PINK_MODERN.get(), ModBlocks.BEDSIDE_CABINET_GRAY_MODERN.get(), ModBlocks.BEDSIDE_CABINET_LIGHT_GRAY_MODERN.get(), ModBlocks.BEDSIDE_CABINET_CYAN_MODERN.get(), ModBlocks.BEDSIDE_CABINET_PURPLE_MODERN.get(), ModBlocks.BEDSIDE_CABINET_BLUE_MODERN.get(), ModBlocks.BEDSIDE_CABINET_BROWN_MODERN.get(), ModBlocks.BEDSIDE_CABINET_GREEN_MODERN.get(), ModBlocks.BEDSIDE_CABINET_RED_MODERN.get(), ModBlocks.BEDSIDE_CABINET_BLACK_MODERN.get()});
    public static final RegistryObject<BlockEntityType<CabinetBlockEntity>> CABINET = register("cabinet", CabinetBlockEntity::new, () -> new Block[]{ModBlocks.CABINET_STONE.get(), ModBlocks.CABINET_ANDESITE.get(), ModBlocks.CABINET_DIORITE.get(), ModBlocks.CABINET_GRANITE.get(), ModBlocks.CABINET_BLACKSTONE.get(), ModBlocks.CABINET_DEEPSLATE.get(), ModBlocks.CABINET_WHITE_MODERN.get(), ModBlocks.CABINET_ORANGE_MODERN.get(), ModBlocks.CABINET_MAGENTA_MODERN.get(), ModBlocks.CABINET_LIGHT_BLUE_MODERN.get(), ModBlocks.CABINET_YELLOW_MODERN.get(), ModBlocks.CABINET_LIME_MODERN.get(), ModBlocks.CABINET_PINK_MODERN.get(), ModBlocks.CABINET_GRAY_MODERN.get(), ModBlocks.CABINET_LIGHT_GRAY_MODERN.get(), ModBlocks.CABINET_CYAN_MODERN.get(), ModBlocks.CABINET_PURPLE_MODERN.get(), ModBlocks.CABINET_BLUE_MODERN.get(), ModBlocks.CABINET_BROWN_MODERN.get(), ModBlocks.CABINET_GREEN_MODERN.get(), ModBlocks.CABINET_RED_MODERN.get(), ModBlocks.CABINET_BLACK_MODERN.get(), ModBlocks.TELEVISION_STAND_WHITE.get(), ModBlocks.TELEVISION_STAND_ORANGE.get(), ModBlocks.TELEVISION_STAND_MAGENTA.get(), ModBlocks.TELEVISION_STAND_LIGHT_BLUE.get(), ModBlocks.TELEVISION_STAND_YELLOW.get(), ModBlocks.TELEVISION_STAND_LIME.get(), ModBlocks.TELEVISION_STAND_PINK.get(), ModBlocks.TELEVISION_STAND_GRAY.get(), ModBlocks.TELEVISION_STAND_LIGHT_GRAY.get(), ModBlocks.TELEVISION_STAND_CYAN.get(), ModBlocks.TELEVISION_STAND_PURPLE.get(), ModBlocks.TELEVISION_STAND_BLUE.get(), ModBlocks.TELEVISION_STAND_BROWN.get(), ModBlocks.TELEVISION_STAND_GREEN.get(), ModBlocks.TELEVISION_STAND_RED.get(), ModBlocks.TELEVISION_STAND_BLACK.get()});
    public static final RegistryObject<BlockEntityType<DeskCabinetBlockEntity>> DESK_CABINET = register("desk_cabinet", DeskCabinetBlockEntity::new, () -> new Block[]{ModBlocks.DESK_CABINET_STONE.get(), ModBlocks.DESK_CABINET_ANDESITE.get(), ModBlocks.DESK_CABINET_DIORITE.get(), ModBlocks.DESK_CABINET_GRANITE.get(), ModBlocks.DESK_CABINET_BLACKSTONE.get(), ModBlocks.DESK_CABINET_DEEPSLATE.get(), ModBlocks.DESK_CABINET_WHITE_MODERN.get(), ModBlocks.DESK_CABINET_ORANGE_MODERN.get(), ModBlocks.DESK_CABINET_MAGENTA_MODERN.get(), ModBlocks.DESK_CABINET_LIGHT_BLUE_MODERN.get(), ModBlocks.DESK_CABINET_YELLOW_MODERN.get(), ModBlocks.DESK_CABINET_LIME_MODERN.get(), ModBlocks.DESK_CABINET_PINK_MODERN.get(), ModBlocks.DESK_CABINET_GRAY_MODERN.get(), ModBlocks.DESK_CABINET_LIGHT_GRAY_MODERN.get(), ModBlocks.DESK_CABINET_CYAN_MODERN.get(), ModBlocks.DESK_CABINET_PURPLE_MODERN.get(), ModBlocks.DESK_CABINET_BLUE_MODERN.get(), ModBlocks.DESK_CABINET_BROWN_MODERN.get(), ModBlocks.DESK_CABINET_GREEN_MODERN.get(), ModBlocks.DESK_CABINET_RED_MODERN.get(), ModBlocks.DESK_CABINET_BLACK_MODERN.get()});
    public static final RegistryObject<BlockEntityType<KitchenDrawerBlockEntity>> KITCHEN_DRAWER = register("kitchen_drawer", KitchenDrawerBlockEntity::new, () -> new Block[]{ModBlocks.KITCHEN_DRAWER_WHITE_MODERN.get(), ModBlocks.KITCHEN_DRAWER_ORANGE_MODERN.get(), ModBlocks.KITCHEN_DRAWER_MAGENTA_MODERN.get(), ModBlocks.KITCHEN_DRAWER_LIGHT_BLUE_MODERN.get(), ModBlocks.KITCHEN_DRAWER_YELLOW_MODERN.get(), ModBlocks.KITCHEN_DRAWER_LIME_MODERN.get(), ModBlocks.KITCHEN_DRAWER_PINK_MODERN.get(), ModBlocks.KITCHEN_DRAWER_GRAY_MODERN.get(), ModBlocks.KITCHEN_DRAWER_LIGHT_GRAY_MODERN.get(), ModBlocks.KITCHEN_DRAWER_CYAN_MODERN.get(), ModBlocks.KITCHEN_DRAWER_PURPLE_MODERN.get(), ModBlocks.KITCHEN_DRAWER_BLUE_MODERN.get(), ModBlocks.KITCHEN_DRAWER_BROWN_MODERN.get(), ModBlocks.KITCHEN_DRAWER_GREEN_MODERN.get(), ModBlocks.KITCHEN_DRAWER_RED_MODERN.get(), ModBlocks.KITCHEN_DRAWER_BLACK_MODERN.get()});
    public static final RegistryObject<BlockEntityType<MicrowaveBlockEntity>> MICROWAVE = register("microwave", MicrowaveBlockEntity::new, () -> new Block[]{ModBlocks.MICROWAVE_LIGHT.get(), ModBlocks.MICROWAVE_DARK.get()});
    public static final RegistryObject<BlockEntityType<ModernKitchenSinkBlockEntity>> MODERN_KITCHEN_SINK = register("modern_kitchen_sink", ModernKitchenSinkBlockEntity::new, () -> new Block[]{ModBlocks.KITCHEN_SINK_WHITE_MODERN.get(), ModBlocks.KITCHEN_SINK_ORANGE_MODERN.get(), ModBlocks.KITCHEN_SINK_MAGENTA_MODERN.get(), ModBlocks.KITCHEN_SINK_LIGHT_BLUE_MODERN.get(), ModBlocks.KITCHEN_SINK_YELLOW_MODERN.get(), ModBlocks.KITCHEN_SINK_LIME_MODERN.get(), ModBlocks.KITCHEN_SINK_PINK_MODERN.get(), ModBlocks.KITCHEN_SINK_GRAY_MODERN.get(), ModBlocks.KITCHEN_SINK_LIGHT_GRAY_MODERN.get(), ModBlocks.KITCHEN_SINK_CYAN_MODERN.get(), ModBlocks.KITCHEN_SINK_PURPLE_MODERN.get(), ModBlocks.KITCHEN_SINK_BLUE_MODERN.get(), ModBlocks.KITCHEN_SINK_BROWN_MODERN.get(), ModBlocks.KITCHEN_SINK_GREEN_MODERN.get(), ModBlocks.KITCHEN_SINK_RED_MODERN.get(), ModBlocks.KITCHEN_SINK_BLACK_MODERN.get()});
    public static final RegistryObject<BlockEntityType<OvenBlockEntity>> OVEN = register("oven", OvenBlockEntity::new, () -> new Block[]{ModBlocks.OVEN_LIGHT.get(), ModBlocks.OVEN_DARK.get()});
    public static final RegistryObject<BlockEntityType<SinkBlockEntity>> SINK = register("sink", SinkBlockEntity::new, () -> new Block[]{ModBlocks.SINK_LIGHT.get(), ModBlocks.SINK_DARK.get()});
    public static final RegistryObject<BlockEntityType<ToiletBlockEntity>> TOILET = register("toilet", ToiletBlockEntity::new, () -> new Block[]{ModBlocks.TOILET_LIGHT.get(), ModBlocks.TOILET_DARK.get()});
    public static final RegistryObject<BlockEntityType<WallCabinetBlockEntity>> WALL_CABINET = register("wall_cabinet", WallCabinetBlockEntity::new, () -> new Block[]{ModBlocks.WALL_CABINET_WHITE.get(), ModBlocks.WALL_CABINET_ORANGE.get(), ModBlocks.WALL_CABINET_MAGENTA.get(), ModBlocks.WALL_CABINET_LIGHT_BLUE.get(), ModBlocks.WALL_CABINET_YELLOW.get(), ModBlocks.WALL_CABINET_LIME.get(), ModBlocks.WALL_CABINET_PINK.get(), ModBlocks.WALL_CABINET_GRAY.get(), ModBlocks.WALL_CABINET_LIGHT_GRAY.get(), ModBlocks.WALL_CABINET_CYAN.get(), ModBlocks.WALL_CABINET_PURPLE.get(), ModBlocks.WALL_CABINET_BLUE.get(), ModBlocks.WALL_CABINET_BROWN.get(), ModBlocks.WALL_CABINET_GREEN.get(), ModBlocks.WALL_CABINET_RED.get(), ModBlocks.WALL_CABINET_BLACK.get()});
    public static final RegistryObject<BlockEntityType<WaterTankBlockEntity>> WATER_TANK = register("water_tank", WaterTankBlockEntity::new, () -> new Block[]{ModBlocks.OAK_WATER_TANK.get(), ModBlocks.SPRUCE_WATER_TANK.get(), ModBlocks.BIRCH_WATER_TANK.get(), ModBlocks.JUNGLE_WATER_TANK.get(), ModBlocks.ACACIA_WATER_TANK.get(), ModBlocks.DARK_OAK_WATER_TANK.get(), ModBlocks.CRIMSON_WATER_TANK.get(), ModBlocks.WARPED_WATER_TANK.get(), ModBlocks.MANGROVE_WATER_TANK.get()});
    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, BlockEntityType.BlockEntitySupplier<T> supplier, Supplier<Block[]> validBlocksSupplier)
    {
        return BLOCK_ENTITIES.register(name, () -> BlockEntityType.Builder.of(supplier, validBlocksSupplier.get()).build(null));
    }

}
