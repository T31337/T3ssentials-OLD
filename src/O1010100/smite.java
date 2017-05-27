package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class smite implements CommandExecutor
{
	T3 plugin;
	public smite(T3 plgn)
	{
		this.plugin = plgn;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
	{
		 if(!sender.hasPermission("T3.Smite"))
		  {
			  sender.sendMessage(ChatColor.RED+"Sorry, You Don't Seem To Have That Permission...");
			  Bukkit.getLogger().info(sender.getName()+" Was DENIED Access To /Smite");
			  Bukkit.getLogger().info(ChatColor.RED+"Node: T3.Smite");
			  return true;
		  }
		  else
		  {
			  if(args.length<1||args.length>2)
			  {
				  sender.sendMessage("Usage: /smite <player>");
				  return true;
			  }
			  else
			  {
				  Player t = (Player) Bukkit.getServer().getPlayer(args[0]);
				  if(!(t.hasPermission("T3.Smite.Denied")))
				  {
				  t.getWorld().strikeLightning(t.getLocation());
				  Bukkit.broadcastMessage(ChatColor.BLUE+t.getDisplayName()+ChatColor.AQUA+" Has Been Smitten!");
				  return true;
				  }
				  else
				  {
					  sender.sendMessage(t.getName()+" May Not Be Smitten!");
					  return true;
				  }
			  }
		  }
	}
}
