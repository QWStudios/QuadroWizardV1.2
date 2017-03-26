package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import view.CardDetailViewGUI;
import view.CardViewGUI;
import view.MainMenuGUI;
import model.Player;
import model.StatusCode;
import model.UserCardRepository;

public class MainMenuController {

	// singleton
	private static MainMenuController mainMenuController;

	// attributes
	private UserCardRepository userCardRepository;
	private MainMenuGUI mainMenuGUI;
	private CardViewController cardViewController;
	private DeckManager deckManager;
	private Player player;

	/**
	 * Ctor
	 */
	// public CardManager(MainMenuGUI mainMenu)
	private MainMenuController() {

		player = new Player();
		userCardRepository = player.getUserCardRepository();
		deckManager = DeckManager.getInstance();
		mainMenuGUI = new MainMenuGUI();
		
		// this.cardView = cardView;

		// cardView.populateTable(cardRepository.getCards());
		// menu stuff
		this.mainMenuGUI.addCardViewActionListener(new CardViewListener());
		this.mainMenuGUI.addSaveActionListener(new SaveProfileListener());
		this.mainMenuGUI.addLoadActionListener(new LoadProfileListener());
		this.mainMenuGUI.addPlayGameActionListener(new PlayGameListener());
		this.mainMenuGUI.setVisible(true);
		this.mainMenuGUI.setSize(256, 256);

	}

	// singleton pattern returns
	public static MainMenuController getInstance() {
		if (null == mainMenuController) {
			mainMenuController = new MainMenuController();
		}

		return mainMenuController;
	}
	/**
	 * This class is used to open the card view when the button is pressed
	 * @author Chris
	 *
	 */
	class CardViewListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			cardViewController =  new CardViewController(userCardRepository);
			/*if (null == cardView) {
				cardView = new CardViewGUI();
				cardView.populateTable(cardRepository.getCards());

			}
			cardView.setAlwaysOnTop(true);
			cardView.setVisible(true);*/
			// cardView.addCardDetailViewActionListener(new
			// CardDetailViewListener());
			// cardView.getTable().addMouseListener(cardView.getTable());
			// cardView.populateTable(cardRepository.getCards());
		}
	}// end class
	
	/**
	 * This class is used to handle the saving for the program and reacts specifically when the save button is pressed.
	 * @author Chris
	 *
	 */
	 class SaveProfileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			userCardRepository.savePlayerCards();
			System.out.println("saved");
			}
	}// end class
	
	/**
	 * This class is used to handle the loading for the program and reacts specifically when the load button is pressed.
	 * @author Chris
	 *
	 */
	class LoadProfileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			userCardRepository.loadPlayerCards();
			System.out.println("loaded");
		}
	}// end class
	
	class PlayGameListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO: Finish
			if(deckManager.isFull() == StatusCode.SUCCESS){
				GameManager gameManager = new GameManager(deckManager);
				System.out.println("Game launching");
			}
		}
	}// end class

	//delete later
	
	class AddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			userCardRepository.loadPlayerCards();
			System.out.println("loaded");
		}
	}// end class
	


}// end class

