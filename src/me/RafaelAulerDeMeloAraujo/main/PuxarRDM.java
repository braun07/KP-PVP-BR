package me.RafaelAulerDeMeloAraujo.main;


import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Scoreboard;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class PuxarRDM
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (!p.hasPermission("kitpvp.puxarrdm"))
    {
      p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVocê nao tem permissAo para executar esse comando");
      return true;
    }
    for (Player p2 : Bukkit.getOnlinePlayers()) {
      if ((p2 != p) && (Habilidade.getAbility(p2) == "RDM"))
      {
        p2.teleport(p);
        Habilidade.setAbility(p2, "RDMFight");
        Habilidade.setAbility(p, "RDMFight");
        p2.sendMessage("§7 " + p.getName() + " puxou todos para comecar o evento RDM !");
        Scoreboard.setScoreBoard(p2);
        Scoreboard.setScoreBoard(p);
      }
    }
    p.sendMessage("§aVoce puxou todos que estao na warp RDM para sua localização !");
    return false;
  }
}
