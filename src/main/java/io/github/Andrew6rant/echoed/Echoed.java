package io.github.Andrew6rant.echoed;

import com.google.common.collect.ImmutableSet;
import com.unascribed.lib39.core.api.AutoRegistry;
import io.github.Andrew6rant.echoed.block.EchoGlass;
import io.github.Andrew6rant.echoed.block.EchoGlassBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class Echoed implements ModInitializer {
	public static final String ModID = "echoed";

	public static final AutoRegistry AUTOREG = AutoRegistry.of(ModID);

	public static void register(String itemName, Item item) {
		Registry.register(Registries.ITEM, new Identifier("echoed", itemName), item);
	}
	public static void register(String blockName, Block block) {
		Registry.register(Registries.BLOCK, new Identifier("echoed", blockName), block);
		Registry.register(Registries.ITEM, new Identifier("echoed", blockName), new BlockItem(block, new FabricItemSettings()));
	}

	public static final EchoGlass ECHO_GLASS = new EchoGlass(FabricBlockSettings.copyOf(Blocks.BARRIER).suffocates(Echoed::never).blockVision(Echoed::never).strength(0.0F, 1200.0F)); //.nonOpaque()
	public static final Item ECHO_KEY = new Item(new Item.Settings());

	public static final BlockEntityType<EchoGlassBlockEntity> ECHO_GLASS_BLOCK_ENTITY = Registry.register(
			Registries.BLOCK_ENTITY_TYPE,
			new Identifier(ModID, "echo_glass_block_entity"),
			FabricBlockEntityTypeBuilder.create(EchoGlassBlockEntity::new, ECHO_GLASS).build()
	);

	public static boolean never(BlockState state, BlockView world, BlockPos pos) {
		return false;
	}

	@Override
	public void onInitialize() {
		register(Names.ECHO_GLASS, ECHO_GLASS);
		register(Names.ECHO_KEY, ECHO_KEY);
	}

}
