package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class Facil
  implements Listener
{
  private Facil plugin;
  
  public Facil(Facil instance)
  {
    this.plugin = instance;
  }
  
  public Facil() {}
  
  @EventHandler
  public void onSignChange(SignChangeEvent e)
  {
    if (e.getLine(0).equalsIgnoreCase("Facil"))
    {
      e.setLine(0, "§4§l-=-= (!) =-=-");
      e.setLine(1, "§c§lRecompensa!");
      e.setLine(2, "§c§lNivel Facil");
      e.setLine(3, "§4§l-=-= (!) =-=-");
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
      if ((lines.length > 0) && (lines[0].equals("§4§l-=-= (!) =-=-")) && 
        (lines.length > 1) && (lines[1].equals("§c§lRecompensa!")) && 
        (lines.length > 2) && (lines[2].equals("§c§lNivel Facil")) && 
        (lines.length > 3) && (lines[3].equals("§4§l-=-= (!) =-=-")))
      {
        Coins.addCoins(p.getName(), 200.0D);
        p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoce ganhou 200 coins por passar.");
        p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fNivel: §aFacil");
        
API.ItemSpawn(p);
        p.sendMessage(API.NomeServer+ "§f Voce voltou pro spawn");
      }
    }
  }
}
