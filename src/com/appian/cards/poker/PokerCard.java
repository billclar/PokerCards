package com.appian.cards.poker;

import com.appian.cards.Artwork;
import com.appian.cards.Card;
import com.appian.cards.Dimensions;
import com.appian.cards.Stock;

import lombok.NonNull;

public class PokerCard implements Card
{
	private final CardType cardType;
	
	private final Dimensions dimensions;
	private final Stock stock;
	private final Artwork frontArtwork;
	private final Artwork backArtwork;

	/**
	 * Creates an immutable PokerCard.
	 * 
	 * @param cardType
	 * @param dimensions
	 * @param stock
	 * @param frontArtwork
	 * @param backArtwork
	 */
	public PokerCard(@NonNull CardType cardType, @NonNull Dimensions dimensions, @NonNull Stock stock, 
			@NonNull Artwork frontArtwork, @NonNull Artwork backArtwork)
	{
		this.cardType = cardType;
		this.dimensions = dimensions;
		this.stock = stock;
		this.frontArtwork = frontArtwork;
		this.backArtwork = backArtwork;
	}
	
	public CardType getCardType()
	{
		return cardType;
	}

	@Override
	public Dimensions getDimensions()
	{
		return dimensions;
	}

	@Override
	public Stock getStock()
	{
		return stock;
	}

	@Override
	public Artwork getFrontArtwork()
	{
		return frontArtwork;
	}

	@Override
	public Artwork getBackArtwork()
	{
		return backArtwork;
	}

}
