package me.RafaelAulerDeMeloAraujo.main;

import java.util.HashMap;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nametagedit.plugin.NametagEdit;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class Tag
  implements CommandExecutor
{
  
  
  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("tag"))
    {
      if (args.length == 0)
      {
          p.sendMessage("§7Tags Existentes no Servidor: §7(§7§lMEMBRO §7| §d§lBOOSTER §7| §3§lVIP §7| §6§lMVP §7| §b§lMVP§6§l+ §7| §9§lPARCEIRO §7| §b§lYOUTUBER  §7| §3§lYOUTUBER§6§l+ §7| §e§lMAPMAKER §7| §e§lAJUDANTE §7| §2§lMOD §7| §5§lMODGC §7| §5§lCOORD §7| §4§lGERENTE §7| §c§lADMIN §7| §3§lDIRETOR §7| §4§lDONO§7)");
          p.sendMessage("\n§cEXPERIMENTAL: Esse comando pode nao funcionar corretamente pois as tags sao fixas (Mas colocamos sistema de mudar de tags mesmo assim)");
          return true;
        }
      else if ((args[0].equalsIgnoreCase("dono")) && (p.hasPermission("role.dono")))
      {
    	  p.setDisplayName("§4§lDONO§f " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§4§lDONO§f ");
          p.setPlayerListName("§4§lDONO§f " + p.getName());
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §4§lDONO");
      }
      else if ((args[0].equalsIgnoreCase("diretor")) && (p.hasPermission("role.diretor")))
      {
    	  p.setDisplayName("§3§lDIRETOR§f " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§3§lDIRETOR§f ");
          p.setPlayerListName("§3§lDIRETOR§f " + p.getName());
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §3§lDIRETOR");
      }
      else if ((args[0].equalsIgnoreCase("gerente")) && (p.hasPermission("role.gerente")))
      {
    	  p.setDisplayName("§4§lGERENTE§f " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§4§lGERENTE§f ");
          p.setPlayerListName("§4§lGERENTE§f " + p.getName());
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §4§lGERENTE");
      }
      else if ((args[0].equalsIgnoreCase("admin")) && (p.hasPermission("role.admin")))
      {
    	  p.setDisplayName("§c§lADMIN§f " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§c§lADMIN§f ");
          p.setPlayerListName("§c§lADMIN§f " + p.getName());
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §c§lADMIN");
      }
      else if ((args[0].equalsIgnoreCase("coordenador")) && (p.hasPermission("role.coordenador")))
      {
    	  p.setDisplayName("§5§lCOORD§f " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§5§lCOORD§f ");
          p.setPlayerListName("§5§lCOORD§f " + p.getName());
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §5§lCOORD");
      }
      else if ((args[0].equalsIgnoreCase("modgc")) && (p.hasPermission("role.modgc")))
      {
    	  p.setDisplayName("§5§lMODGC§f " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§8[§5§lMODGC§8]§f ");
          p.setPlayerListName("§5§lMODGC§f " + p.getName());
        p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §5§lMODGC");
      }
      else if ((args[0].equalsIgnoreCase("moderador")) && (p.hasPermission("role.moderador")))
      {
    	  p.setDisplayName("§2§lMOD§f " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§2§lMOD§f ");
          p.setPlayerListName("§2§lMOD§f " + p.getName());
        p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §2§lMOD");
      }
      else if ((args[0].equalsIgnoreCase("ajudante")) && (p.hasPermission("role.ajudante")))
      {
    	  p.setDisplayName("§e§lAJUDANTE§f " + p.getName());
    	  NametagEdit.getApi().setPrefix(p.getName(), "§e§lAJUDANTE§f ");
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §e§lAJUDANTE");
          p.setPlayerListName("§e§lAJUDANTE§f " + p.getName());
      }
      else if ((args[0].equalsIgnoreCase("builder")) && (p.hasPermission("role.builder")))
      {
    	  p.setDisplayName("§e§lMAPMAKER§f " + p.getName());
          NametagEdit.getApi().setPrefix(p.getName(), "§e§lMAPMAKER§f ");
          p.setPlayerListName("§e§lMAPMAKER§f " + p.getName());
        p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §e§lMAPMAKER");
      }
      else if ((args[0].equalsIgnoreCase("miniyt")) && (p.hasPermission("role.miniyt")))
      {
    	  p.setDisplayName("§b§lYT§f " + p.getName());
    	  NametagEdit.getApi().setPrefix(p.getName(), "§b§lYT§f ");
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §b§lYT");
          p.setPlayerListName("§b§lYT§f " + p.getName());
      }
      else if ((args[0].equalsIgnoreCase("mvp+")) && (p.hasPermission("role.mvp+")))
      {
    	  p.setDisplayName("§b§lMVP PLUS§f " + p.getName());
    	  NametagEdit.getApi().setPrefix(p.getName(), "§b§lMVP PLUS§f ");
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §b§lMVP PLUS");
          p.setPlayerListName("§b§lMVP+§f " + p.getName());
      }
      else if ((args[0].equalsIgnoreCase("youtuber")) && (p.hasPermission("tag.youtuber")))
      {
       	  p.setDisplayName("§3§lYT§6§lPLUS§f " + p.getName());
       	  NametagEdit.getApi().setPrefix(p.getName(), "§3§lYT§6§lPLUS§f ");
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §3§lYT§6§lPLUS");
          p.setPlayerListName("§3§lYT§6§lPLUS§f " + p.getName());
      }
      else if ((args[0].equalsIgnoreCase("mvp")) && (p.hasPermission("tag.mvp")))
      {
    	  p.setDisplayName("§6§lMVP§f " + p.getName());
    	  NametagEdit.getApi().setPrefix(p.getName(), "§6§lMVP§f ");
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §6§lMVP");
          p.setPlayerListName("§6§lMVP§f " + p.getName());
      }
      else if ((args[0].equalsIgnoreCase("vip")) && (p.hasPermission("tag.vip")))
      {
    	  p.setDisplayName("§3§lVIP§f " + p.getName());
    	  NametagEdit.getApi().setPrefix(p.getName(), "§3§lVIP§f ");
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §3§lVIP");
          p.setPlayerListName("§3§lVIP§f " + p.getName());
      }
      else if ((args[0].equalsIgnoreCase("booster")) && (p.hasPermission("role.booster")))
      {
    	  p.setDisplayName("§d§lBOOSTER§f " + p.getName());
    	  NametagEdit.getApi().setPrefix(p.getName(), "§d§lBOOSTER§f ");
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §d§lBOOSTER");
          p.setPlayerListName("§d§lBOOSTER§f " + p.getName());
      }
      else if ((args[0].equalsIgnoreCase("partner") || (args[0].equalsIgnoreCase("parceiro")) && (p.hasPermission("role.partner"))))
      {
    	  p.setDisplayName("§9§lPARCEIRO§f " + p.getName());
    	  NametagEdit.getApi().setPrefix(p.getName(), "§9§lPARCEIRO§f ");
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §9§lPARCEIRO");
          p.setPlayerListName("§9§lPARCEIRO§f " + p.getName());
      }
      else if (args[0].equalsIgnoreCase("membro"))
      {
    	  p.setDisplayName("§7§lMEMBRO§f " + p.getName());
    	  NametagEdit.getApi().setPrefix(p.getName(), "§7§lMEMBRO§f ");
          p.sendMessage(API.NomeServer + "§fVoce esta usando a tag §7§lMEMBRO");
          p.setPlayerListName("§7§lMEMBRO§f " + p.getName());
      }
	return false;
    }
  {
  }
return false;
}
}
