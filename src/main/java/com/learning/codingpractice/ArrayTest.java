package com.learning.codingpractice;

public class ArrayTest {
    public static void main(String[] args){
        ArrayTest prb = new ArrayTest();

        int[] nums = {};
        System.out.println("Ans: " + prb.removeElement(nums, 2));
    }

    public int removeElement(int[] nums, int val) {
        int i=0,j=nums.length-1;
        while(i<=j && j>=0 && i<nums.length){
            if(nums[i]==val){
                if(nums[j]!=val){
                    nums[i++]=nums[j];
                }
                j--;
            }else{
                i++;
            }
        }
        return i;
    }
}
