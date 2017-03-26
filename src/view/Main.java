package view;

import model.AttackCard;
import model.DefenseCard;
import model.TemplateCardRepository;
import controller.MainMenuController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//MainMenuGUI menu = new MainMenuGUI();
		MainMenuController manager = MainMenuController.getInstance();
		//make this controller possibly
		TemplateCardRepository t = TemplateCardRepository.getInstance();
		
		
	}
}