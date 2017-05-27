package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class su implements CommandExecutor
{
	T3 plugin;
	public su(T3 plugin)
	{
		this.plugin = plugin;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		CommandSender p = sender;
		
			String noPermission = ChatColor.RED + "Sorry, You Do Not Have Permission To Do That...";

			String cmd2do = "";
			if (args.length < 2)
			{
				p.sendMessage(ChatColor.RED + "Usage: /" + cmd.getName() + " <player/console command>");
				return false;
			}
			for (int i = 0; i < args.length - 1; i++) {
				cmd2do = cmd2do + args[(i + 1)] + " ";
			}
			if (cmd2do.substring(0, 1).equalsIgnoreCase("/")) {
				cmd2do = cmd2do.substring(1);
			}
			if (args[0].toString().equalsIgnoreCase("c")||args[0].toString().equalsIgnoreCase("console"))
			{
				if (p.hasPermission("T3.su.console"))
				{
					executeAsConsole(cmd2do, p);
					return true;
				}
				p.sendMessage(noPermission);
				return false;
			}
			if (p.hasPermission("T3.su.player"))
			{
				executeAsPlayer(cmd2do, args[0], p);
				return true;
			}
			p.sendMessage(noPermission);
			return false;

	}

	public void executeAsConsole(String cmd2do, CommandSender sender)
	{
		sender.sendMessage(ChatColor.GREEN + "Your Command Will Be Executed By Console");
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd2do);
	}

	public void executeAsPlayer(String cmd2do, String Executer, CommandSender sender)
	{
		if (Bukkit.getServer().getPlayer(Executer) != null)
		{
			
			Bukkit.getServer().getPlayer(Executer).performCommand(cmd2do);
			sender.sendMessage(ChatColor.GREEN + "Your Command Was Sent By " + Bukkit.getServer().getPlayer(Executer).getName());
		}
		else
		{
			sender.sendMessage(ChatColor.RED + "This Player Does Not Exist, Or Is Offline...");
		}
	}
}
//Many Thanks Karuso33 For Original sudo Command :)

