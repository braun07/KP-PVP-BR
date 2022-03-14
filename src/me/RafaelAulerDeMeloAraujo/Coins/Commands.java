/*     */ package me.RafaelAulerDeMeloAraujo.Coins;
/*     */ 
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



@SuppressWarnings("unused")
public class Commands implements CommandExecutor {
	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("givecoins")) {
			if (!sender.hasPermission("kitpvp.coins")) {
				sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fvoce nao tem permissao para isso!");
			} else {
				if (args.length == 0) {
					sender.sendMessage( "§c§l/givecoins [player] [amount]");
					return true;
				}
				Player target = Bukkit.getPlayerExact(args[0]);
				if ((target == null) || (!(target instanceof Player))) {
					sender.sendMessage( "§8(§4§lTSB§f§lPVP§8) §fO Player esta offline");
					return true;
				}
				if (isNumeric(args[1])) {
					Double coins = Double.parseDouble(args[1]);
					Coins.addCoins(target.getName(), coins);
					sender.sendMessage( "§8(§4§lTSB§f§lPVP§8) §fVoce deu do player " + target.getName() + "" + coins
							+ "§6Moedas");
					target.sendMessage( "§8(§4§lTSB§f§lPVP§8) §fVoce recebeu " + coins
							+ " §6Coins");
					target.sendMessage( "§8(§4§lTSB§f§lPVP§8) §fSua conta foi atualizada!");
					Coins.loadCoins();
					
				}
			}
		}
		return false;
	}
}

		


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\Coins\Commands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
