package nms;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InvHandler {
	ItemStack respawnDummy=new ItemStack(Material.LIME_DYE);
	ItemStack removeDummy =new ItemStack(Material.RED_DYE);
	ItemStack pickupController=new ItemStack(Material.ORANGE_DYE);
	ItemStack filler	  =new ItemStack(Material.GLASS_PANE);
	
	ItemMeta respawnDummyMeta=respawnDummy.getItemMeta();
	ItemMeta removeDummyMeta =removeDummy.getItemMeta();
	ItemMeta pickupControllerMeta=pickupController.getItemMeta();
	ItemMeta fillerMeta=filler.getItemMeta();
	Inventory inv;
	
	Player player;
	
	
	public InvHandler(Player ply) {
		player=ply;
		respawnDummyMeta.setDisplayName(ChatColor.GREEN+"respawn Dummy");
		removeDummyMeta.setDisplayName(ChatColor.RED+"remove Dummy");
		pickupControllerMeta.setDisplayName(ChatColor.GOLD+"pickup Dummy Station");
		fillerMeta.setDisplayName(ChatColor.MAGIC+"42069");
		
		
		respawnDummy.setItemMeta(respawnDummyMeta);
		removeDummy.setItemMeta(removeDummyMeta);
		pickupController.setItemMeta(pickupControllerMeta);
		filler.setItemMeta(fillerMeta);
	}
	public void OpenInv() {
		inv=Bukkit.createInventory(player, InventoryType.HOPPER, ChatColor.DARK_PURPLE+"Dummy Controller");
		inv.setItem(0, removeDummy);
		inv.setItem(2, respawnDummy);
		inv.setItem(4, pickupController);
		inv.setItem(1, filler);
		inv.setItem(3, filler);
		player.openInventory(inv);
}
}
