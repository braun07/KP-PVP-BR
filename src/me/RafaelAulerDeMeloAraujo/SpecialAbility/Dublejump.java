/*     */ package me.RafaelAulerDeMeloAraujo.SpecialAbility;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
/*     */ import me.RafaelAulerDeMeloAraujo.main.Main;

import org.bukkit.ChatColor;
/*     */ import org.bukkit.Effect;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.event.player.PlayerToggleFlightEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ public class Dublejump implements Listener, CommandExecutor
/*     */ {
/*     */   private Main main;
/*     */   static Main plugin;
/*     */   
/*     */   public Dublejump(Main main)
/*     */   {
/*  38 */     this.main = main;
/*  39 */     plugin = main;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @EventHandler
/*     */   public void onPlayerToggleFly(PlayerToggleFlightEvent e)
/*     */   {
/*  47 */     Player p = e.getPlayer();
/*  48 */     if (Habilidade.getAbility(p).equalsIgnoreCase("DoubleJump"))
/*     */     {
/*  50 */       if (p.getGameMode() == GameMode.CREATIVE) {
/*  51 */         return;
/*     */       }

/*  53 */       e.setCancelled(true);
/*  54 */       p.setFlying(false);
/*  55 */       p.setAllowFlight(false);
/*  56 */       Location loc = p.getLocation();
/*  57 */       if (!p.isSneaking())
/*     */       {
/*  59 */         p.setFallDistance(-3.0F);
/*  60 */         Vector vector = p.getEyeLocation().getDirection();
/*  61 */         vector.multiply(0.6F);
/*  62 */         vector.setY(1.0F);
/*  63 */         p.setVelocity(vector);
/*     */       }
/*     */       else
/*     */       {
/*  67 */         p.setFallDistance(-3.0F);
/*  68 */         Vector vector = p.getEyeLocation().getDirection();
/*  69 */         vector.multiply(1.35F);
/*  70 */         vector.setY(0.66D);
/*  71 */         p.setVelocity(vector);
/*     */       }
/*  73 */       p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.DoubleJump-Ability")), 1.0F, 1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onDamage(EntityDamageEvent event)
/*     */   {
/*  81 */     Entity e = event.getEntity();
/*  82 */     if ((e instanceof Player))
/*     */     {
/*  84 */       Player player = (Player)e;
/*  85 */       if ((Habilidade.getAbility(player).equalsIgnoreCase("DoubleJump")) && ((event.getEntity() instanceof Player)) && (event.getCause() == EntityDamageEvent.DamageCause.FALL)) {
/*  86 */         event.setDamage(2.0D);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerMove(PlayerMoveEvent e)
/*     */   {
/*  94 */     Player p = e.getPlayer();
/*  95 */     if (Habilidade.getAbility(p).equalsIgnoreCase("DoubleJump"))
/*     */     {
/*  97 */       if (p.getGameMode() == GameMode.CREATIVE) {
/*  98 */         return;
/*     */       }
/* 100 */       if ((p.isOnGround()) && (!p.getAllowFlight())) {
/* 101 */         p.setAllowFlight(true);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void aomorrer(PlayerDeathEvent e)
/*     */   {
/* 109 */     Player p = e.getEntity();
/* 110 */     if (Habilidade.getAbility(p).equalsIgnoreCase("DoubleJump")) {
/* 111 */       p.setAllowFlight(false);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void aomorrer(PlayerQuitEvent e)
/*     */   {
/* 118 */     Player p = e.getPlayer();
/* 119 */     if (Habilidade.getAbility(p).equalsIgnoreCase("DoubleJump")) {
/* 120 */       p.setAllowFlight(false);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*     */   {
/* 129 */     Player p = (Player)sender;
/*     */     
/* 131 */     if (cmd.getName().equalsIgnoreCase("doublejump"))
/*     */     {
/* 133 */       if (!Join.game.contains(p.getName()))
/*     */       {
/* 135 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " Â§eYou are not in kitpvp to do choose this kit!");
/* 136 */         return true;
/*     */       }
/* 138 */       if (!p.hasPermission("kitpvp.kit.doublejump"))
/*     */       {
/* 140 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 141 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
/* 142 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 146 */       if (Habilidade.ContainsAbility(p)) {
/* 147 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 148 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 149 */         return true;
/*     */       }
if (Main.kits.getBoolean("DoubleJumpDisabled")) {
	p.sendMessage(API.NomeServer + ChatColor.RED + "The DoubleJump kit is disabled, sorry");
	return true;
}
/* 151 */       p.getInventory().clear();
/* 152 */       ItemStack dima = new ItemStack(Material.STONE_SWORD);
/* 153 */       ItemMeta souperaa = dima.getItemMeta();
/* 154 */       souperaa.setDisplayName("§cEspada");
/* 155 */       dima.setItemMeta(souperaa);
/* 156 */       ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 157 */       ItemMeta sopas = sopa.getItemMeta();
/* 158 */       sopas.setDisplayName("§6Sopa");
/* 159 */       sopa.setItemMeta(sopas);
/*     */       
/*     */ 
/* 174 */       Habilidade.setAbility(p, "DoubleJump");
/* 175 */       p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "DoubleJump").replace("&", "§"));
/*     */       
/* 177 */       p.getInventory().addItem(new ItemStack[] { dima });
/* 178 */       TitleAPI.sendTitle(p, Integer.valueOf(20), Integer.valueOf(60), Integer.valueOf(20), this.main.getConfig().getString("Title.KitTitle"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "DoubleJump"));
/*     */       RTP.TeleportArenaRandom(p);
/*      
/* 182 */       for (int i = 0; i <= 34; i++) {
/* 183 */         p.getInventory().addItem(new ItemStack[] { sopa });
/*     */       }
Main.give(p);
/*     */     }
/*     */     
/*     */ 
/* 188 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\Dublejump.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
