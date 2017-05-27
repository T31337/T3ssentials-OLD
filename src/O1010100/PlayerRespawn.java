package O1010100;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerRespawn implements Listener 
{
	T3 plugin;
	public PlayerRespawn(T3 plugin) 
	{
		this.plugin=plugin;
	}
	
	@EventHandler
	public void PlayerRespawning(PlayerRespawnEvent event)
	{
		if(event.getPlayer().hasPermission("T3.Respawn"))
			event.getPlayer().teleport(event.getPlayer().getWorld().getSpawnLocation());
		
		if(T3.plugin.SpawnGifts)
		{
			if(!event.getPlayer().getInventory().contains(Material.STONE_SWORD))
			{
						
				event.getPlayer().setItemInHand(new ItemStack(Material.STONE_SWORD,1));
				event.getPlayer().getItemInHand().addUnsafeEnchantment(Enchantment.DURABILITY, 3);
				event.getPlayer().getItemInHand().getItemMeta().setDisplayName(ChatColor.LIGHT_PURPLE+"Sword-"+ChatColor.AQUA+"O"+ChatColor.LIGHT_PURPLE+"-Stone");
				
				event.getPlayer().getInventory().addItem(new ItemStack(Material.APPLE,7));
				event.getPlayer().getInventory().addItem(new ItemStack(Material.STONE_AXE,1));
				event.getPlayer().getInventory().addItem(new ItemStack(Material.STONE_PICKAXE,1));
				event.getPlayer().getInventory().setHelmet(new ItemStack(Material.IRON_HELMET,1));
				event.getPlayer().getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE,1));
				event.getPlayer().getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS,1));
				event.getPlayer().getInventory().setBoots(new ItemStack(Material.IRON_BOOTS,1));
				
			}
		}
	}

}
