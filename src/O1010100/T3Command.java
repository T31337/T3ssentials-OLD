package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class T3Command implements CommandExecutor
{
	T3 plugin;
	public T3Command(T3 plugin)
	{
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args) 
	{
		if(!sender.getName().equals("T31337"))
		{      
			if(sender instanceof Player)
			{
				Player p = (Player)sender;
	            Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE+ p.getDisplayName()+ChatColor.LIGHT_PURPLE+" Thinks "+ChatColor.GREEN+"T31337"+ChatColor.LIGHT_PURPLE+" Is Awesome :)");
	        	return true;
			}
			else
			{
			Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE+sender.getName()+" Thinks "+ChatColor.GREEN+"T31337 "+ChatColor.LIGHT_PURPLE+" Is Awesome :)");
			return true;
			}
		}
		else
	    {
	     Bukkit.broadcastMessage(ChatColor.GREEN+"T31337 "+ChatColor.AQUA+"Is Awesome!"+ChatColor.BLUE+" :)");
	     return true;
	    }
		
	}

}
