package growthcraft.bees.world;

import java.util.Random;

import growthcraft.bees.GrowthCraftBees;
import growthcraft.bees.world.WorldGenBeeHive;
import growthcraft.core.Utils;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class WorldGeneratorBees implements IWorldGenerator
{
	//constants
	//private final int rarity = 8;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if (world.provider.dimensionId == 0)
		{
			generateSurface(world, random, chunkX, chunkZ);
		}
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{
		if (!world.getWorldInfo().getTerrainType().getWorldTypeName().startsWith("flat"))
		{
			int i = chunkX * 16 + random.nextInt(16) + 8;
			int j = random.nextInt(128);
			int k = chunkZ * 16 + random.nextInt(16) + 8;

			boolean flag = true;
			if (GrowthCraftBees.instance.beeUseBiomeDict)
			{
				BiomeGenBase biome = world.getBiomeGenForCoords(i, k);
				flag = (BiomeDictionary.isBiomeOfType(biome, Type.FOREST) ||
						BiomeDictionary.isBiomeOfType(biome, Type.PLAINS))
						&& !BiomeDictionary.isBiomeOfType(biome, Type.FROZEN);
			}
			else
			{
				flag = Utils.isIDInList(world.getBiomeGenForCoords(i, k).biomeID, GrowthCraftBees.instance.beeBiomesList);
			}

			//int i = chunkX * 16 + random.nextInt(16);
			//int k = chunkZ * 16 + random.nextInt(16);
			//int j = world.getHeightValue(i, k);
			if (flag)//&& random.nextInt(this.rarity) == 0)
			{
				new WorldGenBeeHive().generate(world, random, i, j, k);
			}
			//return false;
		}
	}
}
