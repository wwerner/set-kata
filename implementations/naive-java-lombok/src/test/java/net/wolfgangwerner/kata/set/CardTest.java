package net.wolfgangwerner.kata.set;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    @Test
    public void cardHasColorItWasCreatedWith() {
        Card c = Card.of(Shape.SQUIGGLE, Shading.SOLID,Color.RED,Count.ONE);
        assertEquals(Color.RED, c.getColor());
    }

    @Test
    public void cardHasPatternItWasCreatedWith() {
        Card c = Card.of(Shape.SQUIGGLE, Shading.STRIPED,Color.RED,Count.ONE);
        assertEquals(Shading.STRIPED, c.getPattern());
    }

    @Test
    public void cardHasShapeItWasCreatedWith() {
        Card c = Card.of(Shape.SQUIGGLE, Shading.SOLID,Color.RED,Count.ONE);
        assertEquals(Shape.SQUIGGLE, c.getShape());
    }

    @Test
    public void cardHasCountItWasCreatedWith() {
        Card c = Card.of(Shape.SQUIGGLE, Shading.SOLID,Color.RED,Count.TWO);
        assertEquals(Count.TWO, c.getCount());
    }
}
