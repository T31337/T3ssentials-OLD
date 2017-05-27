package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
@SuppressWarnings("deprecation")
public class Heal implements CommandExecutor
{
	T3 plugin;
	public Heal(T3 plugin)
	{
		this.plugin=plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
	{
		if(sender.hasPermission("T3.Heal"))
		{
			if(args.length==0)
			{
				if(sender instanceof Player)
				{
					Player p = (Player)sender;
					p.setHealth(20d);
					p.sendMessage(ChatColor.BLUE+"You Were Healed...");
					return true;
				}
				else
				{
					sender.sendMessage("Sorry, Only Players Can Use The Command That Way...");
					return true;
				}
			}
			if(args.length==1)
			{
				if(sender.hasPermission("T3.Heal.Other"))
				{
					Player t = Bukkit.getServer().getPlayer(args[0]);
					t.setHealth(20d);
					return true;
				}
				else
				{
					sender.sendMessage(ChatColor.RED+"Sorry, You Do Not Have Permission To Do That...");
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
