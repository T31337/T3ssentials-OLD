package O1010100;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Player;

public class EnchantTable implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		if(sender.hasPermission("T3.EnchantTable"))
		{
			Player p = (Player) sender;
			p.openEnchanting(null, true);
			return true;
			
		}
		else
		{
			
			sender.sendMessage("Sorry, You Do Not Have Permission To Do That...");
			Log.debug(sender.getName()+" Was Denied Access To /ET");
			return true;
		}
	}

}
