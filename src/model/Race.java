package model;

public enum Race {

	PHYSICAL("Physical"), RANGED("Ranged"), MAGIC("Magic"), BALANCED("Balanced"), CURSED("Cursed");
	/*Physical: +25% vs Range and -25% vs Mage
	 * Ranged: +25% vs Mage, -25% vs physical
	 * Magic: +25% vs physical, -25% vs range
	 * Balanced +25% vs all
	 * Cursed +50% vs all, -50% from all //possibly change/add in later
	*/
	private String nameAsString;
	
	private Race(String nameAsString){
		this.nameAsString = nameAsString;
	}
	
	@Override
	public String toString() {
		return this.nameAsString;

	}
}
