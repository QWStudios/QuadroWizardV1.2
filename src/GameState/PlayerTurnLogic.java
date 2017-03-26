package GameState;

import javax.swing.JButton;
import javax.swing.JTable;

import model.Card;
import model.CardLocation;
import model.CardType;
import model.Player;
import model.StatusCode;
import model.TypeOnField;
import controller.GameManager;

public class PlayerTurnLogic implements State {

	private GameManager gameManager;
	private JButton currentButton;
	private JTable table;
	private int[] clickLocations;
	private Card currentCard;
	private CardLocation[] playerCardLocation;// possibly delete
	private CardLocation[] enemyCardLocation; //possibly delete
	private CardLocation currentCardLocation;
	// private int[][] surroundingLocations;
	private CardLocation[] surroundingLocations;
	private Player enemy;

	public PlayerTurnLogic(GameManager gameManager) {
		this.gameManager = gameManager;
		this.enemy = gameManager.getEnemy();
		// clickLocations = new int[2];
		playerCardLocation = new CardLocation[5];
		enemyCardLocation = new CardLocation[5];
		playerCardLocation = gameManager.getPlayerCardLocation();
		enemyCardLocation = gameManager.getEnemyCardLocation();

		// /surroundingLocations = new int[8][2];
		surroundingLocations = new CardLocation[8];
	}

	@Override
	public void chooseCard() {
		// TODO Auto-generated method stub
		System.out.println("State:PlayerTurnLogic-Cannot choose a card");
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
		// possibly do in ctor
		System.out
				.println("In State: PlayerTurnLogic: in method: processingTurn()");
		currentButton = gameManager.getButton();
		currentCard = gameManager.getCard(Integer.parseInt(currentButton.getActionCommand()) - 1);
		// get instance of table, call method to handle checking if it is a
		// valid spot
		table = gameManager.getTable();

		// clickLocations = gameManager.getClickLocation();
		currentCardLocation = playerCardLocation[Integer
				.parseInt((currentButton.getActionCommand())) - 1];

		// shouldn't need this method
		/*
		 * if (isValidLocation() == StatusCode.SUCCESS) {
		 * System.out.println("Good place boss"); }
		 */

		// do card battle
		if (cardBattle() == StatusCode.SUCCESS) {
			gameManager.setState(gameManager.getCheckForWin());
		} else {
			// TODO: maybe?
		}
	}

	/*
	 * probably won't need public StatusCode isValidLocation() { //do alogirthm
	 * here return null; }
	 */

	/**
	 * method to do the actual card battle.
	 * 
	 * @return StatusCode
	 */
	private StatusCode cardBattle() {
		// First: get a list of the coordinates of the 8 cells surrounding the
		// current card
		// Second: Determine what is contained in those cells (ex, player cards,
		// enemy cards, blocks, empty)
		// Third: Do the card battle
		// Fourth: Result of the card battle
		// part 1
		findSurroundingLocations();
		// parts 2-3
		//test this
		for (int i = 0; i < 8; i++) {
			if ((surroundingLocations[i].getTypeOnField() == TypeOnField.ENEMY) && 
					(currentCard.getDirection(i) == true) && currentCard.getType() == CardType.ATTACK){
				//handles math for battle
				processBattle(surroundingLocations[i]);
					
				return StatusCode.SUCCESS;	//part 4
			}else if ((surroundingLocations[i].getTypeOnField() == TypeOnField.PLAYER) && 
			(currentCard.getDirection(i) == true) && (currentCard.getType() == CardType.DEFENSE)){
				//TODO: handle defense cards here
			}
		}
		return StatusCode.NO_SURROUNDING_CARDS;	//part 4
	}

	/**
	 * This method is used to find the 8 possible locations surrounding the location of the current card
	 */
	private void findSurroundingLocations() {
		/*
		 * 1 2 3 
		 * 4 X 5 
		 * 6 7 8
		 */
		int count = 0;
		System.out.println("currentCard" + currentCardLocation.getXValue()
				+ " " + currentCardLocation.getYValue());
		for (int row = currentCardLocation.getXValue() - 1; row < currentCardLocation
				.getXValue() + 2; row++) {// TODO: null pointer here
			for (int col = currentCardLocation.getYValue() - 1; col < currentCardLocation
					.getYValue() + 2; col++) {

				if (row != currentCardLocation.getXValue()
						|| col != currentCardLocation.getYValue()) {
					if (row >= 0 && row < 4 && col >= 0 && col < 4) {
						surroundingLocations[count] = gameManager
								.getCardInTable(row, col);
						System.out.println("In bounds row " + row + " col "
								+ col);
					} else {
						surroundingLocations[count] = new CardLocation(row,
								col, null, TypeOnField.OUT_OF_BOUNDS);
						System.out.println("Out of bounds row " + row + " col "
								+ col);
					}
					count++;
					System.out.println("count " + count);
				}// end outer if
			}// end inner loop
		}// end outer loop

		for (CardLocation c : surroundingLocations) {
			System.out.println(c.getTypeOnField().toString());
		}

	}
	/**
	 * This method processes the math and determines the winner for the battle
	 */
	private TypeOnField processBattle(CardLocation enemyCard){
		//enemy player class upon instantiation will randomly generate 5 cards. It will also
		//generate 5 values for the cardLocations array in the class with null x and y values.  This way, the deck and cardLocations arrays will run
		//parallel 
		Card card = enemy.getCardInDeck(enemyCard.getXValue(), enemyCard.getYValue());
		//battle rules.  Card loses if its hp reaches 0.  Defense will absorb some incoming attack.  Race adds a modifier. 
		//TODO: consider defense cards boosting attack cards (for defending card)
		int raceMultiplier = card.getRaceModifier(currentCard.getRace(), enemyCard.getCard().getRace());
		if (((raceMultiplier*currentCard.getSpecial()) + currentCard.getSpecial() >= enemyCard.getCard().getDefense())){
			//do win
		}else{
			//do lose
		}
		return null;
	}
	
	/**
	 * This method checks for cards surrounding the initial battle card in the battle
	 */
	private void checkForSteals(){
		
	}
	
}
