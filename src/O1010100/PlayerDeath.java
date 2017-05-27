package O1010100;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class PlayerDeath implements Listener 
{
	T3 plugin;

	@EventHandler
	 public void playerDeath(PlayerDeathEvent event)
	 {
		 Player p = event.getEntity();
		 if(!p.hasPermission("T3.NoDeathMsg"))
		 {
			 event.setDeathMessage(ChatColor.BLUE+p.getName()+ChatColor.RESET+" Just Died! :<");
			 //p.chat("Oh Drat, I Have Died! :(");
		 }
		 
		 if(p.hasPermission("T3.Respawn2Spawn"))
		 {
			 p.teleport(p.getWorld().getSpawnLocation());
		 }
	 }//playerDeath 
	 
}
