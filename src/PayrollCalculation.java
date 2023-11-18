import java.util.AbstractMap;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PayrollCalculation {

    private double performTaxCalculation(double incomeAfterContributionsDeduction, List<AbstractMap.SimpleEntry<Predicate<Double>, Function<Double, Double>>> brackets) {
        double withholdingTax = 0;

        for(AbstractMap.SimpleEntry<Predicate<Double>, Function<Double, Double>> bracket : brackets) {
            if (bracket.getKey().test(incomeAfterContributionsDeduction)) {
                withholdingTax = bracket.getValue().apply(incomeAfterContributionsDeduction);
                break;
            }
        }

        return withholdingTax;
    }

    public double calculateSemiMonthlyCompensationTax(double incomeAfterContributionsDeduction) {
        return performTaxCalculation(incomeAfterContributionsDeduction, SemiMonthlyRangeAndFormula.semiMonthlyBrackets);
    }

    public double calculateMonthlyCompensationTax(double incomeAfterContributionsDeduction) {
        return performTaxCalculation(incomeAfterContributionsDeduction, MonthlyRangeAndFormula.monthlyBrackets);
    }

    public double calculateTotalContributions(double sss, double philHealth, double pagIbig) {
        return sss + philHealth + pagIbig;
    }

    public double calculateIncomeAfterContributionsDeduction(double income, double totalContributions) {
        return income - totalContributions;
    }

    public double calculateGrossEarnings(double earnings, double nonTaxableAllowance) {
        return earnings + nonTaxableAllowance;
    }

    public double calculateTotalDeductions(double withholdingTax, double totalContributions) {
        return withholdingTax + totalContributions;
    }

    public double calculateNetPay(double grossEarnings, double totalDeductions) {
        return grossEarnings - totalDeductions;
    }

}
