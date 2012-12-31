package com.nuclearw.acidrain;

import java.io.File;

public class Config {
	public static int checkInterval;
	public static int damagePerInterval;
	public static int damageCutoffLevel;
	public static int poisonChance;
	public static int poisonDuration;

	public static boolean leatherRaincoat;
	public static boolean poisonRain;

	public static boolean verbose;

	public static void load(AcidRain plugin) {
		if (!new File(plugin.getDataFolder(), "config.yml").exists()) {
			plugin.saveDefaultConfig();
		}

		checkInterval = plugin.getConfig().getInt("check-interval");
		damagePerInterval = plugin.getConfig().getInt("damage-per");
		damageCutoffLevel = plugin.getConfig().getInt("damage-cutoff");
		poisonChance = plugin.getConfig().getInt("poison-chance");
		poisonDuration = plugin.getConfig().getInt("poison-duration");

		leatherRaincoat = plugin.getConfig().getBoolean("leather-raincoat");
		poisonRain = plugin.getConfig().getBoolean("poison-rain");

		verbose = plugin.getConfig().getBoolean("verbose");

		if (poisonChance < 0 || poisonChance > 100) {
			plugin.getLogger().warning("poison-chance in config.yml is not between 0 and 100; setting it back to 10.");
			poisonChance = 10;
		}
	}
}
