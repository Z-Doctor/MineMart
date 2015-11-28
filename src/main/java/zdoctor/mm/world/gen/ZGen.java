package zdoctor.mm.world.gen;

import zdoctor.mm.world.structures.StructureBlockShop;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZGen {
  public static void init() {
    GameRegistry.registerWorldGenerator(new StructureBlockShop(), 20);
  }
}
