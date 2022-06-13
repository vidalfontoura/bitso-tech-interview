package com.amazon.ring.main;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy. Children with a higher rating get more candies than their neighbors. What is the minimum candies you must give?
 *
 *
 *
 * Input: arr[] = [1, 2, 2]
 *                 1  2  1
 *
 * Output: 4
 *
 *
 * Input: arr[] = [1, 5, 2, 1]
 *                 1  1  1  1
 *                 1  2  1  1
 *                 1  3  2  1
 *

 * Output: 7
 *
 *
 * Input: [1 ,0 , 2]
 *         1   1   1
 *         1   1   2
 *         2   1   2
 *
 *
 *
 * Input: [1, 2, 2]
 *         1  1  1
 *         1  2  1
 *
 *
 * Input: [0, 2, 0, 6, 6]
 *
 *         1  1  1  1  1
 *         1  2  1  2  1
 *
 *
 *
 *
 *
 *
 */
public class Candy {

    public static void main(String[] args) {

        int  arr[] = new int[]{1,2,2};
        int solution = Candy.solution(arr);
//
//        arr = new int[]{1, 5, 2, 1};
//        solution = Candy.solution(arr);
//
//        arr = new int[]{ 1 ,0 , 2};
//        solution = Candy.solution(arr);





    }

    public static int solution(int[] ratings) {

        int[] candies = new int[ratings.length];

        for (int i=0; i<candies.length; i++) {
            candies[i] = 1;
        }

        for (int i=0; i<ratings.length; i++) {
            if (ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i + 1] + 1;
            }
        }

        for (int i=0; i<ratings.length; i++) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = candies[i] + 1;
            }
        }

//        Arrays.stream(ratings).forEach(System.out::println);
//
//        Arrays.stream(candies).forEach(System.out::println);

        return 0;

    }


}
