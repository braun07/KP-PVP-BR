package me.RafaelAulerDeMeloAraujo.main;


import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.Coins.XP;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Scoreboard;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;


import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.World;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;



public class AntiDeathDrop
  implements Listener
{
  private Main main;
  
  public AntiDeathDrop(Main main)
  {
    this.main = main;
  }
  
  @EventHandler
  public void onDeath(PlayerRespawnEvent e)
  {
    if (((e.getPlayer() instanceof Player)) && ((e.getPlayer().getKiller() instanceof Player)))
    {
      Player p = e.getPlayer();
      Player k = p.getKiller();
      if (Join.game.contains(p.getName()))
      {
     
      if ((this.main.getConfig().getString("RespawnSound").equalsIgnoreCase("true")) && (Join.game.contains(p.getName()))) {
        p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Respawn")), 1.0F, 1.0F);
      }
      }}
    }
  
  
  @EventHandler
  public void onDeath(PlayerDeathEvent e)
  {
    
    if (((e.getEntity() instanceof Player)) && ((e.getEntity().getKiller() instanceof Player)))
    {
      Player p = e.getEntity();
      Player k = p.getKiller();
      if (Join.game.contains(p.getName()))
      {
    	  if (p == k) {
    		  return;
    	  }
        Join.game.contains(k.getName());
        
        e.getDrops().clear();
        e.setDeathMessage("");
        p.sendMessage(String.valueOf(API.NomeServer + Main.getInstace().getConfig().getString("Death.Tell").replaceAll("%player%", k.getName())));
        k.sendMessage(String.valueOf(API.NomeServer + Main.getInstace().getConfig().getString("Kill.Tell").replaceAll("%player%", p.getName())));
        p.sendMessage(String.valueOf(API.NomeServer + "§a-" + Main.customization.getInt("XPLost-OnDeath") + "XP"));
        if (k.hasPermission("kitpvp.doublexp")) {
        XP.addXP(k.getName(), Main.customization.getDouble("XPEarned-OnKill") * 2);
        k.sendMessage(String.valueOf(API.NomeServer + "§a+" + Main.customization.getInt("XPEarned-OnKill") * 2 + "XP (2X)"));
        } else { 
        	XP.addXP(k.getName(), Main.customization.getDouble("XPEarned-OnKill"));
            k.sendMessage(String.valueOf(API.NomeServer + "§a+" + Main.customization.getInt("XPEarned-OnKill") + "XP"));
        }
        XP.removeXP(p.getName(), Main.customization.getDouble("XPLost-OnDeath"));
        k.playSound(k.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Respawn")), 6.0F, 1.0F);
        XP.saveXP();
        XP.loadXP();
        if (k.hasPermission("kitpvp.doublecoins")) {
            Coins.addCoins(k.getName(), Main.customization.getDouble("Earned-Coins-Per-Kill") * 2);
            k.sendMessage(String.valueOf(API.NomeServer + Main.messages.getString("CoinsDoubled").replace("%coins%", String.valueOf(Main.customization.getDouble("Earned-Coins-Per-Kill") * 2))).replace("&", "§"));
            } else { 
            	Coins.addCoins(k.getName(), Main.customization.getDouble("Earned-Coins-Per-Kill"));               
            }
        Coins.removeCoins(p.getName(), Main.customization.getDouble("Lost-Coins-Per-Death"));
        Coins.saveCoins();
        Coins.loadCoins();
        API.tirarEfeitos(p);        
        int mortes = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".deaths");      
        Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".deaths", Integer.valueOf(mortes + 1));
        int kills = Main.plugin.getConfig().getInt("status." + k.getName().toLowerCase() + ".kills");      
        Main.plugin.getConfig().set("status." + k.getName().toLowerCase() + ".kills", Integer.valueOf(kills + 1));
        Main.plugin.saveConfig();
        Scoreboard.setScoreBoard(p);
        Scoreboard.setScoreBoard(k);
        Bukkit.getConsoleSender().sendMessage("§e" + p.getName() + " has been killed by " + k.getName() + " on kitpvp");
      }
    }
  }
	@EventHandler
	public void Drop(ItemDespawnEvent e) {
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
				/*     */         {
				public void run()

				/*     */           {
					World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
		  if (e.getEntity().getWorld().getName().equals(w) && (Main.getInstace().getConfig().getString("ClearItemsOnGround").equalsIgnoreCase("true"))) {
		e.getEntity().remove();
		e.getEntity().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 2);
		e.getEntity().getWorld().playSound(e.getEntity().getLocation(), Sound.valueOf(Main.getInstace().getConfig().getString("Sound.ItemDespawn")), 2.0F, 2.0F);
		  /*     */           }
				/* 167 */         }}, 20 * this.main.getConfig().getInt(("ClearInterval")));
				/*     */       }
		          
	


  public static int GetKills(Player p)
  {
      int kills = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
      
    return kills;
  }
 
  
  public static int GetDeaths(Player p)
  {
    int deaths = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".deaths");
    return deaths;
  }
}
