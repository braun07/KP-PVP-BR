package me.RafaelAulerDeMeloAraujo.main;


import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

public class Nerf
  implements Listener
{
  @EventHandler
  public void NerfsDanos(EntityDamageByEntityEvent event)
  {
    if ((event.getDamager() instanceof Player))
    {
      Player player = (Player)event.getDamager();
      Player RECEIVER = (Player)event.getEntity();
      if ((event.getDamager() instanceof Player))
      {
        if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
          event.setDamage(3.5D);
        }
        if (player.getItemInHand().getType() == Material.STONE_SWORD) {
          event.setDamage(4.0D);
        }
        if (player.getItemInHand().getType() == Material.IRON_SWORD) {
          event.setDamage(5.0D);
        }
        if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
          event.setDamage(6.0D);
        }
        if (player.getItemInHand().getType() == Material.STICK) {
            event.setDamage(1.0D);
            return;
          }
        if (player.hasPermission("kitpvp.dano")) {
            event.setDamage(event.getDamage() + 2.0D);
            return;
          }
        if (RECEIVER.hasPermission("kitpvp.dano")) {
            event.setDamage(event.getDamage() - 1.0D);
            return;
          }
        if (player.getItemInHand().getType() == Material.WOOD_AXE) {
          event.setDamage(3.0D);
        }
        if (player.getItemInHand().getType() == Material.STONE_AXE) {
          event.setDamage(4.0D);
        }
        if (player.getItemInHand().getType() == Material.IRON_AXE) {
          event.setDamage(4.5D);
        }
        if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
          event.setDamage(6.0D);
        }
        if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
          event.setDamage(event.getDamage() + 1.0D);
        }
        if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE))
        {
          if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
            event.setDamage(event.getDamage() + 1.5D);
          }
          if (player.getItemInHand().getType() == Material.STONE_SWORD) {
            event.setDamage(event.getDamage() + 1.5D);
          }
          if (player.getItemInHand().getType() == Material.IRON_SWORD) {
            event.setDamage(event.getDamage() + 1.5D);
          }
          if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
            event.setDamage(event.getDamage() + 2.5D);
          }
          if (player.getItemInHand().getType() == Material.WOOD_AXE) {
            event.setDamage(event.getDamage() + 1.5D);
          }
          if (player.getItemInHand().getType() == Material.STONE_AXE) {
            event.setDamage(event.getDamage() + 1.5D);
          }
          if (player.getItemInHand().getType() == Material.IRON_AXE) {
            event.setDamage(event.getDamage() + 1.5D);
          }
          if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
            event.setDamage(event.getDamage() + 1.5D);
          }
          if ((player.getFallDistance() > 0.0F) && (!player.isOnGround()) && (!player.hasPotionEffect(PotionEffectType.BLINDNESS)))
          {
            if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
              event.setDamage(event.getDamage() + 1.0D);
            }
            if (player.getItemInHand().getType() == Material.STONE_SWORD) {
              event.setDamage(event.getDamage() + 1.0D);
            }
            if (player.getItemInHand().getType() == Material.IRON_SWORD) {
              event.setDamage(event.getDamage() + 1.0D);
            }
            if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
              event.setDamage(event.getDamage() + 1.0D);
            }
            if ((player.getFallDistance() > 0.0F) && (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)))
            {
              if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                event.setDamage(event.getDamage() + 2.5D);
              }
              if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                event.setDamage(event.getDamage() + 2.5D);
              }
              if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                event.setDamage(event.getDamage() + 2.5D);
              }
              if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                event.setDamage(event.getDamage() + 2.5D);
              }
              if (player.getItemInHand().getType() == Material.WOOD_AXE) {
                event.setDamage(event.getDamage() + 2.5D);
              }
              if (player.getItemInHand().getType() == Material.STONE_AXE) {
                event.setDamage(event.getDamage() + 2.5D);
              }
              if (player.getItemInHand().getType() == Material.IRON_AXE) {
                event.setDamage(event.getDamage() + 2.5D);
              }
              if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
                event.setDamage(event.getDamage() + 2.5D);
              }
            }
            if ((player.getFallDistance() > 0.0F) && (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) && (!player.isOnGround()))
            {
              if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
                event.setDamage(event.getDamage() + 1.5D);
              }
              if (player.getItemInHand().getType() == Material.STONE_SWORD) {
                event.setDamage(event.getDamage() + 1.5D);
              }
              if (player.getItemInHand().getType() == Material.IRON_SWORD) {
                event.setDamage(event.getDamage() + 1.5D);
              }
              if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
                event.setDamage(event.getDamage() + 1.5D);
              }
              if (player.getItemInHand().getType() == Material.WOOD_AXE) {
                event.setDamage(event.getDamage() + 1.5D);
              }
              if (player.getItemInHand().getType() == Material.STONE_AXE) {
                event.setDamage(event.getDamage() + 1.5D);
              }
              if (player.getItemInHand().getType() == Material.IRON_AXE) {
                event.setDamage(event.getDamage() + 1.5D);
              }
              if (player.getItemInHand().getType() == Material.DIAMOND_AXE) {
                event.setDamage(event.getDamage() + 1.5D);
              }
            }
          }
        }
      }
    }
  }
}
