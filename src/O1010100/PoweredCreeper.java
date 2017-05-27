package O1010100;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;

public class PoweredCreeper implements CommandExecutor

{

	T3 plugin;
	   public PoweredCreeper(T3 plugin)
	   {
		   this.plugin = plugin;
	   }

		public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
		{
			if(!sender.hasPermission("T3.PoweredCreeper"))
			{
				sender.sendMessage("Sorry, You Do Not Have Permission To Do That...");
				return true;
			}
			else
			{
				if(args.length!=0)
				{
					sender.sendMessage("Usage: /PoweredCreeper");
					return true;
				}
				else
				{
					if(sender instanceof Player)
					{
						Player p = (Player)sender;
						 Creeper crpr=(Creeper)p.getWorld().spawn(p.getEyeLocation().add((p.getLocation().getDirection().getZ()-5), 0, 0), Creeper.class);
						 crpr.setPowered(true);
						p.sendMessage("Creeper Spawned, Watch Out!");//Not Always Infront Of Player - Not Sure Why...
						return true;
					}
					else
					{
						sender.sendMessage("Sorry, Only Players May Spawn Creepers...");
						return true;
					}
				}
			}
		}

}
