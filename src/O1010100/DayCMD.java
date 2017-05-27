package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DayCMD implements CommandExecutor 
{
	T3 plugin;

	public DayCMD(T3 plugin) 
	{
		this.plugin=plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) 
	{
		if(sender.hasPermission("T3.Day"))
		{
			if(sender instanceof Player)
			{
				if(args.length==0)
				{
					Player p = (Player)sender;
					p.getWorld().setTime(7l);
					return true;
				}
				else
				{
					Bukkit.getWorld(args[1]).setTime(7l);
					return true;
				}
			}
			else
			{
				Bukkit.getWorld(args[1]).setTime(7l);
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
