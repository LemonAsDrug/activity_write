package com.example.chong.activity_write.exp;

public class NPETest {
    public void fun() throws NullPointException{
        System.out.println("throw NullPointException from fun()");
        throw new NullPointException();
    }

    public static void main(String[] args) {
        NPETest npeTest = new NPETest();
        try {
            npeTest.fun();
        } catch (NullPointException e) {
//            e.printStackTrace();//这句话是什么用
            System.out.println("Caught it ");
        }


    }
}

