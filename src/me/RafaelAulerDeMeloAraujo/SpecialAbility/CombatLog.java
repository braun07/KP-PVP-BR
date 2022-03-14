package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import java.util.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.plugin.*;
import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.main.Main;

import org.bukkit.event.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;

public class CombatLog implements Listener
{
    public static HashMap<Player, Player> emcombate;
    
    static {
        CombatLog.emcombate = new HashMap<Player, Player>();
    }
    
    public static boolean emCombate(final Player p) {
        return CombatLog.emcombate.containsKey(p);
    }
    
    public static String statuscombat(final Player p) {
        String nome = "";
        if (emCombate(p)) {
            nome = "§aSim §2";
        }
        else if (!emCombate(p)) {
            nome = "§cNao §4";
        }
        return nome;
    }
    
    @EventHandler
    public void aocombatlog(final EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player hitter = (Player)e.getDamager();
            if (Habilidade.getAbility(p) != "None" && Habilidade.getAbility(hitter) != "None" && !CombatLog.emcombate.containsKey(p) && !CombatLog.emcombate.containsKey(hitter)) {
                CombatLog.emcombate.put(p, hitter);
                CombatLog.emcombate.put(hitter, p);
                hitter.sendMessage("§8(§4§lTSB§f§lPVP§8)§7Voce esta em combate com §c" + p.getDisplayName());
                p.sendMessage("§8(§4§lTSB§f§lPVP§8)§7Voce esta em combate com §c" + hitter.getDisplayName());
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        CombatLog.emcombate.remove(p);
                        CombatLog.emcombate.remove(hitter);
                        hitter.sendMessage("§8(§4§lTSB§f§lPVP§8) §7Voce agora esta fora de combate");
                        p.sendMessage("§8(§4§lTSB§f§lPVP§8)§7Voce agora esta fora de combate");
                    }
                }, 140L);
            }
        }
    }
    
    @EventHandler
    public void aomorrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        if (CombatLog.emcombate.containsKey(p.getName())) {
            final Player t = CombatLog.emcombate.get(p.getName());
            p.teleport(p.getWorld().getSpawnLocation());
            t.sendMessage("§8(§4§lTSB§f§lPVP§8)§7Voce esta fora de combate");
            CombatLog.emcombate.remove(p);
            CombatLog.emcombate.remove(t);
        }
    }
    
    @EventHandler
    public void aosair(PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (CombatLog.emcombate.containsKey(p.getName())) {
            final Player t = CombatLog.emcombate.get(p.getName());
            p.setHealth(0.0);
            p.teleport(p.getWorld().getSpawnLocation());
            CombatLog.emcombate.remove(p);
            CombatLog.emcombate.remove(t);
            Bukkit.broadcastMessage(API.NomeServer + "§c " + p.getName() + "§7 Deslogou No Meio do PvP e perdeu 300 coins!");
            Coins.removeCoins(t.getName(), 300);
            t.sendMessage("§8(§4§lTSB§f§lPVP§8 §7Voce esta fora de combate");
        }
    }
    
    @EventHandler
    public void aocomando(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        if (e.getMessage().toLowerCase().startsWith("/") && CombatLog.emcombate.containsKey(p)) {
            p.sendMessage(API.NomeServer + " §7Voce nao pode usar comandos em combate!");
            e.setCancelled(true);
        }
    }
}