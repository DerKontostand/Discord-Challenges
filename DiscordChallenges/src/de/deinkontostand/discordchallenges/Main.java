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
    
    public static Main plugin;
    public static int time = 0;

    public static boolean mobdamageswitch = false;
    public static boolean itemdamageswitch = false;
    public static boolean weaknessmobkill = false;
    public static boolean invcleary = false;
    public static boolean levelequalshealth = false;
    public static boolean withoutinv = false;
    public static boolean noinvdrop = false;
    public static boolean effectperchunk = false;
    public static boolean higherperjump = false;

    public static boolean Timer = false;
    public static BukkitRunnable runnable;
    public static String prefix = "§8[§5Kutils§8] ";
    public static String error = "§8[§4ERROR§8]: ";
    
    
    @Override
    public void onEnable() {

        getCommand("settings").setExecutor(new openInventory());
        getCommand("timer").setExecutor(new TimerCMD());

        Bukkit.getPluginManager().registerEvents(new WeaknessMobKill(), this);
        Bukkit.getPluginManager().registerEvents(new MobDamageSwitch(), this);
        Bukkit.getPluginManager().registerEvents(new ItemDamageSwitch(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
        Bukkit.getPluginManager().registerEvents(new LevelEqualsHealth(), this);
        Bukkit.getPluginManager().registerEvents(new WithoutInv(), this);
        Bukkit.getPluginManager().registerEvents(new NoInvDrop(), this);
        
        
        Bukkit.getPluginManager().registerEvents(new Utils(), this);

                new TimerScheduler().runTaskTimer(getPlugin(), 20L, 20L);

        getConfig().options().copyDefaults(true);
        saveConfig();



    }
    
    public static Main getPlugin() {
        return plugin;
    }



    public BukkitRunnable getRunnable() {
        return runnable;
    }

    public static void TimerModule(){
        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6§l" + shortInteger(Main.time)));
                });


                Main.time++;
            }
        };
        runnable.runTaskTimer(Main.getPlugin(), 0, 20);

    }

    public static String shortInteger(int duration) {
        String string = "";
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        if (duration / 60 / 60 / 24 >= 1) {
            duration -= duration / 60 / 60 / 24 * 60 * 60 * 24;
        }
        if (duration / 60 / 60 >= 1) {
            hours = duration / 60 / 60;
            duration -= duration / 60 / 60 * 60 * 60;
        }
        if (duration / 60 >= 1) {
            minutes = duration / 60;
            duration -= duration / 60 * 60;
        }
        if (duration >= 1)
            seconds = duration;
        if (hours <= 9) {
            string = String.valueOf(string) + "0" + hours + "§7§l:§6§l";
        } else {
            string = String.valueOf(string) + hours + "§7§l:§6§l";
        }
        if (minutes <= 9) {
            string = String.valueOf(string) + "0" + minutes + "§7§l:§6§l";
        } else {
            string = String.valueOf(string) + minutes + "§7§l:§6§l";
        }
        if (seconds <= 9) {
            string = String.valueOf(string) + "0" + seconds;
        } else {
            string = String.valueOf(string) + seconds;
        }
        return string;
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
    public static void stopchallenge(){
            Bukkit.getOnlinePlayers().forEach(players ->{
            players.setGameMode(GameMode.SPECTATOR);
            Main.getPlugin().getRunnable().cancel();
            Timer = false;

            new TimerScheduler().runTaskTimer(Main.getPlugin(), 20L, 20L);
        });

    }



}
