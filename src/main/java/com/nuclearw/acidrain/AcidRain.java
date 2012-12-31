package com.nuclearw.acidrain;

import com.nuclearw.acidrain.runnables.Checker;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class AcidRain extends JavaPlugin {

	@Override
	public void onEnable() {
		Config.load(this);

		BukkitScheduler bs = getServer().getScheduler();
		bs.scheduleSyncRepeatingTask(this, new Checker(this), 0L, Config.checkInterval * 20L);

		getLogger().info("Finished loading " + getDescription().getFullName());
	}

	@Override
	public void onDisable() {
		getLogger().info("Finished unloading " + getDescription().getFullName());
	}

	/**
	 * Logs a message to the console if verbose-mode is on in the config.
	 *
	 * @param s Message to log
	 */
	public void verbose(String s) {
		if (Config.verbose) {
			getLogger().info(s);
		}
	}
}
