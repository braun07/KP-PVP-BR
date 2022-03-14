package me.RafaelAulerDeMeloAraujo.X1;

import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Scoreboard;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
import me.RafaelAulerDeMeloAraujo.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class KPJoinWarps
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
  {
    if (!(sender instanceof Player)) {
      return true;
    }
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("kpjoinwarps"))
    {
      if (args.length == 0)
      {
        p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fEsse comando nao existe.");
        return true;
      }
      if (args[0].equalsIgnoreCase("fps"))
      {
        if (Habilidade.ContainsAbility(p))
        {
          p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoce ja escolheu um kit!");
          return true;
        }
        if (Main.plugin.getConfig().getString("FPS.World") == null)
        {
          p.sendMessage(API.NomeServer + "§fA Warp FPS nao esta setada!");
          return true;
        }
        p.getInventory().clear();
        World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("FPS.World"));
        double x = Main.plugin.getConfig().getDouble("FPS.X");
        double y = Main.plugin.getConfig().getDouble("FPS.Y");
        double z = Main.plugin.getConfig().getDouble("FPS.Z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.plugin.getConfig().getDouble("FPS.Pitch"));
        lobby.setYaw((float)Main.plugin.getConfig().getDouble("FPS.Yaw"));
        p.getInventory().clear();
        p.teleport(lobby);
        p.setExp(0.0F);
        p.setExhaustion(20.0F);
        p.setFireTicks(0);
        p.setFoodLevel(20000);
        p.setHealth(20.0D);
        Habilidade.setAbility(p, "FPS");
        Scoreboard.setScoreBoard(p);
        p.setAllowFlight(false);
        ItemStack capacete0 = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack capacete1 = new ItemStack(Material.IRON_HELMET);
        ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
        
        ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
        
        ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
        ItemStack Bota1 = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
        dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§bEspada");
        dima.setItemMeta(souperaa);
        ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§eSopa");
        sopa.setItemMeta(sopas);
        p.getInventory().addItem(new ItemStack[] { dima });
        p.getInventory().setChestplate(peitoral0);
        p.getInventory().setLeggings(calca0);
        p.getInventory().setBoots(Bota0);
        p.getInventory().setHelmet(capacete1);
        for (int i = 0; i <= 34; i++) {
          p.getInventory().addItem(new ItemStack[] { sopa });
        }
        p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fBem vindo a WARP §4§lFPS §f!");
        TitleAPI.sendTitle(p, Integer.valueOf(40), Integer.valueOf(40), Integer.valueOf(60), "§4§lWARP", "§f§lBem vindo(a) a FPS!");
      }
      if (args[0].equalsIgnoreCase("knock"))
      {
        if (Habilidade.ContainsAbility(p))
        {
          p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoce ja escolheu um kit!");
          return true;
        }
        if (Main.plugin.getConfig().getString("KNOCK.World") == null)
        {
          p.sendMessage(API.NomeServer + "§fA Warp KNOCK nao esta setada!");
          return true;
        }
        p.getInventory().clear();
        World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("KNOCK.World"));
        double x = Main.plugin.getConfig().getDouble("KNOCK.X");
        double y = Main.plugin.getConfig().getDouble("KNOCK.Y");
        double z = Main.plugin.getConfig().getDouble("KNOCK.Z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.plugin.getConfig().getDouble("KNOCK.Pitch"));
        lobby.setYaw((float)Main.plugin.getConfig().getDouble("KNOCK.Yaw"));
        p.getInventory().clear();
        p.teleport(lobby);
        p.setExp(0.0F);
        p.setExhaustion(20.0F);
        p.setFireTicks(0);
        p.setFoodLevel(20000);
        p.setHealth(20.0D);
        Habilidade.setAbility(p, "KNOCK");
        p.setAllowFlight(false);
        
        Scoreboard.setScoreBoard(p);
        ItemStack dima = new ItemStack(Material.STICK);
        dima.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
        ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§6Repulsão mais de 8000");
        dima.setItemMeta(souperaa);
        p.getInventory().addItem(new ItemStack[] { dima });
        p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fBem vindo(a) a WARP §4§lKNOCKBACK §f!");
        TitleAPI.sendTitle(p, Integer.valueOf(40), Integer.valueOf(40), Integer.valueOf(60), "§4§lWARP", "§f§lBem vindo(a) a KNOCKBACK!");
      }
      if (args[0].equalsIgnoreCase("pot"))
      {
        if (Habilidade.ContainsAbility(p))
        {
          p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoce ja escolheu um kit!");
          return true;
        }
        if (Main.plugin.getConfig().getString("POT.World") == null)
        {
          p.sendMessage(API.NomeServer + "§fA Warp POT nao esta setada!");
          return true;
        }
        p.getInventory().clear();
        World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("POT.World"));
        double x = Main.plugin.getConfig().getDouble("POT.X");
        double y = Main.plugin.getConfig().getDouble("POT.Y");
        double z = Main.plugin.getConfig().getDouble("POT.Z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.plugin.getConfig().getDouble("POT.Pitch"));
        lobby.setYaw((float)Main.plugin.getConfig().getDouble("POT.Yaw"));
        p.getInventory().clear();
        p.teleport(lobby);
        p.setExp(0.0F);
        p.setExhaustion(20.0F);
        p.setFireTicks(0);
        p.setFoodLevel(20000);
        p.setHealth(20.0D);
        Habilidade.setAbility(p, "POTPVP");
        p.setAllowFlight(false);
        ItemStack capacete0 = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack capacete1 = new ItemStack(Material.IRON_HELMET);
        ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
        Scoreboard.setScoreBoard(p);
        ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
        
        ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
        ItemStack Bota1 = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
        dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cEspada");
        dima.setItemMeta(souperaa);
        ItemStack sopa = new ItemStack(Material.POTION, 1, (short)16421);
        ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6Potinho Magico");
        sopa.setItemMeta(sopas);
        p.getInventory().addItem(new ItemStack[] { dima });
        p.getInventory().setChestplate(peitoral0);
        p.getInventory().setLeggings(calca0);
        p.getInventory().setBoots(Bota0);
        p.getInventory().setHelmet(capacete1);
        for (int i = 0; i <= 34; i++) {
          p.getInventory().addItem(new ItemStack[] { sopa });
        }
        p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fBem vindo(a) a WARP §4§lPOTPVP §f!");
        TitleAPI.sendTitle(p, Integer.valueOf(40), Integer.valueOf(40), Integer.valueOf(60), "§4§lWARP", "§f§lBem vindo(a) a POTPVP!");
      }
      if (args[0].equalsIgnoreCase("rdm"))
      {
        if (Habilidade.ContainsAbility(p))
        {
          p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoce ja escolheu um kit!");
          return true;
        }
        if (Main.plugin.getConfig().getString("RDM.World") == null)
        {
          p.sendMessage(API.NomeServer + "§fA Warp Evento RDM nao esta setada!");
          return true;
        }
        p.getInventory().clear();
        World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("RDM.World"));
        double x = Main.plugin.getConfig().getDouble("RDM.X");
        double y = Main.plugin.getConfig().getDouble("RDM.Y");
        double z = Main.plugin.getConfig().getDouble("RDM.Z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.plugin.getConfig().getDouble("RDM.Pitch"));
        lobby.setYaw((float)Main.plugin.getConfig().getDouble("RDM.Yaw"));
        p.getInventory().clear();
        p.teleport(lobby);
        p.setExp(0.0F);
        p.setExhaustion(20.0F);
        p.setFireTicks(0);
        p.setFoodLevel(20000);
        p.setHealth(20.0D);
        Habilidade.setAbility(p, "RDM");
        p.setAllowFlight(false);
        ItemStack capacete0 = new ItemStack(Material.DIAMOND_HELMET);
        ItemStack capacete1 = new ItemStack(Material.IRON_HELMET);
        ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
        Scoreboard.setScoreBoard(p);
        ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
        
        ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
        ItemStack Bota1 = new ItemStack(Material.DIAMOND_BOOTS);
        ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
        dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cEspada");
        dima.setItemMeta(souperaa);
        ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6Sopa");
        sopa.setItemMeta(sopas);
        p.getInventory().addItem(new ItemStack[] { dima });
        p.getInventory().setChestplate(peitoral0);
        p.getInventory().setLeggings(calca0);
        p.getInventory().setBoots(Bota0);
        p.getInventory().setHelmet(capacete1);
        for (int i = 0; i <= 34; i++) {
          p.getInventory().addItem(new ItemStack[] { sopa });
        }
        p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fBem-vindo(a) a WARP §4§lRDM §f!");
        p.sendMessage("§fComo o Evento §4§lRDM §fFunciona?");
        p.sendMessage("§fTodos os players que vão participar do evento devem estar nessa WARP.");
        p.sendMessage("§fApos isso todos serão puxados para fora do spawn da §4§lRDM");
        p.sendMessage("§fPor um Staff que usara o comando /puxarrdm e irão comecar a luta PVP");
        p.sendMessage("§fO último a ficar vivo ganhara um premio.");
        TitleAPI.sendTitle(p, Integer.valueOf(40), Integer.valueOf(40), Integer.valueOf(60), "§4§lWARP", "§f§lBem vindo a RDM!");
      }
      if (args[0].equalsIgnoreCase("challenge"))
      {
        if (Habilidade.ContainsAbility(p))
        {
          p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fVoce ja escolheu um kit!");
          return true;
        }
        if (Main.plugin.getConfig().getString("CHALLENGE.World") == null)
        {
          p.sendMessage(API.NomeServer + "§fA Warp LavaChallenge nao esta setada!");
          return true;
        }
        p.getInventory().clear();
        World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("CHALLENGE.World"));
        double x = Main.plugin.getConfig().getDouble("CHALLENGE.X");
        double y = Main.plugin.getConfig().getDouble("CHALLENGE.Y");
        double z = Main.plugin.getConfig().getDouble("CHALLENGE.Z");
        Location lobby = new Location(w, x, y, z);
        lobby.setPitch((float)Main.plugin.getConfig().getDouble("CHALLENGE.Pitch"));
        lobby.setYaw((float)Main.plugin.getConfig().getDouble("CHALLENGE.Yaw"));
        p.getInventory().clear();
        p.teleport(lobby);
        p.setExp(0.0F);
        p.setExhaustion(20.0F);
        p.setFireTicks(0);
        p.setFoodLevel(20000);
        p.setHealth(20.0D);
        Habilidade.setAbility(p, "CHALLENGE");
        p.setAllowFlight(false);
        ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("§6Sopa");
        sopa.setItemMeta(sopas);
        Main.give(p);
        Scoreboard.setScoreBoard(p);
        for (int i = 0; i <= 34; i++) {
          p.getInventory().addItem(new ItemStack[] { sopa });
        }
        p.sendMessage("§8(§4§lTSB§f§lPVP§8) §fBem vindo(a) a WARP §4§lLava Challange §f!");
        TitleAPI.sendTitle(p, Integer.valueOf(40), Integer.valueOf(40), Integer.valueOf(60), "§4§lWARP", "§f§lBem vindo a LAVA CHALLANGE!");
      }
    }
    return false;
  }
}
