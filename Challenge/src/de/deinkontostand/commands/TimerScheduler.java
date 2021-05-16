package de.deinkontostand.commands;

import de.deinkontostand.main.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerScheduler extends BukkitRunnable {


    @Override
    public void run() {
        try {
            if (Main.runnable.isCancelled()) {
                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§6§oDer Timer ist pausiert."));
                });
            } else {
                cancel();
                Main.Timer = true;
            }
        }catch(Exception e){
            Main.Timer = false;
        }
    }

}
