public class PayrollService {
    private final PayrollCalculation payrollCalculation;

    public PayrollService(PayrollCalculation payrollCalculation) {
        this.payrollCalculation = payrollCalculation;
    }

    public PayrollDetail calculateSemiMonthlyPayroll(RequestInput requestInput) {
        PayrollDetail payrollDetail = new PayrollDetail();

        double totalContributions = payrollCalculation.calculateTotalContributions(requestInput.getSss(), requestInput.getPhilHealth(), requestInput.getPagIbig());
        double incomeAfterContributionsDeduction = payrollCalculation.calculateIncomeAfterContributionsDeduction(requestInput.getEarnings(), totalContributions);
        double withholdingTax = payrollCalculation.calculateSemiMonthlyCompensationTax(incomeAfterContributionsDeduction);
        double grossEarnings = payrollCalculation.calculateGrossEarnings(requestInput.getEarnings(), requestInput.getNonTaxableAllowance());
        double totalDeductions = payrollCalculation.calculateTotalDeductions(withholdingTax, totalContributions);
        double netPay = payrollCalculation.calculateNetPay(grossEarnings, totalDeductions);

        payrollDetail.setTotalEarnings(requestInput.getEarnings());
        payrollDetail.setNonTaxableAllowance(requestInput.getNonTaxableAllowance());
        payrollDetail.setWithholdingTax(withholdingTax);
        payrollDetail.setSss(requestInput.getSss());
        payrollDetail.setPhilHealth(requestInput.getPhilHealth());
        payrollDetail.setPagIbig(requestInput.getPagIbig());
        payrollDetail.setGrossEarnings(grossEarnings);
        payrollDetail.setTotalDeductions(totalDeductions);
        payrollDetail.setNetPay(netPay);

        return payrollDetail;
    }

    public PayrollSummary getSemiMonthlyPayrollSummary(PayrollDetail payrollDetail) {
        return new PayrollSummary.Builder()
                .totalEarnings(String.valueOf(payrollDetail.getTotalEarnings()))
                .nonTaxableAllowance(String.valueOf(payrollDetail.getNonTaxableAllowance()))
                .withholdingTax(String.valueOf(payrollDetail.getWithholdingTax()))
                .sss(String.valueOf(payrollDetail.getSss()))
                .philHealth(String.valueOf(payrollDetail.getPhilHealth()))
                .pagIbig(String.valueOf(payrollDetail.getPagIbig()))
                .grossEarnings(String.valueOf(payrollDetail.getGrossEarnings()))
                .totalDeductions(String.valueOf(payrollDetail.getTotalDeductions()))
                .netPay(String.valueOf(payrollDetail.getNetPay()))
                .build();
    }

    public PayrollDetail calculateMonthlyPayroll(RequestInput requestInput) {
        PayrollDetail payrollDetail = new PayrollDetail();

        double totalContributions = payrollCalculation.calculateTotalContributions(requestInput.getSss(), requestInput.getPhilHealth(), requestInput.getPagIbig());
        double incomeAfterContributionsDeduction = payrollCalculation.calculateIncomeAfterContributionsDeduction(requestInput.getEarnings(), totalContributions);
        double withholdingTax = payrollCalculation.calculateMonthlyCompensationTax(incomeAfterContributionsDeduction);
        double grossEarnings = payrollCalculation.calculateGrossEarnings(requestInput.getEarnings(), requestInput.getNonTaxableAllowance());
        double totalDeductions = payrollCalculation.calculateTotalDeductions(withholdingTax, totalContributions);
        double netPay = payrollCalculation.calculateNetPay(grossEarnings, totalDeductions);

        payrollDetail.setTotalEarnings(requestInput.getEarnings());
        payrollDetail.setNonTaxableAllowance(requestInput.getNonTaxableAllowance());
        payrollDetail.setWithholdingTax(withholdingTax);
        payrollDetail.setSss(requestInput.getSss());
        payrollDetail.setPhilHealth(requestInput.getPhilHealth());
        payrollDetail.setPagIbig(requestInput.getPagIbig());
        payrollDetail.setGrossEarnings(grossEarnings);
        payrollDetail.setTotalDeductions(totalDeductions);
        payrollDetail.setNetPay(netPay);

        return payrollDetail;
    }

    public PayrollSummary getMonthlyPayrollSummary(PayrollDetail payrollDetail) {
        return new PayrollSummary.Builder()
                .totalEarnings(String.valueOf(payrollDetail.getTotalEarnings()))
                .nonTaxableAllowance(String.valueOf(payrollDetail.getNonTaxableAllowance()))
                .withholdingTax(String.valueOf(payrollDetail.getWithholdingTax()))
                .sss(String.valueOf(payrollDetail.getSss()))
                .philHealth(String.valueOf(payrollDetail.getPhilHealth()))
                .pagIbig(String.valueOf(payrollDetail.getPagIbig()))
                .grossEarnings(String.valueOf(payrollDetail.getGrossEarnings()))
                .totalDeductions(String.valueOf(payrollDetail.getTotalDeductions()))
                .netPay(String.valueOf(payrollDetail.getNetPay()))
                .build();
    }
}
