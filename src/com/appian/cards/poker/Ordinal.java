package com.appian.cards.poker;

public enum Ordinal
{
	TWO("Two", 2),
	THREE("Three", 3),
	FOUR("Four", 4),
	FIVE("Five", 5),
	SIX("Six", 6),
	SEVEN("Seven", 7),
	EIGHT("Eight", 8),
	NINE("Nine", 9),
	TEN("Ten", 10),
	JACK("Jack", 11),
	QUEEN("Queen", 12),
	KING("King", 13),
	ACE("Ace", 14);
	
	private String description;
	private int value;  // In poker, each card has a value.  Two is less then Eight, Jack is less than Ace, etc.
	
	private Ordinal(String description, int value)
	{
		this.description = description;
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
	
	@Override
	public String toString()
	{
		return description;
	}
}
