package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StatusCode;
import model.UserCardRepository;
import view.CardDetailViewGUI;

/**
 * This class is used to handle the card detail windows. It is responsible for
 * opening, closing, populating with data, and updating the window.
 * 
 * @author Chris
 *
 */

public class CardDetailViewController {

	private CardDetailViewGUI cardDetailView;
	private UserCardRepository cardRepository;
	private DeckManager deckManager;
	private int row, col, id, uId;

	public CardDetailViewController(int row, int col,
			UserCardRepository cardRepository) {

		// setRowCol(row, col);
		cardDetailView = new CardDetailViewGUI();
		this.cardRepository = cardRepository;
		deckManager = DeckManager.getInstance();
		updateView(row, col);
		cardDetailView.addCancelActionListener(new CancelButtonListener());
		cardDetailView.addNextActionListener(new NextButtonListener());
		cardDetailView.addPreviousActionListener(new PreviousButtonListener());
		cardDetailView.addAddToDeckActionListener(new AddButtonListener());
		cardDetailView
				.addRemoveFromDeckActionListener(new RemoveButtonListener());
	}

	/**
	 * UpdateView for initial window. Opens the first card and only the first
	 * 
	 * @param row
	 * @param col
	 */
	public void updateView(int row, int col) {
		setRowCol(row, col);
		uId = 0;
		cardDetailView.setVisible(true);
		cardDetailView.setName(cardRepository.getCard(id, uId).getName());
		cardDetailView.setDefense(cardRepository.getCard(id, uId).getDefense());
		cardDetailView.setHealth(cardRepository.getCard(id, uId).getHealth());
		cardDetailView.setNumber(uId + 1);
		cardDetailView.setRace(cardRepository.getCard(id, uId)
				.getRaceAsString());
		if (cardRepository.getCard(id, uId).getInDeck() == true) {
			cardDetailView.setInDeck("In Deck", Color.GREEN);
			cardDetailView.setAddButtonVisibility(false);
			cardDetailView.setRemoveButtonVisibility(true);
		} else {
			cardDetailView.setInDeck("Not In Deck", Color.RED);
			cardDetailView.setAddButtonVisibility(true);
			cardDetailView.setRemoveButtonVisibility(false);
		}
		cardDetailView.setSpecial(cardRepository.getCard(id, uId).getSpecial(),
				cardRepository.getCard(id, uId).getTypeAsInt());
		// finish
	}

	/**
	 * overloaded version taking a uniqueId. This is called by next or previous
	 * buttons
	 * 
	 * @param row
	 * @param col
	 * @param uId
	 */
	public void updateView(int row, int col, int uId) {
		// setRowCol(row, col);
		cardDetailView.setVisible(true);
		cardDetailView.setName(cardRepository.getCard(id, uId).getName());
		cardDetailView.setDefense(cardRepository.getCard(id, uId).getDefense());
		cardDetailView.setHealth(cardRepository.getCard(id, uId).getHealth());
		cardDetailView.setNumber(uId + 1);
		cardDetailView.setRace(cardRepository.getCard(id, uId)
				.getRaceAsString());
		if (cardRepository.getCard(id, uId).getInDeck() == true) {
			cardDetailView.setInDeck("In Deck", Color.GREEN);
			cardDetailView.setAddButtonVisibility(false);
			cardDetailView.setRemoveButtonVisibility(true);
		} else {
			cardDetailView.setInDeck("Not In Deck", Color.RED);
			cardDetailView.setAddButtonVisibility(true);
			cardDetailView.setRemoveButtonVisibility(false);
		}
		cardDetailView.setSpecial(cardRepository.getCard(id, uId).getSpecial(),
				cardRepository.getCard(id, uId).getTypeAsInt());
		// finish
	}

	private void setRowCol(int row, int col) {
		this.row = row;
		this.col = col;
		this.id = ((row * 10) + col);
		System.out.println("setRowCol called, row: " + row + " col: " + col);
	}

	/**
	 * This class is closes the detail view when the save button is pressed
	 * 
	 * @author Chris
	 */
	class CancelButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			cardDetailView.dispose();
		}
	}// end class

	/**
	 * This class is handles updating the detail view to the next card when the
	 * next button is pressed.
	 * 
	 * @author Chris
	 */
	class NextButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// cardRepository.getCard(id, uId+1).getName();
			if (null != cardRepository.getCard(id, uId + 1)) {
				uId += 1;
				System.out.println("Next good" + "row: " + row + "col " + col
						+ "uId " + uId);
				updateView(id, col, uId);

			} else {
				// if (uId != 0) {//perhaps delete this so even if there is only
				// 1 card (uId == 0) it still udates for no reason
				uId = 0;
				updateView(id, col, uId);
				System.out.println("Next bad");
				// }
			}
		}
	}// end class

	/**
	 * This class is handles updating the detail view to the previous card when
	 * the previous button is pressed.
	 * 
	 * @author Chris
	 */
	class PreviousButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (null != cardRepository.getCard(id, uId - 1)) {
					uId -= 1;
					updateView(id, col, uId);
				} /*else {
					System.out.println("In elese");
					uId = cardRepository.findLastUniqueCard(id);
					updateView(id, col, uId);
				}*/
				// System.out.println("No available card");
			} catch (IndexOutOfBoundsException exc) {
				System.out.println("No available card");
				uId = cardRepository.findLastUniqueCard(id);
				updateView(id, col, uId);
			}

		}
	}// end class

	/**
	 * This class is handles the adding to deck.
	 * 
	 * @author Chris
	 *
	 */
	class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			StatusCode code = deckManager.addToDeck(cardRepository.getCard(id,
					uId));
			if (code == StatusCode.DECK_FULL) {
				// TODO: handle
				// shouldn't happen
			} else if (code == StatusCode.DUPLICATE) {
				// TODO: handle
				// shouldn't happen
			} else if (code == StatusCode.SUCCESS) {
				updateView(row, col, uId);

			}

		}
	}// end class

	/**
	 * This class is handles updating the detail view to the next card when the
	 * next button is pressed.
	 * 
	 * @author Chris
	 */
	class RemoveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			StatusCode code = deckManager.removeFromDeck(cardRepository
					.getCard(id, uId));
			if (code == StatusCode.SUCCESS) {
				updateView(row, col, uId);
			} else if (code == StatusCode.NOT_IN_DECK) {
				// TODO: handle
			} else if (code == StatusCode.FAILURE) {
				// TODO: handle
			}
		}
	}// end class

}// end class

/**
 * 
 * @return instance of the CardDetailViewHandler()
 */
/*
 * public CardDetailViewHandler getDetailView() { if (cardDetailViewHandler ==
 * null) { cardDetailViewHandler = new CardDetailViewHandler(); return
 * cardDetailViewHandler; } else return cardDetailViewHandler;
 * 
 * }
 */

