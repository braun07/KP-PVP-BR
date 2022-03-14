package me.RafaelAulerDeMeloAraujo.main;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class TP
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(API.NomeServer + "§fComandos apenas no servidor!");
      return true;
    }
    Player player = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tp"))
    {
      if (!player.hasPermission("kitpvp.staff"))
      {
    	  player.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoce nao tem permissao para executar esse comando");
        return true;
      }
      if (args.length == 0)
      {
        player.sendMessage(API.NomeServer + "§fUse /tp [player] para ir ate um player!");
        player.sendMessage(API.NomeServer + "§fUse /s [player] para puxar um player ate voce!");
        return true;
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        if ((target == null) || (!(target instanceof Player)))
        {
          player.sendMessage(API.NomeServer + "§fJogador nao encontrado!");
          return true;
        }
        player.teleport(target);
        Bukkit.getLogger().info("§4§l" + player.getName() + " §fTeleportou-se ate §4§l" + target.getName());
        Bukkit.broadcast(API.NomeServer + "§4§l" + player.getName() + ChatColor.GRAY + "§f se teleportou para: §4§l" + target.getName(), "kitpvp.staff");
        return true;
      }
      if (args.length > 1)
      {
        player.sendMessage(API.NomeServer + "§fUse /tp [player] para ir ate um player!");
        player.sendMessage(API.NomeServer + "§fUse /s [player] para puxar um player ate voce!");
        return true;
      }
    }
    else if (cmd.getName().equalsIgnoreCase("s"))
    {
      if (!player.hasPermission("kitpvp.staff"))
      {
        player.sendMessage(API.NomeServer + "§fVoce nao tem permissao para fazer isso!");
        return true;
      }
      if (args.length == 0)
      {
        player.sendMessage(API.NomeServer + "§fUse /tp [player] para ir ate um player!");
        player.sendMessage(API.NomeServer + "§fUse /s [player] para puxar um player ate voce!");
        return true;
      }
      if (args.length == 1)
      {
        Player target = Bukkit.getPlayerExact(args[0]);
        if ((target == null) || (!(target instanceof Player)))
        {
          player.sendMessage(API.NomeServer + "§fJogador nao encontrado!");
          return true;
        }
        target.teleport(player);
        Bukkit.getLogger().info("§4§l" + player.getName() + " puxou§f§l " + target.getName());
        Bukkit.broadcast(API.NomeServer + "§4§l" + player.getName() + ChatColor.GRAY + " §fpuxou o jogador §4§l" + target.getName() + " §fate ele!", "kitpvp.staff");
        return true;
      }
      if (args.length > 1)
      {
        player.sendMessage(API.NomeServer + "§fUse /tp [player] para ir ate um player!");
        player.sendMessage(API.NomeServer + "§fUse /s [player] para puxar um player ate voce!");
        return true;
      }
    }
    return false;
  }
}
