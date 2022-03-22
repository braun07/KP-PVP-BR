package me.RafaelAulerDeMeloAraujo.main;

import java.util.ArrayList;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class SS
  implements CommandExecutor, Listener
{
  public static ArrayList<Player> congelado = new ArrayList();
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("ss")) {
      if (p.hasPermission("kitpvp.ss"))
      {
        if (args.length == 0)
        {
          p.sendMessage(String.valueOf("§8(§4§lTSB§f§lPVP§8)") + "§c Utilize: /ss (nome)");
        }
        else
        {
          Player t = Bukkit.getPlayer(args[0]);
          if (t == null)
          {
            p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fO jogador esta offline");
            return true;
          }
          if (!congelado.contains(t))
          {
            congelado.add(t);
            t.sendMessage(String.valueOf("§8(§4§lTSB§f§lPVP§8) ") + "§7Você foi puxado para uma SS por: §f" + p.getDisplayName());
            t.sendMessage(String.valueOf("§8(§4§lTSB§f§lPVP§8) ") + "§7Siga as instruçoes do staffer e passe o AnyDesk");
            TitleAPI.sendTitle(t, Integer.valueOf(10), Integer.valueOf(6000), Integer.valueOf(10), "§cVoce esta em SS");
            p.sendMessage(String.valueOf("§8(§4§lTSB§f§lPVP§8) ") + "§fVocê colocou: §c" + t.getDisplayName() + " §fem §c§lSS");
            World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("SS.World"));
            double x = Main.plugin.getConfig().getDouble("SS.X");
            double y = Main.plugin.getConfig().getDouble("SS.Y");
            double z = Main.plugin.getConfig().getDouble("SS.Z");
            Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)Main.plugin.getConfig().getDouble("SS.Pitch"));
            lobby.setYaw((float)Main.plugin.getConfig().getDouble("SS.Yaw"));
            t.teleport(lobby);
            p.teleport(t.getLocation());
            Bukkit.broadcast("§8(§4§lTSB§f§lPVP§8) §c" + t.getName() + " §ffoi colocado na SS pelo staff: §4§l" + p.getName(), "kitpvp.staff");
          }
          else
          {
            congelado.remove(t);
            t.sendMessage(String.valueOf("§8(§4§lTSB§f§lPVP§8) ") + "§7Você foi liberado por: §a" + p.getDisplayName());
            p.sendMessage(String.valueOf("§8(§4§lTSB§f§lPVP§8) ") + "§7Você liberou: §a" + t.getDisplayName());
            TitleAPI.clearTitle(t);
          }
        }
      }
      else {
        p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVocê não tem permissão para executar esse comando");
      }
    }
    return false;
  }
  
  @EventHandler
  public void aoSair(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    if (congelado.contains(p))
    {
      congelado.remove(p);
      Bukkit.broadcast("§8(§4§lTSB§f§lPVP§8) " + p.getName() + " §fdeslogou enquanto em §c§lSS", "kitpvp.staff");
      TitleAPI.clearTitle(p);
    }
  }
  

  
  @EventHandler
  public void aoComando(PlayerCommandPreprocessEvent e)
  {
    Player p = e.getPlayer();
    if ((congelado.contains(p)) && (!e.getMessage().startsWith("/tell")))
    {
      e.setCancelled(true);
      p.sendMessage(String.valueOf("§8(§4§lTSB§f§lPVP§8) ") + "§cVocê nao pode digitar comando quando estiver em §4§lSS");
    }
  }
}
