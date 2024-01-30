package com.lseg.bdd.test.Learnings;

import java.util.Scanner;

public class MyLearnings {
    public static void main(String args[]) {
        System.out.println("Hello");
//        reverseString("advith");
//        readInt1();
//        floatmul();
//        swapValuesUsingThirdVariable(2, 3);
        isLeapYear(2024);
    }

    public static void reverseString(String text) {
        System.out.println("reversed " + text);
        StringBuffer b = new StringBuffer(text);
        System.out.println(b.reverse());
        char ch;
        String x = "";
        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            x = ch + x;
        }
        System.out.println("Last " + x);

    }

    public static void readInt1() {
        Scanner sc = new Scanner(System.in);
        int v1 = sc.nextInt();
        System.out.println(v1);
    }

    public static void floatmul() {
        float f1 = 1.5f;
        float f2 = 2.0f;

        // to store the multiplied value
        float p = f1 * f2;

        // to print the product
        System.out.println("The product is: " + p);
    }

    static void swapValuesUsingThirdVariable(int m, int n) {
        // Swapping the values
        int temp = m;
        m = n;
        n = temp;
        System.out.println("Value of m is " + m
                + " and Value of n is " + n);
    }

    public static void isLeapYear(int year) {
        boolean is_leap_year = false;
        if (year % 4 == 0) {
            is_leap_year = true;
            if (year % 100 == 0) {
                if (year % 400 == 0)
                    is_leap_year = true;
                else
                    is_leap_year = false;
            }
        } else {
            is_leap_year = false;
        }
            if (!is_leap_year)
                System.out.println(year + " : Non Leap-year");
            else
                System.out.println(year + " : Leap-year");


    }







}