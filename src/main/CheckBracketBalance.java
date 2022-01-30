package main;

import service.BalanceService;

import java.util.Scanner;

//Driver Class
public class CheckBracketBalance {
    //Instances From Service Class And Scanner Class
    static BalanceService balancedBracketsService = new BalanceService();
    static Scanner sc = new Scanner(System.in);
    //Main Driver Method
    public static void main(String[] args) {
        System.out.println("Please Enter String With Brackets Sequences:");
        String bracketsString = sc.nextLine();
        boolean status = false;
        //Check if entered bracket sequences contains at least a pair brackets, otherwise it definitely can't be balanced
        if (bracketsString.length() > 1) {
            //Calling balance service method which returns boolean value
            status = balancedBracketsService.checkIfBracketsIsBalanced(bracketsString);
            if (status == true) {
                System.out.println("The entered String has Balanced Brackets");
            } else {
                System.out.println("The entered Strings do not contain Balanced Brackets");
            }
        } else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }
}
