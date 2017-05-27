package O1010100;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener
{
	T3 plugin;
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e)
	{
		Player p = e.getPlayer();
		e.setQuitMessage(ChatColor.BLUE+p.getDisplayName()+" Went To Saturn, Neptune Or Possably Even Pluto!");
		//e.getQuitMessage();
	}
}
