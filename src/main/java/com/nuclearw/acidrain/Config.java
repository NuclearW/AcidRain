package com.nuclearw.acidrain;

import java.io.File;

public class Config {
	public static int checkInterval;
	public static int damagePerInterval;
	public static int damageCutoffLevel;

	public static void load(AcidRain plugin) {
		if(!new File(plugin.getDataFolder() , "config.yml").exists()) {
			plugin.saveDefaultConfig();
		}

		checkInterval = plugin.getConfig().getInt("check-interval");
		damagePerInterval = plugin.getConfig().getInt("damage-per");
		damageCutoffLevel = plugin.getConfig().getInt("damage-cutoff");
	}
}
