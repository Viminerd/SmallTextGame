public class Bow extends Item {

	public Bow(String name) {
		super(name, "bow");
	}

	@Override
	public void doCommand(String input, Player p) {
		if (input.equals("shoot bow")) {
			for (Item i : p.getBackpack()) {
				if (i instanceof Bow) {
					for (NPC npc : p.getPos().getNPC()) {
						if (npc instanceof Troll) {
							if (p.getEnergy() < 5) {
								System.out.println("You cant shoot your bow, more energy to do that.");
							} else {
								p.setEnergy(p.getEnergy() - 5);
								System.out.println(
										"You shoot the an arrow towards the troll. The arrow hits between its eyes and the monster falls to the ground.");
								p.getPos().removeNPC(npc);
								break; 
							}
						}
						if (npc instanceof Friendly) {
							if (p.getEnergy() < 5) {
								System.out.println("You cant shoot your bow, more energy to do that.");
							} else {
								p.setEnergy(p.getEnergy() - 5);
								System.out.println("You shoot the an arrow towards the friendly" + npc.getName()
										+ " killing it. What a horrible thing to do.");
								p.getPos().removeNPC(npc);
								break;

							}
						} else {

							if (p.getEnergy() < 5) {
								System.out.println("You cant shoot your bow, you need more energy to do that.");
							} else {
								p.setEnergy(p.getEnergy() - 5);
								System.out.println("You shoot the an arrow towards a tree, waste of an arrow...");
							}
						}
					}
					return;
				}
			}
		}

	}

	public String describeYourself() {
		return "There is a bow lying on the ground";

	}
}
