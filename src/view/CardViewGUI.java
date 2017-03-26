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
import controller.TableController;
import controller.MainMenuController;
import model.Card;
import model.UserCardRepository;

import javax.swing.JLabel;

public class CardViewGUI extends JFrame implements MouseListener {

	
	//private CardDetailViewController cardDetailViewController;
	//private CardViewController cardViewController;
	private JPanel contentPane;
	private JTable table;
	private MainMenuController man;
	private JLabel lblStatus;
	private UserCardRepository userCardRepository;
	/**
	 * Create the frame.
	 */
	public CardViewGUI(UserCardRepository userCardRepository) {
		this.userCardRepository = userCardRepository;
		initalizeComponents();
		
		//addCardDetailViewActionListener();
		
		
		//man = MainMenuController.getInstance();
		//cardDetailViewController = new CardDetailViewController();
		//cardViewController =  new CardViewController();// breaks
	}

	private void initalizeComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		table = new JTable(10, 10);
		contentPane.add(table, BorderLayout.CENTER);
		// JScrollPane scrollPane = new JScrollPane(table);
		table.setRowHeight(50);
		table.setCellSelectionEnabled(true);

		lblStatus = new JLabel("Status:");
		contentPane.add(lblStatus, BorderLayout.SOUTH);
		ListSelectionModel cellSelectionModel = table.getSelectionModel();
		cellSelectionModel
				.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		table.addMouseListener(new TableController(table, userCardRepository));
	
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
// ~~~~~~~~~~~~~~~end of mouseLisetnner methods~~~~~~~~~~~~~~~

/*
 * public void mouseClicked(java.awt.event.MouseEvent event){
 * table.addMouseListener(); }
 */

/*
 * table.addMouseListener(new java.awt.event.MouseAdapter() {
 * 
 * @Override public void mouseClicked(java.awt.event.MouseEvent evt) { int row =
 * table.rowAtPoint(evt.getPoint()); int col =
 * table.columnAtPoint(evt.getPoint()); if (row >= 0 && col >= 0) {
 * 
 * 
 * } } });
 */
