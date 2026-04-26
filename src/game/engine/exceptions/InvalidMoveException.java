package game.engine.exceptions;

@SuppressWarnings("serial")
public class InvalidMoveException extends GameActionException{
<<<<<<< HEAD
	public static final String MSG = "Invalid move attempted";
=======
	private static final String MSG = "Invalid move attempted";
>>>>>>> b39bd8a76dee9214f0ad5ed04b197624196b3cfc

	public InvalidMoveException() {
		super(MSG);
	}

	public InvalidMoveException(String message){
		super(message);
	}

}
