package me.messageofdeath.WarpHome.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.messageofdeath.WarpHome.WarpHome;
import me.messageofdeath.WarpHome.Utils.WarpManager.Warp;

public class WarpCommand implements CommandExecutor {
	
	private WarpHome plugin;
	private String permission;
	
	public WarpCommand(WarpHome plugin) {
		this.plugin = plugin;
		this.permission = "warphome.warp.";
	}
	
	/*
	 *  /warp - list all warps
	 *  /warp list - list all warps
	 *  /warp help - displays commands
	 *  /warp <name> - warp to location - Requires permission warphome.warp.<name>
	 *  /warp add <name> - creates warp at location - Requires permission warphome.warp.add
	 *  /warp remove <name> - removes warp - Requires permission warphome.warp.remove
	 */
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(args.length == 0 || args.length == 1 && args[0].equalsIgnoreCase("help") || args.length > 2) {
			//send help
		}else if(args.length == 1 && args[0].equalsIgnoreCase("list")) {
			//send list of warps
		}else if(args.length == 1) {
			if(sender instanceof Player) {
				if(this.plugin.getWarpManager().hasWarp(args[0])) {
					if(sender.hasPermission(this.permission + args[0].toLowerCase())) {
						((Player)sender).teleport(this.plugin.getWarpManager().getWarp(args[0]).getWarpLocation());
						//Complete - Teleported
					}else{
						//Error - Player does not have permission
					}
				}else{
					//Error - Warp does not exist
				}
			}else{
				//Error - Have to be player
			}
		}else if(args.length == 2) {
			if(args[0].equalsIgnoreCase("add")) {
				if(sender instanceof Player) {
					if(sender.hasPermission(this.permission + "add")) {
						if(!this.plugin.getWarpManager().hasWarp(args[1])) {
							Warp warp = new Warp(this.plugin, args[1], ((Player)sender).getLocation());
							this.plugin.getWarpManager().addWarp(warp);
							this.plugin.getDatabaseX().saveWarp(warp);
							//Complete - Created a new warp
						}else{
							//Error - Warp already exists
						}
					}else{
						//Error - does not have permission
					}
				}else{
					//Error - Has to be player
				}
			}else if(args[0].equalsIgnoreCase("remove")){
				if(sender.hasPermission(this.permission + "remove")) {
					if(this.plugin.getWarpManager().hasWarp(args[1])) {
						Warp warp = this.plugin.getWarpManager().getWarp(args[1]);
						this.plugin.getWarpManager().removeWarp(warp.getName());
						this.plugin.getDatabaseX().deleteWarp(warp);
						//Complete - Warp deleted
					}else{
						//Error - Warp does not exist
					}
				}else{
					//Error- does not have permission
				}
			}
		}
		return false;
	}
}
