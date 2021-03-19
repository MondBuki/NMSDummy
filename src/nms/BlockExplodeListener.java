package nms;

import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class BlockExplodeListener implements Listener{
@EventHandler

public void onExplode(EntityExplodeEvent event) {
	for (Block block : new ArrayList<Block>(event.blockList())) {
		
		if(!block.getMetadata(MainClass.StructureKey).isEmpty()||!block.getMetadata(MainClass.ControllerKey).isEmpty()) {
		
			 event.blockList().remove(block);
		
	}
	}
}
}
