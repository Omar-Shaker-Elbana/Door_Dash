package game.engine.cards;
import game.engine.monsters.Monster;
import game.engine.Role;
public class ConfusionCard extends Card {
	private int duration;
	
	public ConfusionCard(String name, String description, int rarity, int duration) {
		super(name, description, rarity, false);
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}
	public void performAction(Monster player, Monster opponent) {
	  
	    Role tempRole = player.getRole();
	    player.setRole(opponent.getRole());
	    opponent.setRole(tempRole); 
	    player.setConfusionTurns(this.getDuration());
	    opponent.setConfusionTurns(this.getDuration());
	}}
