package me.RafaelAulerDeMeloAraujo.Listeners;



import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Horse;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.Plugin;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.main.Main;

/*    */ public class PlaceEvent
/*    */   implements Listener
/*    */ {
    @EventHandler
    public void onPlayerInteractGlad(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.BEACON && Habilidade.getAbility(p).equalsIgnoreCase("Ryu")) {
            e.setCancelled(true);
            p.updateInventory();
        }
    }
        @EventHandler
        public void onPlayerInteractGlad2(final PlayerInteractEvent e) {
            final Player p = e.getPlayer();
            if (p.getItemInHand().getType() == Material.TNT && Habilidade.getAbility(p).equalsIgnoreCase("Bomber")) {
                e.setCancelled(true);
                p.updateInventory();
            }
    }
@EventHandler
public void NaoSpawnarMobs(final CreatureSpawnEvent e) {
    if (e.getEntity() instanceof Creeper) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Skeleton) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Spider) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Wither) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Zombie) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Slime) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Ghast) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof PigZombie) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Pig) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Enderman) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof CaveSpider) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Silverfish) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Blaze) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof MagmaCube) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Witch) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Sheep) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Horse) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Rabbit) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Cow) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Chicken) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Squid) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof MushroomCow) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Ocelot) {
        e.setCancelled(true);
    }
    if (e.getEntity() instanceof Villager) {
        e.setCancelled(false);
    }
    if (e.getEntity() instanceof EnderDragon) {
        e.setCancelled(true);
    }
}
@EventHandler(priority = EventPriority.NORMAL)
public void onChuva(final WeatherChangeEvent e) {
    if (e.toWeatherState()) {
        e.setCancelled(true);
    }
}
@EventHandler
public void onItemDrop(final ItemSpawnEvent e) {
    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.getInstance(), (Runnable)new Runnable() {
        @Override
        public void run() {
            e.getEntity().remove();
            e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 10);
        }
    }, 20L);
}
}
 