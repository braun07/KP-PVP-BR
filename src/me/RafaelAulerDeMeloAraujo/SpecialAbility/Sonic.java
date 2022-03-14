/*     */ package me.RafaelAulerDeMeloAraujo.SpecialAbility;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
import java.util.concurrent.TimeUnit;

/*     */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Color;
/*     */ import org.bukkit.Effect;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Item;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.player.PlayerDropItemEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ import org.bukkit.util.Vector;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Sonic
/*     */   implements Listener, CommandExecutor
/*     */ {
/*  44 */   public int boost = Integer.valueOf(6).intValue();
/*  45 */  
/*  46 */   static ArrayList<String> fall = new ArrayList();
/*  47 */   public static HashMap<String, ItemStack[]> Armadura = new HashMap();
/*  48 */   public static HashMap<String, ItemStack[]> saveinv = new HashMap();
/*  49 */   public static HashMap<String, ItemStack[]> armadura = new HashMap();
/*  50 */   public static HashMap<String, ItemStack[]> Armadura2 = new HashMap();
/*  51 */   
/*     */   public static Main plugin;
/*     */   
/*     */   @EventHandler
/*     */   public void DeshClick(PlayerInteractEvent event)
/*     */   {
/*  57 */     
/*     */     
/*  59 */     final Player p = event.getPlayer();
/*  60 */     if ((event.getPlayer().getItemInHand().getType() == Material.LAPIS_BLOCK) && 
/*  61 */       (Habilidade.getAbility(p).equalsIgnoreCase("Sonic")))
/*     */     {
/*  63 */       if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
/*  64 */         (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
/*  65 */         (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
/*  66 */         (event.getAction() == Action.RIGHT_CLICK_AIR)) {
/*  67 */         event.setCancelled(true);
/*     */       }

if (Cooldown.add(p)) {
    API.MensagemCooldown(p);
    return;
}

/*  74 */     Cooldown.add(p, Main.kits.getInt("SonicCooldown"));
/*  75 */       fall.add(p.getName());
/*  76 */       p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
/*  77 */       p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
/*  78 */       Location loc = p.getLocation();
/*  79 */       for (Entity pertos : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
/*  80 */         if ((pertos instanceof Player))
/*     */         {	
    if (!Habilidade.ContainsAbility((Player)pertos)) {
    	return;
    }
/*  82 */           Player perto = (Player)pertos;
/*  83 */           ((Player)pertos).damage(Main.kits.getDouble("SonicDamage"));
/*  84 */           pertos.setVelocity(new Vector(0.1D, 0.0D, 0.1D));
/*  85 */           Main.darEfeito(((Player)pertos), org.bukkit.potion.PotionEffectType.POISON, Main.kits.getInt("SonicPoisonTime"), Main.kits.getInt("SonicPoisonAmplifier"));
/*     */         }
/*     */       }
/*  88 */       ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
/*  89 */       LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
/*  90 */       kCapacete.setColor(Color.BLUE);
/*  91 */       Capacete.setItemMeta(kCapacete);
/*  93 */       ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
/*  94 */       LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
/*  95 */       kPeitoral.setColor(Color.BLUE);
/*  96 */       Peitoral.setItemMeta(kPeitoral);
/*  98 */       ItemStack Calss = new ItemStack(Material.LEATHER_LEGGINGS);
/*  99 */       LeatherArmorMeta kCalss = (LeatherArmorMeta)Calss.getItemMeta();
/* 100 */       kCalss.setColor(Color.BLUE);
/* 101 */       Calss.setItemMeta(kCalss);
/* 103 */       ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
/* 104 */       LeatherArmorMeta kBota = (LeatherArmorMeta)Capacete.getItemMeta();
/* 105 */       kBota.setColor(Color.BLUE);
/* 106 */       Bota.setItemMeta(kBota);
/* 108 */       Armadura.put(p.getName(), p.getInventory().getArmorContents());
/*     */       
/* 110 */       p.getInventory().setHelmet(Capacete);
/* 111 */       p.getInventory().setChestplate(Peitoral);
/* 112 */       p.getInventory().setLeggings(Calss);
/* 113 */       p.getInventory().setBoots(Bota);
/* 114 */       p.updateInventory();
/*     */       
/* 116 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 131 */           p.updateInventory();
/* 132 */           Sonic.fall.remove(p.getName());
/*     */         }
/* 134 */       }, 60L);
/*     */       
/* 136 */       Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 140 */           Cooldown.remove(p);
/*     */           
/* 142 */           p.sendMessage((Main.messages.getString("SonicCooldownEnd").replace("&", "§")));
/*     */         }
/*     */         
/* 145 */       }, Main.kits.getInt("SonicCooldown") * 20);
/*     */     }
/*     */   }
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*    */   {
/* 27 */     Player p = (Player)sender;
/*    */     
/* 29 */     if (cmd.getName().equalsIgnoreCase("sonic"))
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/* 34 */       if (Habilidade.ContainsAbility(p)) {
/* 35 */         p.sendMessage(String.valueOf(Main.getInstace().getConfig().getString("Prefix").replace("&", "§")) + Main.getInstace().getConfig().getString("Message.KitUse").replace("&", "§"));
/* 36 */         p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(Main.getInstace().getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 37 */         return true;
/*    */       }
/* 39 */       if (!Join.game.contains(p.getName()))
/*    */       {
/* 41 */         p.sendMessage(String.valueOf(Main.getInstace().getConfig().getString("Prefix").replace("&", "§")) + " Â§eYou are not in kitpvp to choose this kit!");
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
ItemStack esp = new ItemStack(Material.LAPIS_BLOCK);
/* 50 */       ItemMeta esp1 = sopa.getItemMeta();
/* 51 */       esp1.setDisplayName("§6Corrida Sonic");
/* 52 */      esp.setItemMeta(esp1);
/*    */       
/*    */ 
/* 67 */       Habilidade.setAbility(p, "Sonic");
/* 68 */       p.sendMessage(String.valueOf(Main.getInstace().getConfig().getString("Prefix").replace("&", "§")) + Main.getInstace().getConfig().getString("Message.Kit").replaceAll("%kit%", "Sonic").replace("&", "§"));
/*    */       
/* 70 */       p.getInventory().addItem(new ItemStack[] { dima });
/*    */       p.getInventory().addItem(new ItemStack[] { esp });
/*    */ 
/*    */ 
/*    */ RTP.TeleportArenaRandom(p);
/* 75 */       for (int i = 0; i <= 34; i++) {
/* 76 */         p.getInventory().addItem(new ItemStack[] { sopa });
/* 77 */         me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI.sendTitle(p, Integer.valueOf(20), Integer.valueOf(60), Integer.valueOf(20), Main.getInstace().getConfig().getString("Title.KitTitle"), Main.getInstace().getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Sonic"));
/*    */       }
Main.give(p);
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 85 */     return false;
/*    */   }
/*    */ 


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\Basic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
/*     */   
/*     */   @EventHandler
/*     */   public void onDrop(PlayerDropItemEvent event) {
/* 151 */     if (event.getItemDrop().getItemStack().getType() == Material.LAPIS_BLOCK && Habilidade.ContainsAbility(event.getPlayer())) {
/* 152 */       event.setCancelled(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\Deshfire.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
