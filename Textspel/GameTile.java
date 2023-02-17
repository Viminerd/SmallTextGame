import java.util.ArrayList;
import java.util.Scanner;

public class GameTile {
	private String name;
	private GameTile North;
	private GameTile East;
	private GameTile South;
	private GameTile West;
	private boolean beenBefore = false;
	private int posX;
	private int posY;

	private ArrayList<Item> itemList = new ArrayList<>();
	private ArrayList<NPC> NPCList = new ArrayList<>();
	private boolean climbableWall = false;

	public GameTile(String Name, int x, int y) {
		name = Name;
		posX = x;
		posY = y;

	}

	public void setNeighbours(GameTile N, GameTile E, GameTile S, GameTile W) {
		North = N;
		East = E;
		South = S;
		West = W;
	}

	public void doCommand(String direction, Player p) {
		NPC trollBlocking = null;
		for (NPC npc : NPCList) {
			if (npc instanceof Troll) {
				trollBlocking = npc;
			}
		}
		switch (direction) {
		case "move north":
			checkMove(p, direction, North, trollBlocking); 
			break;
		case "move east":
			checkMove(p, direction, East, trollBlocking); 			
			break;
		case "move south":
			checkMove(p, direction, South, trollBlocking); 
			break;
		case "move west":
			checkMove(p, direction, West, trollBlocking); 
			break;
		case "look":
			look();
			break;
		default:
			for (NPC npc : NPCList) {
				npc.doCommand(direction, p);
			}
			for (Item i : itemList) {
				i.doCommand(direction, p);
			}
			break;
		}
	}
	
	private void checkMove(Player p, String input, GameTile g, NPC trollBlock) {
		if (trollBlock != null) {
			if (g.beenBefore) {
				checkPossibleMove(p, g);
			} else {
				trollBlock.doCommand(input, p);
			}
		} else {
			checkPossibleMove(p, g);
		}		
	}

	private void checkPossibleMove(Player p, GameTile g) {
		if (g instanceof WallTile) {
			System.out.println("You are looking at a high wall, looks unclimbable. What do you want to do instead?");
		} else if (g.climbableWall) {

			System.out.println(
					"You cant move here, but maybe you can try climbing it? Do you want to try to climb it? Yes or no");
			Scanner input_ = new Scanner(System.in);
			String input_String = input_.nextLine().toLowerCase();
			if (p.getEnergy() > 10 && input_String.equals("yes")) {
				System.out.println("You manage to climb the wall, and now stand atop it exhausted.");
				p.setEnergy(p.getEnergy() - 10);
				p.moveTo(g);
				beenBefore = true;

			} else if (p.getEnergy() < 10 && input_String.equals("yes")) {
				System.out.println(
						"You decide to climb it, but just as you are about to you realise you are too tired and wont be able to make it all the way up.");
				System.out.println("What do you want to do instead?");
			} else{
				System.out.println("You decide not to climb it. What do you want to do instead?");
			}
		} else {
			p.moveTo(g);
			beenBefore = true;
		}
	}

	public void printPosition() {
		System.out.println("Position: (" + posX + ", " + posY + ")");
	}

	public void look() {
		boolean tempbool = beenBefore;
		beenBefore = false;
		description();
		System.out.println("You are able to move to:");
		if (North instanceof WallTile == false) {
			if (North instanceof Soil) {
				System.out.println("A fenced garden to the north. ");
			} else {
				System.out.println("A stone tile to the north. ");
			}
		}
		if (East instanceof WallTile == false) {
			if (East instanceof Soil) {
				System.out.println("A fenced garden to the east. ");
			} else {
				System.out.println("A stone tile to the east. ");
			}
		}
		if (South instanceof WallTile == false) {
			if (South instanceof Soil) {
				System.out.println("A fenced garden to the south. ");
			} else {
				System.out.println("A stone tile to the south. ");
			}
		}
		if (West instanceof WallTile == false) {
			if (West instanceof Soil) {
				System.out.println("A fenced garden to the West. ");
			} else {
				System.out.println("A stone tile to the West. ");
			}
		}

		beenBefore = tempbool;
	}

	public void description() {
		if (!beenBefore) {
			System.out.print("You are standing ");
		} else {
			System.out.print("Your are back ");
		}
		System.out.println(name.toLowerCase() + "" + specificDescription());
		for (Item i : itemList) {
			System.out.println(i.describeYourself());
		}
		System.out.println("what do you want to do next?");

	}

	protected String specificDescription() { 
		return "";
	}

	public ArrayList<NPC> getNPC() {
		return NPCList;
	}

	public void setNPC(NPC npc) {
		NPCList.add(npc);
	}

	public void removeNPC(NPC npc) {
		NPCList.remove(npc);
	}

	public ArrayList<Item> getItems() {
		return itemList;
	}

	public void placeItem(Item item) {
		itemList.add(item);
	}

	public void setClimbableWall() {
		climbableWall = true;
	}

}
