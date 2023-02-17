public class Boots extends Item {
	private boolean worn = false;

	public Boots(String name) {
		super(name, "boots");
	}

	@Override
	public void doCommand(String input, Player p) {

		if (input.equals("put on boots")) {
			for (Item i : p.getBackpack()) {
				if (i instanceof Boots) {
					if (worn == false) {
						System.out.println(
								"You put your shoes on and feel like you can walk forever without getting tired.");
						p.getBackpack().remove(this);
						worn = true;
						p.setWearingBoots(true);

						break;
					} else {
						System.out.println("You already have your shoes on...");
					}
				}
			}
		}
	}

	public String describeYourself() {
		return "There is a pair of boots lying on the ground";

	}

}
