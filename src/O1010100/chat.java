package O1010100;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class chat implements CommandExecutor
{
	T3 plugin;
	public chat(T3 plugin)
	{
		this.plugin = plugin;
	}


	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args)
	{

		if(sender.hasPermission("T3.Chat"))
		{
			String chatMsg = "";
			if(!(args.length > 1))
			{
				sender.sendMessage("Usage: /chat <Player> <Message>");
				return false;
			}
			else
			{
				for (int i = 0; i < args.length - 1; i++)
				{
					chatMsg = chatMsg + args[(i + 1)] + " ";
				}
				Player t= (Player) Bukkit.getServer().getPlayer(args[0]);

				plugin.log.info(sender.getName()+" Forced "+t.getName()+" To Chat A Message!");
				ChatAsPlayer(chatMsg, args[0], sender);

				return true;
			}
		}
		else
		{
			sender.sendMessage(ChatColor.RED+"Sorry, You Don't Have Permission To Do That...");
			plugin.log.info(sender.getName()+" Was DENIED Access To /Chat");
			return false;
		}

	}

	@SuppressWarnings("deprecation")
	public void ChatAsPlayer(String chatMsg, String chatTarget, CommandSender sender)
	{
		if (Bukkit.getServer().getPlayer(chatTarget) != null)
		{
			plugin.log.info(sender.getName()+" Forced "+chatTarget+" To Chat: ");
			Bukkit.getServer().getPlayer(chatTarget).chat(chatMsg);
		}
		else
		{
			sender.sendMessage(ChatColor.RED + "This Player Does Not Exist, Or Is Offline...");
		}
	}
}
