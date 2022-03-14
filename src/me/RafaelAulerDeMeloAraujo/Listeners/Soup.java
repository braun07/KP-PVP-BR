/*    */ package me.RafaelAulerDeMeloAraujo.Listeners;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
/*    */ 
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;


/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */
/*    */ 
/*    */ public class Soup implements Listener
/*    */ {
/*    */   private Main main;
/* 18 */   public int vida = 7;
public int vida1 = 8;
/* 19 */   public int fome = 7;
/*    */   
/*    */   public Soup(Main main) {
/* 22 */     this.main = main;
/*    */   }
/*    */   
/*    */   @SuppressWarnings("deprecation")
@EventHandler
/*    */   public void UsarSopa(PlayerInteractEvent e) {
/* 27 */     if (e.getItem() == null) {
/* 28 */       return;
/*    */     }

Player p = e.getPlayer();
/* 33 */       if (p.getHealth() < 20.0D && Join.game.contains(p.getName()) && (p.getItemInHand().getType() == Material.MUSHROOM_SOUP)) {
	e.setCancelled(true);
/* 34 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Soup")), 2.0F, 5.0F);
/* 35 */        
/* 36 */         if (!p.hasPermission("kitpvp.dano")) {
/* 37 */         p.setHealth(p.getHealth() + this.vida >= 20.0D ? 20.0D : p.getHealth() + this.vida);
} else {
	p.setHealth(p.getHealth() + this.vida1 >= 20.0D ? 20.0D : p.getHealth() + this.vida1);
}
p.setFoodLevel(20);
/* 38 */         e.getItem().setType(Material.BOWL);

	
/*    */       }
/*    */     }
/*    */   }

/*    */ 


