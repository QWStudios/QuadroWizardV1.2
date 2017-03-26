package model;

import java.io.Serializable;

public abstract class Card implements Serializable {

	protected String name;
	protected int id;
	protected int uniqueId;
	protected long saveId;
	protected boolean[] directions;
	protected int health;
	protected int defense;
	protected Race race;
	protected CardType type;
	protected boolean inDeck;
	
	public Card() {
		name = "";
		id = 0;
		uniqueId = 0;
		saveId = 0;
		directions = new boolean[8];
		health = 0;
		defense = 0;
		race = Race.BALANCED;
		type = CardType.ATTACK;
		inDeck = false;
	}

	public Card(String name, int id, int uniqueId, long saveId, int health,
			int defense, Race race, CardType type) {

		this.name = name;
		this.id = id;
		this.uniqueId = uniqueId;
		this.saveId = saveId;
		this.health = health;
		this.defense = defense;
		this.directions = new boolean[8];
		this.race = race;
		this.type = type;
	}

	public void setUniqueId(int id) {
		uniqueId = id;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getDefense() {
		return defense;
	}

	public Race getRace() {
		return race;
	}

	public boolean getDirection(int i){
		return directions[i];
	}
	
	public String getRaceAsString(){
		return race.toString();
	}
	public CardType getType(){
		return type;
	}
	public String getTypeAsString() {
		return type.toString();
	}

	public int getTypeAsInt(){
		return type.toInt();
	}
	public void setInDeck(boolean inDeck){
		this.inDeck = inDeck;
	}
	public boolean getInDeck(){
		return inDeck;
	}
	
	//probably move to a different class
	public int getRaceModifier(Race raceOne, Race raceTwo){
		if ((raceOne == Race.BALANCED) && (raceTwo == Race.BALANCED))
			return 0;
		else if ((raceOne == Race.BALANCED) && (raceTwo == Race.CURSED))
			return 0;
		else if ((raceOne == Race.BALANCED) && (raceTwo == Race.MAGIC))
			return 0;
		else if ((raceOne == Race.BALANCED) && (raceTwo == Race.PHYSICAL))
			return 0;
		else if ((raceOne == Race.BALANCED) && (raceTwo == Race.RANGED))
			return 0;
		else if ((raceOne == Race.CURSED) && (raceTwo == Race.BALANCED))
			return 0;
		else if ((raceOne == Race.CURSED) && (raceTwo == Race.CURSED))
			return 0;
		else if ((raceOne == Race.CURSED) && (raceTwo == Race.MAGIC))
			return 0;
		else if ((raceOne == Race.CURSED) && (raceTwo == Race.PHYSICAL))
			return 0;
		else if ((raceOne == Race.CURSED) && (raceTwo == Race.RANGED))
			return 0;
		else if ((raceOne == Race.MAGIC) && (raceTwo == Race.BALANCED))
			return 0;
		else if ((raceOne == Race.MAGIC) && (raceTwo == Race.CURSED))
			return 0;
		else if ((raceOne == Race.MAGIC) && (raceTwo == Race.MAGIC))
			return 0;
		else if ((raceOne == Race.MAGIC) && (raceTwo == Race.PHYSICAL))
			return 0;
		else if ((raceOne == Race.MAGIC) && (raceTwo == Race.RANGED))
			return 0;
		else if ((raceOne == Race.PHYSICAL) && (raceTwo == Race.BALANCED))
			return 0;
		else if ((raceOne == Race.PHYSICAL) && (raceTwo == Race.CURSED))
			return 0;
		else if ((raceOne == Race.PHYSICAL) && (raceTwo == Race.MAGIC))
			return 0;
		else if ((raceOne == Race.PHYSICAL) && (raceTwo == Race.PHYSICAL))
			return 0;
		else if ((raceOne == Race.PHYSICAL) && (raceTwo == Race.RANGED))
			return 0;
		else if ((raceOne == Race.RANGED) && (raceTwo == Race.BALANCED))
			return 0;
		else if ((raceOne == Race.RANGED) && (raceTwo == Race.CURSED))
			return 0;
		else if ((raceOne == Race.RANGED) && (raceTwo == Race.MAGIC))
			return 0;
		else if ((raceOne == Race.RANGED) && (raceTwo == Race.PHYSICAL))
			return 0;
		else if ((raceOne == Race.RANGED) && (raceTwo == Race.RANGED))
			return 0;
		return 0;
					
	}
	public abstract int getSpecial();
	
	public abstract long composeSaveId();

	public abstract String toString();

}
