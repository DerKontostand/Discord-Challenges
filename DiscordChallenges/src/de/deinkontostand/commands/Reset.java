package de.deinkontostand.commands;

import de.deinkontostand.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reset implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        try {
            Bukkit.getOnlinePlayers().forEach(player -> {
                player.kickPlayer("§c§lDie Welt wurde von §e§l" + sender.getName() + " §c§lResettet");
            });

            Bukkit.getServer().shutdown();

            World w = Bukkit.getWorld("world");
            World n = Bukkit.getWorld("world_nether");
            World e = Bukkit.getWorld("world_the_end");

            w.getWorldFolder().delete();
            n.getWorldFolder().delete();
            e.getWorldFolder().delete();

        }catch (Exception e){

        }
        return false;
    }
}
