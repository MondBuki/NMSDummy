package nms;



import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class GUICommandExecutor {
	boolean isZombieThere;
	Block block;
	Player player;
	Location location;
	
public GUICommandExecutor(Player ply, Block blok) {
	block=blok;
	player=ply;
	location=block.getLocation();
	isZombieThere=true;
	}
public void removeDummy() {
	for (Entity e: player.getWorld().getEntities()) {
		if(!e.getMetadata(MainClass.ZombieKey).isEmpty()&&e.getLocation().distance(location)<3){
			e.remove();
			
	}
	
	
	}
	
}

public void respawnDummy() {
		
		check();
		
		if(isZombieThere==false) {
			MyZombie zombie;
			switch (block.getBlockData().getAsString()) {
		case "minecraft:black_glazed_terracotta[facing=south]"://north
			zombie=new MyZombie(new Location(block.getWorld(), location.getX()+1.5, location.getY(), location.getZ()-0.5));
			zombie.spawn();
				break;
		case "minecraft:black_glazed_terracotta[facing=north]"://south
			zombie=new MyZombie(new Location(block.getWorld(), location.getX()-0.5, location.getY(), location.getZ()+1.3));
			zombie.getBukkitEntity().setRotation(180, 0);
			zombie.spawn();
			break;
		case "minecraft:black_glazed_terracotta[facing=west]"://east
			zombie=new MyZombie(new Location(block.getWorld(), location.getX()+1.5, location.getY(), location.getZ()-0.5));
			zombie.getBukkitEntity().setRotation(90, 0);
			zombie.spawn();
			break;
		case "minecraft:black_glazed_terracotta[facing=east]"://west
			zombie=new MyZombie(new Location(block.getWorld(), location.getX()-0.2, location.getY(), location.getZ()+1.5));
			zombie.getBukkitEntity().setRotation(-90, 0);
			zombie.spawn();
			break;
			}

		isZombieThere=true;
		}
		
	
}
public void returnDummyStaion() {
	if(!block.getMetadata(MainClass.ControllerKey).isEmpty()) {
	removeDummy();
	double x=location.getX();
	double y=location.getY()-1;
	double z=location.getZ();
	org.bukkit.World world=location.getWorld();
	org.bukkit.Material air=org.bukkit.Material.AIR;
	Block thus;
	Block below;	//below
	Block belowToRight;	//1right
	Block belowToRight2;//2right
	Block belowToUp;	//1up
	Block belowToUp2;	//2up
	Block middle;		//1up 1right
	Block diagOut;		//2up 2right
	Block topMiddle;	//2up 1right
	Block rightMiddle;	//1up 2right
	switch (block.getBlockData().getAsString()) {
	case "minecraft:black_glazed_terracotta[facing=south]"://north
		thus=new Location(world, x, y+1, z).getBlock();
		below=new Location(world, x, y, z).getBlock();			//to right x> to forward z<
		belowToRight=new Location(world, x+1, y, z).getBlock();
		belowToRight2=new Location(world, x+2, y, z).getBlock();
		belowToUp=new Location(world, x, y, z-1).getBlock();
		belowToUp2=new Location(world, x, y, z-2).getBlock();
		middle=new Location(world, x+1, y, z-1).getBlock();
		diagOut=new Location(world, x+2, y, z-2).getBlock();
		rightMiddle=new Location(world, x+2, y, z-1).getBlock();
		topMiddle=new Location(world, x+1, y, z-2).getBlock();
			break;
	case "minecraft:black_glazed_terracotta[facing=north]"://south
		thus=new Location(world, x, y+1, z).getBlock();
		below=new Location(world, x, y, z).getBlock();			//to right x< to forward z>
		belowToRight=new Location(world, x-1, y, z).getBlock();
		belowToRight2=new Location(world, x-2, y, z).getBlock();
		belowToUp=new Location(world, x, y, z+1).getBlock();
		belowToUp2=new Location(world, x, y, z+2).getBlock();
		middle=new Location(world, x-1, y, z+1).getBlock();
		diagOut=new Location(world, x-2, y, z+2).getBlock();
		rightMiddle=new Location(world, x-2, y, z+1).getBlock();
		topMiddle=new Location(world, x-1, y, z+2).getBlock();
		break;
	case "minecraft:black_glazed_terracotta[facing=west]"://east
		thus=new Location(world, x, y+1, z).getBlock();
		below=new Location(world, x, y, z).getBlock();			//to right z< to forward x<
		belowToRight=new Location(world, x+1, y, z).getBlock();
		belowToRight2=new Location(world, x+2, y, z).getBlock();
		belowToUp=new Location(world, x, y, z-1).getBlock();
		belowToUp2=new Location(world, x, y, z-2).getBlock();
		middle=new Location(world, x+1, y, z-1).getBlock();
		diagOut=new Location(world, x+2, y, z-2).getBlock();
		rightMiddle=new Location(world, x+1, y, z-2).getBlock();
		topMiddle=new Location(world, x+2, y, z-1).getBlock();
		break;
	case "minecraft:black_glazed_terracotta[facing=east]"://west
		thus=new Location(world, x, y+1, z).getBlock();
		below=new Location(world, x, y, z).getBlock();			//to right z> to forward x>
		belowToRight=new Location(world, x-1, y, z).getBlock();
		belowToRight2=new Location(world, x-2, y, z).getBlock();
		belowToUp=new Location(world, x, y, z+1).getBlock();
		belowToUp2=new Location(world, x, y, z+2).getBlock();
		middle=new Location(world, x-1, y, z+1).getBlock();
		diagOut=new Location(world, x-2, y, z+2).getBlock();
		rightMiddle=new Location(world, x-1, y, z+2).getBlock();
		topMiddle=new Location(world, x-2, y, z+1).getBlock();
		break;
		default:
			thus=new Location(world, x, y+1, z).getBlock();
			below=new Location(world, x, y, z).getBlock();			
			belowToRight=new Location(world, x+1, y, z).getBlock();
			belowToRight2=new Location(world, x+2, y, z).getBlock();
			belowToUp=new Location(world, x, y, z-1).getBlock();
			belowToUp2=new Location(world, x, y, z-2).getBlock();
			middle=new Location(world, x+1, y, z-1).getBlock();
			diagOut=new Location(world, x+2, y, z-2).getBlock();
			rightMiddle=new Location(world, x+2, y, z-1).getBlock();
			topMiddle=new Location(world, x+1, y, z-2).getBlock();
			break;
	}
	thus.setType(air);
	thus.removeMetadata(MainClass.ControllerKey, MainClass.instance);
	below.setType(air);
	below.removeMetadata(MainClass.StructureKey, MainClass.instance);
	belowToRight.setType(air);
	belowToRight.removeMetadata(MainClass.StructureKey, MainClass.instance);
	belowToRight2.setType(air);
	belowToRight2.removeMetadata(MainClass.StructureKey, MainClass.instance);
	belowToUp.setType(air);
	belowToUp.removeMetadata(MainClass.StructureKey, MainClass.instance);
	belowToUp2.setType(air);
	belowToUp2.removeMetadata(MainClass.StructureKey, MainClass.instance);
	topMiddle.setType(air);
	topMiddle.removeMetadata(MainClass.StructureKey, MainClass.instance);
	rightMiddle.setType(air);
	rightMiddle.removeMetadata(MainClass.StructureKey, MainClass.instance);
	middle.setType(air);
	middle.removeMetadata(MainClass.StructureKey, MainClass.instance);
	diagOut.setType(air);
	diagOut.removeMetadata(MainClass.StructureKey, MainClass.instance);
	
	
	org.bukkit.inventory.ItemStack stack=new org.bukkit.inventory.ItemStack(Material.BLACK_GLAZED_TERRACOTTA);
	ItemMeta meta=stack.getItemMeta();
	java.util.List<String> list= new ArrayList<String>();
	
	list.add("Generates a Dummy Station");
	meta.setLore(list);
	
	meta.setDisplayName(ChatColor.AQUA+"Dummy Controller");
	stack.setItemMeta(meta);
	if(player.getInventory().firstEmpty()==-1){						//checks if inventory is full
	player.getWorld().dropItem(player.getLocation(), stack);
	}else {
		player.getInventory().addItem(stack);
	}
}else {
	player.sendMessage(ChatColor.RED+"Stand still while clicking on the Controller!");
}
}
private void check() {
	for (Entity e: player.getWorld().getEntities()) {
		if(e.getLocation().distance(location)<3) {
			if(!e.getMetadata(MainClass.ZombieKey).isEmpty()){
				isZombieThere=true;
				return;
			}
		
		}else {
			isZombieThere=false;
		
		}
	}
	
}

}