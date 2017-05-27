package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ec implements CommandExecutor
{
	T3 plugin;
	public ec(T3 plugin)
	{
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender,Command cmd,String cmdName,String[] args)
	{
		if(sender instanceof Player)
		{
		if(args.length==1)
		  {  
			Player p = (Player)sender;
			  Player t = Bukkit.getServer().getPlayer(args[0]);
			  if(sender.hasPermission("T3.EnderChest.Other"))
			  {
				
				  if(!t.hasPermission("T3.EnderChest.Other.Denied"))
				  {
					  p.openInventory(t.getEnderChest());
					  Bukkit.getLogger().info(sender.getName()+" Was ALLOWED Access To /ec <"+t.getName()+">");
					  return true;
				  }
				  else
				  {
					  sender.sendMessage("You May Not View That Player's EnderChest...");
					  Bukkit.getLogger().info(sender.getName()+" Was DENIED Access To /ec <"+t.getName()+">");
					  Bukkit.getLogger().info(t.getName()+" Has Node: T3.EnderChest.Other.Denied!");
					  return true;
					  
				  }
			  }
			  else
			  {
				  sender.sendMessage(ChatColor.RED+"You Do Not Have Permission To Do That...");
				  Bukkit.getLogger().info(sender.getName()+" Was DENIED Access To /ec <"+t.getName()+"> Node: T3.EnderChest.Other");
				  return true;
			  }
		  	}//args.length==1
			  if(args.length==0)
			  {
				
					  if(sender.hasPermission("T3.EnderChest"))
					  {
						  Player p = (Player) sender;
						  p.openInventory(p.getEnderChest());
						  Bukkit.getLogger().info(sender.getName()+" Was ALLOWED Access To /EC");
						  Bukkit.getLogger().info(ChatColor.RED+"Node: T3.EnderChest");
						  return true;
					  }
				  }
				  else
				  {
					  sender.sendMessage(ChatColor.RED+"Sorry, You Do Not Have Permission To Do That...");
					  plugin.log.info(sender.getName()+" Was DENIED Access To /EC");
					  return true;
				  }
		}
		else
		{
			sender.sendMessage("Only Players May Use /EC...");
			return false;
		}
		return false;
	}
}
