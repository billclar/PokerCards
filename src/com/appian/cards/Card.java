package com.appian.cards;

public interface Card 
{
	/**
	 * Get the physical dimensions of the card.
	 * 
	 * @return A Dimensions object containing the measurements.
	 */
	public Dimensions getDimensions();
	
	/**
	 * Get the card stock.
	 * 
	 * @return The card stock
	 */
	public Stock getStock();
	
	/**
	 * Get the artwork displayed on the front of the card.
	 * 
	 * @return Artwork for the front of the card.
	 */
	public Artwork getFrontArtwork();
	
	/**
	 * Get the artwork displayed on the back of the card.
	 * 
	 * @return Artwork for the back of the card.
	 */
	public Artwork getBackArtwork();
}
