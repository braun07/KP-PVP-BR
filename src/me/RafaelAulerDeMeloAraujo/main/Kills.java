package me.RafaelAulerDeMeloAraujo.main;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.RafaelAulerDeMeloAraujo.main.AntiDeathDrop;





public class Kills implements CommandExecutor { 

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kpkills")){
			 Player player = (Player)sender;
			    if (!player.hasPermission("kitpvp.givekills")) {
			      player.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVocÃª nao tem permissÃ£o para executar esse comando!");
			      return true;
			    }
			
			
			if(args.length < 3){
				sender.sendMessage("§cCorrect usage: /kpkills give/remove <Player> <Amount>");
				return true;
			}
			
			int tanto = Integer.valueOf(args[2]);
			Player t = Bukkit.getPlayer(args[1]);
			
			if(args[0].equalsIgnoreCase("give")){
				
				try{
					Main.plugin.getConfig().set("status." + t.getName().toLowerCase() + ".kills", Integer.valueOf(tanto + AntiDeathDrop.GetKills(t)));
					Main.plugin.saveConfig();
					sender.sendMessage("§aYou give " + tanto + " Kills to the player " + t.getName());
					t.sendMessage("§e" + tanto + " §aKills has been added to your account!");
				}catch(Exception e){
					sender.sendMessage("§cUse only numbers!");
				}
				
			}else{
				sender.sendMessage("§cUse /kpkills give <Player> <Amount>");
			}
		if(args[0].equalsIgnoreCase("remove")){
				
				try{
					Main.plugin.getConfig().set("status." + t.getName().toLowerCase() + ".kills", Integer.valueOf(AntiDeathDrop.GetKills(t) - tanto));
					sender.sendMessage("§aYou remove " + tanto + " Kills of the player " + t.getName());
					t.sendMessage("§e" + tanto + " §aKills has been removed from your account!");
				}catch(Exception e){
					sender.sendMessage("§cUse only numbers!");
				}
		}else{
			sender.sendMessage("§cUse /kpkills remove <Player> <Amount>");
		}
			
			
		}
		return false;
	
}
}
