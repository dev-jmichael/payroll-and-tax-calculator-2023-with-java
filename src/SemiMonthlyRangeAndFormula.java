import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class SemiMonthlyRangeAndFormula {
    private static final Predicate<Double> isBracketOne = salary -> salary <= 10417.00;
    private static final Predicate<Double> isBracketTwo = salary -> salary >= 10417.00 && salary <= 16666.00;
    private static final Predicate<Double> isBracketThree = salary -> salary >= 16667.00 && salary <= 33332.00;
    private static final Predicate<Double> isBracketFour = salary -> salary >= 33333.00 && salary <= 83332.00;
    private static final Predicate<Double> isBracketFive = salary -> salary >= 83333.00 && salary <= 333332.00;
    private static final Predicate<Double> isBracketSix = salary -> salary >= 333333.00;

    private static final Function<Double, Double> calculateBracketOneTax = income -> 0.00;
    private static final Function<Double, Double> calculateBracketTwoTax = income -> (income - 10417) * .15 + 0.00;
    private static final Function<Double, Double> calculateBracketThreeTax = income -> (income - 16667) * .20 + 937.50;
    private static final Function<Double, Double> calculateBracketFourTax = income -> (income - 33333) * .25 + 4270.70;
    private static final Function<Double, Double> calculateBracketFiveTax = income -> (income - 83333) * .30 + 16770.70;
    private static final Function<Double, Double> calculateBracketSixTax = income -> (income - 333333) * .35 + 91770.70;

    public static final List<AbstractMap.SimpleEntry<Predicate<Double>, Function<Double, Double>>> semiMonthlyBrackets = List.of(
            new AbstractMap.SimpleEntry<>(isBracketOne, calculateBracketOneTax),
            new AbstractMap.SimpleEntry<>(isBracketTwo, calculateBracketTwoTax),
            new AbstractMap.SimpleEntry<>(isBracketThree, calculateBracketThreeTax),
            new AbstractMap.SimpleEntry<>(isBracketFour, calculateBracketFourTax),
            new AbstractMap.SimpleEntry<>(isBracketFive, calculateBracketFiveTax),
            new AbstractMap.SimpleEntry<>(isBracketSix, calculateBracketSixTax)
    );
}
