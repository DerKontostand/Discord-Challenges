package de.deinkontostand.listeners;

import de.deinkontostand.main.Main;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if(e.getPlayer().getGameMode() == GameMode.CREATIVE) {
            e.setFormat("§e" + e.getPlayer().getDisplayName() + "§8: §7" + e.getMessage());
        }else if(e.getPlayer().getGameMode() == GameMode.SPECTATOR){
            e.setFormat("§e" + e.getPlayer().getDisplayName() + "§8§o: §7§o" + e.getMessage());
        }
    }

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


