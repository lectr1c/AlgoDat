package me.lectr1c.F3;

import me.lectr1c.F4.InfixToPostFix;

public class Tests {

    public static void main(String[] args) {
        System.out.println(BalancedBrackets.isBalanced("{[]}[]{()[]}"));


        ALStack<Integer> arrayStack = new ALStack<>();
        arrayStack.push(1);
        arrayStack.push(1);
        arrayStack.pop();
        System.out.println(arrayStack.peek());

        LinkedStack<Integer> test = new LinkedStack<>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println(test.toString());
        System.out.println(test.peek(2));
        System.out.println(test.size());
        System.out.println(test.flush());
        System.out.println(test.size());

        var calc = new PostFixEvaluator();

        try {
            System.out.println(calc.eval("19 2 + 7 /"));
        } catch (PostFixEvaluator.SyntaxErrorException e){
            System.out.println(e.getMessage());
        }





    }

}
