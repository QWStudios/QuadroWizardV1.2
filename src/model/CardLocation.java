package model;

public class CardLocation {

	private int x_value;
	private int y_value;
	private Card card;
	private TypeOnField typeOnField;
	
	public CardLocation(int x_value, int y_value, Card card, TypeOnField typeOnField){
		this.x_value = x_value;
		this.y_value = y_value;
		this.card = card;
		this.typeOnField = typeOnField;
		
	}

	public int getXValue(){
		return x_value;
	}
	
	public int getYValue(){
		return y_value;
	}	
	
	public Card getCard(){
		return card;
	}
	
	public TypeOnField getTypeOnField(){
		return typeOnField;
	}
	
	public void setTypeOnField(TypeOnField typeOnField){
		this.typeOnField = typeOnField;
	}
	
	@Override
	public String toString(){
		return ("X: " + x_value + " Y: " + y_value +  " Type: " + typeOnField.toString());
	}
	
}
