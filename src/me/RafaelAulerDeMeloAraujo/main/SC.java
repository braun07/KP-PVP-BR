package me.RafaelAulerDeMeloAraujo.main;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class SC
  implements Listener, CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage("§cThis command is only for players!");
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("sc"))
    {
      if (args.length == 0) {
        sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fUse: §7/sc <MENSAGEM>");
      }
      if (args.length > 0)
      {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
          string.append(args[i] + " ");
        }
        String mensagem = string.toString();
        for (Player arrayOfPlayer : Bukkit.getOnlinePlayers())
        {
          Player staff = arrayOfPlayer;
          if (!sender.hasPermission("kitpvp.staffchat"))
          {
            sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoce nao tem permissão para executar esse comando");
            return true;
          }
          if (staff.hasPermission("kitpvp.staffchat")) {
            staff.sendMessage("§6§l[STAFFCHAT] §f" + sender.getName() + ": §f" + mensagem.replace("&", "§"));
          }
        }
      }
    }
    return false;
  }
}
