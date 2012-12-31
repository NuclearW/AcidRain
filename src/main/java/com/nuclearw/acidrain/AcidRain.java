package com.nuclearw.acidrain;

import com.nuclearw.acidrain.runnables.Checker;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class AcidRain extends JavaPlugin {

	@Override
	public void onEnable() {
		Config.load(this);

        BukkitScheduler bs = getServer().getScheduler();
        bs.scheduleSyncRepeatingTask(this, new Checker(), 0L, Config.checkInterval * 20L);

		getLogger().info("Finished loading " + getDescription().getFullName());
	}

	@Override
	public void onDisable() {
		getLogger().info("Finished unloading " + getDescription().getFullName());
	}
}
