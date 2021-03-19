package nms;

import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin{
	public static MainClass instance;
	public static String ControllerKey="tellmewhy";
	public static String ControllerValue="thisiswhatyoucamefor";
	public static String StructureKey="DummyStructure";
	public static String StructureValue="42069";
	public static String ZombieKey="menschensinddoof";
	public static String ZombieValue="ichmagzüge";
	public static String ZombieHitKey="getrekt";
	public static String ZombieHitValue="dunoob";
	
	@Override
	public void onEnable() {
		instance=this;
		
		
		this.getCommand("mahsDummyController").setExecutor(new Command());
		
		this.getServer().getPluginManager().registerEvents(new PlaceListener(), this);
		this.getServer().getPluginManager().registerEvents(new RightClickListener(), this);
		this.getServer().getPluginManager().registerEvents(new InvClickHandler(), this);
		this.getServer().getPluginManager().registerEvents(new BlockExplodeListener(), this);
		this.getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
		this.getServer().getPluginManager().registerEvents(new ZombieAttackedListener(), this);
	}
}
//you can hit him away while teleporting and you can push him away