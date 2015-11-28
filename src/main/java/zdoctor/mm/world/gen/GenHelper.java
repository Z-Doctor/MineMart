package zdoctor.mm.world.gen;

import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class GenHelper {
  public static int randPos(int chunk, Random rand) {
    return chunk * 16 + rand.nextInt(16);
    
  }
  
  public static int topMost(World world, int x, int z, Block find) {
    for (int y = 1; y < 256; y++) {
      Block temp = world.getBlock(x, y, z);
      if (Block.isEqualTo(temp, find) && canSeeSky(world, x, y, z)) {
        return y;
      }
    }
    return -1;
  }
  
  public static boolean canSeeSky(World world, int posX, int posY, int posZ) {
    for (int y = posY + 1; y < 255; y++) {
      if (!world.isAirBlock(posX, y, posZ))
        return false;
    }
    return true;
  }
  
  public static void prepareLand(World world, int posX, int posY, int posZ, int width, int length, int height, Block base, Block... ignore) {
    if (ignore == null)
      ignore = new Block[] {};
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        for (int z = 0; z < length; z++) {
          if (Arrays.asList(ignore).indexOf(world.getBlock(x, y, z)) == -1) {
            if (y == 0 && world.isAirBlock(x, y, z)) {
              world.setBlock(posX + x, posY, posZ + z, base);
            } else
              world.setBlockToAir(posX + x, posY + y, posZ + z);
          }
        }
      }
    }
  }
}
