package com.nuclearw.acidrain.listeners;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import com.nuclearw.acidrain.AcidRain;
import com.nuclearw.acidrain.Config;

public class WeatherListener implements Listener {
	AcidRain plugin;
	
	public WeatherListener(AcidRain plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(ignoreCancelled = true)
	public void weatherevent(WeatherChangeEvent event) {
		if(event.toWeatherState() == true) {
			if(Config.rainwarning) {
				World world = event.getWorld();
				
				List<Player> players = world.getPlayers();
				
				for (Player player : players) {
					String formatedmsg = Config.rainwarningmsg;
					formatedmsg = ChatColor.translateAlternateColorCodes('&', formatedmsg);
					
					player.sendMessage(formatedmsg);
				}
			}
		}
	}
}
