package O1010100;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class FriendlyMobs implements Listener
{
	T3 plugin;
	Cfg cfg = T3.plugin.T3Cfg;
	@EventHandler(priority=EventPriority.HIGH)
	public void EntityTarget(EntityTargetEvent event)
	{
		Entity ent = event.getEntity();
		if(event.getTarget() instanceof Player)
		{
			if(ent.getType()==EntityType.CREEPER)
			{
				if(cfg.getBoolean("Creepers",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
					{
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
					}
					
				}
			}
			if(ent.getType()==EntityType.SKELETON)
			{
				if(cfg.getBoolean("Skeleton",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
				}
			}
			if(ent.getType()==EntityType.SPIDER)
			{
				if(cfg.getBoolean("Spiders",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
				}
			}
			if(ent.getType()==EntityType.ENDERMAN)
			{
				
				if(cfg.getBoolean("Enderman",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
				}
			}
			if(ent.getType()==EntityType.ENDERMITE)
			{
				
				if(cfg.getBoolean("Enderite",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
				}
			}
			if(ent.getType()==EntityType.ENDER_DRAGON)
			{
				if(cfg.getBoolean("EnderDragon",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
				}
			}
			if(ent.getType()==EntityType.BLAZE)
			{
				if(cfg.getBoolean("Blaze",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
				}
			}
			if(ent.getType()==EntityType.CAVE_SPIDER || ent.getType()==EntityType.SPIDER)
			{
				if(cfg.getBoolean("Spiders",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
				}
			}
			if(ent.getType()==EntityType.GHAST)
			{
				if(cfg.getBoolean("Ghast",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
				}
			}
			if(ent.getType()==EntityType.ZOMBIE)
			{
				if(cfg.getBoolean("Zombie",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
				}
			}
			if(ent.getType()==EntityType.WOLF)
			{
				if(cfg.getBoolean("Wolf",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
				}
			}
			if(ent.getType()==EntityType.WITHER_SKULL||ent.getType()==EntityType.WITHER)
			{
				if(cfg.getBoolean("Withers",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
				}
			}
			if(ent.getType()==EntityType.WITCH)
			{
				if(cfg.getBoolean("Witch",true))
				{
					if(event.getTarget().getType()==EntityType.PLAYER)
						if(!(ent.getLastDamageCause().getEntity() instanceof Player))
							event.setCancelled(true);
				}
			}
		}
	}
}
