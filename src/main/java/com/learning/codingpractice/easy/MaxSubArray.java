package com.learning.codingpractice.easy;

import java.util.Arrays;
import java.util.List;

/**
 * Kadane's Algorithm
 */
public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();

        Integer[] A1 = {1, 2, 3, 4, -10};
        Integer[] A2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //Integer[] A2 = {-2, 1, -3};
        System.out.println("Ans1: " + maxSubArray.solution1(Arrays.asList(A1)));
        System.out.println("Ans2: " + maxSubArray.solution1(Arrays.asList(A2)));

    }

    /**
     *
     */
    public int solution1(final List<Integer> A) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (maxSum < sum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
            System.out.print(sum + " ");
        }
        System.out.println();

        return maxSum;
    }


    /**
     *
     * @param procA
     * @param unprocA
     * @param pIdx
     * @param uIdx
     * @return
     */
    private Integer maxSubArray(Integer[] procA, Integer[] unprocA, int pIdx, int uIdx) {
        //TODO: Only contiguous Sub array needs to be consider. Need to work on removing remaining sub arrays not contiguous
        if(uIdx >= unprocA.length){
            int sum = Arrays.stream(procA)
                    .mapToInt(Integer::intValue)
                    .limit(pIdx)
                    .sum();
            System.out.println("pIdx=" + pIdx + ": " + Arrays.asList(procA).subList(0, pIdx) + ": Sum=" + sum);
            return sum;
        }

        int sum1 = maxSubArray(procA, unprocA, pIdx, uIdx+1);
        procA[pIdx] = unprocA[uIdx];
        int sum2 = maxSubArray(procA, unprocA, pIdx+1, uIdx+1);

        return Math.max(sum1, sum2);
    }
}
