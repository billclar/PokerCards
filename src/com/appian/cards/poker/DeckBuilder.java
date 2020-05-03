package com.appian.cards.poker;

import java.util.ArrayList;
import java.util.List;

import com.appian.cards.Artwork;
import com.appian.cards.Dimensions;
import com.appian.cards.Stock;

import lombok.NonNull;

/**
 * Creates a deck of cards for poker.
 * 
 * @author bclar
 *
 */
public class DeckBuilder
{
	public static final int NUMBER_OF_CARDS_IN_DECK = 52;
	
	/**
	 * Creates a deck of poker cards with no duplicates.
	 * 
	 * @return
	 */
	public static List<PokerCard> createDeckOfCards(@NonNull Dimensions dimensions, @NonNull Stock stock, 
			@NonNull Artwork frontArtwork, @NonNull Artwork backArtwork)
	{
		List<PokerCard> deckOfCards = new ArrayList<>(DeckBuilder.NUMBER_OF_CARDS_IN_DECK);
		
		for( Suit suit : Suit.values())
		{
			for (Ordinal ordinal : Ordinal.values())
			{
				CardType cardType = new CardType(suit, ordinal);
				PokerCard card = new PokerCard(cardType, dimensions, stock, frontArtwork, backArtwork);
				deckOfCards.add(card);
			}
		}
		
		return deckOfCards;
	}
}
