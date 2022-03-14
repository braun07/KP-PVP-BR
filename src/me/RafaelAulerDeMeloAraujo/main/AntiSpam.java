package me.RafaelAulerDeMeloAraujo.main;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.ChatColor;



  
  

  public class AntiSpam
    implements Listener
  {
    public static HashMap<Player, Long> chat = new HashMap();
    
    @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=false)
    public void aAntiSpam(AsyncPlayerChatEvent e)
    {
      Player p = e.getPlayer();
      if (!chat.containsKey(p))
      {
        int zeitconfig = 2000;
        long time = System.currentTimeMillis() + zeitconfig;
        if (p.hasPermission("kitpvp.spam")) {
          return;
        }
        chat.put(p, Long.valueOf(time));
      }
      else if (((Long)chat.get(p)).longValue() <= System.currentTimeMillis())
      {
        if (p.hasPermission("kitpvp.spam")) {
          return;
        }
        int zeitconfig = 2000;
        long time = System.currentTimeMillis() + zeitconfig;
        chat.put(p, Long.valueOf(time));
      }
      else
      {
        if ((((Long)chat.get(p)).longValue() < System.currentTimeMillis()) || 
          (p.hasPermission("kitpvp.spam"))) {
          return;
        }
        p.sendMessage(("§8(§4§lTSB§f§lPVP§8) §fPor favor fale mais devagar!"));
        e.setCancelled(true);
      }
    }
  }