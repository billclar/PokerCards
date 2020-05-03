package com.appian.cards.poker;

public enum Suit
{
	HEARTS("Hearts"),
	DIAMONDS("Diamonds"),
	SPADES("Spades"),
	CLUBS("Clubs");
	
	private String description;
	
	private Suit(String description)
	{
		this.description = description;
	}
	
	@Override
	public String toString()
	{
		return description;
	}
}
