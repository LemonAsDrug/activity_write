package com.example.chong.activity_write.utils;

import com.example.chong.activity_write.exp.TokenInvalidException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Component
public class JwtUtils {

    private static String secret;

    private static long expire;

    private static String header;

    @Autowired
    private HttpServletRequest request;


    /**
     * 生成jwt token
     */
    public String generateToken(long userId) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(String.valueOf(userId))
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * token是否过期
     * @return  true：过期
     */
    public static boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    /**
     * 根据token获取token体信息
     * */
    public Claims getClaimByToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            if (isTokenExpired(claims.getExpiration()))throw new TokenInvalidException();
            return claims;
        }catch (Exception e){
            throw new TokenInvalidException();
        }
    }

    public Long getUserId(){
        String token = request.getHeader("token");
        String subject = getClaimByToken(token).getSubject();
        return Long.parseLong(subject);
    }



}
