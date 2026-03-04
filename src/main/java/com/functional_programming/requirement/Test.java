package com.functional_programming.requirement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        List<LoanApplication> loans = List.of(
                new LoanApplication("A1","Ritesh",200000,750,"APPROVED","Mumbai"),
                new LoanApplication("A2","Rahul",300000,720,"PENDING","Delhi"),
                new LoanApplication("A3","Amit",600000,680,"REJECTED","Mumbai"),
                new LoanApplication("A4","Neha",150000,710,"APPROVED","Delhi"),
                new LoanApplication("A5","Kiran",400000,780,"APPROVED","Mumbai"),
                new LoanApplication("A6","John",250000,690,"PENDING","Bangalore")
        );
        //1️⃣ Get all eligible applications
        //Eligibility:
        //creditScore ≥ 700//status = PENDING//Return list.

        //imperative approach
        Predicate<LoanApplication> creditScorePredicate=s->s.getCreditScore()>=700;
        Predicate<LoanApplication> statusPredicate=s->s.getStatus().equals("PENDING");
        List<LoanApplication> revisedList=new ArrayList<>();
        for (LoanApplication la:loans){
            if (creditScorePredicate.test(la)&& statusPredicate.test(la)){
                revisedList.add(la);
            }
        }
        System.out.println(revisedList);

        // functional approach
        List<LoanApplication> pending = loans.stream()
                .filter(loanApplication -> loanApplication.getStatus().equals("PENDING"))
                .filter(loanApplication -> loanApplication.getCreditScore() >= 700)
                .toList();
        System.out.println(pending);


        List<LoanApplication> result = loans.stream()
                .filter(creditScorePredicate.and(statusPredicate))
                .toList();
        System.out.println(result);

        // total loan amount for all approved applications.
        Double totalAmount = loans.stream()
                .filter(loanApplication -> loanApplication.getStatus().equals("APPROVED"))
                .map(LoanApplication::getLoanAmount)
                .reduce((aDouble, aDouble2) -> aDouble + aDouble2)
                .orElse(0.0);
        System.out.println(totalAmount);

        double total = loans.stream()
                .filter(loan -> "APPROVED".equals(loan.getStatus()))
                .mapToDouble(LoanApplication::getLoanAmount)
                .sum();
        System.out.println(total);


    }
}
