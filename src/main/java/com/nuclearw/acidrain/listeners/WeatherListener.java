package com.nuclearw.acidrain.listeners;

import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import com.nuclearw.acidrain.AcidRain;
import com.nuclearw.acidrain.Config;

public class WeatherListener implements Listener {
	private AcidRain plugin;
	private final Random rand = new Random();

	public WeatherListener(AcidRain plugin) {
		this.plugin = plugin;
	}

	@EventHandler(ignoreCancelled = true)
	public void weatherevent(WeatherChangeEvent event) {
		if(event.toWeatherState() == true) {
			if(Config.rainWarning) {
				World world = event.getWorld();

				if(rand.nextInt(100) < Config.acidRainChance) {
					plugin.raining.add(world);
				}

				List<Player> players = world.getPlayers();

				for(Player player : players) {
					if(player.hasPermission("acidrain.immune")) {return;}

					String formatedmsg = Config.rainWarningMsg;
					formatedmsg = ChatColor.translateAlternateColorCodes('&', formatedmsg);

					player.sendMessage(formatedmsg);
				}
			}
		} else {
			if(plugin.raining.contains(event.getWorld())) {
				plugin.raining.remove(event.getWorld());
			}
		}
	}
}
