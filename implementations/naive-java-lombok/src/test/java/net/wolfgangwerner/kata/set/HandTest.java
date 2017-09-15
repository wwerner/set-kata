package net.wolfgangwerner.kata.set;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HandTest {

    @Test
    public void HandHasAtLeastTwelveCards() {
        Deck d = new Deck();
        Hand h = new Hand(d);
        int numCards = h.cards().size();

        assertTrue("Hand must have at least 12 cards.", numCards >= 12);

    }
}
