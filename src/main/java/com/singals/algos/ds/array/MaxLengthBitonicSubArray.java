package com.singals.algos.ds.array;

import java.util.stream.IntStream;

//https://www.geeksforgeeks.org/maximum-length-bitonic-subarray/
public class MaxLengthBitonicSubArray {

    public static void main(String[] args) {
        int[] inputArray = getInputArray();

        solveInNSquare(inputArray);
        solveInN(inputArray);
    }

    private static void solveInN(int[] inputArray) {
        final int n = inputArray.length;
        int[] inc = new int[n];
        int[] dec = new int[n];

        inc[0] = 1;
        dec[n-1] = 1;

        for (int i=1; i<n; i++){
            inc[i] = inputArray[i] > inputArray[i-1] ?
                inc[i-1] + 1 : 1;
        }

        for (int i=n-2; i>=0; i--){
            dec[i] = inputArray[i] > inputArray[i+1] ?
                    dec[i+1] + 1 : 1;
        }

        final int maxBitonicLength = IntStream.range(0, n)
                .map(i -> inc[i] + dec[i] - 1)
                .sorted()
                .max().getAsInt();

        System.out.println(maxBitonicLength);
    }

    private static void solveInNSquare(int[] inputArray) {
        int maxBitonicLength = 0;
        for (int i=0; i<inputArray.length; i++){
            int currBitonicLength = 0;
            boolean increasing = true;
            int lastNum = Integer.MIN_VALUE;
            for (int j=i; j<inputArray.length; j++){
                final int currNum = inputArray[j];
                if (increasing) {
                    if (currNum >= lastNum){
                        currBitonicLength++;
                    }else {
                        currBitonicLength++;
                        increasing = false;
                    }
                }else {
                    if (currNum <= lastNum){
                        currBitonicLength++;
                    }else {
                        break;
                    }
                }
                if (maxBitonicLength < currBitonicLength) maxBitonicLength = currBitonicLength;
                lastNum = currNum;
            }

        }
        System.out.println(maxBitonicLength);
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
        return new int[] {12, 4, 78, 90, 45, 23};
    }
}
