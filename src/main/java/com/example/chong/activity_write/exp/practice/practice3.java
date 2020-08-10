package com.example.chong.activity_write.exp.practice;

public class practice3 {
    public static void main(String[] args) {
        try {
            int arr[] = {1,2,3,4,5};
            System.out.println(arr[6]);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace(System.out);
        }
    }

}
