package net.wolfgangwerner.kata.set;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SetEqualityTest {

    @Test
    public void setsWithSameCardsInDifferentOrderAreConsideredEqual() {
        Card c0 = Card.of(Shape.PEANUT, Pattern.FULL, Color.GREEN, Count.TWO);
        Card c1 = Card.of(Shape.PEANUT, Pattern.STRIPED, Color.RED, Count.ONE);
        Card c2 = Card.of(Shape.ELLIPSE, Pattern.FULL, Color.RED, Count.ONE);

        CardSet one = new CardSet(c0, c1, c2);
        CardSet two = new CardSet(c2, c0, c1);

        assertTrue(one.equals(two));
    }

    @Test
    public void setsWithSameCardsInDifferentOrderProduceSameHashcode() {
        Card c0 = Card.of(Shape.PEANUT, Pattern.FULL, Color.GREEN, Count.TWO);
        Card c1 = Card.of(Shape.PEANUT, Pattern.STRIPED, Color.RED, Count.ONE);
        Card c2 = Card.of(Shape.ELLIPSE, Pattern.FULL, Color.RED, Count.ONE);

        CardSet one = new CardSet(c0, c1, c2);
        CardSet two = new CardSet(c1, c2, c0);
        assertTrue(one.hashCode() == two.hashCode());
    }
}
