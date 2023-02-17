public class Hoe extends Item {

	public Hoe(String name) {
		super(name, "hoe");
	}

	@Override
	public void doCommand(String input, Player p) {
		//does nothing 
	}
	
	@Override 
	public String describeYourself() {
		return "There is a hoe lying on the ground"; 
		
	}

}