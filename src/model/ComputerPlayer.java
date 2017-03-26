package model;


public class ComputerPlayer extends Player {
	
	public ComputerPlayer(){
		super();
		
	}

	/**
	 * In the final verison, this will take the players level as a parameter and use it to create the difficulty.  
	 * Right now, there is just one difficulty
	 * @return StatusCode
	 */
	public StatusCode generateAI(){
		//final version,  deckManager != singleton, each player has their own.  
		
		deck[0] = new AttackCard("Skeleton", 0, 0, 0, 1, 1, Race.BALANCED, 1);
		deck[1] = new AttackCard("Skeleton", 0, 1, 0, 1, 1, Race.BALANCED, 1);
		deck[2] = new AttackCard("Skeleton", 0, 2, 0, 1, 1, Race.BALANCED, 1);
		deck[3] = new AttackCard("Skeleton", 0, 3, 0, 1, 1, Race.BALANCED, 1);
		deck[4] = new AttackCard("Skeleton", 0, 4, 0, 1, 1, Race.BALANCED, 1);
		return StatusCode.SUCCESS;
		
	}
}
