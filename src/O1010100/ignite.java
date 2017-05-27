package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ignite implements CommandExecutor
{
	T3 plugin;
	
	public ignite(T3 plugin)
	{
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
	{
		if(sender.hasPermission("T3.Ignite"))
		{
			if(args.length==0)
			{
				sender.sendMessage("Usage: /Ignite <Player>");
				return false;
			}
			if(args.length==1)
			{
				Player t = Bukkit.getServer().getPlayer(args[0]);
				if(!t.hasPermission("T3.Ignite.Denied"))
				{
					t.setFireTicks(80);
					sender.sendMessage("Sucessfully Ignited "+t.getName());
					return true;
				}
				else
				{
					sender.sendMessage("You May Not /Ignite That Player...");
					Bukkit.getLogger().info(sender.getName()+" Failed To /Ignite "+t.getName());
					Bukkit.getLogger().info(t.getName()+" Has Node: T3.Other.Denied");
					return false;
				}
			}
			if(args.length>=2)
			{
				sender.sendMessage("Usage: /Ignite <Player>");
				return false;
			}
		}
		else
		{
			sender.sendMessage(ChatColor.RED+"You Do Not Have Permission To /Ignite");
			return false;
		}
		return false;
	}

}
