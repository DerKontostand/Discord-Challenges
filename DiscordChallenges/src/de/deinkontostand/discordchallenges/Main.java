package de.deinkontostand.discordchallenges;


import de.deinkontostand.challenges.*;
import de.deinkontostand.inventorys.InventoryListener;
import de.deinkontostand.inventorys.openInventory;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main plugin;

    public static boolean mobdamageswitch = false;
    public static boolean itemdamageswitch = false;
    public static boolean weaknessmobkill = false;
    public static boolean invcleary = false;
    public static boolean levelequalshealth = false;
    public static boolean withoutinv = false;
    public static boolean noinvdrop = false;
    public static boolean effectperchunk = false;
    public static boolean higherperjump = false;

    @Override
    public void onEnable() {

        getCommand("settings").setExecutor(new openInventory());

        Bukkit.getPluginManager().registerEvents(new WeaknessMobKill(), this);
        Bukkit.getPluginManager().registerEvents(new MobDamageSwitch(), this);
        Bukkit.getPluginManager().registerEvents(new ItemDamageSwitch(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
        Bukkit.getPluginManager().registerEvents(new LevelEqualsHealth(), this);
        Bukkit.getPluginManager().registerEvents(new WithoutInv(), this);
        Bukkit.getPluginManager().registerEvents(new NoInvDrop(), this);




    }

    public static void help(Player p){

        TextComponent component = new TextComponent("§9[HELP]");

        component.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help discordchallenges"));

        String message = "§cFür hilfe drücke auf " + ChatMessageType.valueOf(String.valueOf(component));

        p.sendMessage(message);
    }


    public static Main getPlugin() {
        return plugin;
    }
}
