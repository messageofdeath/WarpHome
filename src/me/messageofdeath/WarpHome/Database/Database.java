package me.messageofdeath.WarpHome.Database;

import org.bukkit.plugin.java.JavaPlugin;

import me.messageofdeath.WarpHome.Utils.YamlDatabase;

public class Database {

	private YamlDatabase db;
	
	public Database(JavaPlugin plugin) {
		this.db = new YamlDatabase(plugin, "database");
		this.db.onStartUp();
	}
	
	public String getHome() {
		return null;
	}
}
