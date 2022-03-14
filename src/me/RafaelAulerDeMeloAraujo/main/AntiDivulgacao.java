package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;

public class AntiDivulgacao implements Listener
{
    public static void msg(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (e.getMessage().contains(".net") || e.getMessage().contains(".com") || e.getMessage().contains("https") || e.getMessage().contains("www") || e.getMessage().contains(".br") || e.getMessage().contains(".host") || e.getMessage().contains("-net") || e.getMessage().contains("-mc") || e.getMessage().contains("-mc") || e.getMessage().contains("mc.") || e.getMessage().contains(".tk") || e.getMessage().contains(".it") || e.getMessage().contains(".ml") || e.getMessage().contains(".ga") || e.getMessage().contains(".cf") || e.getMessage().contains(".gq") || e.getMessage().contains(".biz") || e.getMessage().contains(".net") || e.getMessage().contains("play.") || e.getMessage().contains(".play") || e.getMessage().contains(".pvp") || e.getMessage().contains(".us") || e.getMessage().contains("%") &&  !e.getPlayer().hasPermission("kitpvp.divulgar")) {
            p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoc\u00ea n\u00e3o tem permissao para divulgar.");
            e.setCancelled(true);
        }
    }
}
