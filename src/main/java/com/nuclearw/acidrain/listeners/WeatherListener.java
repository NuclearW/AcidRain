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
	AcidRain plugin;
	
	private final Random r = new Random();
	public boolean rainIsAcidic = false;
	
	public WeatherListener(AcidRain plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler(ignoreCancelled = true)
	public void weatherevent(WeatherChangeEvent event) {
		if(event.toWeatherState() == true) {
			
			if (r.nextInt(100) < Config.acidRainChance) {
				rainIsAcidic = true;
				}
			
			if(Config.rainWarning && rainIsAcidic == true) {
				World world = event.getWorld();
				
				List<Player> players = world.getPlayers();
				
				for (Player player : players) {
					if(player.hasPermission("acidrain.immune")) {return;}
					
					String formatedmsg = Config.rainWarningMsg;
					formatedmsg = ChatColor.translateAlternateColorCodes('&', formatedmsg);
					
					player.sendMessage(formatedmsg);
				}
			}
		}
	}
	
	 public boolean isRainAcidic(){ 
		return rainIsAcidic;
	}
	
}
