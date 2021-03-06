package com.nuclearw.acidrain;

import java.io.File;
import java.util.List;

public class Config {
	// Static Strings
	public static String rainWarningMsg;

	// Static Ints
	public static int acidRainChance;
	public static int checkInterval;
	public static int damagePerInterval;
	public static int damageCutoffLevel;
	public static int poisonChance;
	public static int poisonDuration;

	// Static Booleans
	public static boolean rainWarning;
	public static boolean leatherRaincoat;
	public static boolean poisonRain;

	// Static Debug Booleans
	public static boolean verbose;

	// Static Lists
	public static List<String> enabledWorlds;
	
	public static void load(AcidRain plugin) {
		if(!new File(plugin.getDataFolder(), "config.yml").exists()) {
			plugin.saveDefaultConfig();
		}

		rainWarningMsg = plugin.getConfig().getString("rain-warning-msg");

		acidRainChance = plugin.getConfig().getInt("acid-rain-chance");
		checkInterval = plugin.getConfig().getInt("check-interval");
		damagePerInterval = plugin.getConfig().getInt("damage-per");
		damageCutoffLevel = plugin.getConfig().getInt("damage-cutoff");
		poisonChance = plugin.getConfig().getInt("poison-chance");
		poisonDuration = plugin.getConfig().getInt("poison-duration");

		rainWarning = plugin.getConfig().getBoolean("rain-warning");
		leatherRaincoat = plugin.getConfig().getBoolean("leather-raincoat");
		poisonRain = plugin.getConfig().getBoolean("poison-rain");

		verbose = plugin.getConfig().getBoolean("verbose");

		enabledWorlds = plugin.getConfig().getStringList("enabled-worlds");
		
		if(poisonChance < 0 || poisonChance > 100) {
			plugin.getLogger().warning("poison-chance in config.yml is not between 0 and 100; setting it back to 10.");
			poisonChance = 10;
		}

		if(acidRainChance < 0 || acidRainChance > 100) {
			plugin.getLogger().warning("acid-rain-chance in config.yml is not between 0 and 100; setting it back to 50.");
			acidRainChance = 50;
		}
	}
}
