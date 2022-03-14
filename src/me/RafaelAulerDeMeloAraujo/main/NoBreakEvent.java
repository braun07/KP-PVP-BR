/*    */ package me.RafaelAulerDeMeloAraujo.main;
/*    */ 


import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;

public final class NoBreakEvent
  implements Listener, CommandExecutor
{
  public static ArrayList<Player> embuild = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("build")) {
      if (p.hasPermission("kitpvp.build"))
      {
        if (args.length == 0)
        {
          if (!embuild.contains(p))
          {
            embuild.add(p);
            p.sendMessage(String.valueOf(API.NomeServer) + "§fModo Build §2§lATIVADO");
          }
          else
          {
            embuild.remove(p);
            p.sendMessage(String.valueOf(API.NomeServer) + "§fModo Build §4§lDESATIVADO");
          }
        }
        else
        {
          Player t = Bukkit.getPlayer(args[0]);
          if (t == null)
          {
            p.sendMessage(API.NomeServer + "§cThis player is offline");
            return true;
          }
          if (!embuild.contains(t))
          {
            embuild.add(t);
            p.sendMessage(String.valueOf(API.NomeServer) + "§aNow: §7" + t.getName() + " §acan edit kitpvp arena");
          }
          else
          {
            embuild.remove(t);
            p.sendMessage(String.valueOf(API.NomeServer) + "§aPlayer: §7" + t.getName() + " §ano longer can edit kitpvp arena");
          }
        }
      }
      else {
        p.sendMessage(String.valueOf(API.NomeServer) + "§cVoce nao tem permissao para isso!");
      }
    }
    return false;
  }
  
  @EventHandler
  public void aoconstruir(BlockPlaceEvent e)
  {
    Player p = e.getPlayer();
    if (!embuild.contains(p) && Join.game.contains(e.getPlayer().getName())) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void aoconstruir(BlockBreakEvent e)
  {
    Player p = e.getPlayer();
    if (!embuild.contains(p) && Join.game.contains(e.getPlayer().getName())) {
      e.setCancelled(true);
    }
  }
}
