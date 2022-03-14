/*    */ package me.RafaelAulerDeMeloAraujo.SpecialAbility;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;

import org.bukkit.Bukkit;
/*    */ import org.bukkit.Effect;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.BlockFace;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.EventPriority;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class Sponge
/*    */   implements Listener
/*    */ {
/*    */   private Main main;
/*    */   static Main plugin;
/*    */   
/*    */   public Sponge(Main main)
/*    */   {
/* 31 */     this.main = main;
/* 32 */     plugin = main;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/* 37 */   ArrayList<String> fall = new ArrayList<>();
/*    */   
public void Atirar(Player p) {
	int y = Main.getInstance().getConfig().getInt("SpongeBoostAmplifier");
	Block block = p.getLocation().getBlock().getRelative(0, -1, 0);
	if (block.getType() == Material.ENDER_PORTAL_FRAME && Join.game.contains(p.getName())) {
		Vector vector = new Vector(0, y, 0);
		p.setVelocity(vector);
		this.fall.remove(p.getName());
		 p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SpongeUse")), 4.0F, 4.0F);
		p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
		this.fall.add(p.getName());
	}
}
@EventHandler
private void Jumps(PlayerMoveEvent e) {
	Player p = e.getPlayer();
	Atirar(p);
}
 
   @EventHandler
	public void RemoverDano(EntityDamageEvent e) 
	{
	   if (!(e.getEntity() instanceof Player)) {
           return;
       }
		Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL && this.fall.contains(p.getName())) 
		{
			this.fall.remove(p.getName());
			e.setCancelled(true);

		}
		else if(e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK)
		{
			this.fall.remove(p.getName());
		}
	}
	
}
