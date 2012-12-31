package com.nuclearw.acidrain.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherEvent;

import com.nuclearw.acidrain.AcidRain;
import com.nuclearw.acidrain.Config;

public class WeatherListener implements Listener
{
	AcidRain plugin;
	
	public WeatherListener(AcidRain plugin)
	{
		this.plugin = plugin;
	}
	
	@EventHandler(ignoreCancelled = true)
	public void weatherevent(WeatherEvent event)
	{
		if(event.getWorld().isThundering())
		{
			if(Config.rainwarning)
			{
				plugin.getServer().broadcastMessage(Config.rainwarningmsg);
			}
		}
	}
}
