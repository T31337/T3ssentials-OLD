package O1010100;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityExplode implements Listener
{

	T3 plugin;
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event)
	{
		//This Event Only Gets Registered And Listened For If Player Set CreeperGreif To false In Configuration File
		if(event.getEntityType()==EntityType.CREEPER)
		{
			if(T3.plugin.CreeperGreif==false)
			{
				event.setYield(0.00F);
				event.blockList().clear();
			}
		}
		if(event.getEntityType()==EntityType.PRIMED_TNT || event.getEntityType()==EntityType.MINECART_TNT)
		{
			Entity currer = event.getEntity().getVehicle();
			if(currer.getType() == EntityType.PLAYER)
			{
				if(!currer.hasPermission("T3.TNT"))
				{
					currer.sendMessage(ChatColor.RED+"Insufficent Permissions... (T3.TNT).");
					event.setCancelled(true);
				}
			}
		}
	}
}
