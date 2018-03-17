package de.undertrox.boptools;

import de.undertrox.boptools.item.ModItems;
import de.undertrox.boptools.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = ModBopTools.MODID,
        name = ModBopTools.NAME,
        version = ModBopTools.VERSION,
        dependencies = "required-after:cofhcore@[4.3.10,4.4.0);required-after:biomesoplenty@[7.0.1.2314]")
public class ModBopTools
{
    public static final String MODID = "boptools";
    public static final String NAME = "Biomes o Plenty Tools Mod";
    public static final String VERSION = "0.0.1";

    @SidedProxy(serverSide = "de.undertrox.boptools.proxy.CommonProxy", clientSide = "de.undertrox.boptools.proxy.ClientProxy")
    public static CommonProxy proxy;

    private static Logger logger;



    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("BopTools in Init");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
        }
        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModItems.registerModels();
        }
    }
}
