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

public class setevento
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("setevento"))
    {
      if (!p.hasPermission("kitpvp.setevento")) {
        return true;
      }
      Main.plugin.getConfig().set("EVENTO.World", p.getLocation().getWorld().getName());
      Main.plugin.getConfig().set("EVENTO.X", Double.valueOf(p.getLocation().getX()));
      Main.plugin.getConfig().set("EVENTO.Y", Double.valueOf(p.getLocation().getY()));
      Main.plugin.getConfig().set("EVENTO.Z", Double.valueOf(p.getLocation().getZ()));
      Main.plugin.getConfig().set("EVENTO.Pitch", Float.valueOf(p.getLocation().getPitch()));
      Main.plugin.getConfig().set("EVENTO.Yaw", Float.valueOf(p.getLocation().getYaw()));
      Main.plugin.saveConfig();
      
      p.sendMessage(API.NomeServer + "LOCAL DE EVENTO SETADO COM SUCESSO!");
      return true;
    }
    return false;
  }
}
