package nms;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;


public class InvClickHandler implements org.bukkit.event.Listener{
	GUICommandExecutor executor;
@EventHandler
public void onInvClick(InventoryClickEvent event) {
	
	if(event.getView().getTitle().contentEquals(ChatColor.DARK_PURPLE+"Dummy Controller")){
	if (event.getCurrentItem()!=null) {
		if(event.getCurrentItem().hasItemMeta()) {
			Player player=(Player)event.getWhoClicked();
			executor=new GUICommandExecutor(player, player.getTargetBlockExact(5));		//watch for nullPointerException
		switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
		case "§cremove Dummy": 
			event.setCancelled(true);
			executor.removeDummy();
			break;
		case "§arespawn Dummy":
			event.setCancelled(true);
			executor.respawnDummy();
			break;
		case "§6pickup Dummy Station":
			event.setCancelled(true);
			executor.returnDummyStaion();
			break;
		case "§k42069":
			event.setCancelled(true);
			break;
		default:
			break;
		}
		}
	}
	}

}
}
