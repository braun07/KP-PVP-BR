package me.RafaelAulerDeMeloAraujo.X1;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Warps
  implements Listener, CommandExecutor
{
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
    {
      Inventory inv = e.getInventory();
      Player p = (Player)e.getWhoClicked();
      if (inv.getTitle().equals("Warps"))
      {
        p.playSound(p.getLocation(), Sound.DOOR_CLOSE, 5.0F, 5.0F);
        e.setCancelled(true);
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lFPS"))
        {
          Bukkit.dispatchCommand(p, "kpjoinwarps fps");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lKNOCKBACK"))
        {
          Bukkit.dispatchCommand(p, "kpjoinwarps knock");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lPOTPVP"))
        {
          Bukkit.dispatchCommand(p, "kpjoinwarps pot");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lRDM §e§l(EVENTO)"))
        {
          Bukkit.dispatchCommand(p, "kpjoinwarps rdm");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§lLAVA CHALLANGE"))
        {
          Bukkit.dispatchCommand(p, "kpjoinwarps challenge");
          p.closeInventory();
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§l1V1"))
        {
          X1.entrar1v1(p);
          p.closeInventory();
        }
      }
    }
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("kpwarps"))
    {
      Inventory warps = Bukkit.createInventory(p, 9, "Warps");
      
      ItemStack fps = new ItemStack(Material.GLASS);
      ItemMeta fps2 = fps.getItemMeta();
      fps2.setDisplayName("§6§lFPS");
      List<String> lore1 = new ArrayList();
      lore1.add("§7Warp para aumentar o FPS do seu mine!");
      fps2.setLore(lore1);
      fps.setItemMeta(fps2);
      
      ItemStack pot = new ItemStack(Material.POTION);
      ItemMeta pot1 = pot.getItemMeta();
      pot1.setDisplayName("§6§lPOTPVP");
      List<String> lore9 = new ArrayList();
      lore9.add("§7Warp para tirar pvp com pocoes!");
      pot1.setLore(lore9);
      pot.setItemMeta(pot1);
      
      ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
      ItemMeta lava2 = lava.getItemMeta();
      lava2.setDisplayName("§6§lLAVA CHALLANGE");
      List<String> lore2 = new ArrayList();
      lore2.add("§7Treine seu refil e recraft nesta warp!");
      lava2.setLore(lore2);
      lava.setItemMeta(lava2);
      
      ItemStack v1 = new ItemStack(Material.BLAZE_ROD);
      ItemMeta v12 = v1.getItemMeta();
      v12.setDisplayName("§6§l1V1");
      List<String> lore3 = new ArrayList();
      lore3.add("§7Tire um x1 com outros jogadores!");
      v12.setLore(lore3);
      v1.setItemMeta(v12);
      
      ItemStack vinagre = new ItemStack(Material.STICK);
      ItemMeta vinagre1 = vinagre.getItemMeta();
      vinagre1.setDisplayName("§6§lKNOCKBACK");
      List<String> lore4 = new ArrayList();
      lore4.add("§7Tente derrubar o outro para fora da arena!");
      vinagre1.setLore(lore4);
      vinagre.setItemMeta(vinagre1);
      
      ItemStack r2 = new ItemStack(Material.CAKE);
      ItemMeta vr2 = r2.getItemMeta();
      vr2.setDisplayName("§6§lRDM §e§L(EVENTO)");
      List<String> lore5 = new ArrayList();
      lore5.add("§7Evento Rei da Mesa!");
      vr2.setLore(lore5);
      r2.setItemMeta(vr2);
      
      warps.setItem(0, fps);
      warps.setItem(2, v1);
      warps.setItem(3, lava);
      warps.setItem(5, pot);
      warps.setItem(6, vinagre);
      warps.setItem(8, r2);
      
      p.openInventory(warps);
    }
    return false;
  }
}
