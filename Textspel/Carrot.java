public class Carrot extends Item {

	public Carrot(String name) {
		super(name, "carrot");

	}

	@Override
	public void doCommand(String input, Player p) {
		if (input.equals("eat carrot")) {
			System.out.println("You chomp down on a couple carrots and feel a refreshing energy. ");
			p.setEnergy(p.getEnergy()+20);
			p.getBackpack().remove(this); 
		}
			
	}
	public String describeYourself() {
		return ""; 
		
	}

}
