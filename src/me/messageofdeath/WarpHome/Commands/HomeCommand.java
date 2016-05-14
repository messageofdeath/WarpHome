package me.messageofdeath.WarpHome.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.messageofdeath.WarpHome.WarpHome;

public class HomeCommand implements CommandExecutor {

	private WarpHome plugin;
	
	public HomeCommand(WarpHome plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		return false;
	}
}
