package me.RafaelAulerDeMeloAraujo.main;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Rank
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("ranks"))
    {
    	p.sendMessage(ChatColor.YELLOW + "\u274C" + ChatColor.AQUA + "           INFORMAÇÕES DOS RANKS " + ChatColor.YELLOW + "\u274C");
    	p.sendMessage(ChatColor.WHITE + "\u279C No Nosso Servidor possuimos sistema de níveis");
    	p.sendMessage(ChatColor.WHITE + "\u279C Que podem ir do nível §7§l[0] §fao nível §5§l[100]");
    	p.sendMessage(ChatColor.WHITE + "\u279C Você pode verificar seu nivel no chat ou na scoreboard");
    	p.sendMessage(ChatColor.WHITE + "\u279C Os níveis sao ganhos por XP!");
    	p.sendMessage(ChatColor.WHITE + "\u279C A cada 200 de XP você upa de nível!");
    	p.sendMessage(ChatColor.WHITE + "\u279C Quem tiver o maior nível podera ganhar premios no final da temporada");
    	p.sendMessage(ChatColor.WHITE + "\u279C Por isso lute o maxímo que puder para conquistar o pódio!");
    	p.sendMessage(ChatColor.WHITE + "\u279C Lute e ganhe o maior nivel!\n");
    }
	return false;
  }
}