package O1010100;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class rl implements CommandExecutor 
{
	T3 plugin;
	public rl(T3 plugin)
	{
		this.plugin=plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String cmdName,String[] args)
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage("Sorry, Only Players May Use The /rl Command...");
			return true;
		}
		else
		{
			if(sender.hasPermission("T3.RandomLocation"))
			{
				int distance = 1500;
				Player player = (Player) sender;
				int randomX =  (int) (Math.random() * distance);
				int randomZ = (int)(Math.random()*distance);
			
				int randomY = player.getWorld().getHighestBlockYAt(randomX, randomZ)+1;//+1 to avoid getting stuck in that block
				
				Location randomLocation = new Location(player.getWorld(),randomX,randomY,randomZ);				
				Material uf = player.getWorld().getBlockAt((int)randomLocation.getX(),(int)randomLocation.getY(),(int)randomLocation.getZ()).getType();
				while(uf == Material.LAVA || uf == Material.WATER || uf == Material.AIR)
				{
					randomLocation = new Location(player.getWorld(),randomX,randomY,randomZ);
					uf = player.getWorld().getBlockAt((int)randomLocation.getX(),(int)randomLocation.getY(),(int)randomLocation.getZ()).getType();
				}
				player.sendMessage("Teleported To: X:"+randomX+" Y:"+randomY+" Z:"+randomZ);
				player.teleport(randomLocation);
				return true;

			}
			else
			{
				sender.sendMessage(ChatColor.RED+"Sorry, You Do Not Have Permission To Do That...");
				plugin.log.info(sender.getName()+" Was DENIED Access To /rl");
				return true;
			}
		}
	}

}
