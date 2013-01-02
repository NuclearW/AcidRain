package com.nuclearw.acidrain.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nuclearw.acidrain.AcidRain;
import com.nuclearw.acidrain.Config;

public class BaseCommandExecutor implements CommandExecutor {
	private AcidRain plugin;

	public BaseCommandExecutor(AcidRain plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length > 0) {
			// todo: add help subcommand
			if(args[0].equalsIgnoreCase("reload")) {
				if(!sender.hasPermission("acidrain.reload")) {
					if(sender instanceof Player) {
						sender.sendMessage(ChatColor.RED + "You do not have permission to do this!");
						return true;
					}

					plugin.getLogger().info("You do not have permission to do this!");
					return true;
				}

				plugin.reloadConfig();
				Config.load(plugin);

				if(sender instanceof Player) {	
					sender.sendMessage(ChatColor.GREEN + "Config Reloaded!");
					return true;
				}

				plugin.getLogger().info("Config Reloaded!");
				return true;
			}

			if(sender instanceof Player) {
				sender.sendMessage(ChatColor.RED + "Unknown Sub-Command");
				return true;
			}

			plugin.getLogger().info("Unknown Sub-Command");
			return true;
		}
		return false;
	}

}
