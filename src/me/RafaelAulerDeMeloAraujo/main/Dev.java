/*    */ package me.RafaelAulerDeMeloAraujo.main;
/*    */ 
/*    */ 
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;

/*    */ 
/*    */ 
/*    */ public class Dev
/*    */   implements CommandExecutor
/*    */ {
/*    */   
/*    */   static Main plugin;
/*    */   
/*    */   public Dev(Main main)
/*    */   {
/* 19 */     this.plugin = main;
/* 20 */     plugin = main;
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 25 */     
/* 26 */     if (label.equalsIgnoreCase("dev")) {
	/* 27 */       sender.sendMessage("\n§4§l\u274C §2§lCREDITOS §f§lE §e§lINFORMACAO §4§l \u274C");
	/* 28 */       sender.sendMessage("§6\u279C §cNome do Plugin: §eKP-PVP (Modificado)");
	/* 29 */       sender.sendMessage("§6\u279C §cVersao: §e" + Main.getInstance().getDescription().getVersion());
	/* 30 */       sender.sendMessage("§6\u279C §cAutor 1: §ezEnderX5_ , Rafael Auler ");
				   sender.sendMessage("§6\u279C §cAutor 2: §eSeeligLeo , Leonardo Seelig Junior");
				   sender.sendMessage("§6\u279C §cAutor 3: §e7Braun , Joao Vitor Braun");
	/* 31 */       sender.sendMessage("§6\u279C §cYoutube: http://bit.ly/2kC345B");
	/* 32 */       sender.sendMessage("§6\u279C §cSpigot: http://bit.ly/2j5qvnM");
	/* 33 */       sender.sendMessage("§6\u279C §cPagina: http://bit.ly/2BZCtLE");
	/* 36 */       sender.sendMessage("§cPS: §eSe inscreva no Cannal e me siga no Spigot! Obrigado!");
/* 37 */       
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\main\Dev.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
