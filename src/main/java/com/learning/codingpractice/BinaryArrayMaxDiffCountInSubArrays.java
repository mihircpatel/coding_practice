package com.learning.codingpractice;

import java.util.Arrays;

/**
 * Find max diff of zero and one in subarray from the given Binary array as input.
 *  e.g. Array = [1, 0, 1]
 *  {}=0, {1}=-1, {0}=1, {1}=-1, {1, 0}=0, {1,1}=-2, {0, 1}=0, {1, 0, 1}=-1
 *  Ans = 1
 */
public class BinaryArrayMaxDiffCountInSubArrays {
    public static void main (String[] args)
    {
//        Scanner sc=new Scanner(System.in);
//
//        //INPUT [uncomment & modify if required]
//        int N = sc.nextInt();
//        int[] A=new int[N];
//
//        for(int i=0;i<N;i++){
//            A[i]=sc.nextInt();
//        }
//
//        sc.close();

        int[] N1 = {1,0,1};
        int[] N2 = {1,1,0,0,0,0,0,1,0,0};
        int[] N3 = {0,0,0};

        //OUTPUT [uncomment & modify if required]
        System.out.print("Ans: " + binaryArray(N1));
    }

    public static int binaryArray(int[] A) {

        //this is default OUTPUT. You can change it.
        int result = -404;

        //write your Logic here:
        int[] processed = new int[A.length];
        for(int i=0; i<processed.length; i++){
            processed[i]=-1;
        }
        //result = subArrays(processed, A, 0, 0, 0, 0);
        result = subArrays2(processed, A, 0, 0, 0, 0);

        return result;
    }

    //Find all subarrays
    private static int subArrays(int[] processed, int[] binArr, int pCurrIdx, int upCurrIdx, int zeroCnt, int oneCnt){
        if(upCurrIdx == binArr.length){
            Arrays.stream(processed).filter(value -> value != -1).forEach(System.out::print);
            System.out.println(":"+(zeroCnt - oneCnt));

            return zeroCnt - oneCnt;
        }

        processed[pCurrIdx] = binArr[pCurrIdx];
        if(processed[pCurrIdx] == 0){
            zeroCnt += 1;
        } else if (processed[pCurrIdx] == 1){
            oneCnt += 1;
        }

        int diff1 = subArrays(processed, binArr, pCurrIdx, upCurrIdx+1, zeroCnt, oneCnt);
        int diff2 = subArrays(processed, binArr, pCurrIdx+1, upCurrIdx+1, zeroCnt, oneCnt);

        return Math.max(diff1, diff2);
    }

    private static int subArrays2(int[] processed, int[] binArr, int pCurrIdx, int upCurrIdx, int zeroCnt, int oneCnt){
        if(upCurrIdx == binArr.length){
            Arrays.stream(processed).filter(value -> value != -1).forEach(System.out::print);
            System.out.println(":"+(zeroCnt - oneCnt));

            return zeroCnt - oneCnt;
        }

        int diff1 = subArrays2(processed, binArr, pCurrIdx, upCurrIdx+1, zeroCnt, oneCnt);

        //processed[pCurrIdx] = binArr[pCurrIdx];
        int currDigit = binArr[upCurrIdx];
        if(currDigit == 0){
            zeroCnt++;
        } else if (currDigit == 1){
            oneCnt++;
        }

        processed[pCurrIdx] = currDigit;
        int diff2 = subArrays2(processed, binArr, pCurrIdx+1, upCurrIdx+1, zeroCnt, oneCnt);

        return Math.max(diff1, diff2);
    }
}
