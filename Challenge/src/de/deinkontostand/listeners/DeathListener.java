package de.deinkontostand.listeners;

import de.deinkontostand.commands.TimerCMD;
import de.deinkontostand.commands.TimerScheduler;
import de.deinkontostand.main.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class DeathListener implements Listener {

    static Plugin plugin;
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    final Scoreboard board = manager.getNewScoreboard();
    final Objective objective = board.registerNewObjective("Belowname", "dummy");

    @EventHandler
    public void onDeath(PlayerDeathEvent e){

        fakeDeath(e.getEntity());


    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        e.setRespawnLocation(e.getPlayer().getLocation());


    }

    public static void fakeDeath(Player p){
        p.setGameMode(GameMode.SPECTATOR);

        if(p.getLocation().getBlockY() < 0){
            p.teleport(new Location(p.getWorld(), p.getLocation().getBlockX(), 0, p.getLocation().getBlockZ()));

        }

        try{
            Bukkit.getOnlinePlayers().forEach(player -> {
                player.setGameMode(GameMode.SPECTATOR);

                String prefix = "§8[§6TOD§8] ";

                player.sendMessage(prefix + "§7-----------------------------");
                player.sendMessage(prefix + "§9" + p.getName() + " §6ist gestorben!");
                player.sendMessage(prefix + "\n" + prefix + "§cF §6in den Chat");
                player.sendMessage(prefix + "§7-----------------------------");

                Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
                    public void run() {
                        ScoreboardManager manager = Bukkit.getScoreboardManager();
                        final Scoreboard board = manager.getNewScoreboard();
                        final Objective objective = board.registerNewObjective("Belowname", "dummy");
                        objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);
                        objective.setDisplayName("§c" + p.getStatistic(Statistic.DEATHS) + " §6Tode");
                    }
                },0, 20 * 10);



                ;            });

            Main.Timer = false;
            Main.getPlugin().getRunnable().cancel();
            new TimerScheduler().runTaskTimer(Main.getPlugin(), 20L, 20L);
        }catch (Exception ex){

        }

    }





}
