package model;

public enum TypeOnField {

	PLAYER("Player card"), ENEMY("Enemy card"), BLOCK("Block"), EMPTY("Empty"), OUT_OF_BOUNDS("Out of bounds");

	private String nameAsString;
	private int nameAsInt;
	
	private TypeOnField(String nameAsString) {
		this.nameAsString = nameAsString;
		
	}
	
	@Override
	public String toString() {
		return this.nameAsString;

	}
	
}
