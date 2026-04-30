package game.engine;
import java.io.IOException;
import java.util.*;
import game.engine.dataloader.DataLoader;
import game.engine.exceptions.*;
import game.engine.monsters.*;

public class Game {
    private Board board;
    private ArrayList<Monster> allMonsters;
    private Monster player;
    private Monster opponent;
    private Monster current;

    public Game(Role playerRole) throws IOException {
        this.board = new Board(DataLoader.readCards());
        this.allMonsters = DataLoader.readMonsters();

        this.player = selectRandomMonsterByRole(playerRole);
        this.opponent = selectRandomMonsterByRole(
            playerRole == Role.SCARER ? Role.LAUGHER : Role.SCARER
        );
        this.current = player;

        allMonsters.remove(player);
        allMonsters.remove(opponent);

        
        board.setStationedMonsters(new ArrayList<>(allMonsters));
        board.initializeBoard(DataLoader.readCells());
    }

    public Board getBoard() {
        return board;
    }

    public ArrayList<Monster> getAllMonsters() {
        return allMonsters;
    }

    public Monster getPlayer() {
        return player;
    }

    public Monster getOpponent() {
        return opponent;
    }

    public Monster getCurrent() {
        return current;
    }

    public void setCurrent(Monster current) {
        this.current = current;
    }

    private Monster selectRandomMonsterByRole(Role role) {
        Collections.shuffle(allMonsters);
        return allMonsters.stream()
                .filter(m -> m.getRole() == role)
                .findFirst()
                .orElse(null);
    }

    private Monster getCurrentOpponent() {
        if (this.player.equals(this.current)) {
            return this.opponent;
        } else {
            return this.player;
        }
    }

    private int rollDice() {
        return (int)(Math.random() * 6) + 1;
    }

    public void usePowerup() throws OutOfEnergyException {
        if (this.current.getEnergy() >= Constants.POWERUP_COST) {
            this.current.alterEnergy(-Constants.POWERUP_COST); //  deduct cost
            this.current.executePowerupEffect(this.getCurrentOpponent());
        } else {
            throw new OutOfEnergyException();
        }
    }

    public void playTurn() throws InvalidMoveException {
        if (this.current.isFrozen()) {
            this.current.setFrozen(false);
        } else {
            int roll = rollDice();
            board.moveMonster(this.current, roll, this.getCurrentOpponent());
        }
        switchTurn();
    }

    private void switchTurn() {
        this.current = this.getCurrentOpponent();
    }

    private boolean checkWinCondition(Monster monster) {
        if (monster.getEnergy() < 1000) return false;
        if (monster.getPosition() != 99) return false;
        return true;
    }

    public Monster getWinner() {
        if (this.checkWinCondition(this.player)) return this.player;
        if (this.checkWinCondition(this.opponent)) return this.opponent;
        return null;
    }
}