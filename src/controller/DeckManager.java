package controller;

import model.Card;
import model.StatusCode;

public class DeckManager {

	private static DeckManager uniqueDeckManager;
	private Card[] deck;

	private DeckManager() {
		deck = new Card[5];
	}

	// singleton pattern returns
	public static DeckManager getInstance() {
		if (null == uniqueDeckManager) {
			uniqueDeckManager = new DeckManager();
		}

		return uniqueDeckManager;
	}

	
	/**
	 * 
	 * @return instance of deck
	 */
	public Card[] getDeck(){
		return deck;
	}
	
	/**
	 * 
	 * @param i: index of card in deck
	 * @return card
	 */
	public Card getCardInDeck(int i){
		return deck[i];
	}
	/**
	 * method used for adding card to users deck. Returns false if the deck is
	 * full or is already in the deck.
	 * 
	 * @param toAdd
	 * @return
	 */
	public StatusCode addToDeck(Card toAdd) {
		if (toAdd.getInDeck() == true) {
			System.out.println("Card is in deck");
			return StatusCode.DUPLICATE;
		}
		for (int i = 0; i < deck.length; i++) {
			if (deck[i] == null) {
				deck[i] = toAdd;
				toAdd.setInDeck(true);
				System.out.println("Added");
				return StatusCode.SUCCESS;
			}
		}
		System.out.println("Deck is full");
		return StatusCode.DECK_FULL;
	}

	/**
	 * Handles the removing from deck.  Performs a left rotation each time a card is removed.
	 * @param toRemove
	 * @return StatusCode
	 */
	public StatusCode removeFromDeck(Card toRemove) {
		if (toRemove.getInDeck() == true) {
			System.out.println("Removed");
			for (int i = 0; i < deck.length; i++) {
				if (deck[i] == toRemove) {
					deck[i] = null;
					toRemove.setInDeck(false);
					rotateLeft();
					return StatusCode.SUCCESS;
				}
			}
		} else {
			System.out.println("Not in deck");
			return StatusCode.NOT_IN_DECK;
		}
		return StatusCode.FAILURE;
	}

	/**
	 * helper method rotating all of the values in the array left fill any open
	 * spaces.
	 */
	private void rotateLeft() {
		Card[] temp = new Card[5];
		int count = 0;
		for (int i = 0; i < 5; i++) {
			if (deck[i] != null) {
				temp[count] = deck[i];
				count++;
			}
		}
		deck = temp;
		for(Card c : deck){
			System.out.println(c + " ");
		}
	}

	
	public StatusCode isFull() {
		// this will work assuming a left circular rotation is in place to keep
		// moving each card back to the left most space when one is removed.
		// Thus, if the last element is not null, the array is full
		if (deck[4] != null) {
			return StatusCode.SUCCESS;
		} else {
			return StatusCode.FAILURE;
		}

	}
}
