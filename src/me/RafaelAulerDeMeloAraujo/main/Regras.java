package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Regras implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
			sender.sendMessage("§a\n§c§l            REGRAS \n \n§c1. §7Não utilize nenhum tipo Cheat ou Trapaça.\n§c2. §7Não faça ofensas a equipe ou a jogadores.\n§c3. §7Não abuse de bug's, reporte a equipe. \n§c4. §7Não divulgue outros servidores.\n§c5. §7Não tenha nenhum tipo de Trapaça em seu computador.\n§c6. §7Não ofenda o servidor.\n§c7. §7Não ameaçe o servidor, equipe e jogadores.\n§c8. §7Nao peça cargos.\n§c9. §7Não forje nenhum tipo de Trapaça.\n§c10. §7Evite spam.\n§c11. §7Nao e permitido 3x1 (Exceto na Arena normal)\n \n§cNão obedecer essas regras pode te levar a ter punições em nossa network.");
            return true;
	}

}
