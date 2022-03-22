package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitScheduler;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;

public class Mensagens
  implements Listener
{
  public static void start()
  {
    Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable()
    {
      String[] msg = {
      
        "§fAchou um §4§LCHEATER? §fReporte ele utilizando o comando /report", 
        "§fVeja o link do nosso §9§lDiscord §fdigitando /discord", 
        "§fVocê pode comprar kits na loja de kits usando suas §eMoedas",
        "§fUtilize /youtuber para ver os requisitos das TAGs", 
        "§fUtilize /ranks para ver as informacoes sobre o sistema de niveis",
        "§fTemos eventos diarios! Quando ocorrer um use /evento",
        "§fUtilize /regras para ver as regras do §4§lTSB§f§lPVP.", };
      
      public void run()
      {
        Bukkit.broadcastMessage(API.NomeServer + this.msg[new java.util.Random().nextInt(this.msg.length)]);
      }
    }, 800L, 800L);
  }
}