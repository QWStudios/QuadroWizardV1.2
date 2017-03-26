package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;

import model.Card;
import model.UserCardRepository;
import view.CardDetailViewGUI;
import view.CardViewGUI;

/**
 * Handles the creation of CardViewGUI()
 * @author Chris
 *
 */
public class CardViewController {
	private CardViewGUI cardView;
	private UserCardRepository cardRepository;
	private CardDetailViewGUI cardDetailView;
	private TableController tableController;



	/**
	 * Creates a new CardViewGUI() or updates the current one.
	 */
	public CardViewController(UserCardRepository userCardRepository) {
		cardRepository = userCardRepository;

		if (null == cardView) {
			cardView = new CardViewGUI(cardRepository);
			// populateTable(cardRepository.getCards());
			// THIS should be handled in the CardViewGUI class
			// tableController = new TableController(getTable());//create a
			// separate class to handle the table click

		}
		cardView.setAlwaysOnTop(true);
		cardView.setVisible(true);
		//possibly create a method (in TableController) to update the table with the new data
	}

	/**
	 * 
	 * @return Instance of JTable from the current CardViewGUI instance
	 */
	public JTable getTable() {
		return cardView.getTable();
	}

	

}
