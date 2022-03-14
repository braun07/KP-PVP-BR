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

public class KPSETCHALLENGE
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("setchallenge"))
    {
      if (!p.hasPermission("kitpvp.setspawn")) {
        return true;
      }
      Main.plugin.getConfig().set("CHALLENGE.World", p.getLocation().getWorld().getName());
      Main.plugin.getConfig().set("CHALLENGE.X", Double.valueOf(p.getLocation().getX()));
      Main.plugin.getConfig().set("CHALLENGE.Y", Double.valueOf(p.getLocation().getY()));
      Main.plugin.getConfig().set("CHALLENGE.Z", Double.valueOf(p.getLocation().getZ()));
      Main.plugin.getConfig().set("CHALLENGE.Pitch", Float.valueOf(p.getLocation().getPitch()));
      Main.plugin.getConfig().set("CHALLENGE.Yaw", Float.valueOf(p.getLocation().getYaw()));
      Main.plugin.saveConfig();
      
      p.sendMessage(API.NomeServer + "CHALLENGE SETADA COM SUCESSO!");
      return true;
    }
    return false;
  }
}
