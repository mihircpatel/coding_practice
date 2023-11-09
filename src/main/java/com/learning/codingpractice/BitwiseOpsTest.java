package com.learning.codingpractice;

public class BitwiseOpsTest {

    public static void main(String[] args) {
        int n = 7;
        int varAND = n & 0xF;
        int[] arr = {1,0,2,3,0,4,5,0};

        for (int i=0; i<arr.length;i++){
            arr[i] = arr[i] << 4 | 2;
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (int i=0; i<arr.length;i++){
            arr[i] = arr[i] >> 4;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
//        String binaryString = Integer.toString(varAND, 2);
//        System.out.println("binaryString=" + binaryString);


    }
}
