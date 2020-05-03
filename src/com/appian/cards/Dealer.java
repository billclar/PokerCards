package com.appian.cards;

public interface Dealer
{
	/**
	 * Randomly shuffles all cards in the deck.
	 * 
	 */
	public void shuffle();
	
	/**
	 * Deals one card from the deck.
	 * 
	 * @return A card from the deck.  If no cards available, then null.
	 */
	public Card dealOneCard();
}
