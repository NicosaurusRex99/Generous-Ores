package naturix.go;

import java.util.Random;

import com.google.common.base.Predicate;

import cofh.thermalfoundation.init.TFBlocks;
import erogenousbeef.bigreactors.init.BrBlocks;
import ic2.core.Ic2WorldDecorator;
import ic2.core.block.type.ResourceBlock;
import mekanism.common.MekanismBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Loader;


public class ModWorldGeneration implements IWorldGenerator {

	public static ModWorldGeneration instance = new ModWorldGeneration();
	
	@Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()){
            case -1:
                genNether(world, random, chunkX, chunkZ);
                break;
            case 0:
                genSurface(world, random, chunkX, chunkZ);
                break;
            case 1:
            	break;
        }
    }
	private void addOreSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chance, int minY, int maxY, Predicate<IBlockState> blockToSpawnIn){
		  int diffMinMaxY = maxY - minY;
		  for(int x = 0; x < chance; x++){
		   int posX = blockXPos + random.nextInt(maxX);
		   int posY = minY + random.nextInt(diffMinMaxY);
		   int posZ = blockZPos + random.nextInt(maxZ);

		   WorldGenMinable gen = new WorldGenMinable(block, maxVeinSize, blockToSpawnIn);
			
			if(minY > maxY || minY < 0 || maxY > 256) throw new IllegalArgumentException("Ore Generated Out of Bounds");
			int heighDiff = maxY - minY + 1;
			
			for(int i = 0; i < chance; i++) {
				int b = blockXPos * 16 + random.nextInt(16);
				int y = minY + random.nextInt(heighDiff);
				int z = blockZPos * 16 + random.nextInt(16);
				
				gen.generate(world, random, new BlockPos(b, y, z));
			}
		
		  }
		  }
	 private void genSurface(World world, Random random, int chunkX, int chunkZ){
		 addOreSpawn(Blocks.IRON_ORE.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.ironVein, Config.ironSpawnTries, Config.ironMin, Config.ironMax, BlockMatcher.forBlock(Blocks.STONE));
		 addOreSpawn(Blocks.COAL_ORE.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.coalVein, Config.coalSpawnTries, Config.coalMin, Config.coalMax, BlockMatcher.forBlock(Blocks.STONE));
		 addOreSpawn(Blocks.GOLD_ORE.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.goldVein, Config.goldSpawnTries, Config.goldMin, Config.goldMax, BlockMatcher.forBlock(Blocks.STONE));
		 addOreSpawn(Blocks.LAPIS_ORE.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.lapisVein, Config.lapisSpawnTries, Config.lapisMin, Config.lapisMax, BlockMatcher.forBlock(Blocks.STONE));
		 addOreSpawn(Blocks.REDSTONE_ORE.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.redstoneVein, Config.redstoneSpawnTries, Config.redstoneMin, Config.redstoneMax, BlockMatcher.forBlock(Blocks.STONE));
		 addOreSpawn(Blocks.DIAMOND_ORE.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.diamondVein, Config.diamondSpawnTries, Config.diamondMin, Config.diamondMax, BlockMatcher.forBlock(Blocks.STONE));
		 addOreSpawn(Blocks.EMERALD_ORE.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.emeraldVein, Config.emeraldSpawnTries, Config.emeraldMin, Config.emeraldMax, BlockMatcher.forBlock(Blocks.STONE));
		
		 if(Loader.isModLoaded("thermalexpansion")) {
			 IBlockState tfcopper = Block.getBlockFromItem(TFBlocks.blockOre.oreCopper.getItem()).getStateFromMeta(TFBlocks.blockOre.oreCopper.getMetadata());
			 IBlockState tftin = Block.getBlockFromItem(TFBlocks.blockOre.oreTin.getItem()).getStateFromMeta(TFBlocks.blockOre.oreCopper.getMetadata());
			 IBlockState tfsilver = Block.getBlockFromItem(TFBlocks.blockOre.oreSilver.getItem()).getStateFromMeta(TFBlocks.blockOre.oreCopper.getMetadata());
			 IBlockState tflead = Block.getBlockFromItem(TFBlocks.blockOre.oreLead.getItem()).getStateFromMeta(TFBlocks.blockOre.oreCopper.getMetadata());
			 IBlockState tfaluminum = Block.getBlockFromItem(TFBlocks.blockOre.oreAluminum.getItem()).getStateFromMeta(TFBlocks.blockOre.oreCopper.getMetadata());
			 IBlockState tfnickel = Block.getBlockFromItem(TFBlocks.blockOre.oreNickel.getItem()).getStateFromMeta(TFBlocks.blockOre.oreCopper.getMetadata());
			 
			 addOreSpawn(tfcopper, world, random, chunkX, chunkZ, 16, 16, Config.copperVein, Config.copperSpawnTries, Config.copperMin, Config.copperMax, BlockMatcher.forBlock(Blocks.STONE));
			 addOreSpawn(tftin, world, random, chunkX, chunkZ, 16, 16, Config.tinVein, Config.tinSpawnTries, Config.tinMin, Config.tinMax, BlockMatcher.forBlock(Blocks.STONE));
			 addOreSpawn(tfsilver, world, random, chunkX, chunkZ, 16, 16, Config.silverVein, Config.silverSpawnTries, Config.silverMin, Config.silverMax, BlockMatcher.forBlock(Blocks.STONE));
			 addOreSpawn(tflead, world, random, chunkX, chunkZ, 16, 16, Config.leadVein, Config.leadSpawnTries, Config.leadMin, Config.leadMax, BlockMatcher.forBlock(Blocks.STONE));
			 addOreSpawn(tfaluminum, world, random, chunkX, chunkZ, 16, 16, Config.aluminumVein, Config.aluminumSpawnTries, Config.aluminumMin, Config.aluminumMax, BlockMatcher.forBlock(Blocks.STONE));
			 addOreSpawn(tfnickel, world, random, chunkX, chunkZ, 16, 16, Config.nickelVein, Config.nickelSpawnTries, Config.nickelMin, Config.nickelMax, BlockMatcher.forBlock(Blocks.STONE));	 
		 }
		 if(Loader.isModLoaded("mekanism")) {
			 addOreSpawn(MekanismBlocks.OreBlock.getStateFromMeta(0), world, random, chunkX, chunkZ, 16, 16, Config.osmiumVein, Config.osmiumSpawnTries, Config.osmiumMin, Config.osmiumMax, BlockMatcher.forBlock(Blocks.STONE));
			 addOreSpawn(MekanismBlocks.OreBlock.getStateFromMeta(1), world, random, chunkX, chunkZ, 16, 16, Config.copperVein, Config.copperSpawnTries, Config.copperMin, Config.copperMax, BlockMatcher.forBlock(Blocks.STONE));
			 addOreSpawn(MekanismBlocks.OreBlock.getStateFromMeta(2), world, random, chunkX, chunkZ, 16, 16, Config.tinVein, Config.tinSpawnTries, Config.tinMin, Config.tinMax, BlockMatcher.forBlock(Blocks.STONE));  
		 }
		 if(Loader.isModLoaded("bigreactors")) {
			 addOreSpawn(BrBlocks.brOre.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.uraniumVein, Config.uraniumSpawnTries, Config.uraniumMin, Config.urainumMax, BlockMatcher.forBlock(Blocks.STONE));
			}
		 if(Loader.isModLoaded("ic2")) {
			 addOreSpawn(Block.getBlockById(ResourceBlock.tin_ore.getId()).getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.tinVein, Config.tinSpawnTries, Config.tinMin, Config.tinMax, BlockMatcher.forBlock(Blocks.STONE));
			 addOreSpawn(Block.getBlockById(ResourceBlock.copper_ore.getId()).getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.copperVein, Config.copperSpawnTries, Config.copperMin, Config.copperMax, BlockMatcher.forBlock(Blocks.STONE));
			 addOreSpawn(Block.getBlockById(ResourceBlock.lead_ore.getId()).getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.leadVein, Config.leadSpawnTries, Config.leadMin, Config.leadMax, BlockMatcher.forBlock(Blocks.STONE));
			 addOreSpawn(Block.getBlockById(ResourceBlock.uranium_ore.getId()).getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.uraniumVein, Config.uraniumSpawnTries, Config.uraniumMin, Config.urainumMax, BlockMatcher.forBlock(Blocks.STONE));
						
		 }
		 
	 }
	 private void genNether(World world, Random random, int chunkX, int chunkZ){
		 //addOreSpawn(Blocks.QUARTZ_ORE.getDefaultState(), world, random, chunkX, chunkZ, 16, 16, Config.quartzVein, Config.quartzSpawnTries, 180, 1, BlockMatcher.forBlock(Blocks.NETHERRACK));
	 }
	 
}