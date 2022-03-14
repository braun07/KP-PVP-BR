package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import me.RafaelAulerDeMeloAraujo.main.Main;

public class Ajnin
  implements Listener
{
  public HashMap<Player, Player> ajinhash;
  public HashMap<Player, Long> ajincooldown;
  
  public Ajnin()
  {
    this.ajinhash = new HashMap();
    this.ajincooldown = new HashMap();
  }
  
  @EventHandler
  public void a(EntityDamageByEntityEvent e)
  {
    if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player)))
    {
      Player p = (Player)e.getDamager();
      Player t = (Player)e.getEntity();
      if (Habilidade.getAbility(p).equalsIgnoreCase("Ajnin"))
      {
        this.ajinhash.put(p, t);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
        {
          public void run() {}
        }, 200L);
      }
    }
  }
  
  @EventHandler
  public void aPlayerToggle(PlayerToggleSneakEvent e)
  {
    final Player p = e.getPlayer();
    if (Cooldown.add(p) && (Habilidade.getAbility(p).equalsIgnoreCase("Ajnin")))
    {
      p.sendMessage("§c§lCOOLDOWN §fVoce esta em cooldown de " + Cooldown.cooldown(p) + " segundos");
      return;
    }
    if ((e.isSneaking()) && (Habilidade.getAbility(p).equalsIgnoreCase("Ajnin")) && (this.ajinhash.containsKey(p)))
    {
      Player t = (Player)this.ajinhash.get(p);
      if ((t != null) && (!t.isDead()))
      {
        String s = null;
        if (this.ajincooldown.get(p) != null)
        {
          long l = ((Long)this.ajincooldown.get(p)).longValue() - System.currentTimeMillis();
          DecimalFormat localDecimalFormat = new DecimalFormat("##");
          int i = (int)l / 1000;
          s = localDecimalFormat.format(i);
        }
        if (p.getLocation().distance(t.getLocation()) < 50.0D)
        {
          Location loc = p.getLocation();      
          t.teleport(loc);
          p.sendMessage("§4§lAJNIN: §fVoce puxou " + t.getName() + " §fatÃ© vocÃª!");
          t.sendMessage("§4§lAJNIN: §f" + p.getName() + " puxou vocÃª com o kit AJNIN!");
          Cooldown.add(p, 25);
          Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
          {
            public void run()
            {
              p.sendMessage("§2§lCOOLDOWN Â§aO seu Cooldown acabou");
            }
          }, 500L);
        }
        else
        {
          p.sendMessage("§4§lAJNIN Â§fO ultimo jogador hitado estÃ¡ a mais de 50 blocos de distÃ¢ncia!");
        }
      }
    }
  }
  
  @EventHandler
  public void aomorrer(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    Player t = (Player)this.ajinhash.get(p);
    this.ajinhash.remove(t);
    this.ajinhash.remove(p);
  }
  
  @EventHandler
  public void aosair(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    Player t = (Player)this.ajinhash.get(p);
    this.ajinhash.remove(t);
    this.ajinhash.remove(p);
  }
}