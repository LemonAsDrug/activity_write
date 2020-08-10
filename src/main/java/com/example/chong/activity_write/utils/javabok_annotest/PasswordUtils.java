package com.example.chong.activity_write.utils.javabok_annotest;

import java.util.List;

public class PasswordUtils {

    @UseCase(id = 47, description = "password must contain at least one numeric")
    public boolean validatePassword(String password) {//validate 验证
        return password.matches("\\w*\\d\\w*");
        //String.matched 方法主要是返回是否匹配指定的字符串，如果匹配则为true,否则为false;
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {//encrypt 加密
        return new StringBuffer(password).reverse().toString();
    }

    @UseCase(id = 49,description = "New password can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
