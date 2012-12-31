package com.nuclearw.acidrain;

import org.bukkit.plugin.java.JavaPlugin;

public class AcidRain extends JavaPlugin {
	
	@Override
	public void onEnable() {
		Config.load(this);

		getLogger().info("Finished loading " + getDescription().getFullName());
	}

	@Override
	public void onDisable() {
		getLogger().info("Finished unloading " + getDescription().getFullName());
	}
}
