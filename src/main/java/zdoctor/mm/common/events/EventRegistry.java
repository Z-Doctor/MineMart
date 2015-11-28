package zdoctor.mm.common.events;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;

public class EventRegistry {
  public static class forge {
    
  }
  
  public static class fml {
    
  }
  
  public static void init() {
    MinecraftForge.EVENT_BUS.register(new forge());
    // MinecraftForge.TERRAIN_GEN_BUS.register(target);
    // MinecraftForge.ORE_GEN_BUS.register(target);
    FMLCommonHandler.instance().bus().register(new fml());
  }
}
