package me.blume.creativemode.listeners;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.blume.creativemode.Main;

public class BookRightClick implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;
	public BookRightClick(Main plugin) {
		this.plugin=plugin;
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onRightClick(PlayerInteractEvent event){
		Action action = event.getAction();
		ItemStack item = event.getItem();
		Player player = event.getPlayer();
		if(action==Action.RIGHT_CLICK_AIR || action==Action.RIGHT_CLICK_BLOCK) {

			
			if(item!=null && item.getEnchantmentLevel(Enchantment.DURABILITY)==1881) {
				player.getInventory().setItemInHand(new ItemStack(Material.AIR));
				player.setGameMode(GameMode.CREATIVE);
				player.setFlySpeed((float) 0.1);
				Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){
					@Override
					public void run() {
						player.setGameMode(GameMode.SURVIVAL);
					}
				}, 5*20L);
				
			}
			if(item!=null && item.getEnchantmentLevel(Enchantment.DURABILITY)==1938) {
				player.getInventory().setItemInHand(new ItemStack(Material.AIR));
				player.setGameMode(GameMode.CREATIVE);
				player.setFlySpeed((float) 0.5);
				Bukkit.getScheduler().runTaskLater(plugin, new Runnable(){
					@Override
					public void run() {
						player.setGameMode(GameMode.SURVIVAL);
					}
				}, 10*10L);
				
			}
		}
	}
}
