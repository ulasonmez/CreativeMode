package me.blume.creativemode;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.blume.creativemode.listeners.BookRightClick;
import me.blume.creativemode.listeners.ItemCreater;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new ItemCreater(this), this);
		Bukkit.getPluginManager().registerEvents(new BookRightClick(this), this);
	}
	@Override
	public void onDisable() {
		
	}

}
