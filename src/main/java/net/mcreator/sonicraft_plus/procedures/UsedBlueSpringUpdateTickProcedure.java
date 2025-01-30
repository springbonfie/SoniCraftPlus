package net.mcreator.sonicraft_plus.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.sonicraft_plus.init.SonicraftPlusModBlocks;
import net.mcreator.sonicraft_plus.SonicraftPlusMod;

import java.util.Map;

public class UsedBlueSpringUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SonicraftPlusMod.queueServerWork(2, () -> {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = SonicraftPlusModBlocks.BLUE_SPRING.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		});
	}
}
