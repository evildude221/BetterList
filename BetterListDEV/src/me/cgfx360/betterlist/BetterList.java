package me.cgfx360.betterlist;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;



public class BetterList extends JavaPlugin{
	
	public final Logger logger = Logger.getLogger("Minecraft");
	
	
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Has Been Disabled!");
	
	}
    
	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	
	    if ((commandLabel.equalsIgnoreCase("list"))) {
	        
	    	  Player p = (Player) sender;
	    	  Location loc = p.getLocation();
	    	  p.playSound(loc, Sound.ORB_PICKUP, 8, -20);
	    
	        StringBuilder staff = new StringBuilder();
	        StringBuilder online = new StringBuilder();
	        for (Player player : Bukkit.getOnlinePlayers()){
	            if (player.hasPermission("BetterList.Staff")) {
	                staff.append(staff.length() != 0 ? ", " : "").append(player.getName());
	            } else {
	                
	                online.append(online.length() != 0 ? ", " : "").append(player.getName());
	            }
	        }
	        sender.sendMessage(ChatColor.BLUE.toString() + "                                                     ");
	        sender.sendMessage(ChatColor.RED.toString() + "=====================================================");
	        sender.sendMessage(ChatColor.BLUE.toString() + "                                                     ");
	        sender.sendMessage(ChatColor.YELLOW.toString() + "Players Online: " + ChatColor.GOLD + Bukkit.getOnlinePlayers().length + "/" + Bukkit.getServer().getMaxPlayers());
	        sender.sendMessage(ChatColor.BLUE.toString() + "                                                     ");
	        sender.sendMessage(ChatColor.YELLOW.toString() + "Staff Online: " + ChatColor.GOLD + staff.toString());
	        sender.sendMessage(ChatColor.BLUE.toString() + "                                                     ");
	        sender.sendMessage(ChatColor.RED.toString() + "=====================================================");
	        sender.sendMessage(ChatColor.BLUE.toString() + "                                                     ");
	        sender.sendMessage(ChatColor.BLUE.toString() + "                                                     ");
	        return true;
	    }
	    return false;
	}	

	
	
	
}


