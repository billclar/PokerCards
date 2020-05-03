package com.appian.cards.poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.appian.cards.Artwork;
import com.appian.cards.Dimensions;
import com.appian.cards.Stock;
import com.appian.cards.UnitOfMeasurement;

public class PokerDealerTest
{
	@Test
	public void testShuffle()
	{
		 Dimensions dimensions = new Dimensions(UnitOfMeasurement.CENTIMETER, new BigDecimal(4), new BigDecimal(8), 
				 new BigDecimal(0.1));
		 
		 List<PokerCard> deckOfCards = DeckBuilder.createDeckOfCards(dimensions, Stock.PLASTIC, 
			new Artwork(), new Artwork());
		 
		 // deckOfCards is mutable, so I must clone it for comparison after the shuffle.
		 List<PokerCard> originalDeckOfCards = new ArrayList<>(deckOfCards);
		 
		 PokerDealer dealer = new PokerDealer();
		 dealer.setDeckOfCards(deckOfCards);
		 dealer.shuffle();
		 
		 List<PokerCard> shuffledDeckOfCards = dealer.getDeckOfCards();
		 
		 // Check the number of cards that match according to position.  It's possible that some cards
		 // shuffled back to their original position, but that number should be small.
		 int numberOfMatches = 0;
		 
		 for( int i = 0; i < shuffledDeckOfCards.size(); i++ )
		 {
			 PokerCard originalCard = originalDeckOfCards.get(i);
			 PokerCard shuffledCard = shuffledDeckOfCards.get(i);

			 if( originalCard.getCardType().equals(shuffledCard.getCardType()))
			 {
				 numberOfMatches++;
			 }
		 }
		 
		 System.out.println("numberOfMatches = " + numberOfMatches);
		 
		 // Number of cards shuffled back into their original position should be less than half.
		 assertTrue(numberOfMatches < (DeckBuilder.NUMBER_OF_CARDS_IN_DECK / 2));
	}
	
	@Test
	public void testDealOneCard()
	{
		 Dimensions dimensions = new Dimensions(UnitOfMeasurement.CENTIMETER, new BigDecimal(4), new BigDecimal(8), 
				 new BigDecimal(0.1));
		 
		 List<PokerCard> deckOfCards = DeckBuilder.createDeckOfCards(dimensions, Stock.PLASTIC, 
			new Artwork(), new Artwork());
		 
		 PokerDealer dealer = new PokerDealer();
		 dealer.setDeckOfCards(deckOfCards);
		 dealer.shuffle();
		 
		 PokerCard card = (PokerCard) dealer.dealOneCard();
		 assertTrue(card != null);
		 
		 // Verify there is one less card in the deck.
		 assertEquals(DeckBuilder.NUMBER_OF_CARDS_IN_DECK - 1, dealer.getDeckOfCards().size());
	}
	
	@Test
	public void testDealAllTheCards()
	{
		 Dimensions dimensions = new Dimensions(UnitOfMeasurement.CENTIMETER, new BigDecimal(4), new BigDecimal(8), 
				 new BigDecimal(0.1));
		 
		 List<PokerCard> deckOfCards = DeckBuilder.createDeckOfCards(dimensions, Stock.PLASTIC, 
			new Artwork(), new Artwork());
		 
		 PokerDealer dealer = new PokerDealer();
		 dealer.setDeckOfCards(deckOfCards);
		 dealer.shuffle();
		 
		 for( int i = 1; i <= DeckBuilder.NUMBER_OF_CARDS_IN_DECK; i++ )
		 {
			 PokerCard card = (PokerCard) dealer.dealOneCard();
			 assertTrue(card != null);
			 
			 // Verify there is one less card in the deck.
			 assertEquals(DeckBuilder.NUMBER_OF_CARDS_IN_DECK - i, dealer.getDeckOfCards().size());
		 }

		 // There should be no cards remaining in the deck.
		 PokerCard card = (PokerCard) dealer.dealOneCard();
		 assertTrue(card == null);
	}
}
