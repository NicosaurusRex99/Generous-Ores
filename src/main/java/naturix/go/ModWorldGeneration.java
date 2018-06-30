package naturix.go;

import java.util.Optional;
import java.util.Random;

import com.google.common.base.Predicate;

import appeng.api.definitions.IBlocks;
import cofh.thermalfoundation.block.BlockOre;
import cofh.thermalfoundation.init.TFBlocks;
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
                //genNether(world, random, chunkX, chunkZ);
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
				GO.logger.info(block.getBlock().getLocalizedName());
				gen.generate(world, random, new BlockPos(b, y, z));
			}
		
		  }
		  }
	 @SuppressWarnings("null")
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
		 if(Loader.isModLoaded("ic2")) {
			 IBlockState ic2Tin = Block.getBlockFromItem(BlockOre.oreTin.getItem()).getStateFromMeta(BlockOre.oreTin.getMetadata());
			 IBlockState ic2Copper = Block.getBlockFromItem(BlockOre.oreCopper.getItem()).getStateFromMeta(BlockOre.oreCopper.getMetadata());
			 IBlockState ic2Aluminum = Block.getBlockFromItem(BlockOre.oreAluminum.getItem()).getStateFromMeta(BlockOre.oreAluminum.getMetadata());
			 IBlockState ic2Iridium = Block.getBlockFromItem(BlockOre.oreIridium.getItem()).getStateFromMeta(BlockOre.oreIridium.getMetadata());
			 IBlockState ic2Lead = Block.getBlockFromItem(BlockOre.oreLead.getItem()).getStateFromMeta(BlockOre.oreLead.getMetadata());
			 IBlockState ic2Mithril = Block.getBlockFromItem(BlockOre.oreMithril.getItem()).getStateFromMeta(BlockOre.oreMithril.getMetadata());
			 IBlockState ic2Nickel = Block.getBlockFromItem(BlockOre.oreNickel.getItem()).getStateFromMeta(BlockOre.oreNickel.getMetadata());
			 IBlockState ic2Platinum = Block.getBlockFromItem(BlockOre.orePlatinum.getItem()).getStateFromMeta(BlockOre.orePlatinum.getMetadata());
			 IBlockState ic2Silver = Block.getBlockFromItem(BlockOre.oreSilver.getItem()).getStateFromMeta(BlockOre.oreSilver.getMetadata());
			 
			 addOreSpawn(ic2Tin, world, random, chunkX, chunkZ, 16, 16, Config.tinVein, Config.tinSpawnTries, Config.tinMin, Config.tinMax, BlockMatcher.forBlock(Blocks.STONE)); 
			 addOreSpawn(ic2Copper, world, random, chunkX, chunkZ, 16, 16, Config.copperVein, Config.copperSpawnTries, Config.copperMin, Config.copperMax, BlockMatcher.forBlock(Blocks.STONE)); 
			 addOreSpawn(ic2Aluminum, world, random, chunkX, chunkZ, 16, 16, Config.aluminumVein, Config.aluminumSpawnTries, Config.aluminumMin, Config.aluminumMax, BlockMatcher.forBlock(Blocks.STONE)); 
			 addOreSpawn(ic2Iridium, world, random, chunkX, chunkZ, 16, 16, Config.iridiumVein, Config.iridiumSpawnTries, Config.iridiumMin, Config.iridiumMax, BlockMatcher.forBlock(Blocks.STONE)); 
			 addOreSpawn(ic2Lead, world, random, chunkX, chunkZ, 16, 16, Config.leadVein, Config.leadSpawnTries, Config.leadMin, Config.leadMax, BlockMatcher.forBlock(Blocks.STONE)); 
			 addOreSpawn(ic2Mithril, world, random, chunkX, chunkZ, 16, 16, Config.mithrilVein, Config.mithrilSpawnTries, Config.mithrilMin, Config.mithrilMax, BlockMatcher.forBlock(Blocks.STONE)); 
			 addOreSpawn(ic2Nickel, world, random, chunkX, chunkZ, 16, 16, Config.nickelVein, Config.nickelSpawnTries, Config.nickelMin, Config.nickelMax, BlockMatcher.forBlock(Blocks.STONE)); 
			 addOreSpawn(ic2Platinum, world, random, chunkX, chunkZ, 16, 16, Config.platinumVein, Config.platinumSpawnTries, Config.platinumMin, Config.platinumMax, BlockMatcher.forBlock(Blocks.STONE)); 
			 addOreSpawn(ic2Silver, world, random, chunkX, chunkZ, 16, 16, Config.silverVein, Config.silverSpawnTries, Config.silverMin, Config.silverMax, BlockMatcher.forBlock(Blocks.STONE)); 
			 }
		
	 }
	 	 
}