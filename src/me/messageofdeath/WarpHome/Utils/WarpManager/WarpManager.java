package me.messageofdeath.WarpHome.Utils.WarpManager;

import java.util.ArrayList;

public class WarpManager {

	private ArrayList<Warp> warps;
	
	public WarpManager() {
		this.warps = new ArrayList<Warp>();
	}
	
	public void addWarp(Warp warp) {
		if(!this.hasWarp(warp.getName())) {
			this.warps.add(warp);
		}
	}
	
	public void removeWarp(String name) {
		if(this.hasWarp(name)) {
			this.warps.remove(this.getWarp(name));
		}
	}
	
	public boolean hasWarp(String name) {
		return this.getWarp(name) != null;
	}
	
	public Warp getWarp(String name) {
		for(Warp warp : this.warps) {
			if(warp.getName().equalsIgnoreCase(name)) {
				return warp;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Warp> getAllWarps() {
		return (ArrayList<Warp>)this.warps.clone();
	}
}
