package controller;

import javax.swing.JButton;
import javax.swing.JTable;

import model.Card;
import model.CardLocation;
import model.Player;
import model.StatusCode;
import model.UserCardRepository;
import GameState.CheckForWin;
import GameState.ComputerTurnLogic;
import GameState.GameOver;
import GameState.PlayerTurnLogic;
import GameState.QuitGame;
import GameState.State;
import GameState.WaitingForAction;

/**
 * This class manages the game state Class flow: GameManager ->
 * GameViewController (GameViewTableController) -> GameViewGUI
 * 
 * @author Chris
 *
 */
public class GameManager {

	private GameViewController gameViewController;
	private MainMenuController mainMenuController;
	private DeckManager deckManager;
	private Player enemy;
	
	// State variables
	State waitingForAction;
	State quitGame;
	State playerTurnLogic;
	State checkForWin;
	State computerTurnLogic;
	State gameOver;

	// initial state;
	State currentState = this.waitingForAction;

	public GameManager(DeckManager deckManager) {
		this.deckManager = deckManager;
		enemy = new Player();
		mainMenuController = MainMenuController.getInstance();
		launchGameView();

		this.waitingForAction = new WaitingForAction(this);
		this.quitGame = new QuitGame(this);
		this.playerTurnLogic = new PlayerTurnLogic(this);
		this.checkForWin = new CheckForWin(this);
		this.computerTurnLogic = new ComputerTurnLogic(this);
		this.gameOver = new GameOver(this);

		setState(waitingForAction);

		// return StatusCode.GAME_RUNNING;
	}

	private StatusCode launchGameView() {
		if (null == gameViewController) {
			gameViewController = new GameViewController(deckManager, enemy, this);

			return StatusCode.SUCCESS;
		} else {
			// game already running
			gameViewController.closeGame();
			return StatusCode.SUCCESS;
		}
	}
	public Player getEnemy(){
		return enemy;
	}

	public Card getCard(int i) {
		return deckManager.getCardInDeck(i);
	}

	/**
	 * 
	 * @return instance of current button card clicked
	 */
	public JButton getButton() {
		return gameViewController.getButton();
	}
	
	//replaced by the new playerCardLocation array functions
	/*public int[] getClickLocation() {
		return gameViewController.getClickLocation();
	}*/

	//replaces the getClickLocation method
	public CardLocation[] getPlayerCardLocation(){
		return gameViewController.getPlayerCardLocation();
	}
		
	public CardLocation[] getEnemyCardLocation() {
		return gameViewController.getEnemyCardLocation();
	}
	
	public CardLocation getCardInTable(int row, int col){
		return gameViewController.getCardInTable(row, col);
	}
	
	public JTable getTable() {
		return gameViewController.getTable();
	}

	// State stuff
	public void chooseCard() {
		this.currentState.chooseCard();
	}

	public void quitGame() {
		this.currentState.quitGame();
	}

	public void turnCompleted() {
		this.currentState.turnCompleted();
	}

	public void beginTurn() {
		this.currentState.beginTurn();
	}

	public void winnerFound() {
		this.currentState.winnerFound();
	}

	// gets
	public State getState() {
		return currentState;
	}

	public State getWaitingForAction() {
		return waitingForAction;
	}

	public State getQuitGame() {
		return quitGame;
	}

	public State getPlayerTurnLogic() {
		return playerTurnLogic;
	}

	public State getCheckForWin() {
		return checkForWin;
	}

	public State getComputerTurnLogic() {
		return computerTurnLogic;
	}

	public State getGameOver() {
		return gameOver;
	}

	// sets
	public void setState(State state) {
		currentState = state;
	}

	// other
	public void setCurrentButtonDisabled() {
		gameViewController.disableButton(Integer.parseInt(this.getButton()
				.getActionCommand()) - 1);
	}



}
