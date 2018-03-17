package de.undertrox.boptools.item;

import de.undertrox.boptools.item.equipment.EquipmentGroup;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;


/**
 * Created by silas on 18.02.2018.
 */
public class ModItems {
    public static EquipmentGroup toolsTopaz = new EquipmentGroup(
            "topaz",
            "gemTopaz",
            2,
            400,
            8.0f,
            2.3f,
            17
    );
    public static EquipmentGroup toolsMalachite = new EquipmentGroup(
            "malachite",
            "gemMalachite",
            2,
            600,
            7.0f,
            2.5f,
            12
    );
    public static EquipmentGroup toolsPeridot = new EquipmentGroup(
            "peridot",
            "gemPeridot",
            2,
            500,
            6.0f,
            2.0f,
            13
    );
    public static EquipmentGroup toolsTanzanite = new EquipmentGroup(
            "tanzanite",
            "gemTanzanite",
            2,
            600,
            6.5f,
            2.3f,
            15
    );
    public static EquipmentGroup toolsRuby = new EquipmentGroup(
            "ruby",
            "gemRuby",
            3,
            900,
            7.5f,
            2.8f,
            10
    );
    public static EquipmentGroup toolsSapphire = new EquipmentGroup(
            "sapphire",
            "gemSapphire",
            3,
            1300,
            7.5f,
            3.0f,
            10
    );

    public static void register(IForgeRegistry<Item> registry) {
        toolsTopaz.register(registry);
        toolsRuby.register(registry);
        toolsSapphire.register(registry);
        toolsPeridot.register(registry);
        toolsTanzanite.register(registry);
        toolsMalachite.register(registry);
    }

    public static void registerModels() {
        toolsTopaz.registerItemModels();
        toolsRuby.registerItemModels();
        toolsSapphire.registerItemModels();
        toolsPeridot.registerItemModels();
        toolsTanzanite.registerItemModels();
        toolsMalachite.registerItemModels();
    }
}
