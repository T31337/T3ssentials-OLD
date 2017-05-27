package O1010100;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class Messanger extends BukkitRunnable
{
	T3 plugin;
	ArrayList<String> messages = new ArrayList<String>();
	int count = 0;



	public Messanger(T3 plugin)
	{
		this.plugin = plugin;
		messages.add(ChatColor.DARK_GREEN+Bukkit.getMotd());
		//messages.add(ChatColor.BLUE+"REMINDER: Players MUST Get A Warning Before Kick/Ban!");
		messages.add(ChatColor.GREEN+"Bring Your Friends, All Non-Greifers & Non-Hackers Are Welcome Here!");
		//messages.add(ChatColor.LIGHT_PURPLE+"Thanks T31337 For The Custom Plugin!"+ChatColor.AQUA+" :D");
	}
	
	public void run()
	{

		if(plugin.T3Cfg.getBoolean("Messages", true))
		{
			if( count < messages.size())
			{
				Bukkit.broadcastMessage(messages.get(count));
				count++;
			}
			else
			{
				count = 0;
			}
		}
		else
		{
			//Will Not Auto-Broadcast Messages...
		}


	}
}
