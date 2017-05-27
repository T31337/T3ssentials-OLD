package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;

public class ob implements CommandExecutor
{
	T3 plugin;
	public ob(T3 plugin)
	{
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
	{
		
		if(!(sender instanceof Player))
			{
				sender.sendMessage("Sorry, You MUST Be A Player To Use That Command...");
				return false;
			}
			else
			{
				Player p = (Player) sender;
				if(args.length==0||args.length>=2)
				{
					p.sendMessage("Usage: /ob <player>");
					return false;
				}
				else
				{
					if(p.hasPermission("T3.Bed.Other"))
					{
						Player t = (Player) Bukkit.getServer().getPlayer(args[0]);
						if(!t.isOnline())
						{
						//p.sendMessage("Error: Player Offline!");
						OfflinePlayer trgt[] = Bukkit.getServer().getOfflinePlayers();
						for(int i=0;i>trgt.length;i++)
						{
							if(trgt[i].getName()==t.getName())
							{
								if(!trgt[i].getPlayer().hasPermission("T3.Bed.Other.Denied"))
								{
								p.teleport(trgt[i].getBedSpawnLocation());
								p.sendMessage("Successfulyl Teleported To "+trgt[i].getName()+"'s Bed!");
								return true;
								}
								else
								{
									p.sendMessage("Sorry, You May Not Teleport To That Player's Bed...");
									return true;
								}
							}
							
						}
						p.sendMessage("Sorry, Something Went Wrong....");
						Log.debug(p.getName()+" Attempted To Teleprot To The Bed Of Another Player, But Something Went Wrong");
						return true;
						}
						else
						{
							p.teleport(t.getBedSpawnLocation());
							p.sendMessage("Sucessfully Teleported To "+t.getDisplayName()+"'s Bed!");
							return true;
						}
					}
					else
					{
						p.sendMessage(ChatColor.RED+"You Do Not Have Permission To Do That...");
						return true;
					}
				}
			}
	}
}
