package com.learning.codingpractice;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Roman to Integer
 */
class P1 {
    public static void main(String[] args){
        P1 sl = new P1();
        System.out.println(sl.romanToInt2("MCMXCIV"));

    }
    public int romanToInt(String s) {
        //Map<Character, Integer> symMap = Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);
        Map<Character, Integer> symMap = Stream.of(new Object[][]{
                {'I', 1},
                {'V', 5},
                {'X', 10},
                {'L', 50},
                {'C', 100},
                {'D', 500},
                {'M', 1000}
        }).collect(Collectors.toMap(d -> (Character)d[0], d -> (Integer)d[1]));

        int ans = 0;

        for(int i=1; i<s.length(); i++){
            int x = symMap.get(s.charAt(i-1));
            int y = symMap.get(s.charAt(i));
            if(x < y)
                ans = ans - x;
            else
                ans = ans + x;

        }
        return ans + symMap.get(s.charAt(s.length()-1));
    }

    public int romanToInt2(String s) {
        //Map<Character, Integer> symMap = Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);
        Map<Character, Integer> symMap = Stream.of(new Object[][]{
                {'I', 1},
                {'V', 5},
                {'X', 10},
                {'L', 50},
                {'C', 100},
                {'D', 500},
                {'M', 1000}
        }).collect(Collectors.toMap(d -> (Character)d[0], d -> (Integer)d[1]));

        int ans = 0;

        for(int i=0; i<s.length()-1; i++){
            int x = symMap.get(s.charAt(i));
            int y = symMap.get(s.charAt(i+1));
            if(x < y)
                ans = ans - x;
            else
                ans = ans + x;

        }
        return ans + symMap.get(s.charAt(s.length()-1));
    }
}
