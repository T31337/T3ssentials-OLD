package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kk implements CommandExecutor
{
	T3 plugin;
	public kk(T3 plgn)
	{
		this.plugin = plgn;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args) 
	{
		if(sender.hasPermission("T3.kk"))
		{
			String kickMsg = "";
			if (args.length < 1)
			{
				sender.sendMessage(ChatColor.RED + "Usage: /" + cmd.getName() + " <player> (Message)");
				return true;
			}
			if(args.length == 0)
			{
				Player t = Bukkit.getPlayer(args[0]);

				for (int i = 0; i < args.length - 1; i++)
				{
					kickMsg = kickMsg + args[(i + 1)] + " ";
				}
				t.kickPlayer(ChatColor.RED+"You Were Kicked To Neputne, Saturn Or Possably Even Pluto!\n"+ChatColor.RESET+kickMsg+ChatColor.DARK_BLUE+"\nRepeated Rule Violations Result In A Ban!");
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA+t.getName()+ChatColor.GRAY+" Was Kicked To Saturn, Neptune Or Possably Even Pluto!");
				plugin.log.info(sender.getName()+" Has Kicked "+t.getName()+"From The Server!");
				return true;
			}
			if(args.length==1)
			{
				Player t = Bukkit.getPlayer(args[0]);
				t.kickPlayer(ChatColor.RED+"You Have Been Kicked To Saturn, Neptune Or Pluto!\n"+ChatColor.DARK_PURPLE+"Next Time Follow The Rules,\n"+ChatColor.DARK_BLUE+"Repeated Violations Will Reslult In A Ban!");
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA+t.getName()+ChatColor.GRAY+" Was Kicked To Saturn, Neptune Or Possably Even Pluto!");
				plugin.log.info(sender.getName()+" Kicked "+t.getName()+" From The Server!");
				return true;
			}
			else
			{
				sender.sendMessage(ChatColor.DARK_AQUA+"Please Kick Only One Person At A Time...");
				return true;
			}
		}
		else
		{
			sender.sendMessage(ChatColor.RED+"Sorry, You Do Not Have Permission To Do That...");
			plugin.log.info(sender.getName()+" Was DENIED Access To /kk");
			return true;
		}
	}

}
