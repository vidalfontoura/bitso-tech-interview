package com.amazon.ring.main;

/**
 * Got from https://gist.github.com/GeorgeKoshelev/71cf8285021c58aef877
 */
public class CandySolution {
    public int candy(int[] ratings) {
        int sum = 0;
        if (ratings.length == 0)
            return sum;
        int[] lc = new int[ratings.length];
        int[] rc = new int[ratings.length];
        for (int i = 0 ; i < ratings.length; i++)
            lc[i] = rc[i] = 1;
        for (int i = 0 ; i < ratings.length-1; i++){
            if (ratings[i] < ratings[i+1])
                lc[i+1] = lc[i] + 1;
        }
        for (int i = ratings.length-1 ; i > 0 ; i--){
            if (ratings[i-1] > ratings[i])
                rc[i-1] = rc[i] + 1;
        }
        for (int i = 0 ; i < ratings.length ; i++){
            sum += max(lc[i] , rc[i]);
        }
        return sum;
    }

    private int max(int a , int b){
        return a > b ? a : b;
    }

}
