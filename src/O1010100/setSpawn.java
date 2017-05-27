package O1010100;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setSpawn implements CommandExecutor 
{
	T3 plugin;
	public setSpawn(T3 plugin)
	{
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
	{
		if(sender.hasPermission("T3.setSpawn"))
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage("Sorry, Must Be Player To Use That Command");
				return true;
			}
			else
			{
				Player p = (Player)sender;
				World w = p.getWorld();
				Location loc = p.getLocation();
				w.setSpawnLocation(loc.getBlockX(),loc.getBlockY(),loc.getBlockZ());
				p.sendMessage(String.format("World Spawn Set ({0},{1},{2})", loc.getBlockX(),loc.getBlockY(),loc.getBlockZ()));
				return true;
			}
		}
		else
		{
			sender.sendMessage(ChatColor.RED+"Sorry, You Don't Have Permission To Do That...");
			return true;
		}
	}

}
