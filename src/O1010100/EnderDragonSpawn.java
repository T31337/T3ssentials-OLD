package O1010100;

import org.bukkit.World;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class EnderDragonSpawn implements Listener 
{
	T3 plugin;
	
	@EventHandler
	public void EnderDragonSpwan(CreatureSpawnEvent e)
	{
		if(e.getEntityType()==EntityType.ENDER_DRAGON&&e.getLocation().getWorld().getEnvironment()==World.Environment.NORMAL)
		{
			e.setCancelled(true);
			if(e.getSpawnReason()==SpawnReason.EGG)
			{
				SpawnReason r=e.getSpawnReason();
				String name = r.name().toString();
				e.getEntity().sendMessage("Not Allowed To Spawn EnderDragons On Normal World...");
				Log.debug(name+" Attempted To Spawn EnderDragon With An Egg...");
			}
			//Bukkit.broadcastMessage("EnderDragons Are Not Allowed On The Main World...");
		}
	}
}
