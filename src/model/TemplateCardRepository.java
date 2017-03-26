package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import model.CardTemplate.TwoTuple;

/**
 * This class is used to handle the
 * 
 * @author Chris
 *
 */
public class TemplateCardRepository {

	private static TemplateCardRepository uniqueTemplateCardRepository;
	private CardTemplate[] cardTemplateList;

	/**
	 * Private constructor used for the singleton pattern.
	 */
	private TemplateCardRepository() {
		cardTemplateList = new CardTemplate[3]; //make 100
		loadCardTemplateList();

	}

	// singleton pattern returns
	public static TemplateCardRepository getInstance() {
		if (null == uniqueTemplateCardRepository) {
			uniqueTemplateCardRepository = new TemplateCardRepository();
		}

		return uniqueTemplateCardRepository;
	}

	/**
	 * Loads the template card list from file
	 */
	private void loadCardTemplateList() {

		Scanner in;
		try {
			in = new Scanner(new File("CardTemplateList.txt"));

			// BufferedReader in = new BufferedReader(fileIn);
			for (int i = 0; i < 3; i++) {
				int id = in.nextInt();
				String name = in.next();
				CardTemplate c = new CardTemplate();
				TwoTuple defense = c.new TwoTuple(in.nextInt(), in.nextInt());
				TwoTuple health = c.new TwoTuple(in.nextInt(), in.nextInt());
				TwoTuple defenseBuff = c.new TwoTuple(in.nextInt(),
						in.nextInt());
				TwoTuple attack = c.new TwoTuple(in.nextInt(), in.nextInt());
				TwoTuple arrows = c.new TwoTuple(in.nextInt(), in.nextInt());
				CardTemplate ca = new CardTemplate(id, name, defense, health, defenseBuff, attack, arrows);
				cardTemplateList[i] = ca;
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		printList();
	}

	public void printList() {

		for (CardTemplate c : cardTemplateList)
			System.out.println(c.toString());
		

	}

}
