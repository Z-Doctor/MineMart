package zdoctor.mm.world.structures;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class Blueprint {
  protected static char newLayerChar = ' ';
  protected char[] layer;
  
  public Blueprint(String layout) {
    layer = layout.toCharArray();
  }
  
  public void construct(World world, int posX, int posY, int posZ, HashMap<Character, Block> mMap) {
    int orinalX = posX;
    int orinalZ = posZ;
//    System.out.println("XOrig: " + orinalX);
//    System.out.println("posX: " + posX);
    for (int c = 0; c < layer.length; c++) {
      if (this.layer[c] == newLayerChar) {
        posX = orinalX;
        posZ += 1;
      }
      world.setBlock(posX, posY, posZ, (mMap.get(this.layer[c]) == null ? Blocks.air : mMap.get(this.layer[c])));
      posX +=1;
//      System.out.println("XOrig: " + orinalX);
//      System.out.println("posX: " + posX);
//      System.out.println("posZ: " + posZ);
    }
  }
  
}
