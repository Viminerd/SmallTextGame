public class Human extends Friendly {

	public Human(String name, GameTile position) {
		super(name, position);
	}

	@Override
	public void doCommand(String input, Player p) {
		if (input.equals("greet")) {
			System.out.println("The " + this.getName()
					+ " gives you a nice warm hug and hands you some seeds. You feel like you have slightly more energy.");
			p.setEnergy(p.getEnergy() + 5);
			p.AddItem(new Seed("Seeds"));
		}
	}
}
