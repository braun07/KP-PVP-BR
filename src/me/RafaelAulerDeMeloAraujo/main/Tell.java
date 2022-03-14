package me.RafaelAulerDeMeloAraujo.main;


import org.bukkit.entity.*;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import java.util.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class Tell implements CommandExecutor
{
    public static HashMap<Player, Player> gettell;
    static ArrayList<Player> telloff;
    
    static {
        Tell.gettell = new HashMap<Player, Player>();
        Tell.telloff = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("tell")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf(API.NomeServer) + "§cEscreva: /tell (nome) (msg) §2§§");
                return true;
            }
            final Player target = Bukkit.getPlayer(args[0]);
            if (args[0].toLowerCase().equalsIgnoreCase("on")) {
                Tell.telloff.remove(p);
                p.sendMessage(String.valueOf(API.NomeServer) + "§7Voc\u00ea §bativou §7seu tell §2§§");
            }
            else if (args[0].toLowerCase().equalsIgnoreCase("off")) {
                Tell.telloff.add(p);
                p.sendMessage(String.valueOf(API.NomeServer) + "§7Voc\u00ea §bdesativou §7seu tell §4§§");
            }
            if (args.length > 1) {
                if (target == null) {
                    p.sendMessage("§cJogador esta offline");
                    return true;
                }
                if (Tell.telloff.contains(target)) {
                    p.sendMessage(String.valueOf(API.NomeServer) + "§cO tell desse player esta off §4§§");
                    return true;
                }
                final StringBuilder sb = new StringBuilder();
                for (int i = 1; i < args.length; ++i) {
                    sb.append(args[i]).append(" ");
                }
                final String allArgs = sb.toString().trim();
                p.sendMessage("§7[§aEu§r --> §a" + target.getDisplayName() + "§7]§f: " + allArgs);
                target.sendMessage("§7[§a" + p.getDisplayName() + "§7] §f--> §aEu§7]§f: " + allArgs);
                Tell.gettell.put(p, target);
                Tell.gettell.put(target, p);
            }
        }
        else if (label.equalsIgnoreCase("off")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf(API.NomeServer) + "§7fale com o player no chat normal §2§§");
                return true;
            }
            if (!Tell.gettell.containsKey(p)) {
                p.sendMessage(String.valueOf(API.NomeServer) + "§7Voc\u00ea n\u00e3o tem ninguem para responder §4§§");
                return true;
            }
            final Player deslogo = Tell.gettell.get(p);
            if (deslogo == null) {
            	p.sendMessage("§cJogador esta offline");
                return true;
            }
            if (Tell.telloff.contains(deslogo)) {
                p.sendMessage(String.valueOf(API.NomeServer) + "§cO tell desse player esta off §4§§");
                return true;
            }
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < args.length; ++i) {
                sb.append(args[i]).append(" ");
            }
            final String allArgs = sb.toString().trim();
            p.sendMessage("§7[§aEu§r --> §a" + deslogo.getDisplayName() + "§7]§f: " + allArgs);
            deslogo.sendMessage("§7[§a" + p.getDisplayName() + "§7] §f--> §aEu§7]§f: " + allArgs);
        }
        return false;
    }
}
