public class ClimbableWallTile extends GameTile {
	public ClimbableWallTile(String Name, int x, int y){
		super(Name, x, y); 
		}
	
	@Override
	protected String specificDescription() {
		String text; 
		for (NPC npc : getNPC()) {
			if (npc instanceof Troll) {
				text = ". In front of the wall stands an angry troll growling at you, ";
				break;
			}
		}

		text = ". The wall is covered in ledges and cavities, making you think it would be possible to climb it. \n"
		+ "You feel tired from walking, and need to replenish your energy before making the climb, "; 
		
		return text; 	
	}

}
