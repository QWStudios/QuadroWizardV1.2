package model;

public enum CardType {
	ATTACK("Attack card", 0), DEFENSE("Defense card", 1);

	private String nameAsString;
	private int nameAsInt;
	
	private CardType(String nameAsString, int nameAsInt) {
		this.nameAsString = nameAsString;
		this.nameAsInt = nameAsInt;
	}
	
	@Override
	public String toString() {
		return this.nameAsString;

	}
	
	public int toInt(){
		return this.nameAsInt;
	}
}