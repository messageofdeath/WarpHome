package me.messageofdeath.WarpHome.Utils.HomeManager;

import java.util.ArrayList;
import java.util.UUID;

public class HomeManager {

	private ArrayList<Home> homes;
	
	public HomeManager() {
		this.homes = new ArrayList<Home>();
	}
	
	public void addHome(Home home) {
		if(!this.hasHome(home.getUUID(), home.getHomeName())) {
			this.homes.add(home);
		}
	}
	
	public void removeHome(UUID uuid, String homeName) {
		if(this.hasHome(uuid, homeName)) {
			this.homes.remove(this.getHome(uuid, homeName));
		}
	}
	
	public boolean hasHome(UUID uuid) {
		return !this.getHomes(uuid).isEmpty();
	}
	
	public boolean hasHome(UUID uuid, String homeName) {
		return this.getHome(uuid, homeName) != null;
	}
	
	public Home getHome(UUID uuid, String homeName) {
		for(Home home : this.homes) {
			if(home.getUUID() == uuid && home.getHomeName().equalsIgnoreCase(homeName)) {
				return home;
			}
		}
		return null;
	}
	
	public ArrayList<Home> getHomes(UUID uuid) {
		ArrayList<Home> homes = new ArrayList<Home>();
		for(Home home : this.homes) {
			if(home.getUUID() == uuid) {
				homes.add(home);
			}
		}
		return homes;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Home> getAllHomes() {
		return (ArrayList<Home>)this.homes.clone();
	}
}
