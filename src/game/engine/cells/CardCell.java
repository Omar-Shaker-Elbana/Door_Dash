package game.engine.cells;

<<<<<<< HEAD
import game.engine.Board;
import game.engine.cards.Card;
import game.engine.monsters.Monster;

=======
>>>>>>> b39bd8a76dee9214f0ad5ed04b197624196b3cfc
public class CardCell extends Cell {
	
	public CardCell(String name) {
        super(name);
    }
<<<<<<< HEAD

	public void onLand(Monster landingMonster, Monster opponentMonster) {
        super.onLand(landingMonster, opponentMonster);
        
        Card drawnCard = Board.drawCard();
        
        if (drawnCard != null) {
            drawnCard.performAction(landingMonster, opponentMonster);
        }
    }
=======
>>>>>>> b39bd8a76dee9214f0ad5ed04b197624196b3cfc
   
}
