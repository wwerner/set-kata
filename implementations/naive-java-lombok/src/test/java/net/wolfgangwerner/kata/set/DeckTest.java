package net.wolfgangwerner.kata.set;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DeckTest {

    @Test
    public void HandHasAtLeastTwelveCards() {
        Stack d = new Stack();
        Deck h = new Deck(d);
        int numCards = h.cards().size();

        assertTrue("Deck must have at least 12 cards.", numCards >= 12);

    }
}
