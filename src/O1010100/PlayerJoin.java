package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;

public class PlayerJoin implements Listener
{
	T3 plugin;
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent e)
	{
		
		Player p = e.getPlayer();
		Bukkit.broadcastMessage(p.getName()+" Has  Returned From Saturn, Neptune Or Perhaps Even Pluto!");

		if(p.hasPermission("T3.Survival"))
		{
			if(p.getGameMode()!=GameMode.SURVIVAL)
				p.setGameMode(GameMode.SURVIVAL);//Ensure Players Start On Survival Mode!
		}
		
		if(p.hasPermission("T3.StartSpawn"))
		{
			p.teleport(p.getWorld().getSpawnLocation());
		}
		
		if(T3.plugin.SpawnGifts)
		{
			if(p.getItemInHand().getType()==Material.AIR)
			{
				p.setItemInHand(new ItemStack(Material.STONE_SWORD,1));
				p.getItemInHand().addUnsafeEnchantment(Enchantment.DURABILITY, 3);
				p.getItemInHand().getItemMeta().setDisplayName(ChatColor.LIGHT_PURPLE+"Sword-"+ChatColor.AQUA+"O"+ChatColor.LIGHT_PURPLE+"-Stone");
				if(!p.getInventory().contains(Material.STONE_AXE))
				{
					p.getInventory().addItem(new ItemStack(Material.STONE_AXE,1));
				}
				if(!p.getInventory().contains(Material.STONE_PICKAXE))
				{
					p.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE,1));
				}
			}
		}
		
		if(!p.hasPermission("T3.NoFirework"))
		{
			//ToDo: Make This User Configurable
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(T3.plugin, new Runnable()
			{
				public void run()
				{
					Firework f = (Firework) e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
					FireworkMeta fm = f.getFireworkMeta();
					fm.addEffect(FireworkEffect.builder().flicker(true).trail(true).with(Type.CREEPER).withColor(Color.GREEN,Color.PURPLE).withFade(Color.AQUA).build());
					fm.setPower(2);
					f.setFireworkMeta(fm);					
				}
			}, 20);
		}//FireWork
		 /*
		if(p.hasPermission("T3.Troll"))
		{
			p.setFireTicks(5*20);
			p.chat(ChatColor.RED+"AHHHH! IM BURNNING! IM BURNNING!");
			p.chat(ChatColor.BLUE+"PUT ME OUT, PUT ME OUT, PUT ME OUT!");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(T3.plugin, new Runnable()
			{
				public void run()
				{
					e.getPlayer().setHealth(20d);
				}
			}, 20*9);
		}
		*/		
		if(p.isOp())
		{
			p.setAllowFlight(true);
			p.sendMessage(ChatColor.BLUE+"Flight "+ChatColor.GREEN+"Enabled!");
		}
	return;	
	}//onPlayerJoin()	

}
