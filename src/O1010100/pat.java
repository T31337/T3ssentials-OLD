package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class pat implements CommandExecutor
{
	T3 plugin;
	public pat(T3 plugin)
	{
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args) 
	{
		if(sender.hasPermission("T3.Pat"))
		{
			if(args.length==0||args.length>=2)
			{
				sender.sendMessage("Usage: /pat <player>");
				return true;
			}
			else
			{
				if(!(args[0]==sender.getName()))
				{
					Player target = (Player) Bukkit.getServer().getPlayer(args[0]);
					if (!target.isOnline())
					{
						sender.sendMessage(ChatColor.RED+target.getDisplayName()+" Is Not Online!");
						return true;
					}
					else
					{
						Bukkit.broadcastMessage(sender.getName()+ChatColor.LIGHT_PURPLE+" Just Patted " +ChatColor.BLUE+target.getDisplayName()+ChatColor.LIGHT_PURPLE+" On The Back! :)");  
						return true;
					}
				}
				else
				{
					sender.sendMessage(ChatColor.LIGHT_PURPLE+"Nah, Don't Pat Yourself...");
					Bukkit.broadcastMessage(ChatColor.GREEN+"SERVER "+ChatColor.RESET+"Just Patted "+ChatColor.BLUE+sender.getName()+ChatColor.LIGHT_PURPLE+" On The Back! :)");  
					return true;
				}
			}
		}
		else
		{
			sender.sendMessage(ChatColor.RED+"Sorry, You Do Not Have Permission To Do That...");
			plugin.log.info(sender.getName()+" Was DENIED Access To /Pat");
			return true;
		}
	}
}
