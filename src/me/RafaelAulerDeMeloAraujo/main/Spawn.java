package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Scoreboard;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Gladiator;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;

public class Spawn
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
      return false;
    }
    Player p = (Player)sender;
    	 p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fTeleportando em 3 segundos!");
    	 p.getInventory().clear();
    	 p.setHealth(1.0);
    	 API.darEfeito(p, PotionEffectType.SLOW, 99, 100);
    	 API.darEfeito(p, PotionEffectType.BLINDNESS, 99, 100);
    	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
    			{
          public void run()
          {
    /* 406 */   for (PotionEffect effect : p.getActivePotionEffects()) {
    	/*  70 */         p.removePotionEffect(effect.getType());
    	/*     */       }
    	/*  72 */       p.sendMessage(String.valueOf(Main.getInstace().getConfig().getString("Prefix").replace("&", "§")) + Main.getInstace().getConfig().getString("Message.Clear").replace("&", "§"));
    	/*  73 */       p.getInventory().clear();
    	/*  74 */       p.getInventory().setHelmet(new ItemStack(Material.AIR));
    	/*  75 */       p.getInventory().setChestplate(new ItemStack(Material.AIR));
    	/*  76 */       Habilidade.removeAbility(p);
    	/*  78 */       Deshfire.cooldownm.remove(p);
    	/*  79 */       Deshfire.armadura.remove(p);
    	/*  80 */       Gladiator.lutando.remove(p);
    	/*  81 */       Gladiator.gladgladiator.remove(p);
    	/*  82 */       org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
    	/*  83 */       double x = Main.plugin.getConfig().getDouble("Spawn.X");
    	/*  84 */       double y = Main.plugin.getConfig().getDouble("Spawn.Y");
    	/*  85 */       double z = Main.plugin.getConfig().getDouble("Spawn.Z");
    	/*  86 */       Location lobby = new Location(w, x, y, z);
    	/*  87 */       lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
    	/*  88 */       lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
    	/*  89 */       p.getInventory().clear();
    	/*  90 */       p.teleport(lobby);
    	/*     */       p.setHealth(20);
    	/*  92 */       p.getInventory().setLeggings(new ItemStack(Material.AIR));
    	/*  93 */       p.getInventory().setBoots(new ItemStack(Material.AIR));
    	/*  94 */       ItemStack kits1 = new ItemStack(Material.CHEST);
    	/*  96 */       ItemMeta kits12 = kits1.getItemMeta();
    	/*  97 */       kits12.setDisplayName(Main.messages.getString("KitItemName").replace("&", "§"));
    	/*  98 */       kits1.setItemMeta(kits12);
    	/*  95 */       ItemStack kits = new ItemStack(Material.DIAMOND);
    	/*  96 */       ItemMeta kits2 = kits.getItemMeta();
    	/*  97 */       kits2.setDisplayName(Main.messages.getString("ShopItemName").replace("&", "§"));
    	/*  98 */       kits.setItemMeta(kits2);
    	/*  99 */       ItemStack st = new ItemStack(Material.COMPASS);
    	/* 100 */       ItemMeta st2 = st.getItemMeta();
    	/* 101 */       st2.setDisplayName(Main.messages.getString("1v1ItemName").replace("&", "§"));
    	/* 102 */       st.setItemMeta(st2);
    	ItemStack stats = new ItemStack(Material.NAME_TAG);
    	/* 227 */           ItemMeta stats2 = kits.getItemMeta();
    	/* 228 */           stats2.setDisplayName(Main.messages.getString("StatsItemName").replace("&", "§"));
    	/* 229 */           stats.setItemMeta(stats2);
    	
    	ItemStack stats1 = new ItemStack(Material.WOOD_SWORD);
    	/* 227 */           ItemMeta stats12 = stats1.getItemMeta();
    	/* 228 */           stats12.setDisplayName(Main.messages.getString("ClickTestItemName").replace("&", "§"));
    	/* 229 */           stats1.setItemMeta(stats12);

    	/* 103 */     
Scoreboard.setScoreBoard(p);
    	p.getInventory().setItem(4, kits1);
    	p.getInventory().setItem(6, kits);
    	p.getInventory().setItem(2, st);
    	/*     */       p.setAllowFlight(false);
    	/*     */ p.setHealth(20);
    	/* 107 */    
    	/*     */       
    	/*     */ API.tirarEfeitos(p);
    	/* 107 */       p.updateInventory();
    /*     */         

    /*     */         
    /*     */ 
    /*     */ 
    /*     */ 
    /* 159 */         ((Player)p).playSound(((Player)p).getLocation(), Sound.valueOf(Main.getInstace().getConfig().getString("Sound.SucefullMessage")), 2.0F, 2.0F);
    /* 160 */           	         } }, 60L);
		return false;
    	}
    }
