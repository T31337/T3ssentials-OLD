package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flight implements CommandExecutor
{
	T3 plugin;

	public flight(T3 plugin)
	{
		this.plugin = plugin;
	}

	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
	{
		if(args.length==0)
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage("Usage: /flight <player>");
				return true;
			}
			else
			{

				Player p = (Player) sender;
				//was a player
				if(p.hasPermission("T3.Flight")||p.isOp())
				{
					boolean fly = p.getAllowFlight();
					if(fly)
					{
						p.setAllowFlight(false);
						p.sendMessage("Flight "+ChatColor.RED+"Disabled!");
						return true;
					}
					else
					{
						//!fly
						p.setAllowFlight(true);
						p.sendMessage("Flight "+ChatColor.GREEN+"Enabled!");
						return true;
					}
				}
				else
				{
					p.sendMessage(ChatColor.RED+"You Do Not Have Permission To Do That...");
					return true;
				}
			}

		}//args = 0
		if(args.length==1)
		{
			if(sender.hasPermission("T3.Flight.Other"))
			{
				Player t = (Player) Bukkit.getServer().getPlayer(args[0]);
				if(t.hasPermission("T3.Flight"))
				{
					if(t.isOnline())
					{
						t.setAllowFlight(!t.getAllowFlight());
						sender.sendMessage(t.getName()+" Has Fly: "+t.getAllowFlight());
					}
					else
					{
						sender.sendMessage(ChatColor.RED+"That Player Is Not Online...");
						return true;
					}
				}
				else
				{
					sender.sendMessage("That Player Has No Access To The Flight Permissions...");
					return true;
				}

			}
			else
			{
				sender.sendMessage(ChatColor.RED+"You Do Not Have Permission To Do That...");
				return true;
			}
		}//num args == 1
		if(args.length>=2)
		{	
			Player cur = null;
			for (int i = 0; i < args.length; i++) 
			{
				cur = Bukkit.getServer().getPlayer(args[i]);
				cur.setAllowFlight(!cur.getAllowFlight());
				sender.sendMessage(args[i]+" Has Fly: "+cur.getAllowFlight());
			}
			return true;
		}
		return false;
	}

}
