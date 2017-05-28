package O1010100;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class T3 extends JavaPlugin
{	
	public boolean CreeperGreif=false;
	public boolean EnderManGreif=false;
	public boolean EnderDragonSpawnBlock=true;
	public boolean SpawnGifts=true;
	CfgMgr cfgmgr;
	Cfg T3Cfg;
	public static Location DeathLocation;
	ItemStack[] PlayerItems;
	public static T3 plugin;
	Messanger msgr;
	Logger log =  Bukkit.getLogger();
	PluginDescriptionFile pdfile = this.getDescription();
	@Override
	public void onEnable()
	{
		plugin=this;
		//Craftable BoomStick?
		ShapedRecipe BStick = new ShapedRecipe(setItemName(new ItemStack(Material.STICK),ChatColor.LIGHT_PURPLE+"BoomStick!"))
				.shape(" ! ",
					   "%$%",
					   " % ").setIngredient
								('!',Material.ARROW).setIngredient
								('$', Material.STICK).setIngredient
								('%', Material.IRON_INGOT);
		
		this.getServer().addRecipe(BStick);
		//PluginManager//
		PluginManager pm = Bukkit.getServer().getPluginManager();
		
		//pm.registerEvents(new onBlockChange(), this);//Dependent On User Config
		pm.registerEvents(new PlayerDeath(), this);
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new playerChatEvnt(), this);
		pm.registerEvents(new PlayerLeave(),this);
		pm.registerEvents(new EntityExplode(), this);
		pm.registerEvents(new onBlockChange(), this);
		pm.registerEvents(new PlayerInteract(), this);//For BoomStick Stuff
		pm.registerEvents(new FriendlyMobs(), this);
		cfgmgr = new CfgMgr(this);
		T3Cfg = cfgmgr.getNewConfig("T3Cfg.yml", new String[]
				{"T3ssentias Configuration File","SuperBoats: Boats In Use By Players Won't Break!",":)"});
		T3Cfg.saveConfig();
		
		if(!T3Cfg.contains("SpawnGifts"))
		{
			T3Cfg.set("SpawnGifts", SpawnGifts);
		}
		else
		{
			SpawnGifts=T3Cfg.getBoolean("SpawnGifts",true);
		}
		if(!T3Cfg.contains("CreeperGreif"))
		{
			T3Cfg.createSection("CreeperGreif");
			T3Cfg.set("CreeperGreif", false);
			T3Cfg.saveConfig();
		}
		else
		{
			CreeperGreif = T3Cfg.getBoolean("CreeperGreif",true);
		}
		
		if(!T3Cfg.contains("EnderManGreif"))
		{
			T3Cfg.createSection("EnderManGreif");
			T3Cfg.set("EnderManGreif",EnderManGreif);
			T3Cfg.saveConfig();
		}
		else
		{
			EnderManGreif = T3Cfg.getBoolean("EnderManGerif",true);
		}
		
		if(!T3Cfg.contains("EnderDragonSpwanBlock"))
		{
			T3Cfg.createSection("EnderDragonSpawnBlock");
			T3Cfg.set("EnderDragonSpawnBlock", true);
		}
		else
		{
			if(T3Cfg.getBoolean("EnderDragonSpawnBlock"))
			{
				pm.registerEvents(new EnderDragonSpawn(),this);
			}
		}
		if(!T3Cfg.contains("Messages"))
		{
			T3Cfg.createSection("Messages");
			T3Cfg.set("Messages", false);
			T3Cfg.saveConfig();
			msgr.runTaskTimer(this, 5, 30*20);
			//msgr.runTaskTimer(this, 0, 30*20/*ticks*/);//20 ticks = 1 second
		}
		else
		{
			if(T3Cfg.getBoolean("Messages",true))
			{
				msgr.runTaskTimer(this, 5, 30*20/*ticks*/);//20 ticks = 1 second
			}
		}
		if(!T3Cfg.contains("SuperBoats"))
		{
			T3Cfg.createSection("SuperBoats");
			T3Cfg.set("SuperBoats", true,"SuperBoats - Boats Will Not Break While In Use!");
			T3Cfg.saveConfig();
			pm.registerEvents(new BoatControl(), this);
		}
		else
		{
			if(T3Cfg.getBoolean("SuperBoats",true))
			{
				pm.registerEvents(new BoatControl(), this);
			}
		}
		if(T3Cfg.getBoolean("EnderDragonSpawnBlock"))
		{
		pm.registerEvents(new EnderDragonSpawn(), this);
		}
		if(!T3Cfg.contains("FriendlyMobs"))
		{
			T3Cfg.createSection("FriendlyMobs");
			T3Cfg.set("Creepers", true);
			T3Cfg.set("Skeleton", false);
			T3Cfg.set("Spiders", false);
			T3Cfg.set("Zombies", false);
			T3Cfg.set("Blaze", false);
			T3Cfg.set("Enderman", false);
			T3Cfg.set("Endermite", false);
			T3Cfg.set("EnderDragon", true);
			T3Cfg.set("Withers",false);
			T3Cfg.set("Witch", true);
			T3Cfg.set("Wolf", false);
			T3Cfg.set("Ghast", false);
			T3Cfg.saveConfig();
			
		}
		//
		//msgr = new Messanger(this);
		//msgr.runTaskTimer(this, 0, 30*20/*ticks*/);//20 ticks = 1 second//Dependent On User Config	
		
		this.getCommand("setSpawn").setExecutor(new setSpawn(this));
		this.getCommand("feed").setExecutor(new Feed(this));
		this.getCommand("heal").setExecutor(new Heal(this));
		this.getCommand("ignite").setExecutor(new ignite(this));
		this.getCommand("Flight").setExecutor(new flight(this));
		this.getCommand("pat").setExecutor(new pat(this));
		this.getCommand("gm").setExecutor(new gm(this));
		this.getCommand("T3").setExecutor(new T3Command(this));
		this.getCommand("bed").setExecutor(new bed(this));
		this.getCommand("ob").setExecutor(new ob(this));
		this.getCommand("chat").setExecutor(new chat(this));
		this.getCommand("rs").setExecutor(new rs(this));
		this.getCommand("quit").setExecutor(new quit(this));
		this.getCommand("kk").setExecutor(new kk(this));
		this.getCommand("ct").setExecutor(new ct(this));
		this.getCommand("summon").setExecutor(new summon(this));
		this.getCommand("BoomStick").setExecutor(new BoomStick(this));
		this.getCommand("smite").setExecutor(new smite(this));
		this.getCommand("ec").setExecutor(new ec(this));
		this.getCommand("loc").setExecutor(new loc(this));
		this.getCommand("Creeper").setExecutor(new CreeperCmd(this));
		this.getCommand("su").setExecutor(new su(this));
		this.getCommand("oi").setExecutor(new oi(this));
		this.getCommand("Donkey").setExecutor(new DonkeyCmd(this));
		this.getCommand("ni").setExecutor(new ni(this));
		this.getCommand("rl").setExecutor(new rl(this));
		this.getCommand("PoweredCreeper").setExecutor(new PoweredCreeper(this));
		this.getCommand("Troll").setExecutor(new TrollCmd(this));
		this.getCommand("day").setExecutor(new DayCMD(this));
		this.getCommand("night").setExecutor(new NightCMD(this));
		this.getCommand("pvp").setExecutor(new TogglePVP(this));
		
		log.info(pdfile.getName()+" Version: "+pdfile.getVersion()+" Enabled!");
	}
	@Override
	public void onDisable()
	{
		Bukkit.getServer().clearRecipes();
		Bukkit.getPluginManager().disablePlugin(this);
		log.info(pdfile.getName()+" Version: "+pdfile.getVersion()+" Disabled :(");
		plugin = null;

	}

	public ItemStack setItemName(ItemStack item,String name)
	{
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return item;
	}

}
