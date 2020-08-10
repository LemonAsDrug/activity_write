package com.example.chong.activity_write.exp.practice;

import lombok.Data;
import org.apache.ibatis.jdbc.Null;

@Data
class person0 {
    private String name;

}

public class practice0 {
    public static void main(String[] args) {
        try {
            person0 personzero = null;
            personzero.getName();
        } catch (NullPointerException e) {
            e = new NullPointerException("空指针异常");
            e.printStackTrace(System.out);
        } catch (Exception e ){
            e = new Exception("未列出来的异常");
            e.printStackTrace(System.out);
        }
    }
}
