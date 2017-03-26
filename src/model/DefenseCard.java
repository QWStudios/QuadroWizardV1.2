package model;

public class DefenseCard extends Card {

	protected int defenseBuff;
	
	public  DefenseCard(String name, int id, int uniqueId, long saveId, int health, int defense, Race race, int defenseBuff){
		super(name, id, uniqueId, saveId, health, defense, race, CardType.DEFENSE);
		this.defenseBuff = defenseBuff;
	}
	
	public long composeSaveId(){
		String temp = Integer.toString(id) + Integer.toString(uniqueId) + Integer.toString(health) + Integer.toString(defense) + Integer.toString(defenseBuff); 
		return saveId = Long.parseLong(temp);
	}
	
	public String toString(){
		return "ID: " + id + " Health: " + health;
	}

	public int getSpecial(){
		return defenseBuff;
	}
}
