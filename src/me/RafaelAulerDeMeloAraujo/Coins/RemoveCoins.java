package me.RafaelAulerDeMeloAraujo.Coins;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



@SuppressWarnings("unused")
public class RemoveCoins implements CommandExecutor {
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("removecoins")) {
			if (!sender.hasPermission("kitpvp.coins")) {
				sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoce nao tem permissao para isso!");
			} else {
				if (args.length == 0) {
					sender.sendMessage( "§c§l/removecoins [player] [amount]");
					return true;
				}
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					sender.sendMessage( "§8(§4§lTSB§f§lPVP§8) §fO Player esta Offline");
					return true;
				}
				if (isNumeric(args[1])) {
					Double coins = Double.parseDouble(args[1]);
					Coins.removeCoins(target.getName(), coins);
					sender.sendMessage( "§8(§4§lTSB§f§lPVP§8) §fVoce removeu do player " + target.getName() + "" + coins
							+ "§6Moeda(s)");
					target.sendMessage( "§8(§4§lTSB§f§lPVP§8) §b" + coins
							+ "§6Moeda(s) §fforam removidas de sua conta!");
					target.sendMessage( "§8(§4§lTSB§f§lPVP§8) §fSua conta foi atualizada!");
					Coins.loadCoins();
					
				}
			}
		}
		return false;
	}
}