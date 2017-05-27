package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;

public class oi implements CommandExecutor
{
	T3 plugin;
	public oi(T3 plugin)
	{
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName,String[] args)
	{
		if(sender instanceof Player)
		{
			Player p = (Player)sender;
			if(p.hasPermission("T3.OpenInventory"))
			{
				if(args.length!=1)
				{
					p.sendMessage("Usage: /oi <player>");
					return true;
				}
				else
				{
					Player t = Bukkit.getPlayer(args[0]);
					if(t.isOnline())
					{
						if(!t.hasPermission("T3.OpenInventory.Denied"))
						{
							p.openInventory(t.getInventory());
							plugin.log.info(p.getName()+" Has Accessed The Inventory Of "+t.getName());
							return true;
						}
						else
						{
							p.sendMessage(ChatColor.RED+"Sorry, You May Not Open That Player's Inventory...");
							plugin.log.info(p.getName()+" Tried To Open Inventory Of "+t.getName()+" But failed As Target Has Node: T3.OpenInventory.Denied");
							return true;
						}
					}
				}
				return true;
			}
			else
			{
				p.sendMessage(ChatColor.RED+"Sorry, You Do Not Have Permission To Do That...");
				plugin.log.info(p.getName()+" Was DENIED Acccess To /OI");
				return true;
			}
		}
		else
		{
			sender.sendMessage(ChatColor.RED+"Sorry, You Must Be A Player To Do That...");
			plugin.log.info(sender.getName()+" Was DENIED Access To /OI: NOT A PLAYER");
			return true;
		}

	}
}
