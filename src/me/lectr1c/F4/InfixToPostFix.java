package me.lectr1c.F4;

import me.lectr1c.F3.PostFixEvaluator;

import java.util.*;

public class InfixToPostFix {

    private static final String OPERATORS = "+-*/()";
    private static final int[] PRECEDENCE = {1, 1, 2, 2, -1, -1};
    private Deque<Character> operatorStack;
    private Stack<Integer> operandStack;
    private static final String PATTERN = "[\\p{L}\\p{N}]+|[-+/\\*()]";

    public InfixToPostFix(){
        operatorStack = new ArrayDeque<>();
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

    private int precedence(char character) {
        int index = OPERATORS.indexOf(character);
        return PRECEDENCE[index];
    }

    private boolean isOperand(char character) {
        return Character.isLetter(character) || Character.isDigit(character);
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public int eval(String expression) throws PostFixEvaluator.SyntaxErrorException {
        try {
            String nextToken;
            Scanner scan = new Scanner(expression);
            while ((nextToken = scan.findInLine(PATTERN)) != null) {
                char firstChar = nextToken.charAt(0);

                if (isOperand(firstChar)) {
                    handlePostfixOperand(Integer.parseInt(nextToken));
                } else if (isOperator(firstChar)) {
                    processOperator(firstChar);
                } else {
                    throw new PostFixEvaluator.SyntaxErrorException("Unexpected Character Encountered: " + firstChar);
                }
            }

            while (!operatorStack.isEmpty()) {
                char nextOperator = operatorStack.pop();
                if (nextOperator == '(') {
                    throw new PostFixEvaluator.SyntaxErrorException("Unmatched opening parenthesis");
                }
                handlePostfixOperator(nextOperator);
            }

            int result = operandStack.pop();
            if (!operandStack.empty()) {
                throw new PostFixEvaluator.SyntaxErrorException("Stack was badly formatted; did not follow digit-digit-operator pattern");
            }
            return result;

        } catch (NoSuchElementException ex) {
            throw new PostFixEvaluator.SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }

    private void processOperator(char operator) throws PostFixEvaluator.SyntaxErrorException {
        if (operatorStack.isEmpty() || operator == '(') {
            operatorStack.push(operator);
        } else {
            char top = operatorStack.peek();
            if (precedence(operator) > precedence(top)) {
                operatorStack.push(operator);
            } else {
                while (!operatorStack.isEmpty() && precedence(operator) <= precedence(top)) {
                    operatorStack.pop();
                    if (top == '(') {
                        // Matching '(' popped ‐ exit loop.
                        break;
                    }
                    handlePostfixOperator(top);
                    if (!operatorStack.isEmpty()) {
                        // Reset topOp.
                        top = operatorStack.peek();
                    }
                }

                if (operator != ')') {
                    operatorStack.push(operator);
                }
            }
        }
    }

    private void handlePostfixOperator(char nextOperator) throws PostFixEvaluator.SyntaxErrorException {
        if (operandStack.size() < 2) {
            throw new PostFixEvaluator.SyntaxErrorException("Tried to use operator on fewer than 2 values");
        }
        operandStack.push(evalOp(nextOperator));
    }

    private void handlePostfixOperand(int val) {
        operandStack.push(val);
    }
}
