package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import view.CardDetailViewGUI;
import model.Card;
import model.Race;
import model.UserCardRepository;
/**
 * Handles the JTable on a given CardViewGUI instance.
 * @author Chris
 *
 */
public class TableController extends MouseAdapter {

	private JTable table;
	private CardDetailViewController cardDetailViewController;
	private UserCardRepository userCardRepository;

	/**
	 * Created when a CardViewGUI object is created.  Manages the table within the CardView.
	 * @param table
	 */
	public TableController(JTable table, UserCardRepository userCardRepository) {
		this.table = table;
		this.userCardRepository = userCardRepository;
		populateTable(this.userCardRepository.getCards());
	}

	/**
	 * Overridden from the MouseAdapter class
	 * Listens for the row and column that the mouse clicks on the JTable.
	 */
	@Override
	public void mousePressed(MouseEvent mEvt) {
		int row = table.rowAtPoint(mEvt.getPoint());
		int col = table.columnAtPoint(mEvt.getPoint());
		if (row >= 0 && col >= 0) {
			System.out.println(row + " " + col);
			createCardDetailView(row, col);
		}
	}

	/**
	 * Called when the view is created. Populates the table of users cards from
	 * the UserCardRepository
	 * 
	 * @param card
	 */
	private void populateTable(Card[][] card) {
		//TODO: Fix
		userCardRepository.createAttackCard("Skeleton", 0, 1, 1, Race.BALANCED, 1);
		userCardRepository.createAttackCard("Skeleton", 0, 2, 1, Race.BALANCED, 2);
		userCardRepository.createAttackCard("Skeleton", 0, 2, 2, Race.BALANCED, 1);
		userCardRepository.createAttackCard("Zombie", 1, 2, 3, Race.BALANCED, 1);
		System.out.println("Created skele");
		userCardRepository.print();
		userCardRepository.createAttackCard("Bunny", 10, 4, 2, Race.MAGIC, 2);
		System.out.println("Created bunny");
		userCardRepository.createAttackCard("Basilisk", 7, 5, 3, Race.RANGED, 1);
		System.out.println("Created basilisk");
		userCardRepository.createAttackCard("Basilisk", 7, 6, 6, Race.PHYSICAL, 2);
		System.out.println("Created basilisk");
		userCardRepository.createAttackCard("Skeleton Archer", 55, 2, 2, Race.RANGED, 1);
		System.out.println("Created skele");
		for (int i = 0; i < 10; i++) {
			for (int x = 0; x < 10; x++) {
				if (card[(i*10)+x][0] == null) {
					table.setValueAt("Not owned", i, x);
					
				} else {
					table.setValueAt(card[(i*10)+x][0].getName(), i, x);
					
				}
			}
		}
		//table.setValueAt("Skeleton", 0, 0);
		
	}
	
	/**
	 * Creates a new CardDetailViewController instance based on the values returned from the mousePressed method.
	 * 
	 * @param row
	 * @param col
	 */
	public void createCardDetailView(int row, int col) {
		if (table.getValueAt(row, col).equals("Not owned")) {
			System.out.println("Not owned");
			// null pointer
			// cardViewController.setStatusLabel("That card isn't owned, try another");
		} else {
			if (null == cardDetailViewController) {
				System.out.println("creating detail view");
				cardDetailViewController = new CardDetailViewController(row, col, userCardRepository);
			} else {
				cardDetailViewController.updateView(row, col);
				
				// cardDetailView.update(row, col);
				 
			}
		}
		// close current instance
		// create new one passing the current card

	}

}
