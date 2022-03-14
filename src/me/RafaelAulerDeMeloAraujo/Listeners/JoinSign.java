package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.main.Main;

@SuppressWarnings("unused")
public class JoinSign
  implements Listener
{
  private Main plugin;
  
  public JoinSign(Main main)
  {
    this.plugin = main;
  }
  
  public JoinSign() {}
  
  @EventHandler
  public void onSignChange(SignChangeEvent e)
  {
    if (e.getLine(0).equalsIgnoreCase("[kp]") && (e.getLine(1).equalsIgnoreCase("join")) && e.getPlayer().hasPermission("kitpvp.createsigns"))
    {
      e.setLine(0, Main.messages.getString("JoinSignLine1").replace("&", "§"));
      e.setLine(1, Main.messages.getString("JoinSignLine2").replace("&", "§"));
      e.setLine(2, Main.messages.getString("JoinSignLine3").replace("&", "§"));
      e.setLine(3, Main.messages.getString("JoinSignLine4").replace("&", "§"));
    }
  }
  

  
  @EventHandler
  public void inv(PlayerInteractEvent e)
  {
	  Player p = e.getPlayer();
	  if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null) && (
		      (e.getClickedBlock().getType() == Material.WALL_SIGN) || (e.getClickedBlock().getType() == Material.SIGN_POST)))
		    {
		      Sign s = (Sign)e.getClickedBlock().getState();
		      String[] lines = s.getLines();
		      if ((lines.length > 0) && (lines[0].equals(Main.messages.getString("JoinSignLine1").replace("&", "§")) && 
		        (lines.length > 1) && (lines[1].equals(Main.messages.getString("JoinSignLine2").replace("&", "§")) && 
		        (lines.length > 2) && (lines[2].equals(Main.messages.getString("JoinSignLine3").replace("&", "§")) && 
		        (lines.length > 3) && (lines[3].equals(Main.messages.getString("JoinSignLine4").replace("&", "§"))))))) {
		    	  p.performCommand("kitpvp join");
		      }
  }
  }
  }