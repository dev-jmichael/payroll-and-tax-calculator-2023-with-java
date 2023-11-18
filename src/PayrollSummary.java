public class PayrollSummary {
    private String totalEarnings;
    private String nonTaxableAllowance;
    private String withholdingTax;
    private String sss;
    private String philHealth;
    private String pagIbig;
    private String grossEarnings;
    private String totalDeductions;
    private String netPay;

    public String getTotalEarnings() {
        return totalEarnings;
    }

    public String getNonTaxableAllowance() {
        return nonTaxableAllowance;
    }

    public String getWithholdingTax() {
        return withholdingTax;
    }

    public String getSss() {
        return sss;
    }

    public String getPhilHealth() {
        return philHealth;
    }

    public String getPagIbig() {
        return pagIbig;
    }

    public String getGrossEarnings() {
        return grossEarnings;
    }

    public String getTotalDeductions() {
        return totalDeductions;
    }

    public String getNetPay() {
        return netPay;
    }

    private PayrollSummary(Builder builder) {
        this.totalEarnings = builder.totalEarnings;
        this.nonTaxableAllowance = builder.nonTaxableAllowance;
        this.withholdingTax = builder.withholdingTax;
        this.sss = builder.sss;
        this.philHealth = builder.philHealth;
        this.pagIbig = builder.pagIbig;
        this.grossEarnings = builder.grossEarnings;
        this.totalDeductions = builder.totalDeductions;
        this.netPay = builder.netPay;
    }

    public static class Builder {
        private String totalEarnings;
        private String nonTaxableAllowance;
        private String withholdingTax;
        private String sss;
        private String philHealth;
        private String pagIbig;
        private String grossEarnings;
        private String totalDeductions;
        private String netPay;

        public Builder totalEarnings(String totalEarnings) {
            this.totalEarnings = DecimalUtils.convertToTwoDecimalPlaces(Double.parseDouble(totalEarnings));
            return this;
        }

        public Builder nonTaxableAllowance(String nonTaxableAllowance) {
            this.nonTaxableAllowance = DecimalUtils.convertToTwoDecimalPlaces(Double.parseDouble(nonTaxableAllowance));
            return this;
        }

        public Builder withholdingTax(String withholdingTax) {
            this.withholdingTax = DecimalUtils.convertToTwoDecimalPlaces(Double.parseDouble(withholdingTax));
            return this;
        }

        public Builder sss(String sss) {
            this.sss = DecimalUtils.convertToTwoDecimalPlaces(Double.parseDouble(sss));
            return this;
        }

        public Builder philHealth(String philHealth) {
            this.philHealth = DecimalUtils.convertToTwoDecimalPlaces(Double.parseDouble(philHealth));
            return this;
        }

        public Builder pagIbig(String pagIbig) {
            this.pagIbig = DecimalUtils.convertToTwoDecimalPlaces(Double.parseDouble(pagIbig));
            return this;
        }

        public Builder grossEarnings(String grossEarnings) {
            this.grossEarnings = DecimalUtils.convertToTwoDecimalPlaces(Double.parseDouble(grossEarnings));
            return this;
        }

        public Builder totalDeductions(String totalDeductions) {
            this.totalDeductions = DecimalUtils.convertToTwoDecimalPlaces(Double.parseDouble(totalDeductions));
            return this;
        }

        public Builder netPay(String netPay) {
            this.netPay = DecimalUtils.convertToTwoDecimalPlaces(Double.parseDouble(netPay));
            return this;
        }

        public PayrollSummary build() {
            return new PayrollSummary(this);
        }
    }
}

