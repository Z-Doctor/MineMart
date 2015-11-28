package zdoctor.mm.world.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import zdoctor.mm.exceptions.InvalidArraySize;
import cpw.mods.fml.common.IWorldGenerator;

public class Structure implements IWorldGenerator {
  protected ArrayList<BiomeGenBase> biomeList = new ArrayList<BiomeGenBase>();
  protected HashMap<Character, Block> mMap = new HashMap<Character, Block>();
  
  protected int width;
  protected int length;
  protected int height;
  
  public Structure(Object[] mList, int w, int l, int h) {
    try {
      if (Arrays.asList(mList).size() % 2 != 0)
        throw new InvalidArraySize("Array must contain even amount of Characters and Blocks");
      
      for (int i = 0; i < Arrays.asList(mList).size(); i += 2) {
        if (mList[i] instanceof Character && mList[i + 1] instanceof Block) {
          this.mMap.put((Character) mList[i], (Block) mList[i + 1]);
        } else
          throw new Exception("Check your format. [Character], [Block]");
      }
      
      this.length = l;
      this.width = w;
      this.height = h;
      
    } catch (NullPointerException e) {
      e.printStackTrace();
    } catch (InvalidArraySize e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void build(Structure struct, World world, int posX, int posY, int posZ, Blueprint[] bpPlans) {
    for (int i = 0; i < bpPlans.length; i++) {
      bpPlans[i].construct(world, posX, posY + i, posZ, struct.mMap);
    }
  }
  
  @Override
  public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
    
  }
}
