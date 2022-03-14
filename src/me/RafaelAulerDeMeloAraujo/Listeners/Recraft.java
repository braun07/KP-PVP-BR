package me.RafaelAulerDeMeloAraujo.Listeners;





	


	import org.bukkit.Bukkit;
	import org.bukkit.Material;
	import org.bukkit.Server;
	import org.bukkit.block.Block;
	import org.bukkit.block.Sign;
	import org.bukkit.entity.Player;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
	import org.bukkit.event.block.Action;
	import org.bukkit.event.block.SignChangeEvent;
	import org.bukkit.event.player.PlayerInteractEvent;
	import org.bukkit.inventory.Inventory;
	import org.bukkit.inventory.ItemStack;
	import org.bukkit.inventory.meta.ItemMeta;

	public class Recraft
	  implements Listener
	{
	  private Recraft plugin;
	  
	  public Recraft(Recraft instance)
	  {
	    this.plugin = instance;
	  }
	  
	  public Recraft() {}
	  
	  @EventHandler
	  public void onSignChange(SignChangeEvent e)
	  {
	    if (e.getLine(0).equalsIgnoreCase("recraft"))
	    {
	      e.setLine(0, "§4§l-=-= (!) =-=-");
	      e.setLine(1, "§1§lRECRAFT");
	      e.setLine(2, "§6§lGRATIS");
	      e.setLine(3, "§4§l-=-= (!) =-=-");
	    }
	  }
	  
	  @EventHandler
	  public void inv(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    
	    ItemStack sopas = new ItemStack(Material.BOWL, 64);
	    ItemMeta ksopas = sopas.getItemMeta();
	    ksopas.setDisplayName("§4Pote");
	    sopas.setItemMeta(ksopas);
	    
	    ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
	    ItemMeta kcogur = cogur.getItemMeta();
	    kcogur.setDisplayName("§3--> §cVermelho §3<--");
	    cogur.setItemMeta(kcogur);
	    
	    ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
	    ItemMeta kcogum = cogum.getItemMeta();
	    kcogum.setDisplayName("§3--> §8Marrom §3<--");
	    cogum.setItemMeta(kcogum);
	    
	    Inventory inve = Bukkit.getServer().createInventory(p, 36, "§bRecraft");
	    
	    inve.setItem(0, sopas);
	    inve.setItem(1, sopas);
	    inve.setItem(2, sopas);
	    inve.setItem(3, sopas);
	    inve.setItem(4, sopas);
	    inve.setItem(5, sopas);
	    inve.setItem(6, sopas);
	    inve.setItem(7, sopas);
	    inve.setItem(8, sopas);
	    inve.setItem(9, sopas);
	    inve.setItem(10, sopas);
	    inve.setItem(11, sopas);
	    inve.setItem(12, sopas);
	    inve.setItem(13, sopas);
	    inve.setItem(14, sopas);
	    inve.setItem(15, sopas);
	    inve.setItem(16, sopas);
	    inve.setItem(17, sopas);
	    inve.setItem(27, cogur);
	    inve.setItem(28, cogur);
	    inve.setItem(29, cogur);
	    inve.setItem(30, cogur);
	    inve.setItem(31, cogur);
	    inve.setItem(32, cogur);
	    inve.setItem(33, cogur);
	    inve.setItem(34, cogur);
	    inve.setItem(35, cogur);
	    inve.setItem(18, cogum);
	    inve.setItem(19, cogum);
	    inve.setItem(20, cogum);
	    inve.setItem(21, cogum);
	    inve.setItem(22, cogum);
	    inve.setItem(23, cogum);
	    inve.setItem(24, cogum);
	    inve.setItem(25, cogum);
	    inve.setItem(26, cogum);
	    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null) && (
	      (e.getClickedBlock().getType() == Material.WALL_SIGN) || (e.getClickedBlock().getType() == Material.SIGN_POST)))
	    {
	      Sign s = (Sign)e.getClickedBlock().getState();
	      String[] lines = s.getLines();
	      if ((lines.length > 0) && (lines[0].equals("§4§l-=-= (!) =-=-")) && 
	        (lines.length > 1) && (lines[1].equals("§1§lRECRAFT")) && 
	        (lines.length > 2) && (lines[2].equals("§6§lGRATIS")) && 
	        (lines.length > 3) && (lines[3].equals("§4§l-=-= (!) =-=-"))) {
	        p.openInventory(inve);
	      }
	    }
	  }
	  
	  }
	

