package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;


import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Level;

public class ChatColor
  implements Listener
{
	
  @EventHandler(priority=EventPriority.NORMAL)
  public void onColorandChangeChat(PlayerChatEvent e)
  {
    Player p = e.getPlayer();
    if (!p.hasPermission("kitpvp.chatcolor")) {
      e.setFormat(Level.getLevel(p) + " " + p.getDisplayName() + " §6»" + "§7 " + e.getMessage());
    } else {
      e.setFormat(Level.getLevel(p) + " " + p.getDisplayName() + " §6»" + "§f " + e.getMessage().replaceAll("&", "§"));
    }
  }
}