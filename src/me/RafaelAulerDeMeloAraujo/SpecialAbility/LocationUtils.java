package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import me.RafaelAulerDeMeloAraujo.main.Main;


public class LocationUtils {

public static Location getLocation() {
	String wname = Main.plugin.getConfig().getString("Spawn.World");
	
	if(wname == null || wname.equalsIgnoreCase("")) {
		return null;
	} else {
		World w = Bukkit.getServer().getWorld(wname);
		double x = Main.plugin.getConfig().getDouble("Spawn.X");
		double y = Main.plugin.getConfig().getDouble("Spawn.Y");
		double z = Main.plugin.getConfig().getDouble("Spawn.Z");
		float yaw = Main.plugin.getConfig().getInt("Spawn.Yaw");
		float pitch = Main.plugin.getConfig().getInt("Spawn.Pitch");
		
		return new Location(w, x, y, z, yaw, pitch);
	}
}
}