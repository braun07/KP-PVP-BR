package me.RafaelAulerDeMeloAraujo.main;

import java.util.ArrayList;
import java.util.Arrays;
import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Shop
  implements Listener, CommandExecutor
{
  private Main main;
  public static Inventory shop = Bukkit.getServer().createInventory(null, 54, Main.messages.getString("ShopInventoryName").replace("&", "§"));
  
  static
  {
    createButton(Material.DIAMOND_SWORD, shop, 0, "§6-> §cPvP", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 4500");
    createButton(Material.BOW, shop, 1, "§6-> §cArcher", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 3000");
    createButton(Material.FLINT_AND_STEEL, shop, 2, "§6-> §cPyro", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 6000");
    createButton(Material.DIAMOND_CHESTPLATE, shop, 3, "§6-> §cTank", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 7000");
    createButton(Material.SNOW_BALL, shop, 4, "§6-> §cSwitcher", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 6500");
    createButton(Material.MAGMA_CREAM, shop, 5, "§6-> §cJumper", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 8000");
    createButton(Material.CACTUS, shop, 6, "§6-> §cCactus", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 4000");
    createButton(Material.TNT, shop, 7, "§6-> §cBomber",  Main.messages.getString("ShopPriceLore").replace("&", "§") + " 9000");
    createButton(Material.ENDER_PEARL, shop, 8, "§6-> §cWarper", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 4000");
    
    createButton(Material.FISHING_ROD, shop, 9, "§6-> §cFisherman", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 5000");
    
    createButton(Material.IRON_BOOTS, shop, 10, "§6-> §cStomper", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 17500");
    createButton(Material.REDSTONE_BLOCK, shop, 11, "§6-> §cDeshfire", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 8500");
    createButton(Material.SPIDER_EYE, shop, 12, "§6-> §cViper", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 7000");
    createButton(Material.STRING, shop, 13, "§6-> §cSpiderman", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 6000");
    createButton(Material.IRON_FENCE, shop, 14, "§6-> §cGladiator", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 16000");
    createButton(Material.FIREWORK, shop, 15, "§6-> §cKangaroo", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 5000");
    createButton(Material.COAL, shop, 16, "§6-> §cNinja", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 6500");
    createButton(Material.WATCH, shop, 17, "§6-> §cTimelord", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 7000");
    createButton(Material.GOLDEN_APPLE, shop, 18, "§6-> §cCritical", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 8000");
    createButton(Material.CHAINMAIL_BOOTS, shop, 19, "§6-> §cDoubleJump", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 9500");
    createButton(Material.GOLD_AXE, shop, 20, "§6-> §cThor", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 7000");
    createButton(Material.FERMENTED_SPIDER_EYE, shop, 21, "§6-> §cSnail", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 6000");
    createButton(Material.BLAZE_ROD, shop, 22, "§6-> §cWasp", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 6000");
    createButton(Material.NETHER_STAR, shop, 23, "§6-> §cNaruto", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 12500");
    createButton(Material.FEATHER, shop, 24, "§6-> §cAirman", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 9000");
    createButton(Material.GOLD_NUGGET, shop, 25, "§6-> §cVampire", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 10000");
    createButton(Material.LAPIS_BLOCK, shop, 26, "§6-> §cSonic", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 11000");
    createButton(Material.BOOK, shop, 27, "§6-> §cPhantom", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 10000");
    createButton(Material.SAND, shop, 28, "§6-> §cCamel", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 5000");
    createButton(Material.POTION, shop, 29, "§6-> §cConfuser", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 5500");
    createButton(Material.IRON_AXE, shop, 30, "§6-> §cViking", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 5500");
    createButton(Material.WATER_BUCKET, shop, 31, "§6-> §cPoseidon", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 6000");
    createButton(Material.MUSHROOM_SOUP, shop, 32, "§6-> §cResouper", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 3000");
    createButton(Material.ANVIL, shop, 33, "§6-> §cAnchor", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 8000");
    createButton(Material.BEACON, shop, 34, "§6-> §cRyu", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 5000");
    createButton(Material.BLAZE_ROD, shop, 35, "§6-> §cMonk", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 6000");
    createButton(Material.LAVA_BUCKET, shop, 36, "§6-> §cFireman", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 6000");
    createButton(Material.SLIME_BALL, shop, 37, "§6-> §cAjnin", Main.messages.getString("ShopPriceLore").replace("&", "§") + " 8500");
    createButton(Material.BARRIER, shop, 53, "§4§l-> §cClose", Main.messages.getString("CloseShopLore").replace("&", "§"));
  }
  
  public Shop(Main main)
  {
	ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
    ItemMeta vidro2 = vidro.getItemMeta();
    vidro2.setDisplayName(Main.messages.getString("ShopItemContents").replace("&", "§"));
    vidro.setItemMeta(vidro2);
    ItemStack[] arrayOfItemStack;
    int descpyro1 = (arrayOfItemStack = shop.getContents()).length;
    for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
    {
      ItemStack item = arrayOfItemStack[metapyro1];
      if (item == null) {
        shop.setItem(shop.firstEmpty(), vidro);
      }
    }
    this.main = main;
  }
  
  private static void createButton(Material mat, Inventory inv, int Slot, String name, String lore)
  {
    ItemStack item = new ItemStack(mat);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(name);
    meta.setLore(Arrays.asList(new String[] { lore }));
    item.setItemMeta(meta);
    inv.setItem(Slot, item);
  }
  
  @EventHandler
  public void quickcommand(PlayerCommandPreprocessEvent e)
  {
    if (e.getMessage().equalsIgnoreCase("/kpshop"))
    {
      e.setCancelled(true);
      openMenu(e.getPlayer());
      if (!Join.game.contains(e.getPlayer().getName()))
      {
        e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
        e.getPlayer().closeInventory();
      }
    }
  }
  @EventHandler
  public void quickcommandy(PlayerCommandPreprocessEvent e)
  {
    if (e.getMessage().equalsIgnoreCase("/kp shop"))
    {
      e.setCancelled(true);
      openMenu(e.getPlayer());
      if (!Join.game.contains(e.getPlayer().getName()))
      {
        e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
        e.getPlayer().closeInventory();
      }
    }
  }
  
  @EventHandler
  public void quickcommand1(PlayerCommandPreprocessEvent e)
  {
    if (e.getMessage().equalsIgnoreCase("/kploja"))
    {
      e.setCancelled(true);
      openMenu(e.getPlayer());
      if (!Join.game.contains(e.getPlayer().getName()))
      {
        e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
        e.getPlayer().closeInventory();
      }
    }
  }
  
  @EventHandler
  public void quickcommand2(PlayerCommandPreprocessEvent e)
  {
    if (e.getMessage().equalsIgnoreCase("/shopmenu"))
    {
      e.setCancelled(true);
      openMenu(e.getPlayer());
      if (!Join.game.contains(e.getPlayer().getName()))
      {
        e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
        e.getPlayer().closeInventory();
      }
    }
  }
  
  @EventHandler
  public void quickcommand3(PlayerCommandPreprocessEvent e)
  {
    if (e.getMessage().equalsIgnoreCase("/kitpvp shop"))
    {
      e.setCancelled(true);
      openMenu(e.getPlayer());
      if (!Join.game.contains(e.getPlayer().getName()))
      {
        e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
        e.getPlayer().closeInventory();
      }
    }
  }
  
  public void openMenu(Player p)
  {
    p.openInventory(shop);
    p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 1.0F, 1.0F);
  }
  
  @EventHandler
  public void kit(InventoryClickEvent e)
  {
    Inventory inv = e.getInventory();
    if (inv.getTitle().equals(shop.getName())) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    Inventory inv = e.getInventory();
    Player p = (Player)e.getWhoClicked();
    if (inv.getTitle().equals(Main.messages.getString("ShopInventoryName").replace("&", "§")))
    {
      p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu-Click")), 1.0F, 1.0F);
      e.setCancelled(true);
    }
    ItemStack clicked = e.getCurrentItem();
    if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem() == null)) {
      return;
    }
    if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getType() == Material.AIR)) {
      return;
    }
    if ((inv.getName().equals(shop.getName())) && (p.hasPermission("kitpvp.kit.*") && !(clicked.getType() == Material.BARRIER))) {
    	p.sendMessage("§cVoce ja possui todos os kits!");
    	p.closeInventory();
    	return;
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BOW)) {
    	if (p.hasPermission("kitpvp.kit.archer")) {
    		p.sendMessage("§e[KitPvP] §cYou already have the Kit Archer!");
      		p.closeInventory();
      		return;
    	}
      if (Coins.getCoins(p.getName()).doubleValue() >= 3000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.archer");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.archer");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.archer");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.archer true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.archer");
        p.sendMessage("§6-> §cYou buy the Archer kit §e-3000 coins");
        Coins.removeCoins(p.getName(), 3000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 9000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FEATHER)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 9000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.airman")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Airman!");
        		p.closeInventory();
        		return;
      	}
    	  if (Main.kits.getBoolean("AirmanDisabled")) {
       	     p.sendMessage(API.NomeServer + ChatColor.RED + "The Airman kit is disabled, sorry");
       	     return ;
           }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.airman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.airman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.airman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.airman true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.airman");
        p.sendMessage("§6-> §cYou buy the Airman kit §e-9000 coins");
        Coins.removeCoins(p.getName(), 9000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 9000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.SLIME_BALL)) {
        if (Coins.getCoins(p.getName()).doubleValue() >= 8500.0D)
        {
      	  if (p.hasPermission("kitpvp.kit.ajnin")) {
      		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Ajnin!");
          		p.closeInventory();
          		return;
        	}
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.ajnin");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.ajnin");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.ajnin");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.ajnin true");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.ajnin");
          p.sendMessage("§6-> §cYou buy the Ajnin kit §e-8500 coins");
          Coins.removeCoins(p.getName(), 8500.0D);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (Coins.getCoins(p.getName()).doubleValue() < 8500.0D)
        {
          p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
          e.setCancelled(true);
          p.closeInventory();
        }
      }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BOOK)) {
        if (Coins.getCoins(p.getName()).doubleValue() >= 10000.0D)
        {
      	  if (p.hasPermission("kitpvp.kit.phantom")) {
      		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Phantom!");
          		p.closeInventory();
          		return;
        	}
      	 if (Main.kits.getBoolean("PhantomDisabled")) {
      	     p.sendMessage(API.NomeServer + ChatColor.RED + "The Phantom kit is disabled, sorry");
      	     return ;
          }
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.phantom");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.phantom");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.phantom");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.phantom true");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.phantom");
          p.sendMessage("§6-> §cYou buy the Phantom kit §e-9000 coins");
          Coins.removeCoins(p.getName(), 10000.0D);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (Coins.getCoins(p.getName()).doubleValue() < 10000.0D)
        {
          p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
          e.setCancelled(true);
          p.closeInventory();
          return;
        }
      }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.SAND)) {
        if (Coins.getCoins(p.getName()).doubleValue() >= 5000.0D)
        {
      	  if (p.hasPermission("kitpvp.kit.camel")) {
      		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Camel!");
          		p.closeInventory();
          		return;
        	}
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.camel");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.camel");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.camel");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.camel true");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.camel");
          p.sendMessage("§6-> §cYou buy the Camel kit §e-5000 coins");
          Coins.removeCoins(p.getName(), 5000.0D);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (Coins.getCoins(p.getName()).doubleValue() < 5000.0D)
        {
          p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
          e.setCancelled(true);
          p.closeInventory();
          return;
        }
      }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.NETHER_STAR)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 12500.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.naruto")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Naruto!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.naruto");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.naruto");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.naruto");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.naruto true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.naruto");
        p.sendMessage("§6-> §cYou buy the Naruto kit §e-12500 coins");
        Coins.removeCoins(p.getName(), 12500.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 12500.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
        return;
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.MUSHROOM_SOUP)) {
        if (Coins.getCoins(p.getName()).doubleValue() >= 3000.0D)
        {
      	  if (p.hasPermission("kitpvp.kit.resouper")) {
      		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Resouper!");
          		p.closeInventory();
          		return;
        	}
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.resouper");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.resouper");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.resouper");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.resouper true");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.resouper");
          p.sendMessage("§6-> §cYou buy the Resouper kit §e-3000 coins");
          Coins.removeCoins(p.getName(), 3000.0D);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (Coins.getCoins(p.getName()).doubleValue() < 3000.0D)
        {
          p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
          e.setCancelled(true);
          p.closeInventory();
          return;
        }
      }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.DIAMOND_SWORD)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 4500.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.pvp")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit PvP!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.pvp");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.pvp");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.pvp");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.pvp true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.pvp");
        p.sendMessage("§6-> §cYou buy the PvP kit §e-3500 coins");
        Coins.removeCoins(p.getName(), 4500.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 4500.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.GOLD_NUGGET)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 10000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.vampire")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Vampire!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.vampire");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.vampire");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.vampire");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.vampire true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.vampire");
        p.sendMessage("§6-> §cYou buy the Vampire kit §e-10000 coins");
        Coins.removeCoins(p.getName(), 10000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 10000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.COAL)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6500.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.ninja")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Ninja!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.ninja");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.ninja");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.ninja");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.ninja true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.ninja");
        
        p.sendMessage("§6-> §cYou buy the Ninja kit §e-6500 coins");
        Coins.removeCoins(p.getName(), 6500.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6500.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6-> §cMonk"))) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 5000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.monk")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Monk!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.monk");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.monk");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.monk");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.monk true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.monk");
        p.sendMessage("§6-> §cYou buy the Monk kit §e-5000 coins");
        Coins.removeCoins(p.getName(), 5000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 5000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6-> §cWasp"))) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.wasp")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Wasp!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.wasp");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.wasp");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.wasp");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.wasp true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.wasp");
        p.sendMessage("§6-> §cYou buy the Wasp kit §e-6000 coins");
        Coins.removeCoins(p.getName(), 6000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6-> §cMonk"))) {
        if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
        {
      	  if (p.hasPermission("kitpvp.kit.wasp")) {
      		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Monk!");
          		p.closeInventory();
          		return;
        	}
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.monk");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.monk");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.monk");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.monk true");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.monk");
          p.sendMessage("§6-> §cYou buy the Monk kit §e-6000 coins");
          Coins.removeCoins(p.getName(), 6000.0D);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
        {
          p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
          e.setCancelled(true);
          p.closeInventory();
        }
      }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.IRON_FENCE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 16000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.gladiator")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Gladiator!");
        		p.closeInventory();
        		return;
      	}
    	  if (Main.kits.getBoolean("GladiatorDisabled")) {
       	     p.sendMessage(API.NomeServer + ChatColor.RED + "The Gladiator kit is disabled, sorry");
       	     return ;
           }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.gladiator");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.gladiator");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.gladiator");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.gladiator true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.gladiator");
        p.sendMessage("§6-> §cYou buy the Gladiator kit §e-16000 coins");
        Coins.removeCoins(p.getName(), 16000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 16000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.LAPIS_BLOCK)) {
        if (Coins.getCoins(p.getName()).doubleValue() >= 11000.0D)
        {
        	if (p.hasPermission("kitpvp.kit.sonic")) {
        		p.sendMessage("§e[KitPvP] §cYou already have the Kit Sonic!");
          		p.closeInventory();
          		return;
        	}
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.sonic");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.sonic");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.sonic");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.sonic true");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.sonic");
          p.sendMessage("§6-> §cYou buy the Sonic kit §e-11000 coins");
          Coins.removeCoins(p.getName(), 11000.0D);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (Coins.getCoins(p.getName()).doubleValue() < 11000.0D)
        {
          p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
          e.setCancelled(true);
          p.closeInventory();
        }
      }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FIREWORK)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 5000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.kangaroo")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Kangaroo!");
        		p.closeInventory();
        		return;
      	}
    	  if (Main.kits.getBoolean("KangarooDisabled")) {
    			p.sendMessage(API.NomeServer + ChatColor.RED + "The Kangaroo kit is disabled, sorry");
    			return;
    		}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.kangaroo");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.kangaroo");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.kangaroo");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.kangaroo true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.kangaroo");
        p.sendMessage("§6-> §cYou buy the Kangaroo kit §e-5000 coins");
        Coins.removeCoins(p.getName(), 5000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 5000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.STRING)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.spiderman")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Spiderman!");
        		p.closeInventory();
        		return;
      	}
    	  if (Main.kits.getBoolean("SpidermanDisabled")) {
       	     p.sendMessage(API.NomeServer + ChatColor.RED + "The Spiderman kit is disabled, sorry");
       	     return ;
           }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.spiderman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.spiderman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.spiderman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.spiderman true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.spiderman");
        p.sendMessage("§6-> §cYou buy the PvP kit §e-6000 coins");
        Coins.removeCoins(p.getName(), 6000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.SPIDER_EYE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 7000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.viper")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Viper!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.viper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.viper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.viper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.viper true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.viper");
        p.sendMessage("§6-> §cYou buy the Viper kit §e-7000 coins");
        Coins.removeCoins(p.getName(), 7000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 7000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.GOLD_AXE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 7000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.thor")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Thor!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.thor");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.thor");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.thor");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.thor true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.thor");
        p.sendMessage("§6-> §cYou buy the Thor kit §e-7000 coins");
        Coins.removeCoins(p.getName(), 7000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 7000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BARRIER))
    {
      p.closeInventory();
      p.sendMessage(Main.messages.getString("ShopMenuClosed").replace("&", "§"));
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.REDSTONE_BLOCK)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 8500.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.deshfire")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Deshfire!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.deshfire");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.deshfire");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.deshfire");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.deshfire true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.deshfire");
        
        p.sendMessage("§6-> §cYou buy the Deshfire kit §e-8500 coins");
        Coins.removeCoins(p.getName(), 8500.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 8500.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == null))
    {
      e.setCancelled(true);
      p.closeInventory();
      
      return;
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FLINT_AND_STEEL)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.pyro")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Pyro!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.pyro");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.pyro");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.pyro");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.pyro true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.pyro");
        p.sendMessage("§6-> §cYou buy the Pyro kit §e-6000 coins");
        Coins.removeCoins(p.getName(), 6000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FERMENTED_SPIDER_EYE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.snail")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Snail!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.snail");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.snail");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.snail");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.snail true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.snail");
        p.sendMessage("§6-> §cYou buy the Snail kit §e-6000 coins");
        Coins.removeCoins(p.getName(), 6000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.WATER_BUCKET)) {
        if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
        {
      	  if (p.hasPermission("kitpvp.kit.poseidon")) {
      		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Poseidon!");
          		p.closeInventory();
          		return;
        	}
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.poseidon");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.poseidon");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.poseidon");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.poseidon true");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.poseidon");
          p.sendMessage("§6-> §cYou buy the Poseidon kit §e-6000 coins");
          Coins.removeCoins(p.getName(), 6000.0D);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
        {
          p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
          e.setCancelled(true);
          p.closeInventory();
        }
      }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.IRON_AXE)) {
        if (Coins.getCoins(p.getName()).doubleValue() >= 5500.0D)
        {
      	  if (p.hasPermission("kitpvp.kit.viking")) {
      		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Viking!");
          		p.closeInventory();
          		return;
        	}
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.viking");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.viking");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.viking");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.viking true");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.viking");
          p.sendMessage("§6-> §cYou buy the Poseidon kit §e-5500 coins");
          Coins.removeCoins(p.getName(), 5500.0D);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (Coins.getCoins(p.getName()).doubleValue() < 5500.0D)
        {
          p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
          e.setCancelled(true);
          p.closeInventory();
        }
      }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.POTION)) {
        if (Coins.getCoins(p.getName()).doubleValue() >= 5500.0D)
        {
      	  if (p.hasPermission("kitpvp.kit.confuser")) {
      		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Confuser!");
          		p.closeInventory();
          		return;
        	}
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.confuser");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.confuser");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.confuser");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.confuser true");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.confuser");
          p.sendMessage("§6-> §cYou buy the Confuser kit §e-5500 coins");
          Coins.removeCoins(p.getName(), 5500.0D);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (Coins.getCoins(p.getName()).doubleValue() < 5500.0D)
        {
          p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
          e.setCancelled(true);
          p.closeInventory();
        }
      }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.DIAMOND_CHESTPLATE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 7000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.tank")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Tank!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.tank");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.tank");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.tank");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.tank true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.tank");
        p.sendMessage("§6-> §cYou buy the Tank kit §e-7000 coins");
        Coins.removeCoins(p.getName(), 7000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 7000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.WATCH)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 7000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.timelord")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Timelord!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.timelord");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.timelord");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.timelord");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.timelord true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.timelord");
        p.sendMessage("§6-> §cYou buy the Timelord kit §e-7000 coins");
        Coins.removeCoins(p.getName(), 7000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 7000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.ANVIL)) {
        if (Coins.getCoins(p.getName()).doubleValue() >= 8000.0D)
        {
      	  if (p.hasPermission("kitpvp.kit.anchor")) {
      		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Anchor!");
          		p.closeInventory();
          		return;
        	}
      	 if (Main.kits.getBoolean("AnchorDisabled")) {
      	     p.sendMessage(API.NomeServer + ChatColor.RED + "The Anchor kit is disabled, sorry");
      	     return ;
          }
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.timelord");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.timelord");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.timelord");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.anchor true");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.timelord");
          p.sendMessage("§6-> §cYou buy the Anchor kit §e-8000 coins");
          Coins.removeCoins(p.getName(), 8000.0D);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (Coins.getCoins(p.getName()).doubleValue() < 8000.0D)
        {
          p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
          e.setCancelled(true);
          p.closeInventory();
        }
      }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.SNOW_BALL)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.switcher")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Switcher!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.switcher");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.switcher");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.switcher");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.switcher true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.switcher");
        p.sendMessage("§6-> §cYou buy the Switcher kit §e-6000 coins");
        Coins.removeCoins(p.getName(), 6000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.LAVA_BUCKET)) {
        if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
        {
      	  if (p.hasPermission("kitpvp.kit.fireman")) {
      		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Fireman!");
          		p.closeInventory();
          		return;
        	}
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.fireman");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.fireman");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.fireman");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.fireman true");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.fireman");
          p.sendMessage("§6-> §cYou buy the Fireman kit §e-6000 coins");
          Coins.removeCoins(p.getName(), 6000.0D);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
        {
          p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
          e.setCancelled(true);
          p.closeInventory();
        }
      }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.MAGMA_CREAM)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 8000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.jumper")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Jumper!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.jumper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.jumper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.jumper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.jumper true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.jumper");
        p.sendMessage("§6-> §cYou buy the JUMPER kit §e-8000 coins");
        Coins.removeCoins(p.getName(), 8000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 8000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.CACTUS)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 4000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.cactus")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Cactus!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.cactus");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.cactus");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.cactus");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.cactus true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.cactus");
        p.sendMessage("§6-> §cYou buy the Cactus kit §e-4000 coins");
        Coins.removeCoins(p.getName(), 4000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 4000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.TNT)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 9000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.bomber")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Bomber!");
        		p.closeInventory();
        		return;
      	}
    	  if (Main.kits.getBoolean("BomberDisabled")) {
       	     p.sendMessage(API.NomeServer + ChatColor.RED + "The Bomber kit is disabled, sorry");
       	     return ;
           }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.bomber");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.bomber");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.bomber");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.bomber true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.bomber");
        p.sendMessage("§6-> §cYou buy the Bomber kit §e-9000 coins");
        Coins.removeCoins(p.getName(), 9000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 9000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.ENDER_PEARL)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 4000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.warper")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Warper!");
        		p.closeInventory();
      	}
    	  if (Main.kits.getBoolean("WarperDisabled")) {
       	     p.sendMessage(API.NomeServer + ChatColor.RED + "The Warper kit is disabled, sorry");
       	     return ;
           }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.warper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.warper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.warper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.warper true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.warper");
        p.sendMessage("§6-> §cYou buy the Warper kit §e-4000 coins");
        Coins.removeCoins(p.getName(), 4000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 4000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.GOLDEN_APPLE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 8000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.critical")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Critical!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.critical");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.critical");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.critical");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.critical true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.critical");
        p.sendMessage("§6-> §cYou buy the Critical kit §e-8000 coins");
        Coins.removeCoins(p.getName(), 8000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 8000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FISHING_ROD)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 5000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.fisherman")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Fisherman!");
        		p.closeInventory();
        		return;
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.fisherman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.fisherman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.fisherman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.fisherman true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.fisherman");
        p.sendMessage("§6-> §cYou buy the Fisherman kit §e-5000 coins");
        Coins.removeCoins(p.getName(), 5000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 5000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BEACON)) {
        if (Coins.getCoins(p.getName()).doubleValue() >= 5000.0D)
        {
      	  if (p.hasPermission("kitpvp.kit.ryu")) {
      		  p.sendMessage("§e[KitPvP] §cYou already have the Kit Ryu!");
          		p.closeInventory();
          		return;
        	}
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.ryu");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.ryu");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.ryu");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.ryu true");
          Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.ryu");
          p.sendMessage("§6-> §cYou buy the Ryu kit §e-5000 coins");
          Coins.removeCoins(p.getName(), 5000.0D);
          e.setCancelled(true);
          p.closeInventory();
        }
        else if (Coins.getCoins(p.getName()).doubleValue() < 5000.0D)
        {
          p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
          e.setCancelled(true);
          p.closeInventory();
        }
      }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.ICE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.freezer")) {
      		p.sendMessage("§e[KitPvP] §cYou already have this kit!");
      	}
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.freezer");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.freezer local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.freezer global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.freezer");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.freezer true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.freezer");
        p.sendMessage("§6-> § cYou buy the Freezer kit §e-5000 coins");
        Coins.removeCoins(p.getName(), 6000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.CHAINMAIL_BOOTS)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 9500.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.doublejump")) {
    		  p.sendMessage("§e[KitPvP] §cYou already have the Kit DoubleJump!");
        		p.closeInventory();
        		return;
      	}
    	  if (Main.kits.getBoolean("DoubleJumpDisabled")) {
       	     p.sendMessage(API.NomeServer + ChatColor.RED + "The DoubleJump kit is disabled, sorry");
       	     return ;
           }
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.doublejump");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.doublejump");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.doublejump");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.doublejump true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.doublejump");
        p.sendMessage("§6-> § cYou buy the DoubleJump kit e-9500 coins");
        Coins.removeCoins(p.getName(), 9500.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 9500.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.IRON_BOOTS)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 17500.0D)
      {
    	  if (p.hasPermission("kitpvp.kit.stomper")) {
      		p.sendMessage("§e[KitPvP] §cYou already have the Kit Stomper!");
      		p.closeInventory();
      		return;
      	}
    	  if (Main.kits.getBoolean("StomperDisabled")) {
       	     p.sendMessage(API.NomeServer + ChatColor.RED + "The Stomper kit is disabled, sorry");
       	     return ;
           }  
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.stomper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc addplayerpermission " + p.getName() + " kitpvp.kit.stomper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.stomper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.stomper true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.stomper");
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        Coins.removeCoins(p.getName(), 17500.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 17500.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
  }
  
  private Material ItemStack(Material stainedGlassPane, int i, short s) {
	// TODO Auto-generated method stub
	return null;
}

public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
  {
    return false;
  }
}
