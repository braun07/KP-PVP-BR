package me.RafaelAulerDeMeloAraujo.main;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Crashar
  implements CommandExecutor
{
  public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args)
  {
    if (args.length != 1)
    {
      s.sendMessage("§cUtilize /crash <Jogador>");
      return true;
    }
    if (!s.hasPermission("cmd.crash")) {
    	s.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoce nao tem permissao para executar esse comando.");
    	return true;
    }
    Player p = Bukkit.getPlayer(args[0]);
    if (p == null)
    {
      s.sendMessage("§8(§4§lTSB§f§lPVP§8) §fEsse jogador esta offline");
      return true;
    }
    CrashAPI.crashPlayer(p);
    p.openInventory(Bukkit.createInventory(null, 864));
    s.sendMessage("§8(§4§lTSB§f§lPVP§8) §f" + p.getName() + " foi crashado com sucesso! Voce e do mal");
    Bukkit.broadcast("§8(§4§lTSB§f§lPVP§8) §f" + s.getName() + " crashou o Minecraft de " + p.getName(), "kitpvp.staff");
    return true;
  }
}
