package game.engine.cells;
import game.engine.Constants;
import game.engine.interfaces.CanisterModifier;
import game.engine.monsters.Monster;

public class ContaminationSock extends TransportCell implements CanisterModifier {

    public ContaminationSock(String name, int effect) {
        super(name, effect);
    }

    @Override
    public void onLand(Monster landingMonster, Monster opponentMonster) {
        super.onLand(landingMonster, opponentMonster); // already calls this.transport()
    }

    @Override
    public void modifyCanisterEnergy(Monster monster, int canisterValue) {
        monster.alterEnergy(canisterValue);
    }

    @Override
    public void transport(Monster monster) {
        int newPosition = monster.getPosition() + this.getEffect(); // effect is already negative
        if (newPosition < 0) {
            newPosition = (newPosition % Constants.BOARD_SIZE + Constants.BOARD_SIZE) % Constants.BOARD_SIZE;
        }
        monster.setPosition(newPosition);

        if (monster.isShielded()) {
            monster.setShielded(false); // shield absorbs energy penalty
        } else {
            monster.alterEnergy(-Constants.SLIP_PENALTY);
        }
    }
}