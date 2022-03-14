package me.RafaelAulerDeMeloAraujo.main;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scoreboard.DisplaySlot;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Gladiator;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;


public class Evento implements CommandExecutor, Listener {

	public static boolean evento = false;
	public static boolean stats = true;
	public static boolean pvp = false;

	public static List<String> participantes = new ArrayList<String>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (args.length > 2) {
			sender.sendMessage("§§aUtilize: /evento para entrar em evento");
			}
		if (args.length == 0) {
			if (Main.plugin.getConfig().getString("EVENTO.World") == null) {
				sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fO Evento não esta setado.");
				if (sender.hasPermission("kitpvp.evento"))
				sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fUtilize /setevento para setar local do evento");
			}
			if (!evento) {
				sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fNo momento nao ha nenhum evento iniciado.");
				if (sender.hasPermission("kitpvp.evento"))
					sender.sendMessage("§a§lTUTORIAL DE EVENTOS");
					sender.sendMessage("§a§lEVENTO §fUtilize /evento iniciar para abrir o  evento");
					sender.sendMessage("§a§lEVENTO §fUtilize /evento pvp para ativar pvp no evento");
					sender.sendMessage("§a§lEVENTO §fUtilize /evento fechar para fechar o evento");
					sender.sendMessage("§a§lEVENTO §fUtilize /evento abrir para reabrir o evento");
					sender.sendMessage("§a§lEVENTO §fUtilize /evento finalizar para finalizar o evento");
				return true;
			}
			if (!stats) {
				sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fO evento ja iniciou, nao e possivel entrar!");
				return true;
			}
			if (participantes.contains(sender.getName())) {
				sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVocê ja esta em um evento.");
				return true;
			}
			Habilidade.setAbility(p, "Evento");
			p.setGameMode(GameMode.ADVENTURE);
			p.getInventory().clear();
			p.getInventory().setArmorContents(null);
			sender.sendMessage("§a§lEVENTO §fVoce entrou no evento.");
			ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
	         espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
	         espada.addEnchantment(Enchantment.DURABILITY, 3);
	         p.getInventory().setItem(0, espada);
	         ItemStack capacete = new ItemStack(Material.IRON_HELMET);
				ItemMeta capaceteMeta = capacete.getItemMeta();
				capaceteMeta.setDisplayName("§§eArmadura");
				
				ItemStack peitoral = new ItemStack(Material.IRON_CHESTPLATE);
				ItemMeta peitoralMeta = peitoral.getItemMeta();
				peitoralMeta.setDisplayName("§§eArmadura");
				
				ItemStack calca = new ItemStack(Material.IRON_LEGGINGS);
				ItemMeta calcaMeta = calca.getItemMeta();
				calcaMeta.setDisplayName("§§eArmadura");
				
				ItemStack bota = new ItemStack(Material.IRON_BOOTS);
				ItemMeta botaMeta = bota.getItemMeta();
				botaMeta.setDisplayName("§§eArmadura");
	         ItemStack sopas = new ItemStack(Material.BOWL, 64);
	         ItemMeta ksopas = sopas.getItemMeta();
	         sopas.setItemMeta(ksopas);
	         ItemStack cogur = new ItemStack(Material.INK_SACK, 64, (short)3);
	         ItemMeta kcogur = cogur.getItemMeta();
	         cogur.setItemMeta(kcogur);
	         ItemStack cogum = new ItemStack(Material.INK_SACK, 64, (short)3);
	         ItemMeta kcogum = cogum.getItemMeta();
	         cogum.setItemMeta(kcogum);
	         p.getInventory().setItem(13, sopas);
	         p.getInventory().setItem(14, sopas);
	         p.getInventory().setItem(15, cogur);
	         p.getInventory().setItem(16, cogum);
	         p.setFireTicks(0);
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	         p.getInventory().addItem(new ItemStack[]{new ItemStack(Material.MUSHROOM_SOUP, 1)});
	        bota.setItemMeta(botaMeta);
			calca.setItemMeta(calcaMeta);
			peitoral.setItemMeta(peitoralMeta);
			capacete.setItemMeta(capaceteMeta);
			p.getInventory().setHelmet(capacete);
			p.getInventory().setChestplate(peitoral);
			p.getInventory().setLeggings(calca);
			p.getInventory().setBoots(bota);
	        World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("EVENTO.World"));
	        double x = Main.plugin.getConfig().getDouble("EVENTO.X");
	        double y = Main.plugin.getConfig().getDouble("EVENTO.Y");
	        double z = Main.plugin.getConfig().getDouble("EVENTO.Z");
	        Location lobby = new Location(w, x, y, z);
	        lobby.setPitch((float)Main.plugin.getConfig().getDouble("EVENTO.Pitch"));
	        lobby.setYaw((float)Main.plugin.getConfig().getDouble("EVENTO.Yaw"));
	        p.teleport(lobby);
			p.getActivePotionEffects().forEach(potionEffect -> p.removePotionEffect(potionEffect.getType()));
			p.setFireTicks(0);
			participantes.add(sender.getName());
			return true;
	}
	{
		if (args[0].equalsIgnoreCase("iniciar")) {
			if (sender.hasPermission("kitpvp.evento")) {
				if (evento) {
					sender.sendMessage("§c§lEVENTO §fJa tem um Evento ocorrendo no momento.");
					return true;
				}
				p.getInventory().clear();
				p.setGameMode(GameMode.CREATIVE);
		        World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("EVENTO.World"));
		        double x = Main.plugin.getConfig().getDouble("EVENTO.X");
		        double y = Main.plugin.getConfig().getDouble("EVENTO.Y");
		        double z = Main.plugin.getConfig().getDouble("EVENTO.Z");
		        Location lobby = new Location(w, x, y, z);
		        lobby.setPitch((float)Main.plugin.getConfig().getDouble("EVENTO.Pitch"));
		        lobby.setYaw((float)Main.plugin.getConfig().getDouble("EVENTO.Yaw"));
		        p.teleport(lobby);
				evento = true;
				stats = true;
				pvp = false;
				Bukkit.broadcastMessage("§a§lEVENTO §fO evento ARENA foi iniciado!");
				Bukkit.broadcastMessage("§a§lEVENTO §fUtilize /evento para entrar");
				p.sendMessage("§a§lEVENTO §fUtilize /evento pvp para ativar pvp no evento");
				p.sendMessage("§a§lEVENTO §fUtilize /evento fechar para fechar o evento");
				p.sendMessage("§a§lEVENTO §fUtilize /evento abrir para reabrir o evento");
				p.sendMessage("§a§lEVENTO §fUtilize /evento finalizar para finalizar o evento");
				return true;
			} else {
				p.sendMessage("§cVocê nao tem permissao");
			}
		}
		if (args[0].equalsIgnoreCase("abrir")) {
			if (sender.hasPermission("kitpvp.evento")) {
				if (stats) {
					sender.sendMessage("§c§lEVENTO §fO evento ja esta aberto!");
					return true;
				}
				stats = true;	
				Bukkit.broadcastMessage("\n§c§lEVENTO §§fO evento ARENA foi aberto!\n§eUtilize /evento ");
				return true;
			} else {
				p.sendMessage("§cVocê nao tem permissao");
			}
		}
		if (args[0].equalsIgnoreCase("pvp")) {
			if (sender.hasPermission("kitpvp.evento")) {
				if (!evento) {
					sender.sendMessage("§§c§§lEVENTO §fNo momento nao ha nenhum evento iniciado!");
					return true;
				}
				if (pvp) {
					pvp = false;
					sender.sendMessage("§c§lEVENTO §fO dano do evento foi desabilitado!");
				} else {
					pvp = true;
					sender.sendMessage("§a§lEVENTO §fO dano do evento foi habilitado!");
				}
				return true;
			} else {
				p.sendMessage("§§cVocê nao tem permissao");
			}
		}
		if (args[0].equalsIgnoreCase("fechar")) {
			if (!stats) {
				sender.sendMessage("§c§lEVENTO §§fO evento ja esta fechado!");
				return true;
			}
			stats = false;
			if (sender.hasPermission("kitpvp.evento")) {
			Bukkit.broadcastMessage("\n§c§lEVENTO §fO evento ARENA foi fechado!\n");	
			return true;
			} else {
				p.sendMessage("§cVocê nao tem permissao");
			}
		}
		if (args[0].equalsIgnoreCase("finalizar")) {
			if (sender.hasPermission("kitpvp.evento")) {
				if (!evento) {
					sender.sendMessage("§c§lEVENTO §fNo momento nao ha nenhum evento iniciado!");
					return true;
				}
				stats = false;
				evento = false;
				pvp = false;
				for (Player todos : Bukkit.getOnlinePlayers()) {
					if (participantes.contains(todos.getName())) {
						participantes.remove(todos.getName());

						todos.getInventory().setArmorContents(null);
						todos.getInventory().clear();
						todos.getInventory().setArmorContents(null);
						
				    	/*  92 */       p.getInventory().setLeggings(new ItemStack(Material.AIR));
				    	/*  93 */       p.getInventory().setBoots(new ItemStack(Material.AIR));
				    	/*  94 */       ItemStack kits1 = new ItemStack(Material.CHEST);
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

				    	todos.getInventory().setItem(4, kits1);
				    	todos.getInventory().setItem(6, kits);
				    	todos.getInventory().setItem(2, st);
						
						
								
				    	/*  82 */       org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
				    	/*  83 */       double x = Main.plugin.getConfig().getDouble("Spawn.X");
				    	/*  84 */       double y = Main.plugin.getConfig().getDouble("Spawn.Y");
				    	/*  85 */       double z = Main.plugin.getConfig().getDouble("Spawn.Z");
				    	/*  86 */       Location lobby = new Location(w, x, y, z);
				    	/*  87 */       lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
				    	/*  88 */       lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
				    	/*  90 */       todos.teleport(lobby);
				    	/*  76 */       Habilidade.removeAbility(todos);
				    	/*  78 */       Deshfire.cooldownm.remove(todos);
				    	/*  79 */       Deshfire.armadura.remove(todos);
				    	/*  80 */       Gladiator.lutando.remove(todos);
				    	/*  81 */       Gladiator.gladgladiator.remove(todos);
						todos.setGameMode(GameMode.ADVENTURE);
						todos.setFireTicks(00);
						todos.setNoDamageTicks(0);
						todos.setHealth(20);
						todos.setFoodLevel(20);
						todos.sendMessage("§c§lEVENTO §fO evento foi finalizado, voce foi teleportado para o spawn!");
					}
				}
				Bukkit.broadcastMessage(
						"\n§c§lEVENTO §fO evento ARENA foi finalizado!\n");
				return true;
			} else {
				p.sendMessage("§cVocê nao tem permissao");
			}
		}
		return false;
	}
	}

	@EventHandler
	public void danoEvent(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			if (!pvp && participantes.contains(e.getEntity().getName())) {
				e.setDamage(0.0);
				e.setCancelled(true);
				return;
			}
		}
	}

}

