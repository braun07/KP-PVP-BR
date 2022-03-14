package me.RafaelAulerDeMeloAraujo.ScoreboardManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TablistPrefix {

    private final Scoreboard scoreboard;

    public TablistPrefix(Scoreboard scoreboard){
        this.scoreboard = scoreboard;
        registerPrefix("aDono", "§4DONO§f ");
        registerPrefix("bDiretor", "§3DIRETOR§f ");
        registerPrefix("cAdmin", "§cADMIN§f ");
        registerPrefix("dGerente", "§4GERENTE§f ");
        registerPrefix("eCoordenador", "§5COORD§f ");
        registerPrefix("fModGC", "§5MODGC§f ");
        registerPrefix("gModerador", "§2MOD§f ");
        registerPrefix("hAjudante", "§eAJUDANTE§f ");
        registerPrefix("iBuilder", "§eMAPMAKER§f ");
        registerPrefix("jYoutuber", "§3YT§6PLUS§f ");
        registerPrefix("kMiniYT", "§bYT§f ");
        registerPrefix("lMvpPlus", "§bMVP§6PLUS§f ");
        registerPrefix("mMvp", "§6MVP§f ");
        registerPrefix("nVip", "§3VIP§f ");
        registerPrefix("oBooster", "§dBOOSTER§f ");
        registerPrefix("pPartner", "§9PARCEIRO§f ");
        registerPrefix("qMembro", "§7MEMBRO§f ");
      }

    private Team getTeamPlayer(Player player){
    	if(player.hasPermission("*")){
            return scoreboard.getTeam("aDono");
        }
        if(player.hasPermission("role.diretor")){
            return scoreboard.getTeam("bDiretor");
        }
        if(player.hasPermission("role.admin")){
            return scoreboard.getTeam("cAdmin");
        }
        if(player.hasPermission("role.gerente")){
            return scoreboard.getTeam("dGerente");
        }
        if(player.hasPermission("role.coordenador")){
            return scoreboard.getTeam("eCoordenador");
        }
        if(player.hasPermission("role.modgc")){
            return scoreboard.getTeam("fModGC");
        }
        if(player.hasPermission("role.moderador")){
            return scoreboard.getTeam("gModerador");
        }
        if(player.hasPermission("role.ajudante")){
            return scoreboard.getTeam("hAjudante");
        }
        if(player.hasPermission("role.builder")){
            return scoreboard.getTeam("iBuilder");
        }
        if(player.hasPermission("role.youtuber")){
            return scoreboard.getTeam("jYoutuber");
        }
        if(player.hasPermission("role.miniyt")){
            return scoreboard.getTeam("kMiniYT");
        }
        if(player.hasPermission("role.mvp+")){
            return scoreboard.getTeam("lMvpPlus");
        }
        if(player.hasPermission("role.mvp")){
            return scoreboard.getTeam("mMvp");
        }
        if(player.hasPermission("role.vip")){
            return scoreboard.getTeam("nVip");
        }
        if(player.hasPermission("role.booster")){
            return scoreboard.getTeam("oBooster");
        }
        if(player.hasPermission("role.partner")){
            return scoreboard.getTeam("pPartner");
        }
        return scoreboard.getTeam("qMembro");
    }


    private void registerPrefix(String group, String prefix){
        Team team = scoreboard.getTeam(group)==null?scoreboard.registerNewTeam(group):scoreboard.getTeam(group);
        team.setPrefix(prefix);
    }

    public void applyPlayer(){
        for(Player all: Bukkit.getOnlinePlayers()){
            Team team = getTeamPlayer(all);
            if(!team.hasEntry(all.getName())){
                team.addEntry(all.getName());
            }
        }
    }
}
