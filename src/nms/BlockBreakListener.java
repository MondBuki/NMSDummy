package nms;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener{
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
	if(!event.getBlock().getMetadata(MainClass.StructureKey).isEmpty()||!event.getBlock().getMetadata(MainClass.ControllerKey).isEmpty()) {
		event.setCancelled(true);
	}
}
}
