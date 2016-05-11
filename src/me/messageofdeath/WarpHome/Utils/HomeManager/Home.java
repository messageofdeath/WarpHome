package me.messageofdeath.WarpHome.Utils.HomeManager;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Home {

	private JavaPlugin plugin;
	private UUID uuid;
	private String homeName, world;
	private double x, y, z; 
	private float yaw, pitch;
	
	public Home(JavaPlugin plugin, UUID uuid, String homeName, String world, double x, double y, double z, float yaw, float pitch) {
		this.plugin = plugin;
		this.uuid = uuid;
		this.homeName = homeName;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
	public UUID getUUID() {
		return this.uuid;
	}
	
	public String getHomeName() {
		return this.homeName;
	}
	
	public Player getPlayer() {
		return this.plugin.getServer().getPlayer(this.uuid);
	}
	
	public String getWorldName() {
		return this.world;
	}
	
	public Location getHomeLocation() {
		return new Location(this.plugin.getServer().getWorld(this.world), this.x, this.y, this.z, this.yaw, this.pitch);
	}
}
