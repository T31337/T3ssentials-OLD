package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gm implements CommandExecutor
{
	T3 plugin;
	public gm(T3 Plugin)
	{
		this.plugin = Plugin;
	}

	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args) 
	{
		if(args.length==0)
		{
			if(!(sender instanceof Player))
			{
				sender.sendMessage("You Must Be A Player To Use This Command That Way...");
				return false;
			}
			else//assume it was a player giving command
			{
				Player p = (Player)sender;
				if(p.hasPermission("T3.GameMode"))
				{
					if(p.getGameMode()!=GameMode.CREATIVE)
					{
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(ChatColor.GREEN+"GameMode Set To "+p.getGameMode());
						return true;
					}
					else
					{
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(ChatColor.GREEN+"GameMode Set To "+p.getGameMode());
						return true;
					}

				}//permissoin granted
				else
				{
					p.sendMessage(ChatColor.RED+"Sorry, You Do Not Have Permission To Do That...");
					return true;
				}
			}//player issued gm
		}//args.length==0

		if(args.length==1)
		{
			Player t = Bukkit.getServer().getPlayer(args[0]);
			if(sender.hasPermission("T3.GameMode.Other"))
			{
				if(!t.hasPermission("T3.GameMode.Other.Denied"))
				{
					GameMode tmode = t.getGameMode();
					if(tmode==GameMode.SURVIVAL)
					{
						t.setGameMode(GameMode.CREATIVE);
						t.sendMessage(ChatColor.GREEN+"GameMode Set To Creative!");
						sender.sendMessage(t.getDisplayName()+" Has Had Thier GameMode Changed To Creative!");
						return true;
					}
					else
					{
						t.setGameMode(GameMode.SURVIVAL);
						t.sendMessage(ChatColor.RED+"GameMode Set To Survival!");
						sender.sendMessage(t.getDisplayName()+" Has Had Their GameMode Changed To Survival!");
						return true;
	
					}
				}
			}//granted permission	
			else
			{
				sender.sendMessage(ChatColor.RED+"You Do Not Have Permission To Do That...");
				return true;
			}
		}//args.lenght==1
		if(args.length>=2)
		{
			sender.sendMessage("Usage: /gm <player>");
			return true;
		}
		return false;
	}

}
