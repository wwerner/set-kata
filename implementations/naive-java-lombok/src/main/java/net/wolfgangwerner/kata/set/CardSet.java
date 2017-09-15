package net.wolfgangwerner.kata.set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@ToString
public class CardSet {
    Card first;
    Card second;
    Card third;

    public boolean containsCard(Card c) {
        return first.equals(c) || second.equals(c) || third.equals(c);
    }

    public boolean isValidSet() {
        boolean allShapesDifferent = (first.getShape() != second.getShape()) && (first.getShape() != third.getShape()) && (second.getShape() != third.getShape());
        boolean allShapesEqual = first.getShape() == second.getShape() && first.getShape() == third.getShape();
        boolean shapesFormSet = allShapesDifferent || allShapesEqual;

        boolean allPatternsDifferent = (first.getShading() != second.getShading()) && (first.getShading() != third.getShading()) && (second.getShading() != third.getShading());
        boolean allPatternsEqual = first.getShading() == second.getShading() && first.getShading() == third.getShading();
        boolean patternsFormSet = allPatternsDifferent || allPatternsEqual;

        boolean allColorsDifferent = (first.getColor() != second.getColor()) && (first.getColor() != third.getColor()) && (second.getColor() != third.getColor());
        boolean allColorsEqual = first.getColor() == second.getColor() && first.getColor() == third.getColor();
        boolean colorsFormSet = allColorsDifferent || allColorsEqual;

        boolean allCountsDifferent = (first.getCount() != second.getCount()) && (first.getCount() != third.getCount()) && (second.getCount() != third.getCount());
        boolean allCountsEqual = first.getCount() == second.getCount() && first.getCount() == third.getCount();
        boolean countsFormSet = allCountsDifferent || allCountsEqual;

        return shapesFormSet && patternsFormSet && colorsFormSet && countsFormSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardSet otherSet = (CardSet) o;

        Set<Card> firstSet = new HashSet<>();
        Set<Card> secondSet = new HashSet<>();

        firstSet.add(this.first);
        firstSet.add(this.second);
        firstSet.add(this.third);

        secondSet.add(otherSet.getFirst());
        secondSet.add(otherSet.getSecond());
        secondSet.add(otherSet.getThird());

        return firstSet.equals(secondSet);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = result + second.hashCode();
        result = result + third.hashCode();
        return result * 31;
    }
}
