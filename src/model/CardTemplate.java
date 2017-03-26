package model;

/**
 * 
 * @author Chris This class contains basic information about a card to be used
 *         to map id's to names. It also contains the upper and lower limits of
 *         certain stats.
 */
public class CardTemplate {

	private int id;
	private String name;
	private TwoTuple defense;
	private TwoTuple health;
	private TwoTuple defenseBuff;
	private TwoTuple attack;
	private TwoTuple arrows;

	public CardTemplate() {
	}

	CardTemplate(int id, String name, TwoTuple defense, TwoTuple health,
			TwoTuple defenseBuff, TwoTuple attack, TwoTuple arrows) {
		this.id = id;
		this.name = name;
		this.defense = new TwoTuple(defense);
		this.health = new TwoTuple(health);
		this.defenseBuff = new TwoTuple(defenseBuff);
		this.attack = new TwoTuple(attack);
		this.arrows = new TwoTuple(arrows);
	}

	@Override
	public String toString() {
		return (id + " " + name + " : defense( " + defense.getMin() + ","
				+ defense.getMax() + ") health( " + health.getMin() + ","
				+ health.getMax() + ") defenseBuff (If defense card) ( "
				+ defenseBuff.getMin() + "," + defenseBuff.getMax() + ") attack(if attack card) ("
				+ attack.getMin() + "," + attack.getMax() + ") arrows (" + arrows.getMin() + "," + arrows.getMax() + ")");
	}

	/**
	 * Helper Data structure for storing the min/max value of each attribute to
	 * make things cleaner.
	 * 
	 * @author Chris
	 *
	 */
	public class TwoTuple {

		private int min;
		private int max;

		public TwoTuple(int min, int max) {
			this.min = min;
			this.max = max;
		}

		public TwoTuple(TwoTuple tuple) {
			this.min = tuple.min;
			this.max = tuple.max;
		}

		/**
		 * Accessors for min/max
		 * 
		 * @return
		 */
		public int getMin() {
			return min;
		}

		public int getMax() {
			return max;
		}

		/**
		 * 
		 * @param toCopy
		 */
		public void copy(TwoTuple toCopy) {
			this.min = toCopy.getMin();
			this.max = toCopy.getMax();
		}

	}
}
