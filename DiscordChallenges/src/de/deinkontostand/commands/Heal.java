package de.deinkontostand.commands;

import de.deinkontostand.listeners.onJoin;
import de.deinkontostand.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
                Player p = (Player)sender;

                if (args.length == 0) {
                    p.setHealth(20);
                    p.setFoodLevel(20);

                    p.sendMessage(Main.prefix + "§aDu wurdest geheilt.");


                } else if (args.length == 1) {

                    Player t = Bukkit.getPlayer(args[0]);

                    t.setHealth(20);
                    t.setFoodLevel(20);

                    p.sendMessage(Main.prefix + "§aDu hast §6" + t.getName() + "§a geheilt.");

                    t.sendMessage(Main.prefix + "§aDu wurdest von §6" + p.getName() + "§a geheilt.");

                } else {
                    p.sendMessage(Main.prefix + " LOL");
                }
        }

        return false;
    }
}
