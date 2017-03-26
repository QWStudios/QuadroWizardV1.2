package model;

//possibly move to model
/**
 * 
 * @author Chris Class is intended to give a brief description of a StatusCode
 *         to minimize human error. Codes can be added as new needs are found.
 *         Generally used as a return type to be deciphered to determine the
 *         next course of action.
 */
public enum StatusCode {// Use these in place of booleans, add as needed
	SUCCESS, FAILURE, OPEN_CARD_VIEW, OPEN_MAIN_MENU, DECK_FULL, DUPLICATE, NOT_IN_DECK, GAME_CLOSED, GAME_NOT_CLOSED, GAME_RUNNING, PLAYER, ENEMY, 
	NO_SURROUNDING_CARDS;

}
/*
 * public enum StatusCode { //use this to change the name of the status code
 * SUCCESS("Success"), FAILURE("Failure");
 * 
 * private String nameAsString; private StatusName(String nameAsString){
 * this.nameAsString = nameAsString; }
 * 
 * @Override public String toString(){ return this.nameAsString; }
 * 
 * }
 */