package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightCMD implements CommandExecutor 
{
	T3 plugin;
	public NightCMD(T3 plugin)
	{
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args)
	{
		if(sender.hasPermission("T3.Night"))
		{
			if(sender instanceof Player)
			{
				if(args.length==0)
				{
					Player p = (Player)sender;
					p.getWorld().setTime(19l);
					p.sendMessage("Time Adjusted");
					return true;
				}
				else
				{
					Bukkit.getWorld(args[1]).setTime(19l);
					sender.sendMessage("Time Adjusted");
					return true;
				}
			}
			else
			{
				Bukkit.getWorld(args[1]).setTime(19l);
				sender.sendMessage("Time Adjusted");
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
