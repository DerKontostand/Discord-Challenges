package de.deinkontostand.inventorys;

import de.deinkontostand.discordchallenges.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class openInventory implements CommandExecutor {

    public static Inventory inv = Bukkit.createInventory(null, 36, "§9DiscordChallenges");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {
                setItems(p);

                p.openInventory(inv);

            } else if (args.length == 2) {
                if(args[0].equalsIgnoreCase("sethp")){
                    try{
                        p.setHealth(Integer.parseInt(args[1]));


                    }catch (Exception ex){
                        p.sendMessage("§cDas ist keine Zahl");
                    }

                }

            } else {

                Main.help(p);

            }
        }


        return false;
    }

    ArrayList booleans = new ArrayList();
    ArrayList itemstacks = new ArrayList();

    public static void setItems(HumanEntity p) {

/////////////////////////////////////////////////////////////////////////////////////////
        ItemStack slot = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta slotMeta = slot.getItemMeta();
        slotMeta.setDisplayName("§8 ");
        slot.setItemMeta(slotMeta);
/////////////////////////////////////////////////////////////////////////////////////////
        ItemStack mobswitch = new ItemStack(Material.DROWNED_SPAWN_EGG);
        ItemMeta mobswitchMeta = mobswitch.getItemMeta();
        if(Main.mobdamageswitch) {
            mobswitchMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            mobswitchMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else{
            mobswitch.removeEnchantment(Enchantment.DURABILITY);

        }
        mobswitchMeta.setDisplayName("§9MobDamageSwitch");
        mobswitch.setItemMeta(mobswitchMeta);
/////////////////////////////////////////////////////////////////////////////////////////
        ItemStack itemswitch = new ItemStack(Material.LEVER);
        ItemMeta itemswitchMeta = itemswitch.getItemMeta();
        if(Main.itemdamageswitch) {
            itemswitchMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            itemswitchMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else{
            itemswitch.removeEnchantment(Enchantment.DURABILITY);

        }
        itemswitchMeta.setDisplayName("§9ItemDamageSwitch");
        itemswitch.setItemMeta(itemswitchMeta);
/////////////////////////////////////////////////////////////////////////////////////////
        ItemStack mobweakness = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta mobweaknessMeta = mobweakness.getItemMeta();
        if(Main.weaknessmobkill) {
            mobweaknessMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            mobweaknessMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else{
            mobweakness.removeEnchantment(Enchantment.DURABILITY);
            mobweaknessMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        }
        mobweaknessMeta.setDisplayName("§9WeaknessMobKill");
        mobweakness.setItemMeta(mobweaknessMeta);
/////////////////////////////////////////////////////////////////////////////////////////
        ItemStack invcleary = new ItemStack(Material.BARRIER);
        ItemMeta invclearyMeta = invcleary.getItemMeta();
        if(Main.invcleary) {
            invclearyMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            invclearyMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else{
            invcleary.removeEnchantment(Enchantment.DURABILITY);
            invclearyMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        invclearyMeta.setDisplayName("§cComing Soon");
        invcleary.setItemMeta(invclearyMeta);
/////////////////////////////////////////////////////////////////////////////////////////
        ItemStack levelhealth = new ItemStack(Material.EMERALD);
        ItemMeta levelhealthMeta = levelhealth.getItemMeta();
        if(Main.levelequalshealth) {
            levelhealthMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            levelhealthMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else{
            levelhealth.removeEnchantment(Enchantment.DURABILITY);
            levelhealthMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        levelhealthMeta.setDisplayName("§9LevelEqualsHealth");
        levelhealth.setItemMeta(levelhealthMeta);
/////////////////////////////////////////////////////////////////////////////////////////
        ItemStack withoutinv = new ItemStack(Material.IRON_BARS);
        ItemMeta withoutinvMeta = withoutinv.getItemMeta();
        if(Main.withoutinv) {
            withoutinvMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            withoutinvMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else{
            withoutinv.removeEnchantment(Enchantment.DURABILITY);
            withoutinvMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        withoutinvMeta.setDisplayName("§9WithoutInv §5§kII§6In Bearbeitung§5§kII");
        withoutinv.setItemMeta(withoutinvMeta);
/////////////////////////////////////////////////////////////////////////////////////////
        ItemStack noinvdrop = new ItemStack(Material.DROPPER);
        ItemMeta noinvdropMeta = noinvdrop.getItemMeta();
        if(Main.noinvdrop) {
            noinvdropMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            noinvdropMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else{
            noinvdrop.removeEnchantment(Enchantment.DURABILITY);
            noinvdropMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        noinvdropMeta.setDisplayName("§9NoInvDrop");
        noinvdrop.setItemMeta(noinvdropMeta);
/////////////////////////////////////////////////////////////////////////////////////////
        ItemStack effectperchunk = new ItemStack(Material.GLASS_BOTTLE);
        ItemMeta effectperchunkMeta = effectperchunk.getItemMeta();
        if(Main.effectperchunk) {
            effectperchunkMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            effectperchunkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else{
            effectperchunk.removeEnchantment(Enchantment.DURABILITY);
            effectperchunkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        effectperchunkMeta.setDisplayName("§9EffectPerChunk");
        effectperchunk.setItemMeta(effectperchunkMeta);
/////////////////////////////////////////////////////////////////////////////////////////
        ItemStack higherperjump = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta higherperjumpMeta = higherperjump.getItemMeta();
        if(Main.higherperjump) {
            higherperjumpMeta.addEnchant(Enchantment.DURABILITY, 1, false);
            higherperjumpMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }else{
            higherperjump.removeEnchantment(Enchantment.DURABILITY);
            higherperjumpMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        higherperjumpMeta.setDisplayName("§9HigherPerChunk");
        higherperjump.setItemMeta(higherperjumpMeta);
/////////////////////////////////////////////////////////////////////////////////////////


        for(int i = 0; i < inv.getSize(); i++){
            inv.setItem(i, slot);

        }

        inv.setItem(10, mobswitch);
        inv.setItem(11, itemswitch);
        inv.setItem(12, mobweakness);
        inv.setItem(13, levelhealth);
        inv.setItem(14, withoutinv);
        inv.setItem(15, noinvdrop);
        inv.setItem(16, effectperchunk);
        inv.setItem(19, higherperjump);

        if(p instanceof HumanEntity) {
            Player player = (Player) p;
            player.updateInventory();
        }
    }

}
