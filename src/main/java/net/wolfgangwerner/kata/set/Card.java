package net.wolfgangwerner.kata.set;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value(staticConstructor = "of")
@ToString
@EqualsAndHashCode
public class Card {

    private Shape shape;
    private Pattern pattern;
    private Color color;
    private Count count;
}

