package com.gabriel;

import java.sql.SQLOutput;
import java.util.Arrays;

public class AlmostIncreasingSequence {

    public static void main(String[] args) {

        boolean isIncreasing1 = solution(new int[]{1, 3, 2, 1} );
        System.out.println(isIncreasing1);
        boolean isIncreasing2 = solution(new int[]{1, 3, 2} );
        System.out.println(isIncreasing2);
    }

    static boolean solution(int[] sequence) {

        int count = checkSequence(sequence);
        if (count == -1) {
            return true;
        }

        int index = count;
        count = checkSequence(removeIndex(sequence, count -1));

        if(count == -1) {
            return true;
        }
        count = checkSequence(removeIndex(sequence,index));
        if(count == -1) {
            return true;
        }

        return false;

    }

    static int checkSequence(int[] sequence) {

        for (int i=0; i<sequence.length; i++) {
            if (i+1 < sequence.length &&
                    sequence[i] >= sequence[i+1]) {
                return i;
            }
        }
        return -1;
    }



    static int[] removeIndex(int[] inputArray, int index) {
        int[] outputArray = new int[inputArray.length - 1];
        int count=0;
        for (int i=0; i<inputArray.length; i++) {
            if (index != i) {
                outputArray[count] = inputArray[i];
                count++;
            }
        }
        return outputArray;
    }

    static boolean isSequenceIncreasing(int[] sequence) {
        for (int i=0; i<sequence.length; i++) {
            if (i+1 < sequence.length && sequence[i] >= sequence[i + 1]) {
               return false;
            }
        }
        return true;
    }
}
