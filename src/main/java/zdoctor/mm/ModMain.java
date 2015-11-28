package zdoctor.mm;

import zdoctor.mm.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModMain.MODID, name = ModMain.NAME, version = ModMain.VERSION)
public class ModMain {
  public final static String MODID = "ZDoctorMM";
  public final static String NAME = "Mine Mart";
  public final static String VERSION = "0.0.1";
  
  @SidedProxy(clientSide = "zdoctor.mm.client.ClientProxy", serverSide = "zdoctor.mm.common.CommonProxy")
  public static CommonProxy proxy;
  
  @EventHandler
  public void preInit(FMLPreInitializationEvent e) {
    proxy.preInit(e);
  }
  
  @EventHandler
  public void init(FMLInitializationEvent e) {
    proxy.init(e);
  }
  
  @EventHandler
  public void postInit(FMLPostInitializationEvent e) {
    proxy.postInit(e);
  }
  
}
