package me.messageofdeath.WarpHome.Database;

import java.util.ArrayList;
import java.util.UUID;

import me.messageofdeath.WarpHome.WarpHome;
import me.messageofdeath.WarpHome.Utils.LocationParser;
import me.messageofdeath.WarpHome.Utils.YamlDatabase;
import me.messageofdeath.WarpHome.Utils.HomeManager.Home;
import me.messageofdeath.WarpHome.Utils.WarpManager.Warp;

public class Database {
	
	private WarpHome plugin;
	private YamlDatabase db;
	
	public Database(WarpHome plugin) {
		this.plugin = plugin;
		this.db = new YamlDatabase(plugin, "database");
		this.db.onStartUp();
	}
	
	public void loadHomes() {
		String prefix = "homes";
		for(String uuid : this.db.getStringArray(prefix, new ArrayList<String>())) {
			prefix = "homes" + "." + uuid;
			for(String homeName : this.db.getStringArray(prefix, new ArrayList<String>())) {
				prefix = "homes" + "." + uuid + "." + homeName + ".";
				this.plugin.getHomeManager().addHome(new Home(this.plugin, UUID.fromString(uuid), homeName, this.db.getBoolean(prefix + "isDefault", false),
						LocationParser.stringToLocation(this.db.getString(prefix + "Location", ""))));
			}
		}
	}
	
	public void loadWarps() {
		for(String name : this.db.getStringArray("warps", new ArrayList<String>())) {
			this.plugin.getWarpManager().addWarp(new Warp(this.plugin, name, LocationParser.stringToLocation(this.db.getString("warps" + "." + name, ""))));
		}
	}
	
	public void saveHome(Home home) {
		String prefix = "homes." + home.getUUID().toString() + "." + home.getHomeName() + ".";
		this.db.set(prefix + "isDefault", home.isDefault());
		this.db.set(prefix + "Location", LocationParser.locationToString(home.getHomeLocation()));
	}
	
	public void saveHomes() {
		for(Home home : this.plugin.getHomeManager().getAllHomes()) {
			this.saveHome(home);
		}
	}
	
	public void saveWarp(Warp warp) {
		this.db.set("warps." + warp.getName(), LocationParser.locationToString(warp.getWarpLocation()));
	}
	
	public void saveWarps() {
		for(Warp warp : this.plugin.getWarpManager().getAllWarps()) {
			this.saveWarp(warp);
		}
	}
}
