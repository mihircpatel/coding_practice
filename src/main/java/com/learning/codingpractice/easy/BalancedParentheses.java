package com.learning.codingpractice.easy;

import java.util.LinkedList;

public class BalancedParentheses {
    public static void main(String[] args) {
        BalancedParentheses balancedParentheses = new BalancedParentheses();

        String A1 = "(()())";
        String A2 = "(()";
        String A3 = "))((()(())";

        System.out.println("=== Solution 1 ===");
        System.out.println("Ans1: " + balancedParentheses.solution1(A1));
        System.out.println("Ans2: " + balancedParentheses.solution1(A2));
        System.out.println("Ans3: " + balancedParentheses.solution1(A3));

        System.out.println("=== Solution 2 ===");
        System.out.println("Ans1: " + balancedParentheses.solution2(A1));
        System.out.println("Ans2: " + balancedParentheses.solution2(A2));
        System.out.println("Ans3: " + balancedParentheses.solution2(A3));
    }
    public int solution1(String A) {
        if(A.startsWith(")"))
            return 0;

        int cnt=0;
        char[] stringChar = A.toCharArray();
        for(int i=0; i < stringChar.length; i++){
            if(stringChar[i] == '('){
                cnt++;
            } else if(stringChar[i] == ')'){
                cnt--;
            }
        }
        return cnt == 0 ? 1 : 0;
    }

    public int solution2(String A) {
        LinkedList<Integer> st = new LinkedList<>();

        for(int i=0; i<A.length(); i++){
            char ch = A.charAt(i);

            if(ch == '('){
                st.addLast(i);
            }else{
                if(st.size() == 0){
                    return 0;
                }else{
                    st.removeLast();
                }
            }
        }

        return st.size() == 0? 1: 0;
    }
}
