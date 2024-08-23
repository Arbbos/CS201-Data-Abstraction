package _1_PrelimPeriod_Project;

import java.text.NumberFormat;
import java.util.Scanner;


public class Test {
    public static void main (String [] Args) {
    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;

    Scanner scanner = new Scanner(System.in);

    System.out.println("Principal: ");
    int principal = scanner.nextInt();

    System.out.println("Annual Interest rate: ");
    float annualInterest = scanner.nextFloat();
    float monthlyInterest = annualInterest / PERCENT;

    System.out.println("Period (Years): ");
    byte years = scanner.nextByte();
    int numberofPayments =  years * MONTHS_IN_YEAR;

    double mortgage = principal
     * (monthlyInterest * Math.pow(1 + monthlyInterest, numberofPayments))
    / (Math.pow(1 + monthlyInterest, numberofPayments)-1);

    String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
    System.out.println("Mortgage: "+mortgageFormatted);
    
      
       
        
    }
}
