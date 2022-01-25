package me.lectr1c.F3;

import java.util.EmptyStackException;
import java.util.Stack;

public class PostFixEvaluator {

    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }

    private static final String OPERATORS = "+-*/";
    private Stack<Integer> operandStack;

    public PostFixEvaluator(){
        operandStack = new Stack<>();
    }

    private int evalOp(char op) {
        int rightNum = operandStack.pop();
        int leftNum = operandStack.pop();
        return switch (op) {
            case '+' -> leftNum + rightNum;
            case '-' -> leftNum - rightNum;
            case '*' -> leftNum * rightNum;
            case '/' -> leftNum / rightNum;
            default -> 0;
        };
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public int eval(String expression) throws SyntaxErrorException {
        String[] tokens = expression.split(" +");
        try {
            for(String nextToken : tokens){
                var character = nextToken.charAt(0);
                if (Character.isDigit(character)) {
                    operandStack.push(Integer.parseInt(nextToken));
                }
                else if (isOperator(character)) {
                    if (operandStack.size() < 2) throw new SyntaxErrorException("Operation on less than 2 values.");
                    operandStack.push(evalOp(character));
                } else {
                    throw new SyntaxErrorException("Invalid character encountered");
                }
            }

            int result = operandStack.pop();
            if (!operandStack.empty()) throw new SyntaxErrorException("digit-digit-operator format needs to be used.");
            return result;
        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }

}
