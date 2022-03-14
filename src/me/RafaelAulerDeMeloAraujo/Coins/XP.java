package me.RafaelAulerDeMeloAraujo.Coins;


import me.RafaelAulerDeMeloAraujo.main.Main;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.bukkit.configuration.file.YamlConfiguration;

public class XP
{
  @SuppressWarnings({ "unchecked", "rawtypes" })
public static HashMap<String, Double> bal = new HashMap();
  
  public static HashMap<String, Double> getCoinsMap()
  {
    return bal;
  }
  
  public static Double getXP(String player)
  {
    File playersfile = new File(Main.plugin.getDataFolder() + File.separator, "user-data.yml");
    YamlConfiguration players = YamlConfiguration.loadConfiguration(playersfile);
    return Double.valueOf(players.getDouble("XP." + player));
  }
  
  public static boolean hasAccount(String player)
  {
    File playersfile = new File(Main.plugin.getDataFolder() + File.separator, "user-data.yml");
    YamlConfiguration players = YamlConfiguration.loadConfiguration(playersfile);
    return players.contains(player);
  }
  
  public static void setXP(String player, double amount)
  {
    bal.put(player, Double.valueOf(amount));
    saveXP();
  }
  
  public static void addXP(String player, double amount)
  {
    bal.put(player, Double.valueOf(getXP(player).doubleValue() + amount));
    saveXP();
  }

  public static void removeXP(String player, double amount)
  {
    bal.put(player, Double.valueOf(getXP(player).doubleValue() - amount));
    saveXP();
  }
  
  public static void saveXP()
  {
    File playersfile = new File(Main.plugin.getDataFolder() + File.separator, "user-data.yml");
    YamlConfiguration players = YamlConfiguration.loadConfiguration(playersfile);
    for (String p : getCoinsMap().keySet())
    {
      players.set("XP." + p, getCoinsMap().get(p));
      try
      {
        players.save(playersfile);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public static void loadXP()
  {
    File playersfile = new File(Main.plugin.getDataFolder() + File.separator, "user-data.yml");
    YamlConfiguration.loadConfiguration(playersfile);
  }
}
