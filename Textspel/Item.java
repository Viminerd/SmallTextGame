public abstract class Item {
	private String name;
	private String type; 

	public Item(String name, String type) {

		this.name = name;
		this.type = type; 

	}

	public String getName() {
		return name;
	}
	
	public String getType() {
		return type; 
	}

	public abstract void doCommand(String input, Player p);
	
	public abstract String describeYourself(); 

}
