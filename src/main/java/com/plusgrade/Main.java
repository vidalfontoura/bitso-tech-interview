package com.plusgrade;


/**
 * Given a string, implement a isBalanced function
 * "{{}{}{}}" -> balanced
 * “{}{}” -> balanced
 * “{{}{}}{}” -> balanced
 * "{{}{}" -> not balanced
 * "{{}}{" -> not balanced
 * "}{}{}" -> not balanced
 * “{}}{{}” -> not balanced
 */
public class Main {


    public static void main(String[] args) {
        System.out.println(isBalanced("{{}{}{}}"));
        System.out.println(isBalanced("{}}{{}"));
        System.out.println(isBalanced("}{"));

    }

    // Split the string into smaller strings
    // Run the into differrent threads.
    // Join them ?
    static boolean isBalanced(String string) {
        int count=0;
        for(char c: string.toCharArray()) {
            switch(c) {
                case '{': {
                    count++;
                    break;
                }
                case '}': {
                    if (count == 0) {
                        return false;
                    }
                    count--;
                }

                default:
                    break;
            }
        }
        return count ==0;
    }

}
