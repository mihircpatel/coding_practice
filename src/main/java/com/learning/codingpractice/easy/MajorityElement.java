package com.learning.codingpractice.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        Integer[] A1 = {2, 1, 2};
        Integer[] A2 = {2, 1, 2, 1, 1};

        System.out.println("=== Solution 1 ===");
        System.out.println("Ans1: " + majorityElement.solution1(Arrays.asList(A1)));
        System.out.println("Ans1: " + majorityElement.solution1(Arrays.asList(A2)));

        System.out.println("=== Solution 2 ===");
        System.out.println("Ans2: " + majorityElement.solution2(Arrays.asList(A1)));
        System.out.println("Ans2: " + majorityElement.solution2(Arrays.asList(A2)));

        System.out.println("=== Solution 3 ===");
        System.out.println("Ans2: " + majorityElement.solution3(Arrays.asList(A1)));
        System.out.println("Ans3: " + majorityElement.solution3(Arrays.asList(A2)));
    }
    public int solution1(final List<Integer> A) {
        Map<Integer, Integer> frequencyCount = new HashMap<>();

        for(int ele: A){
            if(frequencyCount.containsKey(ele)) {
                frequencyCount.put(ele, frequencyCount.get(ele) + 1);
            } else {
                frequencyCount.put(ele, 1);
            }
        }
        int compareValue = A.size()/2;
        return frequencyCount.entrySet().stream()
                .filter( ele -> ele.getValue() > compareValue)
                .map( ele -> ele.getKey())
                .findAny()
                .orElse(-1);
    }

    public int solution2(final List<Integer> A) {
        int majorityelem=A.get(0);
        int count=1;
        for(int i=1;i<A.size();i++)
        {
            if(A.get(i)==majorityelem)
            {
                count++;
            }
            else if(count==0){
                majorityelem=A.get(i);
            }
            else{
                count--;
            }
        }

        return majorityelem;
    }

    /**
     * Solution 2 & 3 have the same approach. Just implementation different.
     * @return
     */
    public int solution3(final List<Integer> a) {
        if(a.size()==0)
            return -1;

        int x =a.get(0);
        int c1 =1;
        for(int i =1;i<a.size();i++)
        {
            if(x==a.get(i))
                c1++;
            else
                c1--;

            if(c1==0)
            {x=a.get(i);c1=1;}
        }
        int c=0;
        for(int i =0;i<a.size();i++)
        {
            if(a.get(i)==x)
                c++;
        }
        if(c>a.size()/2)
            return x;
        else
            return -1;

    }
}
