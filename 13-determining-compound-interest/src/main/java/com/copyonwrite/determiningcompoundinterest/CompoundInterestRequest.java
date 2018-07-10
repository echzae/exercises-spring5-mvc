package com.copyonwrite.determiningcompoundinterest;

public class CompoundInterestRequest {
    private double interest;
    private int principal;
    private int years;
    private int yearlyCompounds;

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public int getYearlyCompounds() {
        return yearlyCompounds;
    }

    public void setYearlyCompounds(int yearlyCompounds) {
        this.yearlyCompounds = yearlyCompounds;
    }
}
