package com.functional_programming.requirement;

public class LoanApplication {
    String applicationId;
    String customerName;
    double loanAmount;
    int creditScore;
    String status;   // APPROVED, REJECTED, PENDING
    String city;

    @Override
    public String toString() {
        return "LoanApplication{" +
                "applicationId='" + applicationId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", loanAmount=" + loanAmount +
                ", creditScore=" + creditScore +
                ", status='" + status + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public LoanApplication(String applicationId, String customerName, double loanAmount, int creditScore, String status, String city) {
        this.applicationId = applicationId;
        this.customerName = customerName;
        this.loanAmount = loanAmount;
        this.creditScore = creditScore;
        this.status = status;
        this.city = city;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
