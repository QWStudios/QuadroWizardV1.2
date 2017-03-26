package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.Card;
import model.CardLocation;
import model.Player;
import model.StatusCode;
import model.UserCardRepository;
import view.GameViewGUI;

/**
 * This class manages the GameViewGUI
 * 
 * @author Chris
 *
 */
public class GameViewController {

	private GameViewGUI gameViewGUI;
	private JButton currentButton;
	private DeckManager deckManager;
	private GameManager gameManager;
	private GameViewTableController gameViewTableController;
	private Card currentCard;
	private Player enemy;
	
	public GameViewController(DeckManager deckManager, Player enemy, GameManager gameManager) {
		this.gameManager = gameManager;
		this.deckManager = deckManager;
		this.enemy = enemy;
		gameViewGUI = new GameViewGUI(this, this.gameManager);
		gameViewGUI.setNames(deckManager.getDeck());
		this.gameViewTableController = gameViewGUI.getTableController();

		currentButton = null;
		/*
		 * gameViewGUI.addCardOneActionListener(new CardOneListener());
		 * gameViewGUI.addCardTwoActionListener(new CardTwoListener());
		 * gameViewGUI.addCardThreeActionListener(new CardThreeListener());
		 * gameViewGUI.addCardFourActionListener(new CardFourListener());
		 * gameViewGUI.addCardFiveActionListener(new CardFiveListener());
		 */
		gameViewGUI.addCardActionListener(new CardListener());
		
	}

	// possibly dont use
	public StatusCode closeGame() {
		final JOptionPane optionPane = new JOptionPane(
				"Do you wish to exit the current game?",
				JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
		optionPane.setVisible(true);

		int value = ((Integer) optionPane.getValue()).intValue();
		if (value == JOptionPane.YES_OPTION) {
			gameViewGUI.dispose();
			return StatusCode.GAME_CLOSED;
		} else if (value == JOptionPane.NO_OPTION) {
			// handle
			return StatusCode.GAME_NOT_CLOSED;
		}
		return StatusCode.GAME_NOT_CLOSED;
	}
	

	/*
	 * public JTable getTable(){ return table; }
	 */
	/**
	 * This class is used to handle the actionListener of all of the buttons.
	 * 
	 * @author Chris
	 *
	 */
	class CardListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// currentButton = (JButton) e.getSource();
			// currentButton =
			// gameViewGUI.getCardActionCommand(Integer.parseInt(e.getActionCommand()));
			int actionCommand = Integer.parseInt(e.getActionCommand());
			System.out.println(gameViewGUI.getCard(actionCommand));
			currentCard = deckManager.getCardInDeck(actionCommand-1);
			// this only works if it is the players turn to choose
			//*this code is also found in the GameViewTableController*-maybe delete
			/*if (gameViewTableController.getSpot() == true) {
				currentButton = gameViewGUI.getButton(actionCommand);
				gameManager.chooseCard();
				gameViewGUI.setStatusLabel("Choose a place to play the card");
			}*/
			//gameViewGUI.disableButton(actionCommand);
			//After clicking a valiud card, the player must choose a valid location on the board-handled in the GameViewTableController class
			currentButton = gameViewGUI.getButton(actionCommand);
			gameViewGUI.setStatusLabel("Choose a place to play the card");

		}
	}

	/**
	 * returns the last button clicked, for use within the WaitingForAction
	 * state
	 * 
	 * @return current button clicked
	 */
	public JButton getButton() {
		return currentButton;
	}
	
	public Card getCurrentCard(){
		return currentCard;
	}
	//replaced by the new playerCardLocation array functions
	/*public int[] getClickLocation(){
		return gameViewTableController.getClickLocation();
	}*/
	
	public CardLocation[] getPlayerCardLocation(){
		return gameViewTableController.getPlayerCardLocation();
	}
	
	public CardLocation[] getEnemyCardLocation(){
		return gameViewTableController.getEnemyCardLocation();
	}
	
	public CardLocation getCardInTable(int row, int col){
		return gameViewTableController.getCardInTable(row, col);
	}
	public JTable getTable(){
		return gameViewTableController.getTable();
	}
	public StatusCode disableButton(int i) {
		gameViewGUI.disableButton(i);
		return StatusCode.SUCCESS;
	}
	/**
	 * This class is used to handle the actionListener of the first button.
	 * 
	 * @author Chris
	 *
	 */
	/*
	 * class CardOneListener implements ActionListener {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * 
	 * System.out.println("CardOneListener() called"); } }// end class
	 */
	/**
	 * This class is used to handle the actionListener of the second button.
	 * 
	 * @author Chris
	 *
	 */
	/*
	 * class CardTwoListener implements ActionListener {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * 
	 * System.out.println("CardOneListener() called"); } }// end class
	 */
	/**
	 * This class is used to handle the actionListener of the third button.
	 * 
	 * @author Chris
	 *
	 */
	/*
	 * class CardThreeListener implements ActionListener {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * 
	 * System.out.println("CardOneListener() called"); } }// end class
	 */
	/**
	 * This class is used to handle the actionListener of the fourth button.
	 * 
	 * @author Chris
	 *
	 */
	/*
	 * class CardFourListener implements ActionListener {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * 
	 * System.out.println("CardOneListener() called"); } }// end class
	 */
	/**
	 * This class is used to handle the actionListener of the fifth button.
	 * 
	 * @author Chris
	 *
	 */
	/*
	 * class CardFiveListener implements ActionListener {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * 
	 * System.out.println("CardOneListener() called"); } }// end class
	 */

}