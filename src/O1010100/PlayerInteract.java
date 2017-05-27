package O1010100;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Witch;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener
{
	@EventHandler
	public void Interact(PlayerInteractEvent e)
	{
		Player p = e.getPlayer();
		if(e.getClickedBlock() instanceof Witch)
		{
			if(p.getItemInHand().getType()==Material.AIR)
			{
				
				p.setItemInHand(new ItemStack(Material.GOLDEN_APPLE,1));
				T3.plugin.setItemName(new ItemStack(Material.GOLDEN_APPLE,1), ChatColor.DARK_AQUA+"Mysterious Apple");
			}
		}
		if(p.getItemInHand().toString().contains("BoomStick!")&&(e.getAction().equals(Action.RIGHT_CLICK_AIR)))
			{
				if(p.hasPermission("T3.BoomStick"))
				{
					Snowball snowball = p.getWorld().spawn(p.getEyeLocation(), Snowball.class);//Spawn The SnowBall
					snowball.setVelocity(p.getLocation().getDirection().multiply(1.5)); //Make It Fly
					snowball.setShooter(p);
					
				}
				else
				{
					p.sendMessage(ChatColor.RED+"Sorry, You Do Not Have Permission To Use A "+ChatColor.BLUE+"BoomStick!");
				}
			}
		if(p.getItemInHand().toString().contains("BoomStick!")&&(e.getAction().equals(Action.LEFT_CLICK_AIR)))
		{
			if(p.hasPermission("T3.BoomStick"))
			{
				Arrow Arrow = p.getWorld().spawn(p.getEyeLocation(), Arrow.class);
				Arrow.setVelocity(p.getLocation().getDirection().multiply(1.5));
				Arrow.setShooter(p);
			}
			else
			{
				p.sendMessage(ChatColor.RED+"Sorry, You Do Not Have Permission To Use A "+ChatColor.BLUE+"BoomStick!");
			}
		}
	}
}
