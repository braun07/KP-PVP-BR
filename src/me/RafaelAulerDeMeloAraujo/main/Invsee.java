package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Invsee
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
      return false;
    }
    Player p = (Player)sender;
    if (commandLabel.equalsIgnoreCase("invsee")) {
      if (p.hasPermission("kitpvp.fly"))
      {
        if (args.length == 0)
        {
          p.sendMessage(ChatColor.GOLD + "Digite " + ChatColor.GRAY + "/invsee <Player>");
        }
        else if (args.length == 1)
        {
          Player target = p.getServer().getPlayer(args[0]);
          if (target != null)
          {
            p.sendMessage(ChatColor.GOLD + "Vendo " + ChatColor.GRAY + target.getName());
            p.openInventory(target.getInventory());
          }
          else
          {
            p.sendMessage(ChatColor.RED + "Jogador " + args[0] + 
              "inexistente.");
          }
        }
        else
        {
          p.sendMessage(ChatColor.GOLD + "Digite " + ChatColor.GRAY + "/invsee <Player>");
        }
      }
      else {
    	  p.sendMessage("ß8(ß4ßlTSBßfßlPVPß8) ßfVoce nao tem permiss√£o para executar esse comando");
      }
    }
    return false;
  }
}
