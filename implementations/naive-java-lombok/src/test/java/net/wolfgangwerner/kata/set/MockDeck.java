package net.wolfgangwerner.kata.set;

import java.util.Map;

public class MockDeck extends Deck {
    public MockDeck(Map<CardKey, Card> cards) {
        this.cards = cards;
    }
}
