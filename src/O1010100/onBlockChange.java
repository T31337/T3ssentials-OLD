package O1010100;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class onBlockChange implements Listener 
{
	T3 plugin;
	@EventHandler(priority=EventPriority.HIGHEST)
	public void entityChangeBlockEvent(EntityChangeBlockEvent event)
	{
		
		EntityType ET = event.getEntityType();
			if(ET==EntityType.ENDERMAN)
			{
				if(plugin.T3Cfg.getBoolean("EndermanGreif",true)==false)
				{
					event.setCancelled(true);
				}
			}
	}//entityBlockChangeEvent
}
