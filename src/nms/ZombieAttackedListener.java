package nms;

import java.text.DecimalFormat;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class ZombieAttackedListener implements Listener{
	@EventHandler

public void onAttack(EntityDamageByEntityEvent event) {
		if(!event.getEntity().getMetadata(MainClass.ZombieKey).isEmpty()) {
			Entity zombie=event.getEntity();
			LivingEntity zombie2=(LivingEntity)zombie;
			DecimalFormat df=new DecimalFormat("#.#");
			Location location=zombie.getLocation();
			zombie.setCustomName(ChatColor.AQUA+"Dummy"+ChatColor.GRAY+" HP: "+ChatColor.RED+String.valueOf(df.format(zombie2.getHealth()-event.getDamage())));
		if(event.getDamager() instanceof Player) {
				event.getDamager().sendMessage(ChatColor.GRAY+"You have dealt "+ ChatColor.DARK_RED+String.valueOf(df.format(event.getDamage()))+ChatColor.GRAY+" of Damage to the Dummy.");
			
		}
		
				if(zombie.getMetadata(MainClass.ZombieHitKey).isEmpty()||zombie.getMetadata(MainClass.ZombieHitKey).get(0).asString().contentEquals(MainClass.ZombieHitValue)) {
					zombie.setMetadata(MainClass.ZombieHitKey, new FixedMetadataValue(MainClass.instance, "69"));
					
				new BukkitRunnable() {
					
					@Override
					public void run() {
							
							zombie.teleport(location);
							zombie.removeMetadata(MainClass.ZombieHitKey, MainClass.instance);
							
						
					}
				}.runTaskLater(MainClass.instance, 100);
			}
		}
		
	}
	}
