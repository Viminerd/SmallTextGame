public class Soil extends GameTile {
	public Soil(String Name, int x, int y) {
		super(Name, x, y);
	}

	@Override
	protected String specificDescription() {
		String text = ". There is a nice spot of fertile soil,";
		for (NPC npc : this.getNPC()) {
			if (npc instanceof Troll) {
				text = ". There is a spot of fertile soil, but in front of it stands an angry forest troll,";
			}
			if (npc instanceof Friendly) {
				text = ". There is a spot of fertile soil and a friendly looking " + npc.getName() + ", smiling at you,";
			} 
		}
		return text;
	}
}
