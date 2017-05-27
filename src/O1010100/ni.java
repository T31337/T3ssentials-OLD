package O1010100;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ni implements CommandExecutor
{
	private String in="";
	T3 plugin;
	public ni(T3 plugin)
	{
		this.plugin=plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String CmdName,String[] args)
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage("Only Players May Use The ni Command...");
			return true;
		}
		else
		{
			if(sender.hasPermission("T3.NameItem"))
			{
				in="";
				for (int i = 0; i < args.length; i++) 
				{
					in += args[i] + " ";
				}
	
				Player p = (Player)sender;
				p.setItemInHand(nameItem(p.getItemInHand(),ChatColor.DARK_PURPLE+in));
			}
			else
			{
				sender.sendMessage(ChatColor.RED+"Sorry, You Do Not Have Permission To Do That....");
				return true;
			}
		}
		return false;
	}
	
private ItemStack nameItem(ItemStack item,String name)
{
	ItemMeta meta = item.getItemMeta();
	meta.setDisplayName(name);
	item.setItemMeta(meta);
	return item;
}

}




