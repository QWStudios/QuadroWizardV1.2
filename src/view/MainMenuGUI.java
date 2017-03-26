package view;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainMenuGUI extends JFrame {
	private JButton btnAllCards;
	private JButton btnLoadProfile;
	private JButton btnSaveProfile;
	private JButton btnPlayGame;
	//delete later
	private JButton btnAdd;
	
	
	public MainMenuGUI() {
		initComponents();
		//createEvents();
		
		
	}
	
/*
	//contains code for creating events
	private void createEvents() {
		btnAllCards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setVisible(false);
				CardViewGUI cv = new CardViewGUI();
				cv.setVisible(true);
		}
	});
		
	}*/
	
	//action listeners
	public void addCardViewActionListener(ActionListener listenForCardViewBtn){
		btnAllCards.addActionListener(listenForCardViewBtn);
	}
	
	public void addSaveActionListener(ActionListener listenForSaveBtn){
		btnSaveProfile.addActionListener(listenForSaveBtn);
	}
	
	public void addLoadActionListener(ActionListener listenForLoadBtn){
		btnLoadProfile.addActionListener(listenForLoadBtn);
	}
	public void addPlayGameActionListener(ActionListener listenForPlayGameBtn){
		btnPlayGame.addActionListener(listenForPlayGameBtn);
	}
	//delete later
	public void addAddActionListener(ActionListener listenForAddBtn){
		btnAdd.addActionListener(listenForAddBtn);
	}
	
	//initializes components
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setLayout(null);
		   
	    btnAllCards = new JButton("All Cards\r\n");
	    btnAllCards.setBounds(76, 25, 89, 23);
		getContentPane().add(btnAllCards);
		
		btnLoadProfile = new JButton("Load Profile");
		btnLoadProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLoadProfile.setBounds(76, 59, 89, 23);
		getContentPane().add(btnLoadProfile);
		
		btnSaveProfile = new JButton("Save Profile");
		btnSaveProfile.setBounds(76, 93, 89, 23);
		getContentPane().add(btnSaveProfile);
		
		//delete later
		btnAdd = new JButton("add");
		
		btnAdd.setBounds(76, 127, 89, 23);
		getContentPane().add(btnAdd);
		
		btnPlayGame = new JButton("Play Game");
		btnPlayGame.setBounds(76, 161, 89, 23);
		getContentPane().add(btnPlayGame);
		
	}

	private void setDefaultCloseOperation(Object exit) {
		// TODO Auto-generated method stub
		
	}
}
