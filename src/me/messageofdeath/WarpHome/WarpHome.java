package me.messageofdeath.WarpHome;

import org.bukkit.plugin.java.JavaPlugin;

import me.messageofdeath.WarpHome.Database.Database;
import me.messageofdeath.WarpHome.Utils.LocationParser;
import me.messageofdeath.WarpHome.Utils.HomeManager.HomeManager;
import me.messageofdeath.WarpHome.Utils.WarpManager.WarpManager;

public class WarpHome extends JavaPlugin {
	
	private Database database;
	private HomeManager homeManager;
	private WarpManager warpManager;

	@Override
	public void onEnable() {
		LocationParser.plugin = this;
		this.database = new Database(this);
		this.homeManager = new HomeManager();
		this.warpManager = new WarpManager();
		this.database.loadHomes();
		this.database.loadWarps();
	}
	
	@Override
	public void onDisable() {
		this.database.saveHomes();
		this.database.saveWarps();
	}
	
	public Database getDatabaseX() {
		return this.database;
	}
	
	public HomeManager getHomeManager() {
		return this.homeManager;
	}
	
	public WarpManager getWarpManager() {
		return this.warpManager;
	}
}
