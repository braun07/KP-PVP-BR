package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.potion.*;

import me.RafaelAulerDeMeloAraujo.main.Main;


import org.bukkit.plugin.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;
import org.bukkit.event.player.*;
import org.bukkit.event.entity.*;

public class Gladiator implements Listener
{
    public static ArrayList<String> gladgladiator;
    public boolean generateGLASS;
    public HashMap<String, Location> oldl;
    public static HashMap<String, String> lutando;
    public HashMap<Integer, ArrayList<Location>> blocks;
    public HashMap<Player, Location> localizacao;
    public HashMap<Location, Block> bloco;
    public HashMap<Integer, String[]> players;
    public HashMap<String, Integer> tasks;
    int nextID;
    public int id1;
    public int id2;
    
    
    
    static {
        Gladiator.gladgladiator = new ArrayList<String>();
        Gladiator.lutando = new HashMap<String, String>();
    }
    
    public Gladiator() {
        this.generateGLASS = true;
        this.oldl = new HashMap<String, Location>();
        this.blocks = new HashMap<Integer, ArrayList<Location>>();
        this.localizacao = new HashMap<Player, Location>();
        this.bloco = new HashMap<Location, Block>();
        this.players = new HashMap<Integer, String[]>();
        this.tasks = new HashMap<String, Integer>();
        this.nextID = 0;
    }
    
    @EventHandler
    public void aoComando(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (Gladiator.lutando.containsKey(p.getName()) && e.getMessage().startsWith("/")) {
            e.setCancelled(true);
            p.sendMessage(String.valueOf(API.NomeServer) + (Main.messages.getString("NoCommandsInGlad").replace("&", "ง")));
        }
    }
    
    @EventHandler
    public void OnGladiatorKit(final PlayerInteractEntityEvent event) {
        final Player p = event.getPlayer();
        if (event.getRightClicked() instanceof Player) {
            final Player r = (Player)event.getRightClicked();

            if (p.getItemInHand().getType() == Material.IRON_FENCE && Habilidade.getAbility(p).equalsIgnoreCase("Gladiator")) {
                final Location loc = new Location(p.getWorld(), (double)p.getLocation().getBlockX(), (double)(p.getLocation().getBlockY() + 70), (double)p.getLocation().getBlockZ());
                this.localizacao.put(p, loc);
                this.localizacao.put(r, loc);
                final Location loc2 = new Location(p.getWorld(), (double)(p.getLocation().getBlockX() - 5), (double)(p.getLocation().getBlockY() + 70), (double)(p.getLocation().getBlockZ() - 5));
                final Location loc3 = new Location(p.getWorld(), (double)(p.getLocation().getBlockX() + 6), (double)(p.getLocation().getBlockY() + 70), (double)(p.getLocation().getBlockZ() + 6));
                if (Gladiator.lutando.containsKey(p.getName()) || Gladiator.lutando.containsKey(r.getName())) {
                    event.setCancelled(true);
                    p.sendMessage(String.valueOf(API.NomeServer) + (Main.messages.getString("AlreadyInGlad").replace("&", "ง")));
                    return;
                }
                if (!Habilidade.ContainsAbility(r) && Join.game.contains(r.getName())) {
                	p.sendMessage(String.valueOf(API.NomeServer) + (Main.messages.getString("Only-Use-Glad-On-Players-That-Have-Choosed-A-Kit").replace("&", "ง")));
                	event.setCancelled(true);
                	return;
                }
                final Integer currentID = this.nextID;
                ++this.nextID;
                final ArrayList<String> list = new ArrayList<String>();
                list.add(p.getName());
                list.add(r.getName());
                this.players.put(currentID, list.toArray(new String[1]));
                this.oldl.put(p.getName(), p.getLocation());
                this.oldl.put(r.getName(), r.getLocation());
                if (this.generateGLASS) {
                    final List<Location> cuboid = new ArrayList<Location>();
                    cuboid.clear();
                    for (int bX = -8; bX <= 8; ++bX) {
                        for (int bZ = -8; bZ <= 8; ++bZ) {
                            for (int bY = -1; bY <= 4; ++bY) {
                                final Block b = loc.clone().add((double)bX, (double)bY, (double)bZ).getBlock();
                                if (!b.isEmpty()) {
                                    event.setCancelled(true);
                                    p.sendMessage(String.valueOf(API.NomeServer) + (Main.messages.getString("NoGladCreateArena").replace("&", "ง")));
                                    return;
                                }
                                if (bY == 4) {
                                    cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                                }
                                else if (bY == -1) {
                                    cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                                }
                                else if (bX == -8 || bZ == -8 || bX == 8 || bZ == 8) {
                                    cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                                }
                            }
                        }
                    }
                    for (final Location loc4 : cuboid) {
                        loc4.getBlock().setType(Material.GLASS);
                        this.bloco.put(loc4, loc4.getBlock());
                    }
                    loc2.setYaw(-75.0f);
                    p.teleport(loc2);
                    loc3.setYaw(75.0f);
                    r.teleport(loc3);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
                    r.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 110, 5));
                    p.sendMessage(String.valueOf("ง7You challenged the player to gladiator!")); 
                    p.sendMessage(String.valueOf("ง7If dont have a winner for 5 min you go back to your previous location!"));
                    r.sendMessage(String.valueOf("ง7You challenged the player to gladiator!")); 
                    r.sendMessage(String.valueOf("ง7If dont have a winner for 5 min you go back to your previous location!"));
                    Gladiator.lutando.put(p.getName(), r.getName());
                    Gladiator.lutando.put(r.getName(), p.getName());
                    Gladiator.gladgladiator.add(p.getName());
                    Gladiator.gladgladiator.add(r.getName());
                    this.id2 = Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (Gladiator.lutando.containsKey(p.getName()) && Gladiator.lutando.get(p.getName()).equalsIgnoreCase(r.getName()) && Gladiator.lutando.containsKey(r.getName()) && Gladiator.lutando.get(r.getName()).equalsIgnoreCase(p.getName())) {
                                p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 2000000, 3));
                                r.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 2000000, 3));
                            }
                        }
                    }, 2400L);
                    this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            if (Gladiator.lutando.containsKey(p.getName()) && Gladiator.lutando.get(p.getName()).equalsIgnoreCase(r.getName()) && Gladiator.lutando.containsKey(r.getName()) && Gladiator.lutando.get(r.getName()).equalsIgnoreCase(p.getName())) {
                                Gladiator.lutando.remove(p.getName());
                                Gladiator.lutando.remove(r.getName());
                                Gladiator.gladgladiator.remove(p.getName());
                                Gladiator.gladgladiator.remove(r.getName());
                                p.teleport((Location)Gladiator.this.oldl.get(p.getName()));
                                r.teleport((Location)Gladiator.this.oldl.get(r.getName()));
                                Gladiator.this.oldl.remove(p.getName());
                                Gladiator.this.oldl.remove(r.getName());
                                p.sendMessage(String.valueOf(API.NomeServer) + (Main.messages.getString("GladNoWinner").replace("&", "ยง")));
                                r.sendMessage(String.valueOf(API.NomeServer) + (Main.messages.getString("GladNoWinner").replace("&", "ยง")));
                                final Location loc = Gladiator.this.localizacao.get(p);
                                final List<Location> cuboid = new ArrayList<Location>();
                                for (int bX = -8; bX <= 8; ++bX) {
                                    for (int bZ = -8; bZ <= 8; ++bZ) {
                                        for (int bY = -1; bY <= 4; ++bY) {
                                            if (bY == 4) {
                                                cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                                            }
                                            else if (bY == -1) {
                                                cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                                            }
                                            else if (bX == -8 || bZ == -8 || bX == 8 || bZ == 8) {
                                                cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                                            }
                                        }
                                    }
                                }
                                for (final Location loc2 : cuboid) {
                                    loc2.getBlock().setType(Material.AIR);
                                    Gladiator.this.bloco.get(loc2).setType(Material.AIR);
                                }
                            }
                        }
                    }, 4800L);
                }
            }
        }
    }
    
    @EventHandler
    public void onPlayerInteractGlad(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.IRON_FENCE && Habilidade.getAbility(p).equalsIgnoreCase("Gladiator")) {
            e.setCancelled(true);
            p.updateInventory();
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlyaerInteract(final PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_BLOCK && e.getClickedBlock().getType() == Material.GLASS && e.getPlayer().getGameMode() != GameMode.CREATIVE && Gladiator.lutando.containsKey(e.getPlayer().getName())) {
            e.setCancelled(true);
            e.getClickedBlock().setType(Material.BEDROCK);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (Gladiator.lutando.containsKey(e.getPlayer().getName())) {
                        e.getClickedBlock().setType(Material.GLASS);
                    }
                }
            }, 30L);
        }
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onBlockBreak(final BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.GLASS && e.getPlayer().getGameMode() != GameMode.CREATIVE && Gladiator.lutando.containsKey(e.getPlayer().getName())) {
            e.setCancelled(true);
            e.getBlock().setType(Material.BEDROCK);
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
                @Override
                public void run() {
                    if (e.getPlayer().getGameMode() != GameMode.CREATIVE && Gladiator.lutando.containsKey(e.getPlayer().getName())) {
                        e.getBlock().setType(Material.GLASS);
                    }
                }
            }, 30L);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerLeft(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (Gladiator.lutando.containsKey(p.getName())) {
            final Player t = Bukkit.getServer().getPlayer((String)Gladiator.lutando.get(p.getName()));
            Gladiator.lutando.remove(t.getName());
            Gladiator.lutando.remove(p.getName());
            Gladiator.gladgladiator.remove(p.getName());
            Gladiator.gladgladiator.remove(t.getName());
            final Location old = this.oldl.get(t.getName());
            t.teleport(old);
            t.sendMessage(String.valueOf("ยงcThe player " + p.getName() + " logget out!"));
            Bukkit.getScheduler().cancelTask(this.id1);
            Bukkit.getScheduler().cancelTask(this.id2);
            t.removePotionEffect(PotionEffectType.WITHER);
            final Location loc = this.localizacao.get(p);
            final List<Location> cuboid = new ArrayList<Location>();
            for (int bX = -8; bX <= 8; ++bX) {
                for (int bZ = -8; bZ <= 8; ++bZ) {
                    for (int bY = -1; bY <= 4; ++bY) {
                        if (bY == 4) {
                            cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                        }
                        else if (bY == -1) {
                            cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                        }
                        else if (bX == -8 || bZ == -8 || bX == 8 || bZ == 8) {
                            cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                        }
                    }
                }
            }
            for (final Location loc2 : cuboid) {
                loc2.getBlock().setType(Material.AIR);
                this.bloco.get(loc2).setType(Material.AIR);
            }
            for (final Location loc2 : cuboid) {
                loc2.getBlock().setType(Material.AIR);
                this.bloco.get(loc2).setType(Material.AIR);
            }
            for (final Location loc2 : cuboid) {
                loc2.getBlock().setType(Material.AIR);
                this.bloco.get(loc2).setType(Material.AIR);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDeathGladiator(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        if (Gladiator.lutando.containsKey(p.getName())) {
            final Player k = Bukkit.getServer().getPlayer((String)Gladiator.lutando.get(p.getName()));
            final Location old = this.oldl.get(p.getName());
            k.teleport(old);
            k.sendMessage(String.valueOf("ยง7You win the battle against " + p.getName()));
            Bukkit.getScheduler().cancelTask(this.id1);
            Bukkit.getScheduler().cancelTask(this.id2);
            k.removePotionEffect(PotionEffectType.WITHER);
            k.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 10));
            Gladiator.lutando.remove(k.getName());
            Gladiator.lutando.remove(p.getName());
            Gladiator.gladgladiator.remove(p.getName());
            Gladiator.gladgladiator.remove(k.getName());
            final Location loc = this.localizacao.get(p);
            final List<Location> cuboid = new ArrayList<Location>();
            cuboid.clear();
            for (int bX = -8; bX <= 8; ++bX) {
                for (int bZ = -8; bZ <= 8; ++bZ) {
                    for (int bY = -1; bY <= 4; ++bY) {
                        if (bY == 4) {
                            cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                        }
                        else if (bY == -1) {
                            cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                        }
                        else if (bX == -8 || bZ == -8 || bX == 8 || bZ == 8) {
                            cuboid.add(loc.clone().add((double)bX, (double)bY, (double)bZ));
                        }
                    }
                }
            }
            for (final Location loc2 : cuboid) {
                loc2.getBlock().setType(Material.AIR);
                if (this.bloco.containsKey(loc2)) {
                    this.bloco.get(loc2).setType(Material.AIR);
                }
            }
        }
    }
}
