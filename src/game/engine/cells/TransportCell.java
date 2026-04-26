package game.engine.cells;

<<<<<<< HEAD
import game.engine.Constants;
import game.engine.monsters.Monster;

=======
>>>>>>> b39bd8a76dee9214f0ad5ed04b197624196b3cfc
public abstract class TransportCell extends Cell {
	private int effect;

	public TransportCell(String name, int effect) {
		super(name);
		this.effect = effect;
	}

	public int getEffect() {
		return effect;
	}
<<<<<<< HEAD
	public void transport(Monster monster) {
        int newPosition = monster.getPosition() + this.getEffect();
        
        if (newPosition >= Constants.BOARD_SIZE) {
            newPosition = newPosition % Constants.BOARD_SIZE;
        } else if (newPosition < 0) {
            newPosition = (newPosition % Constants.BOARD_SIZE + Constants.BOARD_SIZE) % Constants.BOARD_SIZE;
        }
        
        monster.setPosition(newPosition); 
    }

    
	public void onLand(Monster landingMonster, Monster opponentMonster) {
        super.onLand(landingMonster, opponentMonster); 
        this.transport(landingMonster);
    }
=======
>>>>>>> b39bd8a76dee9214f0ad5ed04b197624196b3cfc
	
}
