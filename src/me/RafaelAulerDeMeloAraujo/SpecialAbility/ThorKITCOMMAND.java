/*    */ package me.RafaelAulerDeMeloAraujo.SpecialAbility;
/*    */ 
/*    */ import java.util.ArrayList;

import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Scoreboard;
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class ThorKITCOMMAND implements CommandExecutor
/*    */ {
/*    */   private Main main;
/*    */   static Main plugin;
/*    */   
/*    */   public ThorKITCOMMAND(Main main)
/*    */   {
/* 23 */     this.main = main;
/* 24 */     plugin = main;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*    */   {
/* 30 */     Player p = (Player)sender;
/*    */     
/* 32 */     if (cmd.getName().equalsIgnoreCase("kthor"))
/*    */     {
/* 34 */       if (!Join.game.contains(p.getName()))
/*    */       {
/* 36 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " Â§eYou are not in kitpvp to do choose this kit!");
/* 37 */         return true;
/*    */       }
/* 39 */       if (!p.hasPermission("kitpvp.kit.thor"))
/*    */       {
/* 41 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 42 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
/* 43 */         return true;
/*    */       }
/*    */       
/* 46 */       if (Habilidade.ContainsAbility(p)) {
/* 47 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 48 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 49 */         return true;
/*    */       }
/* 51 */       p.getInventory().clear();
/* 52 */       ItemStack dima = new ItemStack(Material.STONE_SWORD);
/* 53 */       ItemMeta souperaa = dima.getItemMeta();
/* 54 */       souperaa.setDisplayName("§cEspada");
/* 55 */       dima.setItemMeta(souperaa);
/* 56 */       ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 57 */       ItemMeta sopas = sopa.getItemMeta();
/* 58 */       sopas.setDisplayName("§6Sopa");
/* 59 */       sopa.setItemMeta(sopas);
/* 60 */       ItemStack especial = new ItemStack(Material.GOLD_AXE);
/* 61 */       ItemMeta especial2 = especial.getItemMeta();
/* 62 */       especial2.setDisplayName("§cMjolnir");
/* 63 */       especial.setItemMeta(especial2);
/*    */       
/*    */       
/* 78 */       p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Thor").replace("&", "§"));
/* 79 */       Habilidade.setAbility(p, "Thor");
/* 80 */       p.getInventory().addItem(new ItemStack[] { dima });
/* 81 */       p.getInventory().addItem(new ItemStack[] { especial });
/*    */       
/*    */ Scoreboard.setScoreBoard(p);
/*    */ RTP.TeleportArenaRandom(p);
/* 85 */       for (int i = 0; i <= 34; i++) {
/* 86 */         p.getInventory().addItem(new ItemStack[] { sopa });
/* 87 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 88 */         me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI.sendTitle(p, Integer.valueOf(20), Integer.valueOf(60), Integer.valueOf(20), this.main.getConfig().getString("Title.KitTitle"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Thor"));
/*    */       }
Main.give(p);
/*    */     }
/*    */     
/* 92 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\ThorKITCOMMAND.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
