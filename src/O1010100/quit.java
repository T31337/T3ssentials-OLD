package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class quit implements CommandExecutor
{
	T3 plugin;
	public quit(T3 plgn)
	{
		this.plugin = plgn;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
	{
		if(!(sender instanceof Player))
		{
			if(sender instanceof ConsoleCommandSender)
			{
				Bukkit.getServer().getShutdownMessage();
				Bukkit.getServer().savePlayers();
				Bukkit.broadcastMessage(ChatColor.AQUA+"Server ShutDown Sequence Initaited!");
				Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE+"Sorry Folks, You All Will Be Dissconected From This Server...  :(");
				if(args.length > 0)
				{
					String sdm = "";
					for(String arg : args)
					{
						sdm += arg+" ";
					}
					Bukkit.broadcastMessage(ChatColor.DARK_PURPLE+sdm);
				}
				Bukkit.getServer().shutdown();
				return true;
			}
			else
			{
				sender.sendMessage("Must Be Player Or Console To /Quit...");
				return true;
			}
		}
		else
		{
			Player p = (Player)sender;
			if(sender.hasPermission("T3.Quit"))
			{
				String quitMsg = "";
				if (args.length < 1)
				{
					sender.sendMessage(ChatColor.RED + "Usage: /" + cmd.getName() + " <Message>");
					return true;
				}
				if(args.length >= 1)
				{
					for (int i = 0; i < args.length; i++)
					{
						quitMsg = quitMsg + args[i] + " ";
					}

					Bukkit.broadcastMessage(ChatColor.DARK_AQUA+p.getName()+":"+ChatColor.GRAY+" "+quitMsg);
					p.kickPlayer(":( Hope To See You Again Soon :)");
					return true;
				}

			}
			else
			{
				sender.sendMessage(ChatColor.RED+"Sorry, You Do Not Have Permission To Do That...");
				plugin.log.info(sender.getName()+" Was DENIED Access To /Quit");
				return true;
			}		}
		return false;
	}
}
