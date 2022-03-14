package me.RafaelAulerDeMeloAraujo.ScoreboardManager;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreBoardHelper
{
  private List<ScoreboardText> list = new ArrayList();
  private Scoreboard scoreBoard;
  private Objective objective;
  private String tag = "PlaceHolder";
  private int lastSentCount = -1;
  
  public ScoreBoardHelper(Scoreboard scoreboard)
  {
    this.scoreBoard = scoreboard;
    this.objective = getOrCreateObjective(this.tag);
    this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
  }
  
  public ScoreBoardHelper(Scoreboard scoreboard, String string)
  {
    Preconditions.checkState(string.length() <= 32, "title can not be more than 32");
    this.tag = ChatColor.translateAlternateColorCodes('&', string);
    this.scoreBoard = scoreboard;
    this.objective = getOrCreateObjective(this.tag);
    this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
  }
  
  public void add(String string, String string2)
  {
    Preconditions.checkState(string.length() <= 16, "left can not be more than 16");
    Preconditions.checkState(string2.length() <= 16, "right can not be more than 16");
    this.list.add(new ScoreboardText(color(string), color(string2)));
  }
  
  public void set(int n, String string, String string2)
  {
    Preconditions.checkState(string.length() <= 16, "left can not be more than 16");
    Preconditions.checkState(string2.length() <= 16, "right can not be more than 16");
    this.list.set(n, new ScoreboardText(color(string), color(string2)));
  }
  
  public void clear()
  {
    this.list.clear();
  }
  
  public void remove(int n)
  {
    String string = getNameForIndex(n);
    this.scoreBoard.resetScores(string);
    Team team = getOrCreateTeam(String.valueOf(String.valueOf(String.valueOf(ChatColor.stripColor(this.tag)))) + n, n);
    team.unregister();
  }
  
  public void update(Player player)
  {
    player.setScoreboard(this.scoreBoard);
    if (this.lastSentCount != -1)
    {
      int n = this.list.size();
      int n2 = 0;
      while (n2 < this.lastSentCount - n)
      {
        remove(n + n2);
        n2++;
      }
    }
    int n = 0;
    while (n < this.list.size())
    {
      Team team = getOrCreateTeam(String.valueOf(String.valueOf(String.valueOf(ChatColor.stripColor(this.tag)))) + n, n);
      ScoreboardText scoreboardText = (ScoreboardText)this.list.get(this.list.size() - n - 1);
      team.setPrefix(scoreboardText.getLeft());
      team.setSuffix(scoreboardText.getRight());
      this.objective.getScore(getNameForIndex(n)).setScore(n + 1);
      n++;
    }
    this.lastSentCount = this.list.size();
  }
  
  public Team getOrCreateTeam(String string, int n)
  {
    Team team = this.scoreBoard.getTeam(string);
    if (team == null)
    {
      team = this.scoreBoard.registerNewTeam(string);
      team.addEntry(getNameForIndex(n));
    }
    return team;
  }
  
  public Objective getOrCreateObjective(String string)
  {
    Objective objective = this.scoreBoard.getObjective("dummyhubobj");
    if (objective == null) {
      objective = this.scoreBoard.registerNewObjective("dummyhubobj", "dummy");
    }
    objective.setDisplayName(string);
    return objective;
  }
  
  public static String color(String string)
  {
    return ChatColor.translateAlternateColorCodes('&', string);
  }
  
  public String getNameForIndex(int n)
  {
    return String.valueOf(String.valueOf(String.valueOf(ChatColor.values()[n].toString()))) + ChatColor.RESET;
  }
  
  public static class ScoreboardText
  {
    private String left;
    private String right;
    
    public ScoreboardText(String string, String string2)
    {
      this.left = string;
      this.right = string2;
    }
    
    public String getLeft()
    {
      return this.left;
    }
    
    public void setLeft(String string)
    {
      this.left = string;
    }
    
    public String getRight()
    {
      return this.right;
    }
    
    public void setRight(String string)
    {
      this.right = string;
    }
  }
}

