package com.nuclearw.acidrain.runnables;

import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

import com.nuclearw.acidrain.AcidRain;
import com.nuclearw.acidrain.Config;

public class Checker implements Runnable {
	private AcidRain plugin;

	public Checker(AcidRain plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {
		Player[] players = plugin.getServer().getOnlinePlayers();

		for(Player player : players) {
			if(player.getWorld().hasStorm()) {
				if(!player.hasPermission("acidrain.immune")) {
					int xLocation = player.getLocation().getBlockX();
					int zLocation = player.getLocation().getBlockX();

					Biome biomeLocation = player.getWorld().getBiome(xLocation, zLocation);

					switch(biomeLocation) {
						case DESERT:
						case DESERT_HILLS:
						case FROZEN_OCEAN:
						case FROZEN_RIVER:
						case HELL:
						case ICE_MOUNTAINS:
						case ICE_PLAINS:
						case SKY:
						case TAIGA:
						case TAIGA_HILLS:
							continue;
					}

					int yLocation = player.getLocation().getBlockY();

					int highestY = player.getWorld().getHighestBlockYAt(xLocation, zLocation);

					if(yLocation > highestY) {
						if(player.getHealth() > Config.damageCutoffLevel) {
							player.damage(Config.damagePerInterval);
						}
					}
				}
			}
		}
    }
}
