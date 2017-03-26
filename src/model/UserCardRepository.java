package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

public class UserCardRepository {

	//private static UserCardRepository uniqueCardRepository;
	private Card[][] cardList;
	
	/**
	 * Private constructor used for the singleton pattern.
	 */
	public UserCardRepository() {
		createCardArray();
		
	}

	/* singleton pattern returns
	public static UserCardRepository getInstance() {
		if (null == uniqueCardRepository) {
			uniqueCardRepository = new UserCardRepository();
		}

		return uniqueCardRepository;
	}*/

	/**
	 * Private method used for creation of the main card array which stores the
	 * users cards during runtime.
	 */
	private void createCardArray() {
		if (null == cardList) {
			cardList = new Card[100][10];
		}
	}

	/**
	 * Private method used for the initialization and loading of the template repository.  The template
	 * repository contains 
	 */
	
	/**
	 * Public method used to load the players cards to a text file. Uses
	 * serializable interface
	 */
	public void loadPlayerCards() {
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream("Save.txt");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			cardList = (Card[][]) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Public method used to save the players cards to a text file. Uses
	 * serializable interface
	 */
	public void savePlayerCards() {
		try {
			FileOutputStream fileout = new FileOutputStream("Save.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileout);
			out.writeObject(cardList);
			out.close();
			fileout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// temp
	public void createAttackCard(String name, int id, int health,
			int defense, Race race, int attack) {

		for (int i = 0; i < 10; i++) {
			if (cardList[id][i] == null) {
				cardList[id][i] = new AttackCard(name, id, i, 0, health,
						defense, race, attack);
				break;
			} else {
				// add elese
			}
		}
	}

	/**
	 * Public accessor used to get a reference to the cardlist.
	 * 
	 * @return reference to the card array
	 */
	public Card[][] getCards() {
		return cardList;
	}

	/**
	 * 
	 * @param id
	 * @param uId
	 * @return Reference to requested card
	 */
	public Card getCard(int id, int uId){
		return cardList[id][uId];
	}
	
	
	/**
	 * Prints the id's and Uids of the cards, possibly delete
	 */
	public void print() {
		for (int i = 0; i < 100; i++) {
			for (int x = 0; x < 10; x++) {
				if (cardList[i][x] != null)
					System.out.print(cardList[i][x].uniqueId + " ");
				else
					System.out.print(cardList[i][x] + " ");
			}
			System.out.println();
		}
	}
	
	public int findLastUniqueCard(int id){
		for(int i = 0; i < 10; i++){
			if(cardList[id][i+1] == null){
				return i;
			}
		}
		return 0;
	}

}
