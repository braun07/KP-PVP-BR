package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import java.io.IOException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import me.RafaelAulerDeMeloAraujo.main.Main;
import net.md_5.bungee.api.ChatColor;



public class RTP {


public static void TeleportArenaRandom(final Player p) {
    final Random dice = new Random();
    final int number = dice.nextInt(4);
    switch (number) {
        case 0: {
        	if (Main.plugin.getConfig().getString("arena1.world") == null) {
        		p.sendMessage(ChatColor.RED + "As arenas nao estao setadas");
        		p.sendMessage(ChatColor.RED + "Peca a um administrador setar as arenas pelo mapa");
        		p.sendMessage(ChatColor.RED + "Com o comando /setarena 1|4");
        		p.sendMessage(ChatColor.RED + "Sete todas as arenas de 1 a 4!");
        		return;
        	}
        	final World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("arena1.world"));
            final double x = Main.plugin.getConfig().getDouble("arena1.x");
            final double y = Main.plugin.getConfig().getDouble("arena1.y");
            final double z = Main.plugin.getConfig().getDouble("arena1.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.plugin.getConfig().getDouble("arena1.pitch"));
            lobby.setYaw((float)Main.plugin.getConfig().getDouble("arena1.yaw"));
            p.getWorld().playEffect(lobby, Effect.ENDER_SIGNAL, 5);
            p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
            p.teleport(lobby);
            break;
        }
        case 1: {
        	if (Main.plugin.getConfig().getString("arena2.world") == null) {
        		p.sendMessage(ChatColor.RED + "As arenas nao estao setadas");
        		p.sendMessage(ChatColor.RED + "Peca a um administrador setar as arenas pelo mapa");
        		p.sendMessage(ChatColor.RED + "Com o comando /setarena 1|4");
        		p.sendMessage(ChatColor.RED + "Sete todas as arenas de 1 a 4!");
        		return;
        	}
        	final World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("arena2.world"));
            final double x = Main.plugin.getConfig().getDouble("arena2.x");
            final double y = Main.plugin.getConfig().getDouble("arena2.y");
            final double z = Main.plugin.getConfig().getDouble("arena2.z");
            final Location lobby2 = new Location(w, x, y, z);
            lobby2.setPitch((float)Main.plugin.getConfig().getDouble("arena2.pitch"));
            lobby2.setYaw((float)Main.plugin.getConfig().getDouble("arena2.yaw"));
            p.getWorld().playEffect(lobby2, Effect.ENDER_SIGNAL, 5);
            p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
            p.teleport(lobby2);
            break;
        }
        case 2: {
        	if (Main.plugin.getConfig().getString("arena3.world") == null) {
        		p.sendMessage(ChatColor.RED + "As arenas nao estao setadas");
        		p.sendMessage(ChatColor.RED + "Peca a um administrador setar as arenas pelo mapa");
        		p.sendMessage(ChatColor.RED + "Com o comando /setarena 1|4");
        		p.sendMessage(ChatColor.RED + "Sete todas as arenas de 1 a 4!");
        		return;
        	}
        	final World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("arena3.world"));
            final double x = Main.plugin.getConfig().getDouble("arena3.x");
            final double y = Main.plugin.getConfig().getDouble("arena3.y");
            final double z = Main.plugin.getConfig().getDouble("arena3.z");
            final Location lobby3 = new Location(w, x, y, z);
            lobby3.setPitch((float)Main.plugin.getConfig().getDouble("arena3.pitch"));
            lobby3.setYaw((float)Main.plugin.getConfig().getDouble("arena3.yaw"));
            p.getWorld().playEffect(lobby3, Effect.ENDER_SIGNAL, 5);
            p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
            p.teleport(lobby3);
            break;
        }
        case 3: {
        	if (Main.plugin.getConfig().getString("arena4.world") == null) {
        		p.sendMessage(ChatColor.RED + "As arenas nao estao setadas");
        		p.sendMessage(ChatColor.RED + "Peca a um administrador setar as arenas pelo mapa");
        		p.sendMessage(ChatColor.RED + "Com o comando /setarena 1|4");
        		p.sendMessage(ChatColor.RED + "Sete todas as arenas de 1 a 4!");
        		return;
        	}
        	final World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("arena4.world"));
            final double x = Main.plugin.getConfig().getDouble("arena4.x");
            final double y = Main.plugin.getConfig().getDouble("arena4.y");
            final double z = Main.plugin.getConfig().getDouble("arena4.z");
            final Location lobby4 = new Location(w, x, y, z);
            lobby4.setPitch((float)Main.plugin.getConfig().getDouble("arena4.pitch"));
            lobby4.setYaw((float)Main.plugin.getConfig().getDouble("arena4.yaw"));
            p.getWorld().playEffect(lobby4, Effect.ENDER_SIGNAL, 5);
            p.getPlayer().playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.0f);
            p.teleport(lobby4);
            break;
        }
    }
}
}
