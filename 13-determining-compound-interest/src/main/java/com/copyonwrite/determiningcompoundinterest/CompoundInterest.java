package com.copyonwrite.determiningcompoundinterest;

public class CompoundInterest {
    private String answer;

    public CompoundInterest(String answer) {
        this.answer = answer;
    }

    public static CompoundInterest from(CompoundInterestRequest request) {
        double amount = request.getPrincipal() * Math.pow(1 + request.getInterest() / 100 / request.getYearlyCompounds(), request.getYearlyCompounds() * request.getYears());
        return new CompoundInterest(
                String.format(
                        "%d invested at %.1f%% for %d years compounded %d times per year is %.2f.",
                        request.getPrincipal(),
                        request.getInterest(),
                        request.getYears(),
                        request.getYearlyCompounds(),
                        amount
                )
        );
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public CompoundInterest() {
    }
}
