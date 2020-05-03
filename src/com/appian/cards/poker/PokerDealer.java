package com.appian.cards.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.appian.cards.Card;
import com.appian.cards.Dealer;

import lombok.NonNull;

public class PokerDealer implements Dealer
{
	private List<PokerCard> deckOfCards;
	
	public void setDeckOfCards(@NonNull List<PokerCard> deckOfCards)
	{
		this.deckOfCards = deckOfCards;
	}
	
	public List<PokerCard> getDeckOfCards()
	{
		return deckOfCards;
	}

	/**
	 * Randomly shuffles all cards in the deck.
	 * 
	 */
	@Override
	public void shuffle()
	{
		List<PokerCard> newDeck = new ArrayList<>(DeckBuilder.NUMBER_OF_CARDS_IN_DECK);
		Random random = new Random();
		
		while( deckOfCards.size() > 0)
		{
			int index = random.nextInt(deckOfCards.size());
			newDeck.add(deckOfCards.remove(index));
		}
		
		setDeckOfCards(newDeck);
	}

	/**
	 * Deals one card from the deck.
	 * 
	 * @return A card from the deck.  If no cards available, then null.
	 */
	@Override
	public Card dealOneCard()
	{
		PokerCard card = null;
		
		if( deckOfCards.size() > 0)
		{
			card = deckOfCards.remove(0);
		}
		
		return card;
	}
}
