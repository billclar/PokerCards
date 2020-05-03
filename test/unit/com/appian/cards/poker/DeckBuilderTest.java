package com.appian.cards.poker;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.appian.cards.Artwork;
import com.appian.cards.Dimensions;
import com.appian.cards.Stock;
import com.appian.cards.UnitOfMeasurement;


public class DeckBuilderTest
{
	@Test
	public void testDeckOfCardsSize()
	{
		 Dimensions dimensions = new Dimensions(UnitOfMeasurement.CENTIMETER, new BigDecimal(4), new BigDecimal(8), 
				 new BigDecimal(0.1));
		 
		 List<PokerCard> deckOfCards = DeckBuilder.createDeckOfCards(dimensions, Stock.PLASTIC, 
			new Artwork(), new Artwork());

		 assertEquals(DeckBuilder.NUMBER_OF_CARDS_IN_DECK, deckOfCards.size());
	}
	
	@Test
	public void testDeckOfCardsForDuplicates()
	{
		 Dimensions dimensions = new Dimensions(UnitOfMeasurement.CENTIMETER, new BigDecimal(4), new BigDecimal(8), 
				 new BigDecimal(0.1));
		 
		 List<PokerCard> deckOfCards = DeckBuilder.createDeckOfCards(dimensions, Stock.PLASTIC, 
			new Artwork(), new Artwork());

		 Set<CardType> cardTypeSet = new HashSet<>();
		 for( PokerCard card : deckOfCards)
		 {
			 cardTypeSet.add(card.getCardType());
		 }
		 
		 assertEquals(DeckBuilder.NUMBER_OF_CARDS_IN_DECK, cardTypeSet.size());
	}
}
