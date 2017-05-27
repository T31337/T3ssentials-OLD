package O1010100;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class playerChatEvnt implements Listener
{

	T3 plugin;
	@EventHandler
	public void PlayerChat(PlayerChatEvent e)
	{
		Player p = e.getPlayer();
		plugin.log.info(p.getName()+": "+e.getMessage());
		if(e.getMessage().contains("asshole")||e.getMessage().contains("dick")||e.getMessage().contains("pussy"))
		{
			e.setCancelled(true);
			p.kickPlayer("You Are Not Allowed To Say: "+e.getMessage());
		}
		
	}
	
}
