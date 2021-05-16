package de.deinkontostand.commands;

import de.deinkontostand.listeners.SettingsListener;
import de.deinkontostand.main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Timer;

public class TimerCMD implements CommandExecutor {

    public static String prefix = "§8[§6Timer§8] ";


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player)sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("resume")) {


                    try{
                        if(!Main.Timer) {
                            Bukkit.getOnlinePlayers().forEach(player -> {
                                player.sendMessage(Main.prefix + "§cDer Timer wurde fortgesetzt.");

                            });
                            Main.Timer = true;
                            Main.TimerModule();
                            if (!Main.runnable.isCancelled()) {
                                new TimerScheduler().cancel();
                            }
                        }
                    }catch (Exception e){

                    }


                } else if (args[0].equalsIgnoreCase("pause")) {
                    try{
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.sendMessage(prefix + "§cDer Timer wurde pausiert.");

                        });

                        Main.Timer = false;
                        Main.getPlugin().getRunnable().cancel();
                        new TimerScheduler().runTaskTimer(Main.getPlugin(), 20L, 20L);
                    }catch (Exception e){

                    }
                } else if(args[0].equalsIgnoreCase("reset")){

                    Bukkit.getOnlinePlayers().forEach(player -> {
                        player.sendMessage(prefix + "§cDer Timer wurde resetet");

                    });

                    Main.runnable.cancel();
                    new TimerScheduler().runTaskTimer(Main.getPlugin(), 20L, 20L);
                    Main.time = 0;
                }else{

                }
            }
        }

        return false;
    }



}
