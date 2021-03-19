package nms;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RightClickListener implements org.bukkit.event.Listener{
	Location location;
	@EventHandler
	
public void onClick(PlayerInteractEvent event) {
	if(event.getClickedBlock()!=null&&event.getPlayer().isOp()) {														//null check
		if(!event.getClickedBlock().getMetadata(MainClass.ControllerKey).isEmpty()) {					//null check
			
			if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)&&!event.getPlayer().isSneaking()) {			//actual checks
				InvHandler handler=new InvHandler(event.getPlayer());
				
				handler.OpenInv();
			}
			
		}
	
	}
	}
	
}
	
	


