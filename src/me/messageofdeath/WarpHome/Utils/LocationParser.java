package me.messageofdeath.WarpHome.Utils;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class LocationParser {
	
	public static JavaPlugin plugin;

	public static Location stringToLocation(String loc1) {
		String[] loc = loc1.split(";");
		if(loc.length == 6) {
			return new Location(LocationParser.plugin.getServer().getWorld(loc[0]), Double.parseDouble(loc[1]), Double.parseDouble(loc[2]), Double.parseDouble(loc[3]),
					Float.parseFloat(loc[4]), Float.parseFloat(loc[5]));
		}
		return null;
	}
	
	public static String locationToString(Location loc) {
		return loc.getWorld().getName() + ";" + loc.getX() + ";" + loc.getY() + ";" + loc.getZ() + ";" + loc.getYaw() + ";" + loc.getPitch();
	}
}
