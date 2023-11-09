package com.learning.codingpractice.easy;

import java.util.Arrays;

public class ReversWords {
    public static void main(String[] args) {
        ReversWords reversWords = new ReversWords();

        String A1 = "the sky is blue";
        String A2 = " this is  ib ";
        String A3 = " hello world ";
        //Integer[] A2 = {-2, 1, -3};

        System.out.println("=== Solution 1 ===");
        System.out.println("Ans1: " + reversWords.solution1(A1));
        System.out.println("Ans2: " + reversWords.solution1(A2));
        System.out.println("Ans3: " + reversWords.solution1(A3));

        System.out.println("=== Solution 2 ===");
        System.out.println("Ans1: " + reversWords.solution2(A1));
        System.out.println("Ans2: " + reversWords.solution2(A2));
        System.out.println("Ans3: " + reversWords.solution2(A3));

    }
    public String solution1(String A) {
        StringBuffer revString = new StringBuffer();
        String[] words = A.trim().split("\\s+");
        System.out.println(Arrays.asList(words));
        for(int i=words.length-1; i >= 0; i--) {
            if(!words[i].isEmpty()){
                if(i!=0) {
                    revString.append(words[i]).append(" ");
                } else {
                    revString.append(words[i]);
                }
            }
        }

        System.out.println(Arrays.asList(revString.toString().split("\\s+")));
        return revString.toString();
    }

    /**
     * InterviewBit solution
     *
     * @param a
     * @return
     */
    public String solution2(String a) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        while (i >= 0) {
            while (i >= 0 && a.charAt(i) == ' ') i--;
            if (i < 0) break;

            int end = i;
            while (i >= 0 && a.charAt(i) != ' ') i--;
            int start = i + 1;
            String word = a.substring(start, end + 1);
            if (sb.length() > 0) sb.append(' ');
            sb.append(word);
        }

        return sb.toString();
    }
}
