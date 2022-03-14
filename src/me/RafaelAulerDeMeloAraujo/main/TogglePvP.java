package me.RafaelAulerDeMeloAraujo.main;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TogglePvP
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Somente jogadores podem executar este comando!");
      return true;
    }
    Player p = (Player)sender;
    if ((cmd.getName().equalsIgnoreCase("togglepvp")))
    {
    	if (!p.hasPermission("kitpvp.togglepvp"))
        {
        	p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVocê nao tem permissão para executar esse comando");
          return true;
        }
      if (p.getWorld().getPVP())
      {
        p.getWorld().setPVP(false);
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "O PvP do Servidor foi Desativado");
        return true;
      }
      p.getWorld().setPVP(true);
      Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "O PvP do Servidor foi Ativado");
      return true;
    }
    return true;
  }
}
