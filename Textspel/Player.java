import java.util.ArrayList;

public class Player {
	private String name;
	private GameTile position;
	private int energy;
	private ArrayList<Item> backpack = new ArrayList<>();
	public boolean alive;

	private boolean wearingBoots = false;

	public Player(String Name, GameTile g) {
		name = Name;
		position = g;
		energy = 0;
		alive = true;
	}

	public void doCommand(String playerInput) {
		switch (playerInput) {

		case "backpack":
			printBackpack();
			break;

		default:

			if (playerInput.contains("pickup")) {
				pickUp(playerInput);
			} else {
				position.doCommand(playerInput, this);
			}
			for (int x = backpack.size()-1; x > -1; x--) {
				backpack.get(x).doCommand(playerInput, this);
			}
			break;
		}

	}

	private void pickUp(String input) {
		
		String[] inputs = input.split(" ");
		if (inputs.length>1) {
			
			for (Item i : getPos().getItems()) {
				if (i.getType().equals(inputs[1])) {
					AddItem(i);
				}
			}
		}
	}

	public void printPosition() {
		position.printPosition();
	}

	public void moveTo(GameTile g) {
		setPos(g);
		if (energy >= 1 && wearingBoots == false) {
			energy--;
		}
		position.description();
		printPosition();
	}

	public void setPos(GameTile g) {
		position = g;
	}

	public GameTile getPos() {
		return position;
	}

	public void AddItem(Item i) {
		backpack.add(i);
		System.out.println("[" + i.getName() + " was added to your backpack]");
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public ArrayList<Item> getBackpack() {
		return backpack;
	}

	public String getName() {
		return name;
	}

	public void setWearingBoots(boolean bool){
		wearingBoots=bool;
	}
	
	public void printBackpack() {
		System.out.println("The following items are currently in you inventory:");
		for (Item i : backpack) {
			System.out.println(i.getName());
		}
	}

}
