package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import net.md_5.bungee.api.ChatColor;

public class PlayerJoin implements Listener {

/*     */   @EventHandler
/*     */   public void onJoin(PlayerJoinEvent e) {
/*  67 */     Player p = e.getPlayer();
    if (LocationUtils.getLocation() == null && p.isOp()) {
    	p.sendMessage(ChatColor.RED + "O Spawn do Servidor nao esta setado!");
    	p.sendMessage(ChatColor.RED + "Sete o spawn do Servidor com o comando /setspawn");
    	p.sendMessage(ChatColor.RED + "Lembre-se de setar o teleporte dos kits com /setarena 1|4");
    	p.sendMessage(ChatColor.RED + "SETE O SPAWN E AS ARENAS!");
}
}
/*     */   @EventHandler
/*     */   public void on(PlayerRespawnEvent e) {
/*  67 */     Player p = e.getPlayer();
    if (LocationUtils.getLocation() == null && p.isOp()) {
    	p.sendMessage(ChatColor.RED + "O Spawn do Servidor nao esta setado!");
    	p.sendMessage(ChatColor.RED + "Sete o spawn do Servidor com o comando /setspawn");
    	p.sendMessage(ChatColor.RED + "Lembre-se de setar o teleporte dos kits com /setarena 1|4");
    	p.sendMessage(ChatColor.RED + "SETE O SPAWN E AS ARENAS!");
}
}
}