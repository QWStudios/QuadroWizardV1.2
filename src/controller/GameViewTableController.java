package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JTable;

import model.CardLocation;
import model.TypeOnField;
import model.UserCardRepository;

/**
 * This class manages the GameViewGUI's table
 * 
 * @author Chris
 *
 */
public class GameViewTableController extends MouseAdapter {
	private JTable table;
	private DeckManager deckManager;
	private GameViewController gameViewController;
	private GameManager gameManager;
	private boolean spotFound = false;
	//private int[] clickLocation;
	private CardLocation[] playerCardLocation;//possibly delete
	private CardLocation[] enemyCardLocation;//possibly delete
	private CardLocation[][] tableCardLocations;
	
	
	/**
	 * Created when a CardViewGUI object is created. Manages the table within
	 * the CardView.
	 * 
	 * @param table
	 */
	public GameViewTableController(JTable table, GameViewController gameViewController, GameManager gameManager) {
		this.gameManager = gameManager;
		this.gameViewController = gameViewController;
		this.table = table;
		deckManager = DeckManager.getInstance();
		
		//clickLocation = new int[2];
		playerCardLocation = new CardLocation[5];
		enemyCardLocation = new CardLocation[5];
		tableCardLocations = new CardLocation[4][4];
		for(int row = 0; row < 4; row++){
			for(int col = 0; col < 4; col++){
				tableCardLocations[row][col] = new CardLocation(row, col, null, TypeOnField.EMPTY);
			}
		}
		setUpBlocks(table);
	}

	public JTable getTable(){
		return table;
	}
	//replaced by the new playerCardLocation array functions
	/*public int[] getClickLocation(){
		return clickLocation;
	}*/
	
	public CardLocation[] getPlayerCardLocation(){
		return playerCardLocation;
	}
	public CardLocation[] getEnemyCardLocation(){
		return enemyCardLocation;
	}
	
	public CardLocation getCardInTable(int row, int col){
		return tableCardLocations[row][col];
	}
	
	/**
	 * Overridden from the MouseAdapter class Listens for the row and column
	 * that the mouse clicks on the JTable.
	 */
	@Override
	public void mousePressed(MouseEvent mEvt) {
		int row = table.rowAtPoint(mEvt.getPoint());
		int col = table.columnAtPoint(mEvt.getPoint());
		if (row >= 0 && col >= 0) {
			System.out.println(row + " " + col);
			if((table.getValueAt(row, col) == null) && (gameViewController.getButton() != null) && (gameManager.getState() == gameManager.waitingForAction)){
				System.out.println("GameViewTableController-MouseClicked-Good spot");
				spotFound = true;
				
				
				/*clickLocation[0] = row;
				clickLocation[1] = col;*/
				
				tableCardLocations[row][col] = new CardLocation(row, col, gameViewController.getCurrentCard(), TypeOnField.PLAYER);
				//change cell color?
				//probably can delete
				
					if(playerCardLocation[Integer.parseInt(gameViewController.getButton().getActionCommand())-1] == null){
						playerCardLocation[Integer.parseInt(gameViewController.getButton().getActionCommand())-1] = new CardLocation(row, col, gameViewController.getCurrentCard(), TypeOnField.PLAYER);
						table.setValueAt(gameViewController.getCurrentCard().getName(), row, col);
					
				}
				gameManager.chooseCard();
			}
			else{
				System.out.println("Not your turn, buddy.");
			}
		}
	}

	
	/**
	 * Sets up the table by setting the "blocked" tiles.  Replace 'X's later with pictures
	 */
	private void setUpBlocks(JTable table) {
		boolean isTaken = false;
		Random rand = new Random();
		for (int i = 0; i < 5; i++) {
			int row = rand.nextInt(4) + 0;
			int col = rand.nextInt(4) + 0;
			if (table.getValueAt(row, col) == "X") {
				isTaken = true;
				while (isTaken == true) {
					row = rand.nextInt(4) + 0;
					col = rand.nextInt(4) + 0;
					if (table.getValueAt(row, col) != "X") {
						table.setValueAt("X", row, col);
						tableCardLocations[row][col] = new CardLocation(row, col, null, TypeOnField.BLOCK);
						isTaken = false;
					}
				}
			} else {
				table.setValueAt("X", row, col);
				tableCardLocations[row][col] = new CardLocation(row, col, null, TypeOnField.BLOCK);
			}
		}
	}// END METHOD
	
	public boolean getSpot(){
		return spotFound;
	}
	
}// END CLASS