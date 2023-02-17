public class Troll extends NPC {

	public Troll(String name, GameTile position) {
		super(name, position);
	}

	@Override
	public void doCommand(String input, Player p) { // kills player
		if (input.equals("shoot bow") == false) {
			System.out.println("The troll charges you and cleaves you in two right along the middle");
			System.out.println("------------------Game over---try again---------------");
			p.alive = false; 
		}
	}

}
