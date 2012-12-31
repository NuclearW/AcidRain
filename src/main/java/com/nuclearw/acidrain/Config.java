package com.nuclearw.acidrain;

import java.io.File;

public class Config {
	public static int checkInterval;
	public static int damagePerInterval;
	public static int damageCutoffLevel;
	public static int poisonchance;
	
	public static boolean leatherRaincoat;
	public static boolean poisonrain;
	
	public static boolean verbose;

	public static void load(AcidRain plugin) {
		if(!new File(plugin.getDataFolder() , "config.yml").exists()) {
			plugin.saveDefaultConfig();
		}

		checkInterval = plugin.getConfig().getInt("check-interval");
		damagePerInterval = plugin.getConfig().getInt("damage-per");
		damageCutoffLevel = plugin.getConfig().getInt("damage-cutoff");
		
		leatherRaincoat = plugin.getConfig().getBoolean("leather-raincoat");
		poisonrain = plugin.getConfig().getBoolean("poisonrain");
		
		verbose = plugin.getConfig().getBoolean("verbose");
	}
}
