package me.RafaelAulerDeMeloAraujo.main;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class Fly
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args)
  {
    if ((sender instanceof Player))
    {
      if (cmd.getName().equalsIgnoreCase("fly"))
      {
        Player player = (Player)sender;
        if (!player.hasPermission("kitpvp.staff"))
        {
          player.sendMessage(API.NomeServer + "§cVoce nao possui permissao para isso!");
          return true;
        }
        if (args.length == 0) {
          if (!player.getAllowFlight())
          {
            player.sendMessage(ChatColor.GREEN + "§8(§4§lTSB§f§lPVP§8) §fFly §2§lATIVADO");
            player.setAllowFlight(true);
          }
          else
          {
            player.sendMessage(ChatColor.GREEN + "§8(§4§lTSB§f§lPVP§8) §fFly §4§lDESATIVADO");
            player.setAllowFlight(false);
          }
        }
        if ((args.length == 1) && 
          (sender.hasPermission("kitpvp.darfly")))
        {
          Player player2 = Bukkit.getPlayer(args[0]);
          if (player2 == null)
          {
            sender.sendMessage(ChatColor.RED + "Jogador Offline");
            return true;
          }
          if (!player2.getAllowFlight())
          {
            sender.sendMessage(ChatColor.GREEN + "Voo Habilitado para " + player2.getName());
            player2.setAllowFlight(true);
            player2.sendMessage(ChatColor.GREEN + "Voo Habilitado por " + player.getName());
            Bukkit.broadcast(API.NomeServer + "§f" + player.getName() + ChatColor.GRAY + " habilitou o fly de " + player2.getName(), "kitpvp.staff");
          }
          else
          {
            sender.sendMessage(ChatColor.GREEN + "Voo Desabilitado para " + player2.getName());
            player2.setAllowFlight(false);
            player2.sendMessage(ChatColor.GREEN + "Voo Desabilitado por " + player.getName());
            Bukkit.broadcast(API.NomeServer + "§f" + player.getName() + ChatColor.GRAY + " desabilitou o fly de " + player2.getName(), "kitpvp.staff");
          }
        }
      }
    }
    else {
      sender.sendMessage(ChatColor.RED + "Voce deve ser um usuario!");
    }
    return false;
  }
}

