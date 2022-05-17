package io.github.Andrew6rant.echoed;

import io.github.Andrew6rant.echoed.block.EchoGlass;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class Echoed implements ModInitializer {
	public static void register(String itemName, Item item) {
		Registry.register(Registry.ITEM, new Identifier("echoed", itemName), item);
	}
	public static void register(String blockName, Block block) {
		Registry.register(Registry.BLOCK, new Identifier("echoed", blockName), block);
		Registry.register(Registry.ITEM, new Identifier("echoed", blockName), new BlockItem(block, new FabricItemSettings().group(ITEM_GROUP)));
	}

	public static final EchoGlass ECHO_GLASS = new EchoGlass(FabricBlockSettings.of(Material.BARRIER).suffocates(Echoed::never).blockVision(Echoed::never)); //.nonOpaque()
	public static final Item ECHO_KEY = new Item(new Item.Settings());

	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier("echoed", "general"),
			() -> new ItemStack(ECHO_GLASS));

	public static boolean never(BlockState state, BlockView world, BlockPos pos) {
		return false;
	}
	@Override
	public void onInitialize() {
		register(Names.ECHO_GLASS, ECHO_GLASS);
		register(Names.ECHO_KEY, ECHO_KEY);
	}
}