package GameState;

public interface State {

	public void chooseCard(); //WaitingForAction->PlayersTurnLogic
	public void quitGame(); //WaitingForAction->QuitGame
	public void turnCompleted(); //either make a second one to handle both user/player or have this return a status code EnemyTurnLogic/PlayerTurnLogic->CheckForWin
	public void beginTurn(); //same as above^ CheckForWin->WaitingForAction or CheckForWin->EnemyTurnLogic
	public void winnerFound(); //CheckForWin->GameOver
	public void processingTurn(); //Player/EnemyTurnLogic->checkForWinner
	
}
