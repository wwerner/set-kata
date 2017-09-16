package net.wolfgangwerner.kata.set;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class StackTest {

    @Test
    public void deckIsComplete() throws NoSuchCardInStackException {
        Stack d = new Stack();
        for (Shape s : Shape.values()) {
            for (Shading p : Shading.values()) {
                for (Color c : Color.values()) {
                    for (Count n : Count.values()) {
                        assertNotNull("Card " + c + " must exist in deck",
                                d.getCard(s, p, c, n));
                    }
                }
            }
        }
    }

    @Test
    public void drawReturnsCompleteCard() {
        Stack d = new Stack();
        Card c = d.draw();
        assertNotNull(c.getColor());
        assertNotNull(c.getCount());
        assertNotNull(c.getShading());
        assertNotNull(c.getShape());
    }

    @Test(expected = NoSuchCardInStackException.class)
    public void drawnCardIsRemovedFromDeck() throws NoSuchCardInStackException {
        Stack d = new Stack();
        Card c = d.draw();
        d.getCard(c.getShape(), c.getShading(), c.getColor(), c.getCount());
    }
}
