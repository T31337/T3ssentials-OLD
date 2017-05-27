package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class TrollCmd implements CommandExecutor 
{
	T3 plugin;
	public TrollCmd(T3 plugin)
	{
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args) 
	{
		if(sender instanceof ConsoleCommandSender)
		{
			if(args.length==0||args.length>1)
			{
				sender.sendMessage("Usage: /Troll <Player>");
				return true;
			}
			if(args.length==1)
			{
				Player t = Bukkit.getPlayer(args[0]);
				double h = t.getHealth();
				t.setFireTicks((int)h/20/*ticks*/);
				t.chat(ChatColor.RED+"AHHHH! IM BURNNING! IM BURNNING!");
				t.chat(ChatColor.BLUE+"PUT ME OUT, PUT ME OUT, PUT ME OUT!");
				return true;

			}
		}
			if(sender.hasPermission("T3.Troll"))
			{
				if(args.length==0||args.length>1)
				{
					sender.sendMessage("Usage: /Troll <Player>");
					return true;
				}
				if(args.length==1)
				{
					Player t = Bukkit.getPlayer(args[0]);
					if(!t.hasPermission("T3.Troll.Denied"))
					{
						final Player plyr = t;
						t.setFireTicks(5*20/*ticks*/);
						t.chat(ChatColor.RED+"AHHHH! IM BURNNING! IM BURNNING!");
						t.chat(ChatColor.BLUE+"PUT ME OUT, PUT ME OUT, PUT ME OUT!");
						
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(T3.plugin, new Runnable()
						{
							public void run()
							{
								plyr.setHealth(20d);
							}
						}, 20*9);
						
						return true;
					}
					else
					{
						sender.sendMessage(ChatColor.LIGHT_PURPLE+"Sorry, You May Not Troll That Player...");
						return true;
					}
				}
			}
			else
			{
				sender.sendMessage("Sorry, You Do Not Have Permission To Do That...");
				return true;
			}
			return false;
		}

	}
