package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ct implements CommandExecutor
{
	T3 plugin;
	public ct(T3 plugin)
	{
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName,String[] args)
	{
		if(!(sender instanceof Player))
			{
				sender.sendMessage("Sorry You MUST Be A Player To Use That Command!");
			   return true;
			}
			else//player issued the command
			{
				Player p = (Player) sender;
				if(p.hasPermission("T3.CraftingTable"))
				{
				
				p.openWorkbench(null, true);
				return true;
				}
				else
				{
					p.sendMessage(ChatColor.RED+"You Do Not Have Permission To Do That...");
					Bukkit.getLogger().info(sender.getName()+" Was DENIED Access To /ct");
					Bukkit.getLogger().info(ChatColor.RED+"Node: T3.CraftingTable");
					return true;
				}
			
			}
	}
}
