package com.gabriel;

public class Main {


    public static void main(String[] args) {
//        int[] inputArray = new int[]{3, 6, -2, -5, 7, 3};
//        int result = solution(inputArray);
//        System.out.println(result);

        int result = solution(2);
        System.out.println(result);
    }


    static boolean solution(String inputString) {

        StringBuilder sb = new StringBuilder(inputString);
        StringBuilder reversed = new StringBuilder(sb.reverse());

        System.out.println(sb.toString());
        System.out.println(reversed.toString());

        return inputString.equals(reversed);

    }

    static int solution(int[] inputArray) {

        int maxProduct = Integer.MIN_VALUE;
        for (int i=0; i<inputArray.length; i++) {
            for (int j=1; j<inputArray.length; j++) {
                if (j - i == 1) {
                    int product = inputArray[i] * inputArray[j];
                    System.out.println(inputArray[i]+" * "+ inputArray[j] + " = "+product);
                    if (maxProduct < product) {
                        maxProduct = product;
                    }
                }
            }
        }
        return maxProduct;
    }

    static int solution(int n) {

        int sum = n;
        for (int i=0; i<n; i++) {
            sum = sum +4;
        }

        return sum + n;
    }


}
