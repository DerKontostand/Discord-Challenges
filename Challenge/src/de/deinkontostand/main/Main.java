package de.deinkontostand.main;

import de.deinkontostand.challenges.*;
import de.deinkontostand.commands.*;
import de.deinkontostand.listeners.*;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Main extends JavaPlugin {

    public static Main plugin;
    public static int time = 0;

    public static boolean NoJump = false;
    public static boolean BlockRemove = false;
    public static boolean OpMobs = false;
    public static boolean BlockInventory = false;

    public static boolean Timer = false;
    public static BukkitRunnable runnable;
    public static String prefix = "§8[§5Kutils§8] ";
    public static String error = "§8[§4ERROR§8]: ";


    @Override
    public void onEnable() {


        plugin = this;
        getCommand("settings").setExecutor(new Settings());
        getCommand("timer").setExecutor(new TimerCMD());
        getCommand("heal").setExecutor(new Heal());
        getCommand("reset").setExecutor(new Reset());
        Bukkit.getPluginManager().registerEvents(new SettingsListener(), this);
        Bukkit.getPluginManager().registerEvents(new NoJump(), this);
        Bukkit.getPluginManager().registerEvents(new GamemodeSwitch(), this);
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new OpMobs(), this);
        Bukkit.getPluginManager().registerEvents(new BlockRemove(), this);

        new TimerScheduler().runTaskTimer(getPlugin(), 20L, 20L);

        getConfig().options().copyDefaults(true);
        saveConfig();

        SettingsListener.booleans.put(0, NoJump);
        SettingsListener.booleans.put(1, OpMobs);
        SettingsListener.booleans.put(2, BlockRemove);
        SettingsListener.booleans.put(3, BlockInventory);

    }

    @Override
    public void onDisable() {
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

    public static void stopChallenge(){

        Bukkit.getOnlinePlayers().forEach(players ->{
            players.setGameMode(GameMode.SPECTATOR);
            Main.getPlugin().getRunnable().cancel();
            Timer = false;

            new TimerScheduler().runTaskTimer(Main.getPlugin(), 20L, 20L);
        });

    }



}
