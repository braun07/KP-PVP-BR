package me.RafaelAulerDeMeloAraujo.Coins;



import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



@SuppressWarnings("unused")
public class CoinsCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("coins")) {
			if (args.length == 0) {
					sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoce tem §b" + Coins.getCoins(sender.getName()) + " §6Moedas");
					return true;
				}
		}
		return false;
	}
	}