public abstract class NPC{
	private String name; 
	public NPC(String name, GameTile position) 
	{
		this.name = name; 	
		position.setNPC(this); 
	}
		
	public String getName() {
		return name;
	}	
	
	public abstract void doCommand(String input, Player p); 
		
	
}
