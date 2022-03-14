package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.RafaelAulerDeMeloAraujo.main.Main;





public class API
{
  
    public static String NomeServer;

    public static String fimcooldown;
	
	  public static String monkCooldownMessage = "§c§bYou cannot use your ability for more: §5 %s seconds!";
	  public String monkedMessage = "§cYou use your ability !";
	  public static int cooldownmonk = 15;
	  public static boolean sendThroughInventory = true;
	  public static transient HashMap<ItemStack, Long> monkStaff = new HashMap<ItemStack, Long>();
	
	public static ArrayList<String> admin = new ArrayList<String>();
	public static ArrayList<String> report = new ArrayList<String>();
	
	public static ArrayList<String> used = new ArrayList<String>();
	public static ArrayList<String> warp = new ArrayList<String>();
	
	public static ArrayList<String> Velotrol2 = new ArrayList<String>();
	public static ArrayList<String> freeze = new ArrayList<String>();
	public static ArrayList<String> freezing = new ArrayList<String>();
	
	public static HashMap<Player, String> kit = new HashMap<Player, String>();
    
    public static void MensagemCooldown(final Player p) {

        p.sendMessage(String.valueOf(API.NomeServer) + (Main.messages.getString("KitCooldown").replace("&", "§")).replace("%time%", String.valueOf(Cooldown.cooldown(p))));
    }
   
    	   static {
    	       
    	        API.NomeServer = Main.getInstance().getConfig().getString("Prefix").replace("&", "§");
    	        API.fimcooldown = Main.getInstance().getConfig().getString("Prefix").replace("&", "§") + (Main.messages.getString("KitCooldownEnd").replace("&", "§"));
    	    
    	    
    	    
    	   }

		
	    public static void tirarArmadura(final Player p) {
	        p.getInventory().setHelmet(new ItemStack(Material.AIR));
	        p.getInventory().setChestplate(new ItemStack(Material.AIR));
	        p.getInventory().setLeggings(new ItemStack(Material.AIR));
	        p.getInventory().setBoots(new ItemStack(Material.AIR));
	    }
	    public static ItemStack darArmadura(final Material material, final Color cor) {
	        final ItemStack item = new ItemStack(material);
	        final LeatherArmorMeta itemm = (LeatherArmorMeta)item.getItemMeta();
	        itemm.setColor(cor);
	        item.setItemMeta((ItemMeta)itemm);
	        return item;
	    }
	    
		  public static void darEfeito(final Player p, final PotionEffectType tipo, final int duracao, final int level) {
		        p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
		    }
			public static String cor(String s) {
				return s.replace("&", "§");
			} 

public static void tirarEfeitos(final Player p) {
    p.removePotionEffect(PotionEffectType.ABSORPTION);
    p.removePotionEffect(PotionEffectType.BLINDNESS);
    p.removePotionEffect(PotionEffectType.CONFUSION);
    p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
    p.removePotionEffect(PotionEffectType.FAST_DIGGING);
    p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
    p.removePotionEffect(PotionEffectType.HARM);
    p.removePotionEffect(PotionEffectType.HEAL);
    p.removePotionEffect(PotionEffectType.HEALTH_BOOST);
    p.removePotionEffect(PotionEffectType.HUNGER);
    p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
    p.removePotionEffect(PotionEffectType.INVISIBILITY);
    p.removePotionEffect(PotionEffectType.JUMP);
    p.removePotionEffect(PotionEffectType.NIGHT_VISION);
    p.removePotionEffect(PotionEffectType.POISON);
    p.removePotionEffect(PotionEffectType.REGENERATION);
    p.removePotionEffect(PotionEffectType.SATURATION);
    p.removePotionEffect(PotionEffectType.SLOW);
    p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
    p.removePotionEffect(PotionEffectType.SPEED);
    p.removePotionEffect(PotionEffectType.WATER_BREATHING);
    p.removePotionEffect(PotionEffectType.WEAKNESS);
    p.removePotionEffect(PotionEffectType.WITHER);
}
public static void ItemSpawn(final Player p) {
	p.getInventory().clear();
	p.getInventory().clear();
	 for (PotionEffect effect : p.getActivePotionEffects()) {
			/*  70 */         p.removePotionEffect(effect.getType());
			/*     */       }
			/*  73 */       p.getInventory().clear();
			/*  74 */       p.getInventory().setHelmet(new ItemStack(Material.AIR));
			/*  75 */       p.getInventory().setChestplate(new ItemStack(Material.AIR));
			/*  76 */       Habilidade.removeAbility(p);
			/*  77 */       me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown.remove(p);
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
			/*     */       Habilidade.setAbility(p, "None");
			p.getInventory().setLeggings(new ItemStack(Material.AIR));
			p.getInventory().setBoots(new ItemStack(Material.AIR));
			ItemStack kits1 = new ItemStack(Material.CHEST);
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

			p.getInventory().setItem(4, kits1);
			p.getInventory().setItem(6, kits);
			p.getInventory().setItem(2, st);
			p.setAllowFlight(false);       
			API.tirarEfeitos(p);
			p.updateInventory();
}
}
