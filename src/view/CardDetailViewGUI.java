package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CardDetailViewGUI extends JFrame {

	private JPanel contentPane;

	private JButton btnNext, btnAddToDeck, btnPrevious, btnClose, btnRemoveFromDeck;
	private JLabel lblHealthPrompt, lblHealth, lblDefensePrompt, lblDefense,
			lblRacePrompt, lblRace, lblName, lblSpecialPrompt, lblSpecial,
			lblNoPrompt, lblNo, lblInDeck;

	
	/**
	 * Create the frame.
	 */
	public CardDetailViewGUI() {
		initalizeComponents();

	}

	// TODO
	// Finish the class
	/**
	 * Component initalizer method
	 */
	private void initalizeComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAddToDeck = new JButton("Add to deck");
		btnAddToDeck.setBounds(90, 162, 121, 23);
		contentPane.add(btnAddToDeck);

		btnNext = new JButton("Next");
		btnNext.setBounds(179, 196, 89, 23);
		contentPane.add(btnNext);

		btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(80, 196, 89, 23);
		contentPane.add(btnPrevious);

		btnClose = new JButton("Close");
		btnClose.setBounds(278, 196, 89, 23);
		contentPane.add(btnClose);

		lblHealthPrompt = new JLabel("Health");
		lblHealthPrompt.setBounds(10, 46, 62, 23);
		contentPane.add(lblHealthPrompt);

		lblHealth = new JLabel("\" \"");
		lblHealth.setBounds(80, 46, 62, 23);
		contentPane.add(lblHealth);

		lblDefensePrompt = new JLabel("Defense");
		lblDefensePrompt.setBounds(10, 75, 62, 23);
		contentPane.add(lblDefensePrompt);

		lblDefense = new JLabel("\" \"");
		lblDefense.setBounds(80, 75, 62, 23);
		contentPane.add(lblDefense);

		lblRacePrompt = new JLabel("Race");
		lblRacePrompt.setBounds(10, 104, 62, 23);
		contentPane.add(lblRacePrompt);

		lblRace = new JLabel("\" \"");
		lblRace.setBounds(80, 104, 62, 23);
		contentPane.add(lblRace);

		lblName = new JLabel("\" \"");
		lblName.setBounds(179, 10, 62, 23);
		contentPane.add(lblName);

		lblSpecialPrompt = new JLabel("\" \"");
		lblSpecialPrompt.setBounds(10, 133, 62, 23);
		contentPane.add(lblSpecialPrompt);

		lblSpecial = new JLabel("\"\" ");
		lblSpecial.setBounds(80, 133, 62, 23);
		contentPane.add(lblSpecial);

		lblNo = new JLabel("\"\"");
		lblNo.setBounds(80, 14, 46, 14);
		contentPane.add(lblNo);

		lblNoPrompt = new JLabel("No");
		lblNoPrompt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNoPrompt.setBounds(26, 14, 46, 14);
		contentPane.add(lblNoPrompt);

		lblInDeck = new JLabel("");
		lblInDeck.setBounds(10, 162, 89, 14);
		contentPane.add(lblInDeck);
		
		btnRemoveFromDeck = new JButton("Remove from deck");
		btnRemoveFromDeck.setBounds(232, 162, 121, 23);
		contentPane.add(btnRemoveFromDeck);
		setAlwaysOnTop(true);
		setVisible(true);
	}

	public void addNextActionListener(ActionListener listenForNextBtn) {
		btnNext.addActionListener(listenForNextBtn);
	}

	public void addPreviousActionListener(ActionListener listenForPreviousBtn) {
		btnPrevious.addActionListener(listenForPreviousBtn);
	}

	public void addCancelActionListener(ActionListener listenForCancelBtn) {
		btnClose.addActionListener(listenForCancelBtn);
	}

	public void addAddToDeckActionListener(ActionListener listenForAddBtn) {
		btnAddToDeck.addActionListener(listenForAddBtn);
	}
	
	public void addRemoveFromDeckActionListener(ActionListener listenForRemoveBtn) {
		btnRemoveFromDeck.addActionListener(listenForRemoveBtn);
	}
	public void setName(String text) {
		lblName.setText(text);
	}

	public void setDefense(int defense) {
		lblDefense.setText(Integer.toString(defense));
	}

	public void setHealth(int health) {
		lblHealth.setText(Integer.toString(health));
	}

	public void setRace(String race) {
		lblRace.setText(race);
	}

	public void setNumber(int num) {
		lblNo.setText(Integer.toString(num));
	}

	public void setInDeck(String text, Color color){
		lblInDeck.setText(text);
		lblInDeck.setForeground(color);
	}
	public void setAddButtonVisibility(boolean bool){
		btnAddToDeck.setVisible(bool);
	}
	public  void setRemoveButtonVisibility(boolean bool){
		btnRemoveFromDeck.setVisible(bool);
	}
	public void setSpecial(int special, int type) {
		lblSpecial.setText(Integer.toString(special));
		if (type == 0) {
			lblSpecialPrompt.setText("Attack");
		} else {
			lblSpecialPrompt.setText("Defense Buff");
		}
	}
}
