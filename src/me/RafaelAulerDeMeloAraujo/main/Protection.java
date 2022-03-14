package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;

import org.bukkit.event.Listener;


public class Protection implements Listener {



@EventHandler(priority = EventPriority.HIGHEST)
public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
	
	if (event.getEntity() instanceof Player && (event.getDamager() instanceof Player)) {

		final Player damaged = (Player) event.getEntity();
		if (Habilidade.getAbility(damaged) == "None") {
			event.setCancelled(true);
		}
		if (Habilidade.getAbility(damaged) == "CHALLENGE") {
			event.setCancelled(true);
		}
		if (Habilidade.getAbility(damaged) == "RDM") {
			event.setCancelled(true);
		}
		if (Habilidade.getAbility(damaged) == Main.cfg_x1.getString("x1.ability")) {
			event.setCancelled(true);
		}
	}
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageByEntity(final EntityDamageEvent event) {
		
		if (event.getEntity() instanceof Player) {

			final Player damaged = (Player) event.getEntity();
			if (Habilidade.getAbility(damaged) == "None") {
				event.setCancelled(true);
			}
}
}
}