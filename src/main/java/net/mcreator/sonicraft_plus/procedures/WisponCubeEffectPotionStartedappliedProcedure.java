package net.mcreator.sonicraft_plus.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.sonicraft_plus.init.SonicraftPlusModEntities;
import net.mcreator.sonicraft_plus.entity.WisponCubeTrapEntity;

public class WisponCubeEffectPotionStartedappliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof WisponCubeTrapEntity == false) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = SonicraftPlusModEntities.WISPON_CUBE_TRAP.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("sonicraft_plus:wispon.cube.attack")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("sonicraft_plus:wispon.cube.attack")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
		entity.setDeltaMovement(new Vec3(0, 0, 0));
	}
}
