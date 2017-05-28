package O1010100;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

public class DonkeyCmd implements CommandExecutor
{
	
	T3 plugin;
	
	public DonkeyCmd(T3 plugin)
	{
		this.plugin=plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage("Only Players May Use The /Donkey Command");
			return true;
		}
		else
		{
			if(sender.hasPermission("T3.Donkey"))
			{
				 Player p = (Player)sender;
				 Horse donkey=(Horse)p.getWorld().spawn(p.getLocation().add((p.getLocation().getDirection().getZ()+2), 1, 0), Horse.class);
				 donkey.setVariant(Horse.Variant.DONKEY);
				 donkey.setOwner(p);
				 donkey.setCustomName(String.format(ChatColor.WHITE+"{0}'s {1} Donkey!",p.getName(),ChatColor.DARK_PURPLE));
				 p.sendMessage(ChatColor.AQUA+"You Spawned A Donkey!");
				 return true;
			}
			else
			{
				sender.sendMessage("Sorry, You Do Not Have Permission To Do That...");
				plugin.log.info(sender.getName()+" Was Denied Access To /Donkey");
				return true;
			}
		}
	}

}
