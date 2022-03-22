package me.RafaelAulerDeMeloAraujo.main;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class Gamemode
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
    if (!player.hasPermission("kitpvp.gamemode"))
    {
    	player.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoce nao tem permissÃ£o para executar esse comando");
      return true;
    }
    if (args.length == 0)
    {
      sender.sendMessage(API.NomeServer + "Use /gm [gamemode] [player] ou /gm [gamemode]");
      return true;
    }
    if (args.length == 1)
    {
      if (args[0].equalsIgnoreCase("0"))
      {
        player.setGameMode(GameMode.SURVIVAL);
        player.sendMessage(API.NomeServer + "Seu gamemode foi atualizado para §4§lSOBREVIVENCIA§f.");
      }
      else if (args[0].equalsIgnoreCase("1"))
      {
        player.setGameMode(GameMode.CREATIVE);
        player.sendMessage(API.NomeServer + "Seu gamemode foi atualizado para §4§lCRIATIVO§f.");
      }
      else if (args[0].equalsIgnoreCase("2"))
      {
        player.setGameMode(GameMode.ADVENTURE);
        player.sendMessage(API.NomeServer + "Seu gamemode foi atualizado para §4§lAVENTURA§f.");
      }
      else
      {
        sender.sendMessage(API.NomeServer + "Esse gamemode nao existe!");
        return true;
      }
      return true;
    }
    if (args.length == 2 && player.hasPermission("kitpvp.dargm"))
    {
      Player target = Bukkit.getPlayerExact(args[1]);
      if ((target == null) || (!(target instanceof Player)))
      {
        player.sendMessage(API.NomeServer + "Jogador nao encontrado!");
        return true;
      }
      if (args[0].equalsIgnoreCase("0"))
      {
        target.setGameMode(GameMode.SURVIVAL);
        target.sendMessage(API.NomeServer + "Voce entrou no modo §4§lSOBREVIVENCIA.");
        target.sendMessage(API.NomeServer + "§c" + target.getName() + " §fatualizou seu gamemode para §4§lSOBREVIVENCIA§f.");
        Bukkit.broadcast(API.NomeServer + "§c" + player.getName() + ChatColor.WHITE + " Atualizou o gamemode de §c" + target.getName() + " §fpara §4§lSOBREVIVENCIA.", "kitpvp.staff");
      }
      else if (args[0].equalsIgnoreCase("1"))
      {
        target.setGameMode(GameMode.CREATIVE);
        target.sendMessage(API.NomeServer + "Voce entrou no modo §4§lCRIATIVO");
        target.sendMessage(API.NomeServer + "§c " + target.getName() + " §fatualizou seu gamemode para §4§lCRIATIVO§f.");
        Bukkit.broadcast(API.NomeServer + "§c" + player.getName() + ChatColor.WHITE + " Atualizou o gamemode de §c" + target.getName() + " §fpara §4§lCRIATIVO", "kitpvp.staff");
      }
      else if (args[0].equalsIgnoreCase("2"))
      {
        target.setGameMode(GameMode.ADVENTURE);
        target.sendMessage(API.NomeServer + " Voce entrou no modo §4§lAVENTURA");
        target.sendMessage(API.NomeServer + "§c" + target.getName() + " §fatualizou seu gamemode para §4§lAVENTURA§f.");
        Bukkit.broadcast(API.NomeServer + "§c" + player.getName() + ChatColor.WHITE + " Atualizou o gamemode de §c" + target.getName() + " §fpara §4§lAVENTURA", "kitpvp.staff");
      }
      else
      {
        sender.sendMessage(API.NomeServer + "Esse gamemode nao existe!");
        return true;
      }
      return false;
    }
    if (args.length > 2)
    {
      sender.sendMessage(API.NomeServer + "Use /gm [gamemode] [player] ou /gm [gamemode]");
      return true;
    }
    return false;
  }
}

