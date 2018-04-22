package de.undertrox.boptools.intermod;

import de.undertrox.boptools.item.ModItems;
import de.undertrox.boptools.item.equipment.EquipmentGroup;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.tools.TinkerTraits;

/**
 * Created by silas on 22.04.2018.
 */
public class TinkersCompat {

    public Material topaz;
    public Material malachite;
    public Material peridot;
    public Material tanzanite;
    public Material ruby;
    public Material sapphire;
    public Material amber;

    public TinkersCompat() {
        topaz = addMaterial("topaz", 0xed871a, ModItems.toolsTopaz.toolMaterial, TinkerTraits.jagged);
        malachite = addMaterial("malachite", 0x268932, ModItems.toolsMalachite.toolMaterial, TinkerTraits.depthdigger);
        peridot = addMaterial("peridot", 0x6cc92e, ModItems.toolsPeridot.toolMaterial, TinkerTraits.insatiable);
        tanzanite = addMaterial("tanzanite", 0x6c36aa, ModItems.toolsTanzanite.toolMaterial, TinkerTraits.unnatural);
        ruby = addMaterial("ruby", 0xa93541, ModItems.toolsRuby.toolMaterial, TinkerTraits.momentum);
        sapphire = addMaterial("sapphire", 0x281bd6, ModItems.toolsSapphire.toolMaterial, TinkerTraits.aquadynamic);
        amber = addMaterial("amber", 0xe5910b, ModItems.toolsAmber.toolMaterial, TinkerTraits.ecological);
    }

    public void register() {
        TinkerRegistry.integrate(topaz);
        TinkerRegistry.integrate(malachite);
        TinkerRegistry.integrate(peridot);
        TinkerRegistry.integrate(tanzanite);
        TinkerRegistry.integrate(ruby);
        TinkerRegistry.integrate(sapphire);
        TinkerRegistry.integrate(amber);
    }

    public Material addMaterial(String name, int color, Item.ToolMaterial material, ITrait trait) {
        Material mat = new Material(name, color);
        mat.setCraftable(true);
        mat.setCastable(false);
        mat.addCommonItems(name);
        mat.addItemIngot("gem" + name.substring(0,1).toUpperCase() + name.substring(1));
        mat.addItem("block" + name.substring(0,1).toUpperCase() + name.substring(1), 1, Material.VALUE_Block);
        mat.addTrait(trait);
        mat.addStats(new HeadMaterialStats(
                material.getMaxUses()/3*2,
                material.getEfficiency(),
                material.getAttackDamage() + 2,
                material.getHarvestLevel()
        ));
        mat.addStats(new HandleMaterialStats(
                material.getEnchantability()/15f,
                material.getMaxUses()/3
        ));
        mat.addStats(new ExtraMaterialStats(material.getMaxUses()/3));
        mat.addStats(new ArrowShaftMaterialStats(
                material.getEnchantability()/15f,
                material.getMaxUses()/100
        ));
        return mat;
    }
}
