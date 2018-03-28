package de.undertrox.boptools.item.equipment;

import cofh.core.item.ItemArmorCore;
import cofh.core.item.tool.*;
import de.undertrox.boptools.ModBopTools;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistry;

/**
 * Created by silas on 12.03.2018.
 */
public class EquipmentGroup {

    public Item.ToolMaterial toolMaterial;
    public ItemArmor.ArmorMaterial armorMaterial;

    public String name;
    public String repairIngot;

    private ModBopTools.CONFIG_TOOLS.EquipmentConfig config;

    public ItemAxeCore axe;
    public ItemBowCore bow;
    public ItemHammerCore hammer;
    public ItemPickaxeCore pickaxe;
    public ItemHoeCore hoe;
    public ItemShearsCore shears;
    public ItemShieldCore shield;
    public ItemShovelCore shovel;
    public ItemSickleCore sickle;
    public ItemSwordCore sword;
    public ItemFishingRodCore fishingRod;

    public ItemArmorCore helmet;
    public ItemArmorCore chestplate;
    public ItemArmorCore leggings;
    public ItemArmorCore boots;

    public EquipmentGroup(
            String name,
            String repairIngot,
            int harvestLevel,
            int maxUses,
            float efficiency,
            float damage,
            int enchantability,
            float arrowDamage,
            float arrowSpeed,
            float bowZoomMultiplier,
            int sickleRadius,
            int fishingLuck,
            int fishingSpeed,
            int armorDurability,
            int helmetProtection,
            int chestplateProtection,
            int leggingsProtection,
            int bootsProtection,
            SoundEvent soundOnEquip,
            float armorToughness,
            ModBopTools.CONFIG_TOOLS.EquipmentConfig config
    ){
        toolMaterial = EnumHelper.addToolMaterial(
                name.toUpperCase(),
                harvestLevel,
                maxUses,
                efficiency,
                damage,
                enchantability
        );
        armorMaterial = EnumHelper.addArmorMaterial(
                name,
                ModBopTools.MODID + ":" + name + "/armor",
                armorDurability,
                new int[] {
                        bootsProtection,
                        leggingsProtection,
                        chestplateProtection,
                        helmetProtection
                },
                enchantability,
                soundOnEquip,
                armorToughness
        );
        this.name = name;
        this.repairIngot = repairIngot;

        helmet = new ItemArmorCore(armorMaterial, EntityEquipmentSlot.HEAD);
        chestplate = new ItemArmorCore(armorMaterial, EntityEquipmentSlot.CHEST);
        leggings = new ItemArmorCore(armorMaterial, EntityEquipmentSlot.LEGS);
        boots = new ItemArmorCore(armorMaterial, EntityEquipmentSlot.FEET);

        axe = new ItemAxeCore(toolMaterial);
        bow = new ItemBowCore(toolMaterial)
                .setArrowDamage(arrowDamage)
                .setArrowSpeed(arrowSpeed)
                .setZoomMultiplier(bowZoomMultiplier);
        hammer = new ItemHammerCore(toolMaterial);
        pickaxe = new ItemPickaxeCore(toolMaterial);
        hoe = new ItemHoeCore(toolMaterial);
        shears = new ItemShearsCore(toolMaterial);
        shield = new ItemShieldCore(toolMaterial);
        shovel = new ItemShovelCore(toolMaterial);
        sickle = new ItemSickleCore(toolMaterial)
                .setRadius(sickleRadius);
        sword = new ItemSwordCore(toolMaterial);
        fishingRod = new ItemFishingRodCore(toolMaterial)
                .setLuckModifier(fishingLuck)
                .setSpeedModifier(fishingSpeed);
        this.config = config;

        setNames();
        setRepairIngots();
    }

    public EquipmentGroup(
            String name,
            String repairIngot,
            int harvestLevel,
            int maxUses,
            float efficiency,
            float damage,
            int enchantability,
            ModBopTools.CONFIG_TOOLS.EquipmentConfig config
    ){
            this(
                    name,
                    repairIngot,
                    harvestLevel,
                    maxUses,
                    efficiency,
                    damage,
                    enchantability,
                    damage/4,
                    efficiency/20,
                    efficiency/30,
                    harvestLevel*1,
                    harvestLevel/2,
                    (int) efficiency/3,
                    maxUses/35,
                    harvestLevel,
                    harvestLevel+2,
                    harvestLevel+3,
                    harvestLevel,
                    SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                    harvestLevel,
                    config
            );
    }

    private void setNames() {
        axe.setRegistryName("axe_" + name).setUnlocalizedName("boptools.tool.axe" + name);
        bow.setRegistryName("bow_" + name).setUnlocalizedName("boptools.tool.bow" + name);
        hammer.setRegistryName("hammer_" + name).setUnlocalizedName("boptools.tool.hammer" + name);
        pickaxe.setRegistryName("pickaxe_" + name).setUnlocalizedName("boptools.tool.pickaxe" + name);
        hoe.setRegistryName("hoe_" + name).setUnlocalizedName("boptools.tool.hoe" + name);
        shears.setRegistryName("shears_" + name).setUnlocalizedName("boptools.tool.shears" + name);
        shield.setRegistryName("shield_" + name).setUnlocalizedName("boptools.tool.shield" + name);
        shovel.setRegistryName("shovel_" + name).setUnlocalizedName("boptools.tool.shovel" + name);
        sickle.setRegistryName("sickle_" + name).setUnlocalizedName("boptools.tool.sickle" + name);
        sword.setRegistryName("sword_" + name).setUnlocalizedName("boptools.tool.sword" + name);
        fishingRod.setRegistryName("fishing_rod_" + name).setUnlocalizedName("boptools.tool.fishingrod" + name);

        helmet.setRegistryName("helmet_" + name).setUnlocalizedName("boptools.armor.helmet" + name);
        chestplate.setRegistryName("chestplate_" + name).setUnlocalizedName("boptools.armor.chestplate" + name);
        leggings.setRegistryName("leggings_" + name).setUnlocalizedName("boptools.armor.leggings" + name);
        boots.setRegistryName("boots_" + name).setUnlocalizedName("boptools.armor.boots" + name);
    }

    private void setRepairIngots() {
        axe.setRepairIngot(repairIngot);
        bow.setRepairIngot(repairIngot);
        hammer.setRepairIngot(repairIngot);
        pickaxe.setRepairIngot(repairIngot);
        hoe.setRepairIngot(repairIngot);
        shears.setRepairIngot(repairIngot);
        shield.setRepairIngot(repairIngot);
        shovel.setRepairIngot(repairIngot);
        sickle.setRepairIngot(repairIngot);
        sword.setRepairIngot(repairIngot);
        fishingRod.setRepairIngot(repairIngot);

        helmet.setRepairIngot(repairIngot);
        chestplate.setRepairIngot(repairIngot);
        leggings.setRepairIngot(repairIngot);
        boots.setRepairIngot(repairIngot);
    }

    private void createRecipes() {
        String stick = "stickWood";
        if (config.tools.enableAxe) {
            addShapedOreRecipe(axe, new Object[]{
                    "ii",
                    "is",
                    " s",
                    'i', repairIngot,
                    's', stick
            });
        }
        if (config.tools.enableBow) {
            addShapedOreRecipe(bow, new Object[]{
                    " iS",
                    "s S",
                    " iS",
                    'i', repairIngot,
                    's', stick,
                    'S', "string"
            });
        }
        if (config.tools.enableHammer) {
            addShapedOreRecipe(hammer, new Object[]{
                    "iii",
                    "isi",
                    " s ",
                    'i', repairIngot,
                    's', stick
            });
        }
        if (config.tools.enablePickaxe) {
            addShapedOreRecipe(pickaxe, new Object[]{
                    "iii",
                    " s ",
                    " s ",
                    'i', repairIngot,
                    's', stick
            });
        }
        if (config.tools.enableHoe) {
            addShapedOreRecipe(hoe, new Object[]{
                    "ii",
                    " s",
                    " s",
                    'i', repairIngot,
                    's', stick
            });
        }
        if (config.tools.enableShears) {
            addShapedOreRecipe(shears, new Object[]{
                    " i",
                    "i ",
                    'i', repairIngot,
            });
        }
        if (config.tools.enableShield) {
            addShapedOreRecipe(shield, new Object[]{
                    "iii",
                    "isi",
                    " i ",
                    'i', repairIngot,
                    's', Items.SHIELD
            });
        }
        if (config.tools.enableShovel) {
            addShapedOreRecipe(shovel, new Object[]{
                    "i",
                    "s",
                    "s",
                    'i', repairIngot,
                    's', stick
            });
        }
        if (config.tools.enableSickle) {
            addShapedOreRecipe(sickle, new Object[]{
                    "i ",
                    " i",
                    "si",
                    'i', repairIngot,
                    's', stick
            });
        }
        if (config.tools.enableSword) {
            addShapedOreRecipe(sword, new Object[]{
                    "i",
                    "i",
                    "s",
                    'i', repairIngot,
                    's', stick
            });
        }
        if (config.tools.enableFishingRod) {
            addShapedOreRecipe(fishingRod, new Object[]{
                    "  i",
                    " iS",
                    "s S",
                    'i', repairIngot,
                    's', stick,
                    'S', "string"
            });
        }

        if (config.armor.enableHelmet) {
            addShapedOreRecipe(helmet, new Object[]{
                    "iii",
                    "i i",
                    'i', repairIngot,
            });
        }
        if (config.armor.enableChestplate) {
            addShapedOreRecipe(chestplate, new Object[]{
                    "i i",
                    "iii",
                    "iii",
                    'i', repairIngot,
            });
        }
        if (config.armor.enableLeggings) {
            addShapedOreRecipe(leggings, new Object[]{
                    "iii",
                    "i i",
                    "i i",
                    'i', repairIngot,
            });
        }
        if (config.armor.enableBoots) {
            addShapedOreRecipe(boots, new Object[]{
                    "i i",
                    "i i",
                    'i', repairIngot,
            });
        }
    }

    public ResourceLocation getNameForRecipe(ItemStack output) {
        ModContainer activeContainer = Loader.instance().activeModContainer();
        ResourceLocation baseLoc = new ResourceLocation(activeContainer.getModId(), output.getItem().getRegistryName().getResourcePath());
        ResourceLocation recipeLoc = baseLoc;
        int index = 0;
        while (CraftingManager.REGISTRY.containsKey(recipeLoc)) {
            index++;
            recipeLoc = new ResourceLocation(activeContainer.getModId(), baseLoc.getResourcePath() + "_" + index);
        }
        return recipeLoc;
    }

    public void addShapedOreRecipe(ItemStack output, Object[] params) {
        ResourceLocation location = getNameForRecipe(output);
        ShapedOreRecipe recipe = new ShapedOreRecipe(location, output, params);
        recipe.setRegistryName(location);
        GameData.register_impl(recipe);
    }

    public void addShapedOreRecipe(Item output, Object[] params) {
                addShapedOreRecipe(new ItemStack(output), params);
    }

    public void register(IForgeRegistry<Item> registry){
        registry.registerAll(
                axe,
                bow,
                hammer,
                pickaxe,
                hoe,
                shears,
                shield,
                shovel,
                sickle,
                sword,
                fishingRod,

                helmet,
                chestplate,
                leggings,
                boots
        );
        createRecipes();
    }

    public void registerItemModels() {
        ModBopTools.proxy.registerItemRenderer(axe, 0, "tool/" + name + "/axe");
        ModBopTools.proxy.registerItemRenderer(bow, 0, "tool/" + name + "/bow/bow_initial");
        ModBopTools.proxy.registerItemRenderer(hammer, 0, "tool/" + name + "/hammer");
        ModBopTools.proxy.registerItemRenderer(pickaxe, 0, "tool/" + name + "/pickaxe");
        ModBopTools.proxy.registerItemRenderer(hoe, 0, "tool/" + name + "/hoe");
        ModBopTools.proxy.registerItemRenderer(shears, 0, "tool/" + name + "/shears");
        ModBopTools.proxy.registerItemRenderer(shield, 0, "tool/" + name + "/shield/shield");
        ModBopTools.proxy.registerItemRenderer(shovel, 0, "tool/" + name + "/shovel");
        ModBopTools.proxy.registerItemRenderer(sickle, 0, "tool/" + name + "/sickle");
        ModBopTools.proxy.registerItemRenderer(sword, 0, "tool/" + name + "/sword");
        ModBopTools.proxy.registerItemRenderer(fishingRod, 0, "tool/" + name + "/fishing_rod/fishing_rod");

        ModBopTools.proxy.registerItemRenderer(helmet, 0, "armor/" + name + "/helmet");
        ModBopTools.proxy.registerItemRenderer(chestplate, 0, "armor/" + name + "/chestplate");
        ModBopTools.proxy.registerItemRenderer(leggings, 0, "armor/" + name + "/leggings");
        ModBopTools.proxy.registerItemRenderer(boots, 0, "armor/" + name + "/boots");
    }
}
