public class Seed extends Item {

	public Seed(String name) {
		super("Seed", "seed");
	}

	@Override
	public void doCommand(String input, Player p) {
		boolean hasHoe = false; 
		for (Item i : p.getBackpack()) {
			if (i instanceof Hoe) {      
				hasHoe = true;            
			}
		}
		if (input.equals("plant seeds")) {
			if (hasHoe && p.getPos() instanceof Soil) {
				System.out.println("You plant the seeds which magically grows into a couple of carrots, yummy!");
				System.out.println("You place the carrots in your backback and resumes your journey.");
				p.AddItem(new Carrot("Carrot"));	
				p.getBackpack().remove(this);
			}
			else if(!hasHoe && p.getPos() instanceof Soil) {
				System.out.println("You do not have a hoe to til the soil!");
			}
			else if (hasHoe && p.getPos() instanceof Soil) {
				System.out.println("You need to find proper soil to plant the seeds in.");
			}
			else if(p.getPos() instanceof Soil == false) {
				System.out.println("You need some soil to plant the seeds in.");
			}
		}
	}
	public String describeYourself() {
		return "There is some seeds lying on the ground"; 
		
	}
}
