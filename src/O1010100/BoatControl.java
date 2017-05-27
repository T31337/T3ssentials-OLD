package O1010100;

import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;


public class BoatControl implements Listener 
{
	T3 plugin;
	@EventHandler(priority = EventPriority.MONITOR)
	public void BoatsControl(EntityDamageEvent e)
	{
		Entity ent = e.getEntity();
		if(e.getEntityType() == EntityType.BOAT)
		//if(ent.getType() == EntityType.BOAT)
		{
			Boat boat = (Boat) ent;
							
			if(plugin.T3Cfg.getBoolean("SuperBoats", true))
			{
				boat.setWorkOnLand(true);
				if(!(ent.getLastDamageCause() instanceof Player))
				{
					e.setCancelled(true);
					e.setDamage(0);
					Log.info("Boat Should Not Have Broken...");
					e.getEntity().getPassenger().sendMessage("Boat Should Not Have Broken...");
				}
			}
		}
	}
}