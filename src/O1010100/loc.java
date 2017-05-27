package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class loc implements CommandExecutor
{
T3 plugin;
public loc(T3 plugin)
{
	this.plugin = plugin;
}


@SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender,Command cmd,String cmdName,String[] args)
{
	if(!sender.hasPermission("T3.Location"))
	  {
		  sender.sendMessage(ChatColor.RED+"Sorry, You Don't Have Permission To Do That...");
		  Bukkit.getLogger().info(sender.getName()+" Was DENIED Access To /Loc");
		  return true;
	  }
	  else
	  {
		  if(args.length==0)
		  {
		  if(sender instanceof Player)
		  {
			  Player p = (Player)sender;
		  sender.sendMessage(ChatColor.WHITE+"X:"+p.getLocation().getBlockX()+" Y:"+p.getLocation().getBlockY()+" Z:"+p.getLocation().getBlockZ());
		  return true;
		  }
		  else
		  {
			  sender.sendMessage("Must Be A Player To Use The /Loc Command That Way...");
			  return true;
		  }
		  }//args.length==1
		  if(args.length==1)
		  {
			  if(!sender.hasPermission("T3.Location.Other"))
			  {
				  sender.sendMessage(ChatColor.RED+"You Do Not Have Permission To Do That...");
				  Bukkit.getLogger().info(sender.getName()+" Was DENIED Access To /Loc");
				  Bukkit.getLogger().info(ChatColor.RED+"NODE: T3.Location.Other");
				  return true;
			  }
			  else
			  {
				  Player t = Bukkit.getServer().getPlayer(args[0]);
				  if(t.isOnline())
				  {
					  if(!t.hasPermission("T3.Location.Hidden"))
					  {
						  sender.sendMessage(ChatColor.WHITE+t.getName()+" -> X:"+t.getLocation().getBlockX()+" Y:"+t.getLocation().getBlockY()+" Z:"+t.getLocation().getBlockZ()+" World: "+t.getWorld().toString());
						  Bukkit.getLogger().info(sender.getName()+" Used /loc: "+t.getName()+" -> X:"+t.getLocation().getBlockX()+" Y:"+t.getLocation().getBlockY()+" Z:"+t.getLocation().getBlockZ()+" World: "+t.getWorld().toString());
						  Bukkit.getLogger().info(sender.getName()+" Was ALLOWED Access To /Loc <"+t.getName()+">");
						  return true;
					  }
					  else
					  {
						  if(sender instanceof ConsoleCommandSender)
						  {
						  sender.sendMessage(ChatColor.WHITE+t.getName()+" -> X:"+t.getLocation().getBlockX()+" Y:"+t.getLocation().getBlockY()+" Z:"+t.getLocation().getBlockZ()+" World: "+t.getWorld().toString());
						  return true;
						  }
						  else
						  {
						  Bukkit.getLogger().info(sender.getName()+" Was DENIED Access To The Location Of "+t.getName()+" (Target Exempt From /LOC)");
						 // Bukkit.getLogger().info(ChatColor.GREEN+"NODE: T3.Location.Other <- "+sender.getName());
						  Bukkit.getLogger().info(ChatColor.GREEN+"NODE: T3.Location.Hidden <- "+t.getName());
						  
						  return true;
						  }
					  }
				  }
				  else
				  {
					  sender.sendMessage("Player Offline...");
					  return true;
				  }
			  }
		  }
		  if(args.length>=2)
		  {
			  sender.sendMessage("Usage: /Loc (Player)");
			  return true;
		  }
	  }
	return true;
}
}
