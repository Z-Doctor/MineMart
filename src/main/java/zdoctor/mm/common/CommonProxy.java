package zdoctor.mm.common;

import zdoctor.mm.common.events.EventRegistry;
import zdoctor.mm.world.gen.ZGen;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
  
  public void preInit(FMLPreInitializationEvent e) {
    CTabs.preInit();
    ZItems.preInit();
    
  }
  
  public void init(FMLInitializationEvent e) {
    ZItems.init();
    ZGen.init();
    EventRegistry.init();
    
  }
  
  public void postInit(FMLPostInitializationEvent e) {
    
  }
  
}
