package net.wolfgangwerner.kata.set;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DeckTest {

    @Test
    public void deckIsComplete() throws NoSuchCardInDeckException {
        Deck d = new Deck();
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
        Deck d = new Deck();
        Card c = d.draw();
        assertNotNull(c.getColor());
        assertNotNull(c.getCount());
        assertNotNull(c.getShading());
        assertNotNull(c.getShape());
    }

    @Test(expected = NoSuchCardInDeckException.class)
    public void drawnCardIsRemovedFromDeck() throws NoSuchCardInDeckException {
        Deck d = new Deck();
        Card c = d.draw();
        d.getCard(c.getShape(), c.getShading(), c.getColor(), c.getCount());
    }
}
