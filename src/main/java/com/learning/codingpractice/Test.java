/*
 * Copyright (c) 2021. UXP Systems, Inc.  All Rights Reserved.
 * NOTICE:  All information contained herein is, and remains
 * the property of UXP Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to UXP Systems Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from UXP Systems Incorporated.
 * UXDR, ULM, Powering The Digital User Lifecycle and User Lifecycle Management
 * are all trademarks of UXP Systems Inc.
 */

package com.learning.codingpractice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;

public class Test {
    public static void main(String args[] ) throws Exception {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        Test test = new Test();
        long start;
        long finish;

        System.out.println("Solution 1");
        System.out.println("==========");
        start = System.currentTimeMillis();
        test.solution1(args);
        finish = System.currentTimeMillis();
        System.out.println("Time taken by Solution 1: " + (finish - start) + " ms.");

        System.out.println("\nSolution 2");
        System.out.println("==========");
        start = System.currentTimeMillis();
        test.solution2(args);
        finish = System.currentTimeMillis();
        System.out.println("Time taken by Solution 2: " + (finish - start) + " ms.");

    }

    private void solution1(String[] args) {
        // Alphabat -> [position]
        // c -> 1; o -> 2,4; r -> 3,9; n -> 5; a -> 6; v -> 7; i -> 8; u -> 10; s -> 11
/*        args = new String[6];
        //String[] arguments = new String[5];
        args[0] = "coronavirus";
        args[1] = "4";
        args[2] = "abcde";
        args[3] = "crnas";
        args[4] = "onarous";
        args[5] = "ravus";*/

        Map<Character, Set<Integer>> virusComposition = new HashMap<>();

        char[] inputVirusCompositionChar = args[0].toCharArray();

        storeVirusComposition(virusComposition, inputVirusCompositionChar);
        //System.out.println("Map: " + virusComposition);
        String result = "NEGATIVE";
        for(int i = 2; i<Integer.parseInt(args[1])+2; i++){
            char[] bloodCompositionChar = args[i].toCharArray();
            boolean positive = analyzeBloodComposition(bloodCompositionChar, virusComposition);

            result = positive ? "POSITIVE" : "NEGATIVE";
            System.out.println(result);
        }
    }

    private void storeVirusComposition(Map<Character, Set<Integer>> virusComposition, char[] inputVirusCompositionChar) {
        for(int i = 0; i< inputVirusCompositionChar.length; i++) {
            if(virusComposition.containsKey(inputVirusCompositionChar[i])) {
                virusComposition.get(inputVirusCompositionChar[i]).add(Integer.valueOf(i+1));
            } else {
                Set<Integer> indexes = new HashSet<>();
                indexes.add(i+1);
                virusComposition.put(inputVirusCompositionChar[i], indexes);
            }
            //System.out.println("Iteration " + i + ": " + virusComposition);
        }
    }

    private boolean analyzeBloodComposition(char[] composition, Map<Character, Set<Integer>> virusComposition) {
        for(int j=0; j<composition.length; j++) {
            if(!virusComposition.containsKey(composition[j])) {
                return false;
            } else {
                final int index = j+1;
                Optional<Integer> invalidOpt = virusComposition.get(composition[j]).stream().filter(val -> index > val).findAny();
                if(invalidOpt.isPresent()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void solution2(String[] args) {
		/*ArrayList<String> subSeq = new ArrayList<String>();
		for (int i = 1; i <= virus.length(); i++) {
			subSeq.add(virus.subSequence(1, i).toString());
		}
		if (subSeq.contains(p1)) {
			System.out.println("Positive");
		}
		System.out.println("*************");*/
        for (int i = 0; i < Integer.parseInt(args[1]); i++) {
            if (isSequence(args[0], args[i+2])) {
                System.out.println("POSITIVE");
            } else {
                System.out.println("NEGATIVE");
            }
        }
    }

    private static boolean isSequence(String virus, String p1) {
        int i = 0, j = 0;
        while (j < p1.length() && i < virus.length()) {
            if (p1.charAt(j) == virus.charAt(i)) {
                j++;
            }
            i++;
        }
        if (j == p1.length()) {
            return true;
        } else {
            return false;
        }
    }
}
