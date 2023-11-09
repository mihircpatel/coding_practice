package com.learning.codingpractice;

public class BinaryTreeSolutions {
    public static String subBranchSizeCompare(long[] arr) {
        String result = "No data";
        if(arr.length == 0){
            return result;
        }
        int left = getBranchSize(arr, 1, 0);
        int right = getBranchSize(arr, 2, 0);
        if(right > left){
            result = "Right";
        } else if (left > right) {
            result = "Left";
        } else {
            result = "Same";
        }

        return result;
    }

    // node = i; childNOdes = 2*i && 2*i + 1
    private static int getBranchSize(long[] arr, int idx, int count){
        if(idx >= arr.length){
            return 0;
        }

        int l = getBranchSize(arr, 2*idx + 1, count);
        int r = getBranchSize(arr, 2*idx + 2, count);

        if(arr[idx] > -1){
            count++;
        }
        return count + (l + r);
    }

    public static void main(String[] args) {
        long[] arr = {3, 9, 6, 4, -1, 10, 3};
        System.out.println("Output: " + BinaryTreeSolutions.subBranchSizeCompare(arr));
    }
}
