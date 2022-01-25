package me.lectr1c.F3;

import java.util.EmptyStackException;
import java.util.Stack;

public class BalancedBrackets {

    private static final String OPEN = "([{";
    private static final String CLOSED = ")]}";

   public static boolean isBalanced(String exp){
       boolean balanced = true;
       Stack<Character> bracketStack = new Stack<>();
       try {
           for (int i = 0; i < exp.length(); i++){
               if (!balanced) return false;
               char c = exp.charAt(i);

               if (isOpen(c)) bracketStack.push(c);
               else if (isClosed(c)){
                   char topChar = bracketStack.pop();
                   balanced = CLOSED.indexOf(c) == OPEN.indexOf(topChar);
               }

           }
       } catch (EmptyStackException e) {
           balanced = false;
       }
       return balanced && bracketStack.empty();
   }

   private static boolean isOpen(char character){
       return switch (character){
           case '(', '{', '[' -> true;
           default -> false;
       };
   }

    private static boolean isClosed(char character){
        return switch (character){
            case ')', '}', ']' -> true;
            default -> false;
        };
    }



}
