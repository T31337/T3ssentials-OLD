package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class summon implements CommandExecutor
{
	T3 plugin;

	public summon(T3 plugin)
	{
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)	
	{
		if(!(sender instanceof Player))
 	   {
 		   sender.sendMessage(ChatColor.RED+"Sorry, You Must Be A Player To Use That Command...");
 		   return true;
 	   }
 	   else
 	   {
 		   Player p = (Player)sender;
 		   //player issued Summon Command 
 		   if(p.hasPermission("T3.Summon"))
 		   {
	 		   if(args.length==0)
	 		   {
	 			   p.sendMessage("Usage: /summon <player>");
	 			   return true;
	 		   }
	 		   else
	 		   {
	 		  
	 			 
	 			    
	 				  for (String arg : args) 
	 				  {
						Player t = Bukkit.getPlayer(arg);
						if(!(t.getName()==sender.getName()))
						{
						if(!t.isOnline())
						{
							sender.sendMessage(t.getName()+" Is Offline...");
							return true;
						}
						if(!t.hasPermission("T3.Summon.Denied"))
						{
	
							t.teleport(p.getLocation());
							t.sendMessage(ChatColor.BLUE+"You Have Been Summoned!");
							plugin.log.info(sender.getName()+" Has Sucessfully Summoned: "+t.getName());
							sender.sendMessage(ChatColor.WHITE+t.getName()+" Has Been Summoned!");
							return true;
						}
						else
						{
							sender.sendMessage(ChatColor.RED+t.getName()+" Could Not Be Summoned!");
							plugin.log.info(t.getName()+" Was NOT Summoned - Target Exempt (T3.Other.Denied)");
							return true;
						}
						}
						else
						{
							sender.sendMessage("Seriously? You Just Attempted To Summon Yourself!");
							return true;
						}
					}
	 		   }
 		   }
		   else
		   {
			   p.sendMessage(ChatColor.RED+"You Do Not Have Permission To Do That...");
			   plugin.log.info(p.getName()+" Was DENIED Access To /Summon");
			   return true;
		   }
 		  
	   }//sender is player
	return true;
	}
}
