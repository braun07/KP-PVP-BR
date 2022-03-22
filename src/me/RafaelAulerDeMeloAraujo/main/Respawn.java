package me.RafaelAulerDeMeloAraujo.main;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Gladiator;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
import me.RafaelAulerDeMeloAraujo.X1.X1;

	

	

	public class Respawn implements Listener {
		  @EventHandler
		  public void onDeath(PlayerDeathEvent e) {
		    if (Join.game.contains(e.getEntity().getName())) {
		      Player victim = e.getEntity();
		      e.setDeathMessage("");
		      victim.getWorld().playEffect(victim.getLocation().add(0.0D, 1.0D, 0.0D), Effect.STEP_SOUND, 152);
		      respawnPlayer(victim);
		    } 
		  }
		  
		  @EventHandler(priority = EventPriority.HIGHEST)
		  public void onRespawn(PlayerRespawnEvent e) {
		    Player p = e.getPlayer();
		    if (Join.game.contains(p.getName()) && !X1.lutadores.containsKey(p.getName())) {
		      World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("SpawnD.World"));
		      double x = Main.plugin.getConfig().getDouble("SpawnD.X");
		      double y = Main.plugin.getConfig().getDouble("SpawnD.Y");
		      double z = Main.plugin.getConfig().getDouble("SpawnD.Z");
		      Location lobby = new Location(w, x, y, z);
		      lobby.setPitch((float)Main.plugin.getConfig().getDouble("SpawnD.Pitch"));
		      lobby.setYaw((float)Main.plugin.getConfig().getDouble("SpawnD.Yaw"));
		      e.setRespawnLocation(lobby);
		      Bukkit.getConsoleSender().sendMessage("[DEBUG] " + p.getName() + " Got respawned at " + e.getRespawnLocation());
		    } 
		  }
		  
		  private void respawnPlayer(final Player p) {
		    Location deathLocation = p.getLocation();
		    Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), () -> p.spigot().respawn(), 1L);
		    (new BukkitRunnable() {
		        int time = 5;
		        
		        public void run() {
		          TitleAPI.sendTitle(p, Integer.valueOf(20), Integer.valueOf(40), Integer.valueOf(20), Main.getInstace().getConfig().getString("Title.DeathTitle"), Main.getInstace().getConfig().getString("Title.DeathSubTitle"));
		          p.playSound(p.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("Sound.Respawning")), 3.0F, 3.0F);
		          p.getInventory().clear();
		          p.getInventory().clear();
		          for (PotionEffect effect : p.getActivePotionEffects())
		            p.removePotionEffect(effect.getType()); 
		          p.getInventory().clear();
		          p.getInventory().setHelmet(new ItemStack(Material.AIR));
		          p.getInventory().setChestplate(new ItemStack(Material.AIR));
		          Habilidade.removeAbility(p);
		          Cooldown.remove(p);
		          Deshfire.cooldownm.remove(p);
		          Deshfire.armadura.remove(p);
		          Gladiator.lutando.remove(p);
		          Gladiator.gladgladiator.remove(p);
		          World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("SpawnD.World"));
		          double x = Main.plugin.getConfig().getDouble("SpawnD.X");
		          double y = Main.plugin.getConfig().getDouble("SpawnD.Y");
		          double z = Main.plugin.getConfig().getDouble("SpawnD.Z");
		          Location lobby = new Location(w, x, y, z);
		          lobby.setPitch((float)Main.plugin.getConfig().getDouble("SpawnD.Pitch"));
		          lobby.setYaw((float)Main.plugin.getConfig().getDouble("SpawnD.Yaw"));
		          p.getInventory().clear();
		          p.teleport(lobby);
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
		          p.sendMessage("§8(§4§lTSB§f§lPVP§8)" + ChatColor.WHITE + " Você respawnou!");
		          p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 30, 0));
		          p.playSound(p.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("Sound.RespawnSucess")), 3.0F, 3.0F);
		          p.setGameMode(GameMode.ADVENTURE);
		          cancel();
		        }
		      }).runTaskTimer((Plugin)Main.getInstance(), 0L, 20L);
		  }
		  
		  private ItemStack make(Material material, int amount, int shrt, String displayName, List<String> lore) {
		    ItemStack item = new ItemStack(material, amount, (short)shrt);
		    ItemMeta meta = item.getItemMeta();
		    meta.setDisplayName(displayName);
		    meta.setLore(lore);
		    item.setItemMeta(meta);
		    return item;
		  }
		}