package model;

public class AttackCard extends Card{

	protected int attack;

	public AttackCard(String name, int id, int uniqueId, long saveId, int health, int defense, Race race, int attack){
		super(name, id, uniqueId, saveId, health, defense, race, CardType.ATTACK);
		this.attack = attack;
	}
	
	public long composeSaveId(){
		String temp = Integer.toString(id) + Integer.toString(uniqueId) + Integer.toString(health) + Integer.toString(defense); 
		return saveId = Long.parseLong(temp);
	}
	
	public String toString(){
		return "ID: " + id + " Health: " + health;
		
	}
	
	public int getSpecial(){
		return attack;
	}
	

}
