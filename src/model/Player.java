package model;
/**
 * This class is to represent the player.  In this version of QW, there will be 2 instances.  A human and computer
 * @author Chris
 *
 */
public class Player {

	//deck and cardLocations should be parallel
	protected Card[] deck;
	protected UserCardRepository userCardRepository;
	protected CardLocation[] cardLocations;
	
	
	public Player(){
		
		deck = new Card[5];
		userCardRepository = new UserCardRepository();
		cardLocations = new CardLocation[5];
	}
	
	public UserCardRepository getUserCardRepository(){
		return userCardRepository;
	}
	
	public Card[] getDeck(){
		return deck;
	}
	/**
	 * This method will return a card when the index in the array is known
	 * @param i
	 * @return
	 */
	public Card getCardInDeck(int i){
		return deck[i];
	}
	/**
	 * This method will get a card in the deck when only the location is known.
	 * @param x
	 * @param y
	 * @return Card object
	 */
	public Card getCardInDeck(int x, int y){
		for(int i = 0; i < cardLocations.length; i++){
			if(cardLocations[i].getXValue() == x && cardLocations[i].getYValue() == y){
				return deck[i];
			}

		}
		return null;
	}
	
	public CardLocation getCardLocation(int i){
		return cardLocations[i];
	}
	
	
	
}
