package com.nuclearw.acidrain.runnables;

import com.nuclearw.acidrain.AcidRain;
import com.nuclearw.acidrain.Config;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

public class Checker implements Runnable {
	private AcidRain plugin;

	public Checker(AcidRain plugin) {
		this.plugin = plugin;
	}

	@Override
	public void run() {
		Player[] players = plugin.getServer().getOnlinePlayers();

		for(Player player : players) {
			if(!player.getWorld().hasStorm()) continue;
			if(player.hasPermission("acidrain.immune")) continue;

			int xLocation = player.getLocation().getBlockX();
			int zLocation = player.getLocation().getBlockX();

			Biome biomeLocation = player.getWorld().getBiome(xLocation, zLocation);

			plugin.verbose("Player: " + player.getName() + " X: " + xLocation + " Z: " + zLocation + " Biome: " + biomeLocation.toString());

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

			if(yLocation <= highestY) continue;
			if(player.getHealth() <= Config.damageCutoffLevel) continue;

			plugin.verbose("Player: " + player.getName() + " Y: " + yLocation + " HighestY: " + highestY);

			player.damage(Config.damagePerInterval);
		}
	}
}
