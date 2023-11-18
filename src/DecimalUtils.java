import java.text.DecimalFormat;

public class DecimalUtils {
    public static String convertToTwoDecimalPlaces(double num) {
        return String.format("%.2f", num);
    }
}
