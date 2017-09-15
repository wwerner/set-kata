package net.wolfgangwerner.kata.set;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Hand {
    private final int STANDARD_HAND_SIZE = 12;

    private Deck deck;
    private Set<Card> cards = new HashSet<>();

    public Hand(Deck deck) {
        this.deck = deck;
        for (int i = 0; i < STANDARD_HAND_SIZE; i++) {
            cards.add(deck.draw());
        }
    }

    public Set<Card> cards() {
        return Collections.unmodifiableSet(cards);
    }

    private void refill() {
        int missingCards = STANDARD_HAND_SIZE - cards.size();
        for (int i = 0; i < missingCards; i++) {
            this.cards.add(this.deck.draw());
        }
    }


    // this does not work correctly. It produces not all the SETs all the time.
    // See SetEqualityTest.
    public Set<CardSet> findSets() {
        Set<CardSet> foundSets = new HashSet<>();

        for (Card first : this.cards) {
            for (Card second : this.cards) {
                if (first.equals(second)) {
                    continue;
                }
                for (Card third : this.cards) {
                    if (first.equals(second) || first.equals(third) || second.equals(third)) {
                        continue;
                    }
                    CardSet candidate = new CardSet(first, second, third);
                    if (candidate.isValidSet())
                        foundSets.add(candidate);
                }
            }
        }
        return foundSets;
    }
}
