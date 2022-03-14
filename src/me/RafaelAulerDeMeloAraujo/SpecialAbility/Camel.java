package me.RafaelAulerDeMeloAraujo.SpecialAbility;


	
	import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
	
	import org.bukkit.entity.Player;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
	import org.bukkit.event.player.PlayerMoveEvent;
	import org.bukkit.potion.PotionEffect;
	import org.bukkit.potion.PotionEffectType;

import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Scoreboard;
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
		
		/*    */ import org.bukkit.command.Command;
		/*    */ import org.bukkit.command.CommandSender;
		/*    */ 
		/*    */ 
		/*    */ import org.bukkit.inventory.ItemStack;
		/*    */
		/*    */ import org.bukkit.inventory.meta.ItemMeta;
		/*    */ 
		/*    */ public class Camel implements org.bukkit.command.CommandExecutor, Listener
		/*    */ {
		/*    */   private Main main;
		/*    */   static Main plugin;
		/*    */   
		/*    */   public Camel(Main main)
		/*    */   {
		/* 20 */     this.main = main;
		/* 21 */     plugin = main;
		/*    */   }
		/*    */   	@EventHandler
		void onPlayerCamel(PlayerMoveEvent e) {
			Player p = e.getPlayer();
			if (((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SAND)
					|| (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SANDSTONE))
					&& (Habilidade.getAbility(p) == "Camel")) {
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Main.kits.getInt("CamelRegenTime") * 20, Main.kits.getInt("CamelRegenAmplifier")));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Main.kits.getInt("CamelSpeedTime") * 20, Main.kits.getInt("CamelSpeedAmplifier")));
			}
		}
		/*    */ 
		/*    */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
		/*    */   {
		/* 27 */     Player p = (Player)sender;
		/*    */     
		/* 29 */     if (cmd.getName().equalsIgnoreCase("kcamel"))
		/*    */     {
		/*    */ 
		/*    */ /*  69 */       if (!p.hasPermission("kitpvp.kit.camel"))
		/*     */       {
			/*  71 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
			/*  72 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
			/*  73 */         return true;
			/*     */       }
		/*    */ 
		/* 34 */       if (Habilidade.ContainsAbility(p)) {
		/* 35 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
		/* 36 */         p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
		/* 37 */         return true;
		/*    */       }
		/* 39 */       if (!Join.game.contains(p.getName()))
		/*    */       {
		/* 41 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to choose this kit!");
		/* 42 */         return true;
		/*    */       }
		/* 44 */       p.getInventory().clear();
		/* 45 */       ItemStack dima = new ItemStack(Material.STONE_SWORD);
		/* 46 */       ItemMeta souperaa = dima.getItemMeta();
		/* 47 */       souperaa.setDisplayName("§cEspada");
		/* 48 */       dima.setItemMeta(souperaa);
		/* 49 */       ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		/* 50 */       ItemMeta sopas = sopa.getItemMeta();
		/* 51 */       sopas.setDisplayName("§6Sopa");
		/* 52 */       sopa.setItemMeta(sopas);
		/*    */       
		/*    */ 
		/*    */       
		/* 67 */       Habilidade.setAbility(p, "Camel");
		/* 68 */       p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Camel").replace("&", "§"));
		/*    */       Scoreboard.setScoreBoard(p);
		/* 70 */       p.getInventory().addItem(new ItemStack[] { dima });
		/*    */       RTP.TeleportArenaRandom(p);
		/*    */ Main.give(p);
		/*    */ 
		/*    */ 
		/* 75 */       for (int i = 0; i <= 34; i++) {
		/* 76 */         p.getInventory().addItem(new ItemStack[] { sopa });
		/* 77 */         me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), this.main.getConfig().getString("Title.KitTitle"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Camel"));
		/*    */       }
		/*    */     }
		/*    */     
		/*    */ 
		/*    */ 
		/*    */ 
		/*    */ 
		/* 85 */     return false;
		/*    */   }
		/*    */ }


		/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\Basic.class
		 * Java compiler version: 8 (52.0)
		 * JD-Core Version:       0.7.1
		 */
	
