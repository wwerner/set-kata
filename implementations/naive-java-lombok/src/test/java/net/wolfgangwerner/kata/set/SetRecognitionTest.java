package net.wolfgangwerner.kata.set;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;


public class SetRecognitionTest {

    @Test
    //THIS TEST IS FLAKEY, the reason is that the set recognition algorithm is wrong
    //it finds only valid sets, but not neccesarily all of them
    public void singleSetMatchingShapePatternAndColorIsFound() {
        Map<CardKey, Card> testCards = new HashMap<>();
        Card c0 = Card.of(Shape.SQUIGGLE, Shading.OUTLINED, Color.GREEN,Count.TWO);
        Card c1 = Card.of(Shape.SQUIGGLE, Shading.STRIPED, Color.RED,Count.ONE);
        Card c2 = Card.of(Shape.OVAL, Shading.OUTLINED, Color.RED,Count.ONE);
        Card c3 = Card.of(Shape.DIAMOND, Shading.OUTLINED, Color.RED,Count.TWO);
        Card c4 = Card.of(Shape.SQUIGGLE, Shading.OUTLINED, Color.GREEN,Count.THREE);
        Card c5 = Card.of(Shape.DIAMOND, Shading.OUTLINED, Color.VOILET,Count.THREE);
        Card c6 = Card.of(Shape.SQUIGGLE, Shading.OUTLINED, Color.GREEN,Count.ONE);
        Card c7 = Card.of(Shape.SQUIGGLE, Shading.SOLID, Color.VOILET,Count.ONE);
        Card c8 = Card.of(Shape.DIAMOND, Shading.SOLID, Color.VOILET,Count.ONE);
        Card c9 = Card.of(Shape.DIAMOND, Shading.STRIPED, Color.VOILET,Count.THREE);
        Card c10 = Card.of(Shape.OVAL, Shading.STRIPED, Color.GREEN,Count.ONE);
        Card c11 = Card.of(Shape.SQUIGGLE, Shading.STRIPED, Color.VOILET,Count.ONE);
        Card c12 = Card.of(Shape.DIAMOND, Shading.STRIPED, Color.VOILET,Count.ONE);

        testCards.put(CardKey.of(c0), c0);
        testCards.put(CardKey.of(c1), c1);
        testCards.put(CardKey.of(c2), c2);
        testCards.put(CardKey.of(c3), c3);
        testCards.put(CardKey.of(c4), c4);
        testCards.put(CardKey.of(c5), c5);
        testCards.put(CardKey.of(c6), c6);
        testCards.put(CardKey.of(c7), c7);
        testCards.put(CardKey.of(c8), c8);
        testCards.put(CardKey.of(c9), c9);
        testCards.put(CardKey.of(c10), c10);
        testCards.put(CardKey.of(c11), c11);
        testCards.put(CardKey.of(c12), c12);

        MockDeck deck = new MockDeck(testCards);
        Hand hand = new Hand(deck);

        Set<CardSet> recognizedSets = hand.findSets();
        System.out.println(recognizedSets);

        assertThat(recognizedSets.size(), is(4));

        Set<CardSet> expectedSets = new HashSet<>();
        expectedSets.add(new CardSet(c0,c4,c6));
        expectedSets.add(new CardSet(c6,c1,c7));
        expectedSets.add(new CardSet(c0,c5,c2));
        expectedSets.add(new CardSet(c11,c10,c1));

        assertTrue(recognizedSets.containsAll(expectedSets));

    }
}
