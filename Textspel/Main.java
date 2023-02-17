import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello adventurer, in this short game your mission is to navigate through the map and \n"
				+ "reach the treasure. To reach the treasure you have to complete a couple of tasks and fight your way \n"
				+ "through the dangers ahead. Type help to get possible commands, and type look to get hints of where you can go.");
		System.out.println("Lets start the game; what is your name?");
		Scanner nameInput = new Scanner(System.in);
		String name = nameInput.nextLine(); 
		Game G = new Game(name);
		G.run();
	}
	

}
