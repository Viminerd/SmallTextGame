public class BasicTile extends GameTile {
	public BasicTile(String name, int x, int y) {
		super(name, x, y);
	}

	@Override
	protected String specificDescription() {
		String text =". You look around, but there is nothing but rocks in sight,";
		for (NPC npc : this.getNPC()) {
			if (npc instanceof Troll) {
				text = ". You feel the ground treble as an angry troll runs towards you,";
			}
			if (npc instanceof Friendly) {
				text = ". There is a friendly looking " + npc.getName() + ", smiling at you,";
			} 
		}
		return text;
	}
}