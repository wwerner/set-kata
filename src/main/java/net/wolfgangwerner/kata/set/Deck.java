package net.wolfgangwerner.kata.set;

import lombok.ToString;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@ToString
public class Deck {
    protected Map<CardKey, Card> cards = new HashMap<>();

    public Deck() {
        for (Pattern p : Pattern.values()) {
            for (Shape s : Shape.values()) {
                for (Color c : Color.values()) {
                    for (Count n : Count.values()) {
                        this.cards.put(CardKey.of(s, p, c, n), Card.of(s,p,c,n));
                    }
                }
            }
        }
    }

    public Card getCard(Shape s, Pattern p, Color c, Count n) throws NoSuchCardInDeckException {
        CardKey ck = CardKey.of(s, p, c, n);
        Card result = this.cards.get(ck);
        if (result == null) {
            throw new NoSuchCardInDeckException("No card found for card key " + ck);
        }
        return result;
    }

    public Card draw() {
        CardKey ck;
        Card result;
        do {
            ck = CardKey.random();
            this.cards.get(ck);
        } while (!this.cards.containsKey(ck));

        try {
            result = getCard(ck.getShape(), ck.getPattern(), ck.getColor(), ck.getCount());
        } catch (NoSuchCardInDeckException e) {
            throw new IllegalStateException("It is not expected for the application to try to draw an non-existing card. This should never happen.", e);
        }
        this.cards.remove(ck);

        return result;
    }
}

@Value(staticConstructor = "of")
@ToString
class CardKey {
    private static final Random RANDOM = new Random();

    Shape shape;
    Pattern pattern;
    Color color;
    Count count;


    static CardKey random() {
        return of(Shape.values()[RANDOM.nextInt(Shape.values().length)],
                Pattern.values()[RANDOM.nextInt(Pattern.values().length)],
                Color.values()[RANDOM.nextInt(Color.values().length)],
                Count.values()[RANDOM.nextInt(Count.values().length)]
        );
    }

    static CardKey of(Card c) {
        return of(c.getShape(),c.getPattern(),c.getColor(),c.getCount());
    }
}