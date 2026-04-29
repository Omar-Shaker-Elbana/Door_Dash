package game.engine.cells;

import game.engine.Board;
import game.engine.Role;
import game.engine.interfaces.CanisterModifier;
import game.engine.monsters.Monster;

public class DoorCell extends Cell implements CanisterModifier {
	private Role role;
	private int energy;
	private boolean activated;
	
	public DoorCell(String name, Role role, int energy) {
		super(name);
		this.role = role;
		this.energy = energy;
		this.activated = false;
	}
	
	public Role getRole() {
		return role;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean isActivated) {
		this.activated = isActivated;
	}

	
	@Override
	public void modifyCanisterEnergy(Monster monster, int canisterValue) {
	    if (monster.getRole() == this.role) {
	        monster.alterEnergy(canisterValue);
	    } else {
	        monster.alterEnergy(-canisterValue);
	    }
	}

	
	@Override
	public void onLand(Monster landingMonster, Monster opponentMonster) {
	    super.onLand(landingMonster, opponentMonster);

	    if (this.activated) return;

	    int energyVal = this.energy;
	    boolean energyChanged = false;

	    // Before energy
	    int before = landingMonster.getEnergy();

	    // Apply to landing monster
	    modifyCanisterEnergy(landingMonster, energyVal);

	    if (landingMonster.getEnergy() != before) {
	        energyChanged = true;
	    }

	    // Apply to teammates
	    for (Monster m : Board.getStationedMonsters()) {
	        if (m.getRole() == landingMonster.getRole()) {
	            int beforeTeam = m.getEnergy();

	            modifyCanisterEnergy(m, energyVal);

	            if (m.getEnergy() != beforeTeam) {
	                energyChanged = true;
	            }
	        }
	    }

	    // Activate ONLY if something actually changed
	    if (energyChanged) {
	        this.activated = true;
	    }
	}
}
