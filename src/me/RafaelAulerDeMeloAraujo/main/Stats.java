/*    */ package me.RafaelAulerDeMeloAraujo.main;
/*    */ 
/*    */ 
/*    */ import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.Coins.XP;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Level;
/*    */ import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
/*    */ 
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class Stats implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 18 */     Player p = (Player)sender;
/* 19 */     if (cmd.getName().equalsIgnoreCase("stats"))
/*    */     {
/* 22 */       if (args.length == 0) {
/* 23 */         int kills = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
/* 24 */         int deaths = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".deaths");
/*    */         p.sendMessage("§eSeu Status");
/* 26 */         p.sendMessage("§b");      
/* 28 */         p.sendMessage("§bKills §8\u279C§e " + kills);
/* 29 */         p.sendMessage("§bDeaths §8\u279C§e " + deaths);        
/* 31 */         p.sendMessage("§bMoedas §8\u279C§e " + Coins.getCoins(p.getName()));
/* 32 */         p.sendMessage("§bStreak §8\u279C§e " + Streak.killstreak.get(p.getName()));
                 p.sendMessage("§bXP §8\u279C§e " + XP.getXP(p.getName()));
                 p.sendMessage("§bLevel §8\u279C§e " + Level.getLevel(p));
/* 33 */         p.sendMessage("§b");
/* 34 */         return true;
/*    */       }       
/* 37 */       if ((args.length > 0) && (args.length < 2) && (p.hasPermission("kitpvp.stats.see.other"))) {
/* 38 */         Player t = org.bukkit.Bukkit.getServer().getPlayer(args[0]);
/* 39 */         if (t != null) {
/* 40 */           int kills = Main.plugin.getConfig().getInt("status." + t.getName().toLowerCase() + ".kills");
/* 41 */           int deaths = Main.plugin.getConfig().getInt("status." + t.getName().toLowerCase() + ".deaths");
/* 42 */           p.sendMessage("§b");
/* 43 */           p.sendMessage("§bPlayer §8\u279C§e " + t.getName());
/* 44 */           p.sendMessage("§bKills §8\u279C§e " + kills);
/* 45 */           p.sendMessage("§bDeaths §8\u279C§e " + deaths);          
/* 47 */           p.sendMessage("§bMoedas §8\u279C§e " + Coins.getCoins(t.getName()));
/* 48 */           p.sendMessage("§bStreak §8\u279C§e " + Streak.killstreak.get(t.getName()));
                   p.sendMessage("§bXP §8\u279C§e " + XP.getXP(t.getName()));
                   p.sendMessage("§bLevel §8\u279C§e " + Level.getLevel(t));
/* 49 */           p.sendMessage("§b");
/*    */         }
/*    */       }
/*    */     }     
/* 54 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\main\Stats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
