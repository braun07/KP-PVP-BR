package me.RafaelAulerDeMeloAraujo.ScoreboardManager;

import org.bukkit.entity.*;

import me.RafaelAulerDeMeloAraujo.Coins.XP;
import me.RafaelAulerDeMeloAraujo.main.AntiDeathDrop;
import net.md_5.bungee.api.ChatColor;


public class Level
{
    public static String getLevel(final Player p) {
        final double a = XP.getXP(p.getName());
        if (a <= 0.0) {
            return ChatColor.GRAY + "[0]";
        }
        if (a <= 200.0) {
            return ChatColor.GREEN + "[1]";
        }
        if (a <= 400.0) {
            return ChatColor.GREEN + "[2]";
        }
        if (a <= 600.0) {
            return ChatColor.GREEN + "[3]";
        }
        if (a <= 800.0) {
            return ChatColor.GREEN + "[4]";
        }
        if (a <= 1000.0) {
            return ChatColor.GREEN + "[5]";
        }
        if (a <= 1200.0) {
            return ChatColor.GREEN + "[6]";
        }
        if (a <= 1400.0) {
            return ChatColor.GREEN + "[7]";
        }
        if (a <= 1600.0) {
            return ChatColor.GREEN + "[8]";
        }
        if (a <= 1800.0) {
            return ChatColor.GREEN + "[9]";
        }
        if (a <= 2000.0) {
            return ChatColor.GREEN + "[10]";
        }
        if (a <= 2200.0) {
            return ChatColor.YELLOW + "[11]";
        }
        if (a <= 2400.0) {
            return ChatColor.YELLOW + "[12]";
        }
        if (a <= 2600.0) {
            return ChatColor.YELLOW + "[13]";
        }
        if (a <= 2800.0) {
        	return ChatColor.YELLOW + "[14]";
        }
        if (a <= 3000.0) {
        	return ChatColor.YELLOW + "[15]";
        }
        if (a <= 3200.0) {
        	return ChatColor.YELLOW + "[16]";
        }
        if (a <= 3400.0) {
        	return ChatColor.YELLOW + "[17]";
        }
        if (a <= 3600.0) {
        	return ChatColor.YELLOW + "[18]";
        }
        if (a <= 3800.0) {
        	return ChatColor.YELLOW + "[19]";
        }
        if (a <= 4000.0) {
        	return ChatColor.YELLOW + "[20]";
        }
        if (a <= 4200.0) {
        	return ChatColor.AQUA + "[21]";
        }
        if (a <= 4400.0) {
        	return ChatColor.AQUA + "[22]";
        }
        if (a <= 4600.0) {
        	return ChatColor.AQUA + "[23]";
        }
        if (a <= 4800.0) {
        	return ChatColor.AQUA + "[24]";
        }
        if (a <= 5000.0) {
        	return ChatColor.AQUA + "[25]";
        }
        if (a <= 5200.0) {
        	return ChatColor.AQUA + "[26]";
        }
        if (a <= 5400.0) {
        	return ChatColor.AQUA + "[27]";
        }
        if (a <= 5600.0) {
        	return ChatColor.AQUA + "[28]";
        }
        if (a <= 5800.0) {
        	return ChatColor.AQUA + "[29]";
        }
        if (a <= 6000.0) {
        	return ChatColor.AQUA + "[30]";
        }
        if (a <= 6200.0) {
        	return ChatColor.DARK_GREEN + "[31]";
        }
        if (a <= 6400.0) {
        	return ChatColor.DARK_GREEN + "[32]";
        }
        if (a <= 6600.0) {
        	return ChatColor.DARK_GREEN + "[33]";
        }
        if (a <= 6800.0) {
        	return ChatColor.DARK_GREEN + "[34]";
        }
        if (a <= 7000.0) {
        	return ChatColor.DARK_GREEN + "[35]";
        }
        if (a <= 7200.0) {
        	return ChatColor.DARK_GREEN + "[36]";
        }
        if (a <= 7400.0) {
        	return ChatColor.DARK_GREEN + "[37]";
        }
        if (a <= 7600.0) {
        	return ChatColor.DARK_GREEN + "[38]";
        }
        if (a <= 7800.0) {
        	return ChatColor.DARK_GREEN + "[39]";
        }
        if (a <= 8000.0) {
        	return ChatColor.DARK_GREEN + "[40]";
        }
        if (a <= 8200.0) {
        	return ChatColor.DARK_GREEN + "[41]";
        }
        if (a <= 8400.0) {
        	return ChatColor.GOLD + "[42]";
        }
        if (a <= 8600.0) {
        	return ChatColor.GOLD + "[43]";
        }
        if (a <= 8800.0) {
        	return ChatColor.GOLD + "[44]";
        }
        if (a <= 9000.0) {
        	return ChatColor.GOLD + "[45]";
        }
        if (a <= 9200.0) {
        	return ChatColor.GOLD + "[46]";
        }
        if (a <= 9400.0) {
        	return ChatColor.GOLD + "[47]";
        }
        if (a <= 9600.0) {
        	return ChatColor.GOLD + "[48]";
        }
        if (a <= 9800.0) {
        	return ChatColor.GOLD + "[49]";
        }
        if (a <= 10000.0) {
        	return ChatColor.GOLD + "[50]";
        }
        if (a <= 10200.0) {
        	return ChatColor.GOLD + "[51]";        	
        }
        if (a <= 10400.0) {
        	return ChatColor.BLUE + "[52]";
        }
        if (a <= 10600.0) {
        	return ChatColor.BLUE + "[53]";
        }
        if (a <= 10800.0) {
        	return ChatColor.BLUE + "[54]";
        }
        if (a <= 11000.0) {
        	return ChatColor.BLUE + "[55]";
        }
        if (a <= 11200.0) {
        	return ChatColor.BLUE + "[56]";
        }
        if (a <= 11400.0) {
        	return ChatColor.BLUE + "[57]";
        }
        if (a <= 11600.0) {
        	return ChatColor.BLUE + "[58]";
        }
        if (a <= 11800.0) {
        	return ChatColor.BLUE + "[59]";
        }
        if (a <= 12000.0) {
        	return ChatColor.BLUE + "[60]";
        }
        if (a <= 12200.0) {
        	return ChatColor.RED + "[61]";
        }
        if (a <= 12400.0) {
        	return ChatColor.RED + "[62]";
        }
        if (a <= 12600.0) {
        	return ChatColor.RED + "[63]";
        }
        if (a <= 12800.0) {
        	return ChatColor.RED + "[64]";
        }
        if (a <= 13000.0) {
        	return ChatColor.RED + "[65]";
        }
        if (a <= 13200.0) {
        	return ChatColor.RED + "[66]";
        }
        if (a <= 13400.0) {
        	return ChatColor.RED + "[67]";
        }
        if (a <= 13600.0) {
        	return ChatColor.RED + "[68]";
        }
        if (a <= 13800.0) {
        	return ChatColor.RED + "[69]";
        }
        if (a <= 14000.0) {
        	return ChatColor.DARK_RED + "[70]";
        }
        if (a <= 14200.0) {
        	return ChatColor.DARK_RED + "[71]";
        }
        if (a <= 14400.0) {
        	return ChatColor.DARK_RED + "[72]";
        }
        if (a <= 14600.0) {
        	return ChatColor.DARK_RED + "[73]";
        }
        if (a <= 14800.0) {
        	return ChatColor.DARK_RED + "[74]";
        }
        if (a <= 15000.0) {
        	return ChatColor.DARK_RED + "[75]";
        }
        if (a <= 15200.0) {
        	return ChatColor.DARK_RED + "[76]";
        }
        if (a <= 15400.0) {
        	return ChatColor.DARK_RED + "[77]";
        }
        if (a <= 15600.0) {
        	return ChatColor.DARK_RED + "[78]";
        }
        if (a <= 15800.0) {
        	return ChatColor.DARK_RED + "[79]";
        }
        if (a <= 16000.0) {
        	return ChatColor.DARK_RED + "[80]";
        }
        if (a <= 16200.0) {
        	return ChatColor.DARK_RED + "[81]";
        }
        if (a <= 16400.0) {
        	return ChatColor.DARK_RED + "[82]";
        }
        if (a <= 16600.0) {
        	return ChatColor.DARK_RED + "[83]";
        }
        if (a <= 16800.0) {
        	return ChatColor.DARK_RED + "[84]";
        }
        if (a <= 17000.0) {
        	return ChatColor.DARK_RED + "[85]";
        }
        if (a <= 17200.0) {
        	return ChatColor.DARK_RED + "[86]";
        }
        if (a <= 17400.0) {
        	return ChatColor.DARK_RED + "[87]";
        }
        if (a <= 17600.0) {
        	return ChatColor.DARK_RED + "[88]";
        }
        if (a <= 17800.0) {
        	return ChatColor.DARK_RED + "[89]";
        }
        if (a <= 18000.0) {
        	return ChatColor.DARK_RED + "[90]";
        }
        if (a <= 18200.0) {
        	return ChatColor.DARK_RED + "[91]";
        }
        if (a <= 18400.0) {
        	return ChatColor.DARK_RED + "[92]";
        }
        if (a <= 18600.0) {
        	return ChatColor.DARK_RED + "[93]";
        }
        if (a <= 18800.0) {
        	return ChatColor.DARK_RED + "[94]";
        }
        if (a <= 19000.0) {
        	return ChatColor.DARK_RED + "[95]";
        }
        if (a <= 19200.0) {
        	return ChatColor.DARK_RED + "[96]";
        }
        if (a <= 19400.0) {
        	return ChatColor.DARK_RED + "[97]";
        }
        if (a <= 19600.0) {
        	return ChatColor.DARK_RED + "[98]";
        }
        if (a <= 19800.0) {
        	return ChatColor.DARK_RED + "[99]";
        }
        if (a <= 20000.0) {
        	return ChatColor.DARK_PURPLE + "[100]";
        }
        if (a > 20000.0) {
        	return ChatColor.DARK_PURPLE + "[100]";
        }
        return ChatColor.GRAY + "[0]";
    }
}