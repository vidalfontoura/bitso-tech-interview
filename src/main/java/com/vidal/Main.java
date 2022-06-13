package com.vidal;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * *
 *  * Input: arr[] = [1, 2, 2]
 *  *                 1  2  1
 *  *
 *  * Output: 4
 *  *
 *  *
 *  * Input: arr[] = [1, 5, 2, 1]
 *  *                 1  1  1  1
 *  *                 1  2  1  1
 *  *                 1  3  2  1
 *  *
 *
 *  * Output: 7
 *  *
 *  *
 *  * Input: [1 ,0 , 2]
 *  *         1   1   1
 *  *         1   1   2
 *  *         2   1   2
 *  *
 *  *
 *  *
 *  * Input: [1, 2, 2]
 *  *         1  1  1
 *  *         1  2  1
 *  *
 *  *
 *  * Input: [0, 2, 0, 6, 6]
 *  *
 *  *         1  1  1  1  1
 *  *         1  2  1  2  1
 *
 *
 *
 *  Input: [ 6, 4, 5, 2, 1]
 *           1  1  1  1  1
 *           1  1  2  1  1
 *           2  1  3  2  1
 *
 *
 */
public class Main {


    public static void main(String[] args) {
//        IntStream.range(1, 10).forEach(c -> System.out.println(c));

        int[] input = new int[]{ 1, 2, 2};
        solution(input);
        System.out.println();

        input = new int[]{1,0,2};
        solution(input);
        System.out.println();

        input = new int[]{1, 5, 2, 1};
        solution(input);

        System.out.println();

        input = new int[]{0, 2, 0, 6, 6};
        solution(input);
        System.out.println();

        input = new int[]{6, 4, 5, 2, 1};
        solution(input);




    }

    public static int solution(int[] ratings) {

        int[] candies = new int[ratings.length];

        for (int i = 0; i < candies.length; i++) {
            candies[i] = 1;
        }

//        // ** Step 1: Forward **
//        for (int i=0; i<ratings.length-1; i++) {
//            if (ratings[i] >= ratings[i+1]) {
//                continue;
//            }
//            candies[i+1] = candies[i] + 1;
//        }
//
//        // ** Step 2: Backward **
//        for (int i=ratings.length-1; i>0; i--) {
//            if (ratings[i] >= ratings[i-1]) {
//                continue;
//            }
//            candies[i-1] = Math.max(candies[i] + 1, candies[i-1]);
//        }
//
        for (int i = 0; i < ratings.length; i++) {
            if (i+1< ratings.length && ratings[i + 1] > ratings[i]) {
                candies[i + 1] = candies[i + 1] + 1;
            }
        }
//
        for (int i = 0; i < ratings.length; i++) {
            if (i+1< ratings.length && ratings[i] > ratings[i + 1]) {
                candies[i] = candies[i] + 1;
            }
        }

        Arrays.stream(ratings).forEach(c -> System.out.print(c + ","));

        System.out.println();

        Arrays.stream(candies).forEach(c -> System.out.print(c + ","));

        return 0;
    }

}
