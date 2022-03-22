package me.RafaelAulerDeMeloAraujo.main;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Ping
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if (args.length > 0)
    {
      Player p = Bukkit.getPlayer(args[0]);
      if (p != null)
      {
        String ping = null;
        Method[] arrayOfMethod;
        int j = (arrayOfMethod = p.getClass().getMethods()).length;
        for (int i = 0; i < j; i++)
        {
          Method meth = arrayOfMethod[i];
          if (meth.getName().equals("getHandle")) {
            try
            {
              Object obj = meth.invoke(p, null);
              Field[] arrayOfField;
              int m = (arrayOfField = obj.getClass().getFields()).length;
              for (int k = 0; k < m; k++)
              {
                Field field = arrayOfField[k];
                if (field.getName().equals("ping")) {
                  ping = String.valueOf(field.getInt(obj));
                }
              }
            }
            catch (Exception e)
            {
              e.printStackTrace();
            }
          }
        }
        sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fO ping de " + p.getName() + " e de: " + ChatColor.RED + ping + "ms");
      }
      else
      {
        sender.sendMessage(ChatColor.RED + "Player nao encontrado.");
      }
      return true;
    }
    if ((sender instanceof Player))
    {
      Player p = (Player)sender;
      String ping = null;
      Method[] arrayOfMethod;
      int j = (arrayOfMethod = p.getClass().getMethods()).length;
      for (int i = 0; i < j; i++)
      {
        Method meth = arrayOfMethod[i];
        if (meth.getName().equals("getHandle")) {
          try
          {
            Object obj = meth.invoke(p, null);
            Field[] arrayOfField;
            int m = (arrayOfField = obj.getClass().getFields()).length;
            for (int k = 0; k < m; k++)
            {
              Field field = arrayOfField[k];
              if (field.getName().equals("ping")) {
                ping = String.valueOf(field.getInt(obj));
              }
            }
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
        }
      }
      sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fSeu Ping é de : " + ChatColor.RED + ping + "ms");
    }
    else
    {
      sender.sendMessage("§8(§4§lTSB§f§lPVP§8) §fSeu Ping é de: " + ChatColor.RED + "0ms");
    }
    return true;
  }
}
