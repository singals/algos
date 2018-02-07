package com.singals.algos.ds.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

//https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/
public class ThreeWayPartitioning {

    public static void main(String[] args) {
        int[] input = getInputArray();
        int lowVal = getLowVal();
        int highVal = getHighVal();
        final int n = input.length;

        List<Integer> small = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();
        List<Integer> high = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (input[i] < lowVal){
                small.add(input[i]);
            }else if (input[i] >= lowVal && input[i] <= highVal){
                mid.add(input[i]);
            }else {
                high.add(input[i]);
            }
        }

        for (Integer x : small) System.out.print(x + " ");
        for (Integer x : mid) System.out.print(x + " ");
        for (Integer x : high) System.out.print(x + " ");
    }

    private static int[] getInputArray() {
        /*Scanner scanner = new Scanner(System.in);
        final String line = scanner.nextLine().trim();//expected form -> 12,4,78,90,45,23
        final String[] tokens = line.split(",");
        int[] inputArr = new int[tokens.length];
        for (int i=0; i<tokens.length; i++){
            inputArr[i] = Integer.parseInt(tokens[i]);
        }
        return inputArr;*/
        return new int[] {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
    }

    private static int getLowVal() {
//        return getInt();
        return 14;
    }

    private static int getHighVal() {
//        return getInt();
        return 20;
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        final String line = scanner.nextLine().trim();//expected form -> 12
        return Integer.parseInt(line);
    }
}
