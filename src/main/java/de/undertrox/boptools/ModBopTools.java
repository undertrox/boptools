package de.undertrox.boptools;

import de.undertrox.boptools.item.ModItems;
import de.undertrox.boptools.proxy.CommonProxy;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
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
        dependencies = "required-after:cofhcore;after:biomesoplenty;before:tconstruct",
        acceptedMinecraftVersions = "[1.12,1.12.2]"
)
public class ModBopTools
{
    public static final String MODID = "boptools";
    public static final String NAME = "Biomes o Plenty Tools Mod";
    public static final String VERSION = "0.0.3";

    @SidedProxy(serverSide = "de.undertrox.boptools.proxy.CommonProxy", clientSide = "de.undertrox.boptools.proxy.ClientProxy")
    public static CommonProxy proxy;

    public static Logger logger;



    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            logger.debug("Registering Items");
            ModItems.register(event.getRegistry());
            logger.debug("Finished Registering Items");
        }
        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            logger.debug("Registering Item Models");
            ModItems.registerModels();
            logger.debug("Finished Registering Item Models");
        }
    }

    @Mod.EventBusSubscriber(modid=MODID)
    private static class ConfigHandler {
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(MODID)) {
                ConfigManager.sync(MODID, Config.Type.INSTANCE);
            }
        }
    }

    public static class CONFIG_TOOLS {


        public static EquipmentConfig amber = new EquipmentConfig();
        public static EquipmentConfig malachite = new EquipmentConfig();
        public static EquipmentConfig peridot = new EquipmentConfig();
        public static EquipmentConfig ruby = new EquipmentConfig();
        public static EquipmentConfig sapphire = new EquipmentConfig();
        public static EquipmentConfig tanzanite = new EquipmentConfig();
        public static EquipmentConfig topaz = new EquipmentConfig();

        public static class EquipmentConfig {

            @Config.RequiresMcRestart
            public ToolsSettings tools = new ToolsSettings();
            @Config.RequiresMcRestart
            public ArmorSettings armor = new ArmorSettings();

            public static class ToolsSettings {
                @Config.Name("Enable Axe")
                public boolean enableAxe = true;

                @Config.Name("Enable Bow")
                public boolean enableBow = true;

                @Config.Name("Enable FishingRod")
                public boolean enableFishingRod = true;

                @Config.Name("Enable Hammer")
                public boolean enableHammer = true;

                @Config.Name("Enable Hoe")
                public boolean enableHoe = true;

                @Config.Name("Enable Pickaxe")
                public boolean enablePickaxe = true;

                @Config.Name("Enable Shears")
                public boolean enableShears = true;

                @Config.Name("Enable Shield")
                public boolean enableShield = true;

                @Config.Name("Enable Shovel")
                public boolean enableShovel = true;

                @Config.Name("Enable Sickle")
                public boolean enableSickle = true;

                @Config.Name("Enable Sword")
                public boolean enableSword = true;
            }
            public static class ArmorSettings {
                @Config.Name("Enable Helmet")
                public boolean enableHelmet = true;

                @Config.Name("Enable Chestplate")
                public boolean enableChestplate = true;

                @Config.Name("Enable Leggings")
                public boolean enableLeggings = true;

                @Config.Name("Enable Boots")
                public boolean enableBoots = true;
            }
        }
    }
}
