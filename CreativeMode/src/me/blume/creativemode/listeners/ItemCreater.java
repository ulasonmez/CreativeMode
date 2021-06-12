package me.blume.creativemode.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.blume.creativemode.Main;
import net.md_5.bungee.api.ChatColor;

public class ItemCreater implements Listener{

	@SuppressWarnings("unused")
	private Main plugin;
	public ItemCreater(Main plugin) {
		this.plugin=plugin;
	}

  
	public static ItemStack getBook() {
		Random rand = new Random();
		ItemStack book = new ItemStack(Material.BOOK);
		ItemMeta meta = book.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD+"Creative Mode");
		meta.addEnchant(Enchantment.DURABILITY, 1881, true);
		ArrayList<String> lore = new ArrayList<String>();
		int a = rand.nextInt(374)+123;
		lore.add(Integer.toString(a));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		book.setItemMeta(meta);
		return book;
	}
	public static ItemStack getAwesomeBook() {
		Random rand = new Random();
		ItemStack book = new ItemStack(Material.BOOK);
		ItemMeta meta = book.getItemMeta();
		meta.setDisplayName(ChatColor.RED+"Super Creative Mode");
		meta.addEnchant(Enchantment.DURABILITY, 1938, true);
		ArrayList<String> lore = new ArrayList<String>();
		int a = rand.nextInt(374)+123;
		lore.add(Integer.toString(a));
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		book.setItemMeta(meta);
		return book;
	}
	public static void removeBook(Player player) {
		player.getInventory().remove(ItemCreater.getBook());
	}
	
	
	@SuppressWarnings("serial")
	@EventHandler
	public void craftstick(PrepareItemCraftEvent event) {
		CraftingInventory inv = event.getInventory();
		if(inv.getMatrix().length<9) return;
		checkCraft(getBook(),inv,new HashMap<Integer,ItemStack>(){{
			put(0,new ItemStack(Material.GOLD_INGOT));
			put(1,new ItemStack(Material.GOLD_INGOT));
			put(2,new ItemStack(Material.GOLD_INGOT));
			put(3,new ItemStack(Material.GOLD_INGOT));
			put(4,new ItemStack(Material.BOOK));
			put(5,new ItemStack(Material.GOLD_INGOT));
			put(6,new ItemStack(Material.GOLD_INGOT));
			put(7,new ItemStack(Material.GOLD_INGOT));
			put(8,new ItemStack(Material.GOLD_INGOT));
			/*
			 *  0 1 2
			 *  3 4 5
			 *  6 7 8
			 */
		}});
		checkCraft(getAwesomeBook(),inv,new HashMap<Integer,ItemStack>(){{
			put(0,new ItemStack(Material.GOLD_BLOCK));
			put(1,new ItemStack(Material.GOLD_BLOCK));
			put(2,new ItemStack(Material.GOLD_BLOCK));
			put(3,new ItemStack(Material.GOLD_BLOCK));
			put(4,new ItemStack(Material.BOOK));
			put(5,new ItemStack(Material.GOLD_BLOCK));
			put(6,new ItemStack(Material.GOLD_BLOCK));
			put(7,new ItemStack(Material.GOLD_BLOCK));
			put(8,new ItemStack(Material.GOLD_BLOCK));
		}});

	}
	
	
	public void checkCraft(ItemStack result,CraftingInventory inv,HashMap<Integer, ItemStack> ingredients) {
		ItemStack[] matrix = inv.getMatrix();
		for(int i =0;i<9;i++) {
			if(ingredients.containsKey(i)) {
				if(matrix[i]==null || !matrix[i].equals(ingredients.get(i))) {
					return;
				}
			}
			else {
				if(matrix[i]!=null) {
					return;
				}
			}
		}
			inv.setResult(result);
	}
}
