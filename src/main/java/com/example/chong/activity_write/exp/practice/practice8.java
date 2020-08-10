package com.example.chong.activity_write.exp.practice;

class person8{

    public static void p(){
        throw new NullPointerException();
    }
}

public class practice8 {
    public static void main(String[] args) {
        person8 persons8 = null;
        persons8.p();//空指针是运行时异常
//        try {
//            person8 persons8 = null;
//            persons8.p();
//        }catch (NullPointerException e){
//            e.printStackTrace(System.out);
//        }
    }
}
