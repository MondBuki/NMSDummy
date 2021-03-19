package nms;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.metadata.FixedMetadataValue;

public class StationBuilder {
	Location location;
	World world;
	Material glowstone=Material.GLOWSTONE;
	Material smooth_stone=Material.SMOOTH_STONE;
	BlockFace blockFace;
public StationBuilder(Location loc, World wrld, BlockFace face) {
	location=loc;
	world=wrld;
	blockFace=face;
}
public void build() {
	double x=location.getX();
	double y=location.getY()-1;
	double z=location.getZ();
	
	Block below;	//below
	Block belowToRight;	//1right
	Block belowToRight2;//2right
	Block belowToUp;	//1up
	Block belowToUp2;	//2up
	Block middle;		//1up 1right
	Block diagOut;		//2up 2right
	Block topMiddle;	//2up 1right
	Block rightMiddle;	//1up 2right
	MyZombie zombie;
	switch (blockFace) {
	case NORTH:
		below=new Location(world, x, y, z).getBlock();			//to right x> to forward z<
		belowToRight=new Location(world, x+1, y, z).getBlock();
		belowToRight2=new Location(world, x+2, y, z).getBlock();
		belowToUp=new Location(world, x, y, z-1).getBlock();
		belowToUp2=new Location(world, x, y, z-2).getBlock();
		middle=new Location(world, x+1, y, z-1).getBlock();
		diagOut=new Location(world, x+2, y, z-2).getBlock();
		rightMiddle=new Location(world, x+2, y, z-1).getBlock();
		topMiddle=new Location(world, x+1, y, z-2).getBlock();
		zombie=new MyZombie(new Location(world, location.getX()+1.5, location.getY(),location.getZ()-0.35));
		
		
		break;
	case SOUTH:
		below=new Location(world, x, y, z).getBlock();			//to right x< to forward z>
		belowToRight=new Location(world, x-1, y, z).getBlock();
		belowToRight2=new Location(world, x-2, y, z).getBlock();
		belowToUp=new Location(world, x, y, z+1).getBlock();
		belowToUp2=new Location(world, x, y, z+2).getBlock();
		middle=new Location(world, x-1, y, z+1).getBlock();
		diagOut=new Location(world, x-2, y, z+2).getBlock();
		rightMiddle=new Location(world, x-2, y, z+1).getBlock();
		topMiddle=new Location(world, x-1, y, z+2).getBlock();
		zombie=new MyZombie(new Location(world, middle.getLocation().getX()+0.5, middle.getLocation().getY()+1, middle.getLocation().getZ()+0.5));
		zombie.getBukkitEntity().setRotation(180, 0);
		break;
	case EAST:
		below=new Location(world, x, y, z).getBlock();			//to right z< to forward x<
		belowToRight=new Location(world, x+1, y, z).getBlock();
		belowToRight2=new Location(world, x+2, y, z).getBlock();
		belowToUp=new Location(world, x, y, z-1).getBlock();
		belowToUp2=new Location(world, x, y, z-2).getBlock();
		middle=new Location(world, x+1, y, z-1).getBlock();
		diagOut=new Location(world, x+2, y, z-2).getBlock();
		rightMiddle=new Location(world, x+1, y, z-2).getBlock();
		topMiddle=new Location(world, x+2, y, z-1).getBlock();
		zombie=new MyZombie(new Location(world, middle.getLocation().getX()+0.5, middle.getLocation().getY()+1, middle.getLocation().getZ()+0.5));
		zombie.getBukkitEntity().setRotation(90, 0);
		break;
	case WEST:
		below=new Location(world, x, y, z).getBlock();			//to right z> to forward x>
		belowToRight=new Location(world, x-1, y, z).getBlock();
		belowToRight2=new Location(world, x-2, y, z).getBlock();
		belowToUp=new Location(world, x, y, z+1).getBlock();
		belowToUp2=new Location(world, x, y, z+2).getBlock();
		middle=new Location(world, x-1, y, z+1).getBlock();
		diagOut=new Location(world, x-2, y, z+2).getBlock();
		rightMiddle=new Location(world, x-1, y, z+2).getBlock();
		topMiddle=new Location(world, x-2, y, z+1).getBlock();
		zombie=new MyZombie(new Location(world, middle.getLocation().getX()+0.5, middle.getLocation().getY()+1, middle.getLocation().getZ()+0.5));
		zombie.getBukkitEntity().setRotation(-90, 0);
		break;

	default:
		below=new Location(world, x, y, z).getBlock();			//to right x> to forward z<
		belowToRight=new Location(world, x+1, y, z).getBlock();
		belowToRight2=new Location(world, x+2, y, z).getBlock();
		belowToUp=new Location(world, x, y, z-1).getBlock();
		belowToUp2=new Location(world, x, y, z-2).getBlock();
		middle=new Location(world, x+1, y, z-1).getBlock();
		diagOut=new Location(world, x+2, y, z-2).getBlock();
		rightMiddle=new Location(world, x+2, y, z-1).getBlock();
		topMiddle=new Location(world, x+1, y, z-2).getBlock();
		zombie=new MyZombie(new Location(world, middle.getLocation().getX()+0.5, middle.getLocation().getY()+1, middle.getLocation().getZ()+0.5));
		break;
	}
	
	below.setType(glowstone);
	below.setMetadata(MainClass.StructureKey, new FixedMetadataValue(MainClass.instance, MainClass.StructureValue));
	belowToRight.setType(smooth_stone);
	belowToRight.setMetadata(MainClass.StructureKey, new FixedMetadataValue(MainClass.instance, MainClass.StructureValue));
	belowToRight2.setType(glowstone);
	belowToRight2.setMetadata(MainClass.StructureKey, new FixedMetadataValue(MainClass.instance, MainClass.StructureValue));
	belowToUp.setType(smooth_stone);
	belowToUp.setMetadata(MainClass.StructureKey, new FixedMetadataValue(MainClass.instance, MainClass.StructureValue));
	belowToUp2.setType(glowstone);
	belowToUp2.setMetadata(MainClass.StructureKey, new FixedMetadataValue(MainClass.instance, MainClass.StructureValue));
	topMiddle.setType(smooth_stone);
	topMiddle.setMetadata(MainClass.StructureKey, new FixedMetadataValue(MainClass.instance, MainClass.StructureValue));
	rightMiddle.setType(smooth_stone);
	rightMiddle.setMetadata(MainClass.StructureKey, new FixedMetadataValue(MainClass.instance, MainClass.StructureValue));
	middle.setType(glowstone);
	middle.setMetadata(MainClass.StructureKey, new FixedMetadataValue(MainClass.instance, MainClass.StructureValue));
	diagOut.setType(glowstone);
	diagOut.setMetadata(MainClass.StructureKey, new FixedMetadataValue(MainClass.instance, MainClass.StructureValue));
	zombie.spawn();
	//zombie.spawn();
	//belowToRight.setType(Material.SMOOTH_STONE);
	//belowToUp.setType(Material.SMOOTH_STONE);
}
}
