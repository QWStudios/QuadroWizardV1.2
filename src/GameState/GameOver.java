/**
 * 
 */
package GameState;

import controller.GameManager;

/**
 * @author Chris
 *
 */
public class GameOver implements State {

	GameManager gameManager;

	public GameOver(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	@Override
	public void chooseCard() {
		// TODO Auto-generated method stub

	}

	@Override
	public void quitGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void turnCompleted() {
		// TODO Auto-generated method stub

	}

	@Override
	public void beginTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void winnerFound() {
		// TODO Auto-generated method stub

	}

	@Override
	public void processingTurn() {
		// TODO Auto-generated method stub

	}

}
