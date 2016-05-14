package me.messageofdeath.WarpHome.Utils.HomeManager;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.messageofdeath.WarpHome.WarpHome;

public class Home {

	private WarpHome plugin;
	private UUID uuid;
	private String homeName, world;
	private boolean isDefault;
	private double x, y, z; 
	private float yaw, pitch;
	
	public Home(WarpHome plugin, UUID uuid, String homeName, boolean isDefault, Location loc) {
		this.plugin = plugin;
		this.uuid = uuid;
		this.homeName = homeName;
		this.isDefault = isDefault;
		this.world = loc.getWorld().getName();
		this.x = loc.getX();
		this.y = loc.getY();
		this.z = loc.getZ();
		this.yaw = loc.getYaw();
		this.pitch = loc.getPitch();
	}
	
	public UUID getUUID() {
		return this.uuid;
	}
	
	public String getHomeName() {
		return this.homeName;
	}
	
	public boolean isDefault() {
		return this.isDefault;
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
