package service;

import java.util.Stack;
//Service Class to checks if given brackets sequence is balanced
public class BalanceService {
    public static boolean checkIfBracketsIsBalanced(String bracketsExpression) {
        //Implementing using a stack
        Stack<Character> stack = new Stack<>();
        //Char to hold popped out element
        char poppedOutChar;
        for (int i = 0; i < bracketsExpression.length(); i++) {
            char currentBracket = bracketsExpression.charAt(i);
            // Will perform push()  when character is in (,{,[ 
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                stack.push(currentBracket);
                continue;
            }
            //If BracketsSequence has initial characters like ),},], so stack will be empty
            if (stack.isEmpty()) {
                return false;
            }
            //Comparing the current while popping it out of the stack
            switch (currentBracket) {
                case ')':
                    poppedOutChar = stack.pop();
                    if (poppedOutChar == '{' || poppedOutChar == '[') {
                        return false;
                    }
                    break;
                case ']':
                    poppedOutChar = stack.pop();
                    if (poppedOutChar == '(' || poppedOutChar == '{') {
                        return false;
                    }
                    break;
                case '}':
                    poppedOutChar = stack.pop();
                    if (poppedOutChar == ')' || poppedOutChar == ']') {
                        return false;
                    }
                    break;
            }
        }
        //In case if all characters in brackets are checked, and still stack may not be empty
        return (stack.isEmpty());
    }
}