package com.learning.codingpractice;

import java.util.HashMap;
import java.util.Map;

public class StringTest2 {
    public static void main(String[] args) {

        int i=1;
        int i2=0;
        char a = 'a';
        char res=(char)i;
        String result = ""+i;
        result+=i2;
        System.out.println("res: "+res);
        System.out.println("result: "+result);

        chekMapEntriesWithStringKey();

    }

    public static void chekMapEntriesWithStringKey() {
        Map<String, Integer> map = new HashMap<>();
        String str1 = "Hello";
        map.put(str1, 1);
        String str2 = new String("Hello");
        map.put(str2, 2);
        String str3 = new String("Hello");
        map.put(str3, 3);

        System.out.println(map.size());

        System.out.println(map.get("Hello"));
        System.out.println(map.get(new String("Hello")));
    }
}
