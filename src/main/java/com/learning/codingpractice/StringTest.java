package com.learning.codingpractice;

public class StringTest {
    public static void main(String[] args) {
        String ip ="abbbd gjhakd\b hlhjeha.\n hjjkhkhkjd.";

        char[] chars = ip.toCharArray();
        for(int i=0; i<chars.length-1; i++){
            if(chars[i+1] != '\b' && chars[i] != '\b'){
                System.out.print(chars[i]);
            } else if(chars[i] == '\n'){
                System.out.println();
            }
        }
    }
}
