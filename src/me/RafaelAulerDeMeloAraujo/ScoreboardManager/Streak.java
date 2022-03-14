/*     */ package me.RafaelAulerDeMeloAraujo.ScoreboardManager;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
/*     */ import me.RafaelAulerDeMeloAraujo.main.Main;
import net.md_5.bungee.api.chat.BaseComponent;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Sound;
import org.bukkit.World;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Streak
/*     */   implements Listener
/*     */ {
/*     */   private Main main;
/*     */   static Main plugin;
/*     */   
/*     */   public Streak()
/*     */   {
/*  31 */     this.main = this.main;
/*  32 */     plugin = this.main;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  40 */   public static Map<String, Integer> killstreak = new HashMap();
/*     */   
/*     */   public void onEnable() {}
/*     */   
/*     */   @EventHandler
/*  45 */   public void playerdeath(PlayerDeathEvent ev) { Player p = ev.getEntity();
/*  46 */     if ((p.getKiller() instanceof Player))
/*     */     {
/*     */ 
/*  49 */       Player killer = p.getKiller();
/*  50 */       if (Join.game.contains(killer.getName()))
/*     */       {
/*  52 */       p.sendMessage(API.NomeServer + "" + (Main.messages.getString("StreakDestroyed").replace("&", "§").replace("%player%", killer.getName()))); }
/*  53 */       addtokillstreak(killer);
/*  54 */       killstreak.put(p.getName(), Integer.valueOf(0));
/*     */     }
/*     */   }
/*     
*/  

/*     */ 
/*     */   public void addtokillstreak(Player killer)
/*     */   {
/*  61 */     String name = killer.getName();
/*  62 */     if (killstreak.containsKey(name) && Join.game.contains(name))
/*     */     {
/*  64 */       int kills = ((Integer)killstreak.get(name)).intValue();
/*  65 */       kills++;
/*  66 */       killstreak.put(name, Integer.valueOf(kills));
/*     */       
/*  68 */       killer.sendMessage(API.NomeServer + "" + "§fVoce esta com KillStreak de " + ChatColor.RED + Integer.toString(kills) + "§f Kills.");
/*  69 */       if (kills == 100 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "100").replace("%player%", name) , killer.getWorld());
/*  73 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-100") + " Coins!");
/*  74 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-100"));
/*     */       }
/*  76 */       if (kills == 90 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "90").replace("%player%", name) , killer.getWorld());
/*  80 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-90") + " Coins!");
/*  81 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-90"));
/*     */       }
/*  76 */      if (kills == 80 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "80").replace("%player%", name) , killer.getWorld());
/*  80 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-80") + " Coins!");
/*  81 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-80"));
/*     */       }
if (kills == 70 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "70").replace("%player%", name) , killer.getWorld());
/*  80 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-70") + " Coins!");
/*  81 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-70"));
/*     */       }
/*  83 */       if (kills == 65 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "65").replace("%player%", name) , killer.getWorld());
/*  87 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-65") + " Coins!");
/*  88 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-65"));
/*     */       }
/*  83 */       if (kills == 60 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "60").replace("%player%", name) , killer.getWorld());
/*  87 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-60") + " Coins!");
/*  88 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-60"));
/*     */       }
if (kills == 55 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "55").replace("%player%", name) , killer.getWorld());
/* 101 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-30") + " Coins!");
/* 102 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-30"));
/*     */       }
/*  90 */       if (kills == 50 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "50").replace("%player%", name) , killer.getWorld());
/*  94 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-50") + " Coins!");
/*  95 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-50"));
/*     */       }
if (kills == 45 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "45").replace("%player%", name) , killer.getWorld());
/* 101 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-30") + " Coins!");
/* 102 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-30"));
/*     */       }
if (kills == 40 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "40").replace("%player%", name) , killer.getWorld());
/* 101 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-40") + " Coins!");
/* 102 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-40"));
/*     */       }
if (kills == 35 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "35").replace("%player%", name) , killer.getWorld());
/* 101 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-30") + " Coins!");
/* 102 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-30"));
/*     */       }
/*  97 */       if (kills == 30 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "30").replace("%player%", name) , killer.getWorld());
/* 101 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-30") + " Coins!");
/* 102 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-30"));
/*     */       }
/*  97 */       if (kills == 25 && (Join.game.contains(name)))
/*     */       {
	
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "25").replace("%player%", name) , killer.getWorld());
/* 101 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-25") + " Coins!");
/* 102 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-25"));
/*     */       }
/* 104 */       if (kills == 20 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "20").replace("%player%", name) , killer.getWorld());
/* 108 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-20") + " Coins!");
/* 109 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-20"));
/*     */       }
/* 104 */       if (kills == 15 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "15").replace("%player%", name) , killer.getWorld());
/* 108 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-15") + " Coins!");
/* 109 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-15"));
/*     */       }
/* 111 */       if (kills == 10 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "10").replace("%player%", name) , killer.getWorld());
/* 115 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-10") + " Coins!");
/* 116 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-10"));
/*     */       }
/* 118 */       if (kills == 5 && (Join.game.contains(name)))
/*     */       {
	broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "5").replace("%player%", name) , killer.getWorld());
/* 122 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-5") + " Coins!");
/* 123 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-5"));
/*     */       }
/* 118 */       if (kills == 3 && (Join.game.contains(name)))
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + Main.messages.getString("KillStreakBroadcast").replace("&", "§").replace("%killstreak%", "3").replace("%player%", name) , killer.getWorld());
/* 122 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "Voce recebeu " + Main.customization.getDouble("KS-3") + " Coins!");
/* 123 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-3"));
/*     */       }
/*     */       
/*     */     }
/*     */   }
/*     */ 

  public void broadcast(String text, World w){
    for(Player p: w.getPlayers()){
        p.sendMessage(text);
    }
  }}
/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\ScoreboardManager\Streak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
