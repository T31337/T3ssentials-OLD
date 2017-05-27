package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BoomStick implements CommandExecutor
{
	T3 plugin;
	public BoomStick(T3 plugin)
	{
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender,Command cmd,String cmdName,String[] args)
	{
		if(!sender.hasPermission("T3.BoomStick"))
		{
			sender.sendMessage(ChatColor.RED+"You Do Not Have Permission To Do That...");
			return true;
		}
		else
		{
			if(args.length==0)
			{
				if(!(sender instanceof Player))
				{
					sender.sendMessage("Incorrect Usage Of BoomStick!");
					return true;
				}
				else
				{
					boolean exist = false;
					Player p = (Player)sender;
					for (int i = 0; i < args.length; i++) 
					{
						ItemMeta data = p.getInventory().getItem(i).getItemMeta();
						if( data.getDisplayName().contains("BoomStick"))
						{
							exist = true;
							break;
						}	
					}
					if(exist==false)
					{
						p.getInventory().addItem(T3.plugin.setItemName(new ItemStack(Material.STICK,1),ChatColor.AQUA+"BoomStick!"));
						p.sendMessage("BoomStick Has Been Added To Your Inventory");
						return true;
					}
					else
					{
						p.sendMessage("You Already Have A BoomStick...");
						return true;
					}
				}
			}
			if(args.length==1)
			{

				Player t = Bukkit.getPlayer(args[0]);
				if(t.hasPermission("T3.BoomStick"))
				{
					if(!t.isOnline())
					{
						sender.sendMessage("Sorry, That Player Is Not Online...");
						return true;
					}
					else
					{
						boolean exist = false;
						for (int i = 0; i < t.getInventory().getSize(); i++) 
						{
							ItemMeta data = t.getInventory().getItem(i).getItemMeta();
							if( data.getDisplayName().contains("BoomStick"))
							{
								exist = true;
								break;
							}
						}
						if(exist == false)
						{
							t.getInventory().addItem(T3.plugin.setItemName(new ItemStack(Material.STICK,1),ChatColor.AQUA+"BoomStick!"));
							t.sendMessage("BoomStick Has Been Added To Your Inventory");
							return true;
						}
						else
						{
							//Already Has BoomStick?
							sender.sendMessage("That Player Already Has A BoomStick...");
							return true;
						}
					}
				}
				else
				{
					sender.sendMessage("You May Not Give That Player A BoomStick...");
					return true;
				}
			}
			return false;
		}
	}
}