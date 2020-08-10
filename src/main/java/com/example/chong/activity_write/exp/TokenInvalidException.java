package com.example.chong.activity_write.exp;

import lombok.Data;

/**
 * token失效异常
 * */
@Data
public class TokenInvalidException extends RuntimeException {

    private static String msg = "token失效";
    private  int code = 10001;

    public TokenInvalidException(){
        super(msg);
    }
}
