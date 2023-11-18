import java.util.AbstractMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MonthlyRangeAndFormula {
    private static final Predicate<Double> isBracketOne = salary -> salary <= 20833.00;
    private static final Predicate<Double> isBracketTwo = salary -> salary >= 20833.00 && salary <= 33332.00;
    private static final Predicate<Double> isBracketThree = salary -> salary >= 33333.00 && salary <= 66666.00;
    private static final Predicate<Double> isBracketFour = salary -> salary >= 66667.00 && salary <= 166666.00;
    private static final Predicate<Double> isBracketFive = salary -> salary >= 166667.00 && salary <= 666666.00;
    private static final Predicate<Double> isBracketSix = salary -> salary >= 666667.00;

    private static final Function<Double, Double> calculateBracketOneTax = income -> 0.00;
    private static final Function<Double, Double> calculateBracketTwoTax = income -> (income - 20833) * .15 + 0.00;
    private static final Function<Double, Double> calculateBracketThreeTax = income -> (income - 33333) * .20 + 1875.00;
    private static final Function<Double, Double> calculateBracketFourTax = income -> (income - 66667) * .25 + 8541.80;
    private static final Function<Double, Double> calculateBracketFiveTax = income -> (income - 166667) * .30 + 33541.80;
    private static final Function<Double, Double> calculateBracketSixTax = income -> (income - 666667) * .35 + 183541.80;

    public static final List<AbstractMap.SimpleEntry<Predicate<Double>, Function<Double, Double>>> monthlyBrackets = List.of(
            new AbstractMap.SimpleEntry<>(isBracketOne, calculateBracketOneTax),
            new AbstractMap.SimpleEntry<>(isBracketTwo, calculateBracketTwoTax),
            new AbstractMap.SimpleEntry<>(isBracketThree, calculateBracketThreeTax),
            new AbstractMap.SimpleEntry<>(isBracketFour, calculateBracketFourTax),
            new AbstractMap.SimpleEntry<>(isBracketFive, calculateBracketFiveTax),
            new AbstractMap.SimpleEntry<>(isBracketSix, calculateBracketSixTax)
    );
}
