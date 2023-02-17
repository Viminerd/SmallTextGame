import java.util.Scanner;
public class Game {

	private Player player;
	private GameTile goal;

	public Game(String name) {
		GameTile wall = new WallTile();
		GameTile tile00 = new BasicTile("in your house", 0, 0);
		new Goblin("House Goblin", tile00);
		GameTile tile10 = new BasicTile("on Stone", 1, 0);
		GameTile tile20 = new BasicTile("on Stone", 2, 0);
		GameTile tile01 = new BasicTile("on Stone", 0, 1);
		GameTile tile02 = new BasicTile("on Stone", 0, 2);
		new Human("old man", tile02);
		GameTile tile11 = new Soil("fenced garden", 1, 1);
		GameTile tile22 = new BasicTile("on Stone", 2, 2);
		GameTile tile12 = new BasicTile("on Stone", 1, 2);
		GameTile tile21 = new BasicTile("on Stone", 2, 1);
		GameTile tile31 = new BasicTile("on Stone", 3, 1);
		GameTile tile41 = new BasicTile("on Stone", 4, 1);
		new Troll("Troll", tile41);
		GameTile tile51 = new BasicTile("on Stone", 5, 1);

		tile00.setNeighbours(wall, tile10, tile01, wall);
		tile10.setNeighbours(wall, tile20, tile11, tile00);
		tile20.setNeighbours(wall, wall, tile21, tile10);
		tile01.setNeighbours(tile00, tile11, tile02, wall);
		tile02.setNeighbours(tile01, tile12, wall, wall);
		tile11.setNeighbours(tile10, tile21, tile12, tile01);
		tile22.setNeighbours(tile21, wall, wall, tile12);
		tile12.setNeighbours(tile11, tile22, wall, tile02);
		tile21.setNeighbours(tile20, tile31, tile22, tile11);
		tile31.setNeighbours(wall, tile41, wall, tile21);
		tile41.setNeighbours(wall, tile51, wall, tile31);
		tile22.placeItem(new Bow("bow"));
		tile20.placeItem(new Hoe("hoe"));
		tile22.setClimbableWall();
		player = new Player(name, tile00);
		goal = tile51;
	}

	public void run() {
		System.out.println("The journey begins, where do you want to go? North, East, South or West?");

		player.getPos().description();
		Scanner input = new Scanner(System.in);
		while (player.getPos() != goal && player.alive) {
			newInput(input);
		}
		if (player.alive) {
			System.out.println(
					"Congratulations " + player.getName() + ", you made it to the treasure and won the game!!");
		}
	}

	private void help_func() {
		System.out.println("To move - type \"move [direction]\" where direction is either North, East, South or West.");
		System.out.println(
				"Other possible options are \"backpack\", \"plant seeds\", \"pickup [item] \", \"shoot bow\", \"eat carrot\", "
						+ "\"put on boots\", \"greet\" and \"look\".");
		System.out.println("All which are only possible at times");
		System.out.println("If you type look you also get a hint och possible directions to move.");
	}

	private void newInput(Scanner input) {
		String inputString = input.nextLine().toLowerCase();
		inputCommand(inputString);
	}

	private void inputCommand(String commandInput) {
		commandInput = commandInput.toLowerCase();
		if (commandInput.equals("help")) {
			help_func();
		} else {
			player.doCommand(commandInput);
		}
	}

}
