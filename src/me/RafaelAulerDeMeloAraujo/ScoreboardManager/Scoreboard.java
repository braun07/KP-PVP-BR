package me.RafaelAulerDeMeloAraujo.ScoreboardManager;

import java.util.Map;
import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.Coins.XP;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.main.AntiDeathDrop;
import org.bukkit.entity.Player;

public class Scoreboard
{
  public static void setScoreBoard(Player player)
  {
    SimpleScoreboard scoreboard = new SimpleScoreboard("§4§lTSB §f§lPVP");
    
    int k = AntiDeathDrop.GetKills(player);
    int d = AntiDeathDrop.GetDeaths(player);
    scoreboard.add(" ");
    scoreboard.add("§f Matou: §a" + k);
    scoreboard.add("§f Morreu: §c" + d);
    scoreboard.add("§f Streak: §e" + Streak.killstreak.get(player.getName()));
    scoreboard.add(" ");
    scoreboard.add("§f Moedas: §b" + Coins.getCoins(player.getName()));
    scoreboard.add("§f Nível: §b" + Level.getLevel(player));
    scoreboard.add("§f Grupo: " + GetGrupo(player));
    scoreboard.add(" ");
    scoreboard.add("§f XP: §b" + XP.getXP(player.getName()));
    scoreboard.add("§f Kit: §b" + Habilidade.getAbility(player));
    scoreboard.build();
    TablistPrefix tablistPrefix = new TablistPrefix(scoreboard.getScoreboard());
    tablistPrefix.applyPlayer();
    scoreboard.send(new Player[] { player });
  }
  
  public static String GetGrupo(Player p)
  {
    if (p.hasPermission("*")) {
      return "§4§lDONO";
    }
    if (p.hasPermission("role.diretor")) {
      return "§3§lDIRETOR";
    }
    if (p.hasPermission("role.admin")) {
      return "§c§lADMIN";
    }
    if (p.hasPermission("role.gerente")) {
      return "§4§lGERENTE";
    }
    if (p.hasPermission("role.coordenador")) {
      return "§5§lCOORD";
    }
    if (p.hasPermission("role.modgc")) {
      return "§5§lMODGC";
    }
    if (p.hasPermission("role.moderador")) {
      return "§2§lMOD";
    }
    if (p.hasPermission("role.ajudante")) {
      return "§e§lAJUDANTE";
    }
    if (p.hasPermission("role.builder")) {
      return "§e§lMAPMAKER";
    }
    if (p.hasPermission("role.youtuber")) {
      return "§3§lYOUTUBER§6§l+";
    }
    if (p.hasPermission("role.miniyt")) {
      return "§b§lYOUTUBER";
    }
    if (p.hasPermission("role.partner")) {
      return "§9§lPARCEIRO";
    }
    if (p.hasPermission("role.booster")) {
      return "§d§lBOOSTER";
    }
    if (p.hasPermission("role.mvp+")) {
      return "§b§lMVP§6§l+";
    }
    if (p.hasPermission("role.mvp")) {
      return "§6§lMVP";
    }
    if (p.hasPermission("role.vip")) {
      return "§3§lVIP";
    }
      return "§7§lMEMBRO";
  }
}
