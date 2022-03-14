package me.RafaelAulerDeMeloAraujo.ScoreboardManager;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class SimpleScoreboard
{
  private Scoreboard scoreboard;
  private String title;
  private Map<String, Integer> scores;
  private List<Team> teams;
  
  public SimpleScoreboard(String title)
  {
    this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
    this.title = title;
    this.scores = Maps.newLinkedHashMap();
    this.teams = Lists.newArrayList();
  }
  
  public void blankLine()
  {
    add("§0");
  }
  
  public void add(String text)
  {
    add(text, null);
  }
  
  public void add(String text, Integer score)
  {
    Preconditions.checkArgument(text.length() < 48, "text cannot be over 48 characters in length");
    text = fixDuplicates(text);
    this.scores.put(text, score);
  }
  
  private String fixDuplicates(String text)
  {
    while (this.scores.containsKey(text)) {
      text = text + "§r";
    }
    if (text.length() > 48) {
      text = text.substring(0, 47);
    }
    return text;
  }
  
  private Map.Entry<Team, String> createTeam(String text)
  {
    String result = "";
    if (text.length() <= 16) {
      return new AbstractMap.SimpleEntry(null, text);
    }
    Team team = this.scoreboard.registerNewTeam("text-" + this.scoreboard.getTeams().size());
    Iterator iterator = Splitter.fixedLength(16).split(text).iterator();
    team.setPrefix((String)iterator.next());
    result = (String)iterator.next();
    if (text.length() > 32) {
      team.setSuffix((String)iterator.next());
    }
    this.teams.add(team);
    return new AbstractMap.SimpleEntry(team, result);
  }
  
  public void build()
  {
    Objective obj = this.scoreboard.registerNewObjective(this.title.length() > 16 ? this.title.substring(0, 15) : this.title, "dummy");
    obj.setDisplayName(this.title);
    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
    
    int index = this.scores.size();
    for (Map.Entry text : this.scores.entrySet())
    {
      Map.Entry team = createTeam((String)text.getKey());
      Integer score = Integer.valueOf(text.getValue() != null ? ((Integer)text.getValue()).intValue() : index);
      
      final Map.Entry teamf = team;
      OfflinePlayer player = new OfflinePlayer()
      {
        public void setOp(boolean arg0) {}
        
        public void setWhitelisted(boolean arg0) {}
        
        public void setBanned(boolean arg0) {}
        
        public Map<String, Object> serialize()
        {
          return null;
        }
        
        public boolean isOp()
        {
          return false;
        }
        
        public boolean isWhitelisted()
        {
          return false;
        }
        
        public boolean isOnline()
        {
          return false;
        }
        
        public boolean isBanned()
        {
          return false;
        }
        
        public boolean hasPlayedBefore()
        {
          return false;
        }
        
        public UUID getUniqueId()
        {
          return null;
        }
        
        public Player getPlayer()
        {
          return null;
        }
        
        public String getName()
        {
          return (String)teamf.getValue();
        }
        
        public long getLastPlayed()
        {
          return 0L;
        }
        
        public long getFirstPlayed()
        {
          return 0L;
        }
        
        public Location getBedSpawnLocation()
        {
          return null;
        }
      };
      if (team.getKey() != null) {
        ((Team)team.getKey()).addPlayer(player);
      }
      obj.getScore(player).setScore(score.intValue());
      index--;
    }
  }
  
  public Team registerNewTeam(String team)
  {
    return this.scoreboard.registerNewTeam(team);
  }
  
  public void reset()
  {
    this.title = null;
    this.scores.clear();
    for (Team t : this.teams) {
      t.unregister();
    }
    this.teams.clear();
  }
  
  public Scoreboard getScoreboard()
  {
    return this.scoreboard;
  }
  
  public void send(Player[] players)
  {
    Player[] arrayOfPlayer;
    int j = (arrayOfPlayer = players).length;
    for (int i = 0; i < j; i++)
    {
      Player p = arrayOfPlayer[i];
      p.setScoreboard(this.scoreboard);
    }
  }
}
