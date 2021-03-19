package nms;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;


public class Command implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender Sender, org.bukkit.command.Command Command, String Alias, String[] args) {
		if(Sender instanceof Player) {
			if(Sender.isOp()) {
				if(args.length>0) {
					
					if(args[0].contentEquals("help")) {
						Sender.sendMessage(ChatColor.RED+"This Command Grants you an item that will generate a Dummy Station to test out weapons. Do not place dummy stations too close together. Dummy Stations will stop working if you stop the server. The Dummy can be pushed away from its starting position. If its too far away, the Controller wont kill it. Use the /kill command to kill the zombie then ");
					}
				}else {
		Player player=(Player)Sender;
		
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
		
		
	}
	}
		}
		return true;
}
	
}
