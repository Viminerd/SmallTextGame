public class Goblin extends Friendly {

	public Goblin(String name, GameTile position) {
		super(name, position);

	}
	
	@Override
	public void doCommand(String input, Player p) {
		if (input.equals("greet")) {
			System.out.println(
					this.getName() + ": Ahh you saw me " + p.getName() + ". Here you can have your boots back :). ");
			p.AddItem(new Boots("Enchanted Boots"));
		}
	}
}