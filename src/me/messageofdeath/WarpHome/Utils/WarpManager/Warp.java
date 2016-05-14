package me.messageofdeath.WarpHome.Utils.WarpManager;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class Warp {

	private JavaPlugin plugin;
	private String name, world;
	private double x, y, z; 
	private float yaw, pitch;
	
	public Warp(JavaPlugin plugin, String name, Location loc) {
		this.plugin = plugin;
		this.name = name;
		this.world = loc.getWorld().getName();
		this.x = loc.getX();
		this.y = loc.getY();
		this.z = loc.getZ();
		this.yaw = loc.getYaw();
		this.pitch = loc.getPitch();
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getWorldName() {
		return this.world;
	}
	
	public Location getWarpLocation() {
		return new Location(this.plugin.getServer().getWorld(this.world), this.x, this.y, this.z, this.yaw, this.pitch);
	}
}
