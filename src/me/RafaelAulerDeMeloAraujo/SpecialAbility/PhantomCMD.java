package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Scoreboard;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
import me.RafaelAulerDeMeloAraujo.main.Main;

/*    */ public class PhantomCMD implements org.bukkit.command.CommandExecutor
/*    */ {
/*    */   private Main main;
/*    */   static Main plugin;
/*    */   
/*    */   public PhantomCMD(Main main)
/*    */   {
/* 20 */     this.main = main;
/* 21 */     plugin = main;
/*    */   }
/*    */   

/* 202 */     public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
	/* 186 */     Player p = (Player)sender;
	/* 187 */     ItemStack dima = new ItemStack(Material.STONE_SWORD);
	/* 188 */     ItemMeta souperaa = dima.getItemMeta();
	/* 189 */     souperaa.setDisplayName("§cEspada");
	/* 190 */     dima.setItemMeta(souperaa);
	/* 191 */     ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
	/* 192 */     ItemMeta sopas = sopa.getItemMeta();
	/* 193 */     sopas.setDisplayName("§6Sopa");
	/* 194 */     sopa.setItemMeta(sopas);
	/* 195 */     ItemStack monk = new ItemStack(Material.FEATHER);
	/* 196 */     ItemMeta ims = monk.getItemMeta();
	/* 197 */     ims.setDisplayName("§bVoar!");
	/* 198 */     monk.setItemMeta(ims);
	/*     */     
	/*     */ 
	/*     */ 
	/* 202 */     if (cmd.equalsIgnoreCase("kphantom")) {
	/* 203 */       if (Habilidade.ContainsAbility(p)) {
	/* 204 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
	/* 205 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
	/* 206 */         return true;
	/*     */       }
	/* 208 */       if (!Join.game.contains(p.getName()))
	/*     */       {
	/* 210 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " Â§eYou are not in kitpvp to choose this kit!");
	/* 211 */         return true;
	/*     */       }
	/* 213 */       if (!p.hasPermission("kitpvp.kit.phantom")) {
	/* 214 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", cmd));
	/* 215 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
	/* 216 */         return true;
	/*     */       }
	if (Main.kits.getBoolean("PhantomDisabled")) {
		p.sendMessage(API.NomeServer + ChatColor.RED + "The Phantom kit is disabled, sorry");
		return true;
	}
	/* 218 */       p.getInventory().clear();
	/* 219 */       p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Phantom").replace("&", "Â§"));
	/* 220 */       p.setGameMode(GameMode.ADVENTURE);
	/*     */       
	/* 222 */       Habilidade.setAbility(p, "Phantom");
	/* 235 */       p.getInventory().addItem(new ItemStack[] { dima });
	/* 236 */       p.getInventory().addItem(new ItemStack[] { monk });
	/*     */       
	/* 238 */       for (int i = 0; i <= 34; i++) {
	/* 239 */         p.getInventory().addItem(new ItemStack[] { sopa });
	/*     */       }
	/*     */     }
	/*     */     Scoreboard.setScoreBoard(p);
	/* 243 */     TitleAPI.sendTitle(p, Integer.valueOf(20), Integer.valueOf(60), Integer.valueOf(20), this.main.getConfig().getString("Title.KitTitle"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Phantom"));
	/*     */     RTP.TeleportArenaRandom(p);
	/*     */ Main.give(p);
	/*     */ 
	/* 247 */     return false;
	/*     */   }
	/*     */ }


	/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\Kangaroo.class
	 * Java compiler version: 8 (52.0)
	 * JD-Core Version:       0.7.1
	 */
