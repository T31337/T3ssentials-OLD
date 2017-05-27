package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {
	T3 plugin;
	public Feed(T3 plugin)
	{
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
	{
		if (sender.hasPermission("T3.Feed"))
		{
			if(args.length==0)
			{
					if(sender instanceof Player)
					{
						Player p = (Player)sender;
						p.setExhaustion(0f);
						p.sendMessage(ChatColor.LIGHT_PURPLE+"You Were Fed!");
						return true;
					}
					else
					{
						sender.sendMessage(ChatColor.RED+"Incorrect Usage... Try /Feed <Player>");
						return true;
					}
	
			}
			if(args.length==1)
			{
				if(sender.hasPermission("T3.Feed.Other"))
				{
					Player t = Bukkit.getPlayer(args[0]);
					t.setExhaustion(200f);
					t.sendMessage(ChatColor.LIGHT_PURPLE+"You Have Been Fed!");
					return true;
				}
				else
				{
					sender.sendMessage(ChatColor.RED+"Sorry, You Don't Have Permission To Do That...");
					return true;
				}
			}
			return false;
		}
		else
		{
			sender.sendMessage(ChatColor.RED+"Sorry, You Don't Have Permission To Do That...");
			return true;
		}	
	}

}
