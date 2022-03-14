package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.potion.*;

import me.RafaelAulerDeMeloAraujo.main.Main;

import org.bukkit.entity.*;
import org.bukkit.block.*;
import org.bukkit.event.*;

public class Poseidon implements Listener
{
	 @EventHandler
	  public void aoPoseidon(PlayerMoveEvent e)
	  {
	    Player p = e.getPlayer();
	    Block b = p.getLocation().getBlock();
	    if ((Habilidade.getAbility(p).equalsIgnoreCase("Poseidon")) && ((b.getType() == Material.WATER) || (b.getType() == Material.STATIONARY_WATER)))
	    {
	    	API.darEfeito(p, PotionEffectType.INCREASE_DAMAGE, Main.kits.getInt("PoseidonStrenghtTime"), Main.kits.getInt("PoseidonStrenghtAmplifier"));
            API.darEfeito(p, PotionEffectType.DAMAGE_RESISTANCE, Main.kits.getInt("PoseidonDamageResistanceTime"), Main.kits.getInt("PoseidonDamageResistanceAmplifier"));
            API.darEfeito(p, PotionEffectType.SPEED, Main.kits.getInt("PoseidonSpeedTime"), Main.kits.getInt("PoseidonSpeedAmplifier"));
	    }
	  }
    }












