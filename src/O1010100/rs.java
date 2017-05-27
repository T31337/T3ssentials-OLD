package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class rs implements CommandExecutor
{
	T3 plugin;
	public rs(T3 plugin)
	{
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender,Command cmd,String cmdName, String[] args)
	{
		if(args.length==0)
    	{
    		if(!(sender instanceof Player))
    		{
    			sender.sendMessage("You Must Be A Player To Use This Command That Way...");
    			sender.sendMessage("Usage: /rs <player>");
    			return true;
    		}
    		else
    		{
    			//player issued respawn cmd
    			
    			Player p = (Player) sender;
    			
    			if(p.hasPermission("T3.2Spawn"))
    			{
    			//send Player back to spawn
    				p.teleport(Bukkit.getPlayer(p.getName()).getWorld().getSpawnLocation());
	    			//p.sendMessage("Sent To Spawn!");
	    			return true;
    			}
    			else
    			{
    				
    				p.sendMessage(ChatColor.RED+"You Do Not Have Permission To Do That...");
    				Bukkit.getLogger().info(p.getName()+" Was Denied Access To: /"+cmd.getName());
    				Bukkit.getLogger().info("Permission Node: "+ChatColor.RED+"T3.rs");
    				return true;
    			}
    		}
    	}//args.lenght==0
    if(args.length==1)
    {
    	if(sender.hasPermission("T3.Respwan.Other"))
    	{
    		Player t = (Player) Bukkit.getServer().getPlayer(args[0]);
    		if(!t.hasPermission("T3.Respawn.Denied"))
    		{
    			//send Player Back To Spawn
    			t.teleport(Bukkit.getPlayer(args[0]).getWorld().getSpawnLocation());
    			t.sendMessage("Sucessfuly Sent To Spawn!");
    			sender.sendMessage(t.getName()+" Was Sent To Spawn!");
    			return true;
    		}
    	}
        else
        {
        	Player t = (Player) Bukkit.getServer().getPlayer(args[0]);
    	  sender.sendMessage(t.getDisplayName()+ChatColor.RED+" May Not Be Sent To Spawn!");
    	  Bukkit.getLogger().info(sender.getName()+"Was Not Allowed To Send "+t.getName()+" To Spwan!");
    	  Bukkit.getLogger().info(t.getName()+" Has Node: T3.rs.Other.Denied");
    	  return true;
        }
    }//args.length==1
		return false;
	}
}
