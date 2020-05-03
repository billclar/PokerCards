package com.appian.cards.poker;

import lombok.NonNull;

public class CardType
{
	private final Suit suit;
	private final Ordinal ordinal;
	
	/**
	 * Creates an immutable card type
	 * 
	 * @param suit
	 * @param ordinal
	 */
	public CardType(@NonNull Suit suit, @NonNull Ordinal ordinal)
	{
		this.suit = suit;
		this.ordinal = ordinal;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ordinal == null) ? 0 : ordinal.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		
		if (getClass() != obj.getClass())
		{
			return false;
		}
		
		CardType other = (CardType) obj;
		if (ordinal != other.ordinal)
		{
			return false;
		}
		if (suit != other.suit)
		{
			return false;
		}
		
		return true;
	}

	public String toString()
	{
		return ordinal.toString() + " of " + suit.toString();
	}
}
