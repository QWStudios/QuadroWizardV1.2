package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;

import controller.CardDetailViewController;
import controller.CardViewController;
import controller.GameManager;
import controller.GameViewController;
import controller.GameViewTableController;
import controller.TableController;
import controller.MainMenuController;
import model.Card;
import model.StatusCode;

import javax.swing.JLabel;
import javax.swing.JButton;

public class GameViewGUI extends JFrame implements MouseListener {

	
	//private CardDetailViewController cardDetailViewController;
	//private CardViewController cardViewController;
	private JPanel contentPane;
	private JTable table;
	private MainMenuController man;
	private JLabel lblStatus;
	private JButton btnCardOne,btnCardTwo, btnCardThree, btnCardFour, btnCardFive;
	private JButton[] buttons;//  = {btnCardOne, btnCardTwo, btnCardThree, btnCardFour, btnCardFive};
	private GameViewController gameViewController;
	private GameViewTableController gameViewTableController;
	private GameManager gameManager;
	/**
	 * Create the frame.
	 */
	public GameViewGUI(GameViewController gameViewController, GameManager gameManager) {
		this.gameViewController = gameViewController;
		this.gameManager = gameManager;
		initalizeComponents();
		
		//addCardDetailViewActionListener();
		
		
		//man = MainMenuController.getInstance();
		//cardDetailViewController = new CardDetailViewController();
		//cardViewController =  new CardViewController();// breaks
	}

	private void initalizeComponents() {
		setVisible(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 797);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable(4, 4);
		table.setBounds(10, 11, 705, 600);
		contentPane.add(table);
		// JScrollPane scrollPane = new JScrollPane(table);
		table.setRowHeight(150);
		table.setCellSelectionEnabled(true);

		lblStatus = new JLabel("Status:");
		lblStatus.setBounds(5, 739, 683, 14);
		contentPane.add(lblStatus);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		this.gameViewTableController = new GameViewTableController(table, this.gameViewController, this.gameManager);
		table.addMouseListener(this.gameViewTableController);
		
		btnCardOne = new JButton("New button");
		btnCardOne.setBounds(21, 622, 117, 106);
		contentPane.add(btnCardOne);
		
		btnCardTwo = new JButton("New button");
		btnCardTwo.setBounds(148, 622, 117, 106);
		contentPane.add(btnCardTwo);
		
		btnCardThree = new JButton("New button");
		btnCardThree.setBounds(275, 622, 117, 106);
		contentPane.add(btnCardThree);
		
		btnCardFour = new JButton("New button");
		btnCardFour.setBounds(402, 622, 117, 106);
		contentPane.add(btnCardFour);
		
		btnCardFive = new JButton("New button");
		btnCardFive.setBounds(529, 622, 117, 106);
		contentPane.add(btnCardFive);
	
		btnCardOne.setActionCommand("1");
		btnCardTwo.setActionCommand("2");
		btnCardThree.setActionCommand("3");
		btnCardFour.setActionCommand("4");
		btnCardFive.setActionCommand("5");
		buttons = new JButton[5];
		buttons[0] = btnCardOne;
		buttons[1] = btnCardTwo;
		buttons[2] = btnCardThree;
		buttons[3] = btnCardFour;
		buttons[4] = btnCardFive;
	}

	/**
	 * initialization method used to set the text on each button 
	 * @param deck
	 */
	public void setNames(Card[] deck) {
		for(int i = 0; i < 5; i++){
			buttons[i].setText(generateButtonText(deck[i]));
		}
		/*btnCardOne.setText(generateButtonText(deck[0]));
		btnCardTwo.setText(generateButtonText(deck[1]));
		btnCardThree.setText(generateButtonText(deck[2]));
		btnCardFour.setText(generateButtonText(deck[3]));
		btnCardFive.setText(generateButtonText(deck[4]));*/
	}
	/**
	 * helper method used by setNames(Card[] deck) to generate the text
	 * @param card
	 * @return
	 */
	private String generateButtonText(Card card){
		return(card.getName() + "\n" + card.getTypeAsString() + ": " + card.getSpecial() + "\nHealth: " + card.getHealth() + "\nDefense: " + card.getDefense());
	}
	
	public void addCardActionListener(ActionListener listenForCardBtn) {
		for(int i = 0; i < 5; i++){
			buttons[i].addActionListener(listenForCardBtn);
			
		}
		
		
		/*btnCardOne.addActionListener(listenForCardBtn);
		btnCardTwo.addActionListener(listenForCardBtn);
		btnCardThree.addActionListener(listenForCardBtn);
		btnCardFour.addActionListener(listenForCardBtn);
		btnCardFive.addActionListener(listenForCardBtn);*/
	}
	public JButton getButton(int actionCommand){
		return buttons[actionCommand];
	}
	
	public String getCard(int actionCommand){
		return buttons[actionCommand-1].getText();
	}
	
	public StatusCode disableButton(int actionCommand){
		buttons[actionCommand-1].setEnabled(false);
		return StatusCode.SUCCESS;
	}
	
	public GameViewTableController getTableController() {
		return this.gameViewTableController;
	}
	/*
	public void addCardDetailViewActionListener() {
		//http://stackoverflow.com/questions/21064572/mouselistener-in-separate-class-not-working
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
				int col = table.columnAtPoint(evt.getPoint());
				if (row >= 0 && col >= 0) {
					System.out.println(row + " " + col);
					// pass to controller
					// cardViewController.createCardDetailView(row, col);
					//cardDetailController.createCardDetailView(row, col);
				}

			}

		});
	}
*/
	public JTable getTable() {
		return table;
	}

	public void setStatusLabel(String s) {
		 lblStatus.setText(s);
	}
	

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~MouseListener interface
	// methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	@Override
	public void mouseClicked(MouseEvent event) {

		Point point = event.getPoint();
		int row, column;
		row = table.rowAtPoint(point);
		column = table.columnAtPoint(point);
		System.out.println(row + " " + column);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println(table.getSelectedRow());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	

	
}// end class

