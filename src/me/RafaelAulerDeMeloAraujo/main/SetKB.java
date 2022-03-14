package me.RafaelAulerDeMeloAraujo.main;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SetKB
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("setknock"))
    {
      if (!p.hasPermission("kitpvp.setknock")) {
        return true;
      }
      Main.plugin.getConfig().set("KNOCK.World", p.getLocation().getWorld().getName());
      Main.plugin.getConfig().set("KNOCK.X", Double.valueOf(p.getLocation().getX()));
      Main.plugin.getConfig().set("KNOCK.Y", Double.valueOf(p.getLocation().getY()));
      Main.plugin.getConfig().set("KNOCK.Z", Double.valueOf(p.getLocation().getZ()));
      Main.plugin.getConfig().set("KNOCK.Pitch", Float.valueOf(p.getLocation().getPitch()));
      Main.plugin.getConfig().set("KNOCK.Yaw", Float.valueOf(p.getLocation().getYaw()));
      Main.plugin.saveConfig();
      
      p.sendMessage(API.NomeServer + "KNOCK SETADA COM SUCESSO!");
      return true;
    }
    return false;
  }
}