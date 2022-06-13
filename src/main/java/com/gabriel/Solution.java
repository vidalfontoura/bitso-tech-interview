package com.gabriel;

public class Solution {

    public static void main(String[] args) {
        int[] statues = new int[]{6,2,3,8};
        int result = solution(statues);
        System.out.println(result);
    }
    static int solution(int[] statues) {
        int smaller = Integer.MAX_VALUE;
        int bigger = Integer.MIN_VALUE;

        for (int i=0; i<statues.length; i++) {
            int value = statues[i];
            if (value < smaller) {
                smaller = value;
            }
            if (value > bigger) {
                bigger = value;
            }
        }
        int length = bigger-smaller;

        return  length - statues.length + 1;

    }
}
