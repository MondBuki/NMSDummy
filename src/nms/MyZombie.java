package nms;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashSet;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.CraftWorld;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.metadata.FixedMetadataValue;

import net.minecraft.server.v1_15_R1.ChatMessage;
import net.minecraft.server.v1_15_R1.EntityZombie;
import net.minecraft.server.v1_15_R1.GenericAttributes;
import net.minecraft.server.v1_15_R1.IChatBaseComponent;
import net.minecraft.server.v1_15_R1.PathfinderGoal;
import net.minecraft.server.v1_15_R1.PathfinderGoalSelector;

public class MyZombie extends EntityZombie{
	Location location;
	float health;
	public MyZombie(Location loc) {
		super(((CraftWorld)loc.getWorld()).getHandle());
		location=loc;
		health=1000;
        this.setPosition(loc.getX(), loc.getY(), loc.getZ());
        this.getAttributeInstance(GenericAttributes.MAX_HEALTH).setValue(1000);
        this.setPositionRotation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
    	//this.setNoAI(true);

    	this.setHealth(health);
    	
    	this.setSilent(true);
    	this.setCanPickupLoot(false);
    	
 
    	this.getBukkitEntity().setMetadata(MainClass.ZombieKey, new FixedMetadataValue(MainClass.instance, MainClass.ZombieValue));
    
    	this.expToDrop=0;
    	IChatBaseComponent component=new ChatMessage(ChatColor.AQUA+"TestDummy"+ChatColor.RED+" "+String.valueOf(Math.round(health)));
    	this.setCustomName(component);
      
       
        try {
            java.lang.reflect.Field dField;
            dField = PathfinderGoalSelector.class.getDeclaredField("d");
            dField.setAccessible(true);
            dField.set(goalSelector, new LinkedHashSet<>());
            dField.set(targetSelector, new LinkedHashSet<>());
           
            java.lang.reflect.Field cField;
            cField = PathfinderGoalSelector.class.getDeclaredField("c");
            cField.setAccessible(true);
            dField.set(goalSelector, new LinkedHashSet<>());
            cField.set(targetSelector, new EnumMap<>(PathfinderGoal.Type.class));
           
            java.lang.reflect.Field fField;
            fField = PathfinderGoalSelector.class.getDeclaredField("f");
            fField.setAccessible(true);
            dField.set(goalSelector, new LinkedHashSet<>());
            fField.set(targetSelector, EnumSet.noneOf(PathfinderGoal.Type.class));
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    	
        
       }
	/*public MyZombie(org.bukkit.World world, Location loc) {
		super((World) world);
		this.setPosition(location.getX(), location.getY(),location.getZ());
		this.setCustomName(new ChatMessage(ChatColor.RED+name));
		this.setCustomNameVisible(true);
		this.setNoAI(true);
		this.setInvisible(true);
	}
   public void editName(String newName) {
	   name=newName;
	   */
   
	public void spawn() {
		((CraftWorld)location.getWorld()).getHandle().addEntity(this, SpawnReason.CUSTOM);
	}
	
	public boolean K_() {		//overrides isSunAffected to return false
		return false;
	}
}
