package GameState;

import javax.swing.JButton;

import controller.GameManager;

public class WaitingForAction implements State {

	private GameManager gameManager;
	private JButton currentButton;
	
	
	public WaitingForAction(GameManager gameManager){
		this.gameManager = gameManager;
		//chooseCard();
	}
	
	@Override
	public void chooseCard() {
		currentButton = gameManager.getButton(); //possibly handle this in next class
		if(currentButton != null){
		System.out.println("GameState.WaitingForAction: Card chosen, advancing to state: PLayerTurnLogic\n" + gameManager.getState());
		gameManager.setState(gameManager.getPlayerTurnLogic());
		gameManager.setCurrentButtonDisabled();
		gameManager.getState().processingTurn();
		}
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
