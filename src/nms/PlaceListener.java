package nms;





import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;



public class PlaceListener implements Listener{
	
	@EventHandler
public void onPlace(BlockPlaceEvent event) {
		if(!event.getBlockAgainst().getMetadata(MainClass.ControllerKey).isEmpty()){
			//event.getPlayer().sendMessage("has metadata");
			
				if(!event.getPlayer().isSneaking()) {
					event.setCancelled(true);
							}
		}else if(event.getItemInHand().getItemMeta().getLore()!=null){
				if(event.getPlayer().isOp()) {
			if(event.getItemInHand().getItemMeta().getLore().get(0).contentEquals("Generates a Dummy Station")) {
		Block block=event.getBlock();
		block.setMetadata(MainClass.ControllerKey, new FixedMetadataValue(MainClass.instance, MainClass.ControllerValue));
		
		
		//System.out.println(block.getBlockData().getAsString());
		
		StationBuilder stationBuilder=new StationBuilder(block.getLocation(), block.getWorld(),event.getPlayer().getFacing());
		
		stationBuilder.build();
			}
		
			}
		/*
		Location chestLoc = block.getLocation();
        chestLoc.getBlock().setType(Material.CHEST);
        Chest chest = (Chest) chestLoc.getBlock().getState();
        Inventory inv = chest.getInventory();
        ItemStack ds = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta dm = ds.getItemMeta();
        dm.setDisplayName("Example");
        ds.setItemMeta(dm);
        inv.addItem(ds);*/
		}
}
}
