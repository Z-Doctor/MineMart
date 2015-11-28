package zdoctor.mm.world.structures;

import java.util.HashMap;
import java.util.Random;

import zdoctor.mm.world.gen.GenHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class StructureBlockShop extends Structure {
//  protected static int distanceBetweenSpawns = 2000; 
  protected float spawnChance = .75f;
  protected static Object[] mList = new Object[] {'s', Blocks.stone, 'i', Blocks.gold_block, 'g', Blocks.glowstone};
  protected static Blueprint[] bpPlans = new Blueprint[] {new Blueprint("iii iii iii"), new Blueprint("sss sxs sxs"), new Blueprint("sss sxs sxs"), new Blueprint("sss sxs sss"),
      new Blueprint("sss sgs sss"), new Blueprint("sss sss sss")};
  
  public StructureBlockShop() {
    super(mList, 3, 3, 10);
    this.biomeList.add(BiomeGenBase.plains);
  }
  
  @Override
  public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
    if (this.biomeList.indexOf(world.getBiomeGenForCoords(chunkX, chunkX)) != -1 && random.nextFloat() < spawnChance) {
//      System.out.println("Testing");
      for (int attempt = 0; attempt < 3; attempt++) {
        int posX = GenHelper.randPos(chunkX, random);
        int posZ = GenHelper.randPos(chunkZ, random);
        int posY = GenHelper.topMost(world, posX, posZ, Blocks.grass);
        if (posY != -1) {
//          System.out.println("Generating.");
          GenHelper.prepareLand(world, posX-1, posY, posZ, this.width, this.length, this.height, Blocks.diamond_block);
//          Structure.build(this, world, posX, posY, posZ, bpPlans);
          return;
        } else
          System.out.println("Trying Again");
      }
    }
  }
  
}
