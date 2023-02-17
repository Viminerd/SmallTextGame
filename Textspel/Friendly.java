public abstract class Friendly extends NPC {
	
	
	public Friendly(String name, GameTile position) {
		super(name, position);
	}
	
	@Override
	public abstract void doCommand(String input,Player p);
}
