package game.engine.cells;

<<<<<<< HEAD
import game.engine.Constants;
import game.engine.interfaces.CanisterModifier;
import game.engine.monsters.Monster;
=======
import game.engine.interfaces.CanisterModifier;
>>>>>>> b39bd8a76dee9214f0ad5ed04b197624196b3cfc

public class ContaminationSock extends TransportCell implements CanisterModifier {

	public ContaminationSock(String name, int effect) {
		super(name, effect);
	}
<<<<<<< HEAD

	public void onLand(Monster landingMonster, Monster opponentMonster) {
        super.onLand(landingMonster, opponentMonster);
        this.transport(landingMonster); // 
        landingMonster.alterEnergy(-Constants.SLIP_PENALTY); 
    }
    
    public void modifyCanisterEnergy(Monster monster, int canisterValue) {
        monster.alterEnergy(canisterValue);
    }
=======
>>>>>>> b39bd8a76dee9214f0ad5ed04b197624196b3cfc
	

}

