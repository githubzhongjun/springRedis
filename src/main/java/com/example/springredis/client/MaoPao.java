package com.example.springredis.client;

import java.util.Arrays;

public class MaoPao {

    private static int[] arr = {5, 10, 8, 20, 31, 2};

    public static void main(String[] args) {

        for (int i = 0; i < arr.length -1; i++){
            for (int j = 0; j < arr.length-1-i; j++){
                if (arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
