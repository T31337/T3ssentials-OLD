package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class bed implements CommandExecutor
{
	T3 plugin;
	public bed(T3 plugin)
	{
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
	{
		if(args.length==0)
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage("Usage: /bed <player>");
				return false;
			}
			else
			{
				Player p = (Player)sender;
				//was a player
				if(sender.hasPermission("T3.Bed"))
				{
					try
					{
						Location bed = p.getBedSpawnLocation();
						p.teleport(bed);
						p.sendMessage("You Have Been Teleported To Your Bed!");
						return true;
					}
					catch (Exception e)
					{
						sender.sendMessage("Bed Missing :< Sorry...");
						plugin.log.info("Error: "+e.getMessage());
						return false;
					}

				}//sender had permission
				else
				{
					sender.sendMessage("You Do Not Have Permission To Do That...");
					Bukkit.getLogger().info(sender.getName()+" Was DENIED Access To /Bed");
					Bukkit.getLogger().info(ChatColor.RED+"Node: T3.Bed");
					return false;
				}
			}//bed CMD From Player

		}//args.length==0
		if(args.length==1)
		{
			Player t = (Player) Bukkit.getServer().getPlayer(args[0]);
			if(sender.hasPermission("T3.Bed.Other"))
			{
				if(t.isOnline())
				{
					if(!t.hasPermission("T3.Other.Denied"))
					{
						Location bed = t.getBedSpawnLocation();
						try
						{
							t.teleport(bed);
							t.sendMessage("You Were Sent To Your Bed!");
							sender.sendMessage(t.getName()+" Was Sent To Their Bed!");
							Bukkit.getLogger().info(sender.getName()+" Sent "+t.getName()+" To Their Bed!");
							return true;
						}
						catch(Exception e)
						{
							sender.sendMessage(t.getName()+"'s Bed Was Missing :< Sorry...");
							plugin.log.info(sender.getName()+" Did /Bed ("+t.getName()+")");
							plugin.log.info("Error: "+e.getMessage());
							return false;
						}

					}
					else
					{
						sender.sendMessage("You May not Send That Player To Their Bed!");
						Bukkit.getLogger().info(sender.getName()+" Was UNABLE To Send "+t.getName()+" To Their Bed");
						Bukkit.getLogger().info(t.getName()+" Has Node: T3.Other.Denied");
						return false;
					}

				}
				else
				{
					sender.sendMessage(t.getName()+" Is Offline!");
					return false;
				}
			}
			else
			{
				sender.sendMessage("Sorry, You Do Not Have Permission To Do That...");
				//Bukkit.getLogger().info(sender.getName()+" Was DENIED Access To /Bed");
				return false;
			}
		}
		return false;
	}

}
