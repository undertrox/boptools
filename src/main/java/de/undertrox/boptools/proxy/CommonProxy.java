package de.undertrox.boptools.proxy;

import de.undertrox.boptools.ModBopTools;
import de.undertrox.boptools.intermod.TinkersCompat;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;

/**
 * Created by silas on 18.02.2018.
 */
public class CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id) {
    }

    public void preInit() {
        if (Loader.isModLoaded("tconstruct")) {
            ModBopTools.logger.info("Tinkers Construct is installed, loading Tinkers Construct integration");
            try {
                TinkersCompat tinkersCompat = new TinkersCompat();
                tinkersCompat.register();
                ModBopTools.logger.info("Finished loading of Tinkers Construct integration successfully");
            } catch (Exception e) {
                ModBopTools.logger.warn("Loading of Tinkers Construct integration failed:");
                e.printStackTrace();
            }
        } else {
            ModBopTools.logger.info("Tinkers Construct is not installed, not loading Tinkers Construct integration");
        }
    }
}
