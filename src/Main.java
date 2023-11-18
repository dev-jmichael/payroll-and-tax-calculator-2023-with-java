import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    private static RequestInput getRequestInput() {
        RequestInput requestInput = new RequestInput();

        System.out.print("Earnings: ");
        requestInput.setEarnings(scanner.nextDouble());

        System.out.print("Non-taxable allowance: ");
        requestInput.setNonTaxableAllowance(scanner.nextDouble());

        System.out.print("SSS: ");
        requestInput.setSss(scanner.nextDouble());

        System.out.print("PhilHealth: ");
        requestInput.setPhilHealth(scanner.nextDouble());

        System.out.print("Pag-ibig: ");
        requestInput.setPagIbig(scanner.nextDouble());

        return requestInput;
    }

    private static void displayResultSummary(PayrollSummary payrollSummary) {
        System.out.println("\nEARNINGS");
        System.out.println("Total Earnings: " + payrollSummary.getTotalEarnings());
        System.out.println("Non-taxable allowance: " + payrollSummary.getNonTaxableAllowance() + "\n");

        System.out.println("DEDUCTIONS");
        System.out.println("Withholding Tax: " + payrollSummary.getWithholdingTax());
        System.out.println("SSS: " + payrollSummary.getSss());
        System.out.println("PhilHealth: " + payrollSummary.getPhilHealth());
        System.out.println("Pag-ibig: " + payrollSummary.getPagIbig() + "\n");

        System.out.println("Gross Earnings: " + payrollSummary.getGrossEarnings());
        System.out.println("Deductions: " + payrollSummary.getTotalDeductions());
        System.out.println("Net Pay: " + payrollSummary.getNetPay());
    }

    private static void processSemiMonthlyPayroll() {
        RequestInput requestInput = getRequestInput();
        PayrollService service = new PayrollService(new PayrollCalculation());
        PayrollDetail payrollDetail = service.calculateSemiMonthlyPayroll(requestInput);
        PayrollSummary payrollSummary = service.getSemiMonthlyPayrollSummary(payrollDetail);
        displayResultSummary(payrollSummary);
    }

    private static void processMonthlyPayroll() {
        RequestInput requestInput = getRequestInput();
        PayrollService service = new PayrollService(new PayrollCalculation());
        PayrollDetail payrollDetail = service.calculateMonthlyPayroll(requestInput);
        PayrollSummary payrollSummary = service.getMonthlyPayrollSummary(payrollDetail);
        displayResultSummary(payrollSummary);
    }

    public static void main(String[] args) {
        System.out.println("[1] Semi-Monthly");
        System.out.println("[2] Monthly");
        System.out.print(">>> ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> processSemiMonthlyPayroll();
            case 2 -> processMonthlyPayroll();
        }
    }
}