package com.wanda.fuyao.calf.base.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Calendar;
import java.util.Date;

/**
 * @PackName: com.wanda.fuyao.calf.base.security.utils
 * @ClassName: JwtUtil
 * @Description: JWT 工具类
 * @User: Lion
 * @Date: 2022/03/03  14:27
 */
public class JwtUtil {
    public final static String TOKEN_DECODE_SECRET = "~!@#$";
    public final static Integer TOKEN_EXPIRES_TIME = 120;
    /**
     * @Method
     * @Description 根据userId生成Token
     * @Params
     * @Return
     * @Throws
     * @Author Lion
     * @Date 2022/03/17 14:27
     */
    public static String createToken(String userId){
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,TOKEN_EXPIRES_TIME);
        Date expiresDate = nowTime.getTime();

        return JWT.create().withAudience(userId)
                           .withIssuedAt(new Date())
                           .withExpiresAt(expiresDate)
                           .withClaim("userId",userId)
                           .sign(Algorithm.HMAC256(TOKEN_DECODE_SECRET));

    }

    /**
     * @Method
     * @Description 解析Token
     * @Params
     * @Return
     * @Throws
     * @Author Lion
     * @Date 2022/03/07 16:31
     */
    public static DecodedJWT verifyToken(String token){
        try{
            return JWT.require(Algorithm.HMAC256(TOKEN_DECODE_SECRET))
                    .build()
                    .verify(token);
        }catch (TokenExpiredException ex){
            throw new TokenExpiredException("Token已过期！");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * @Method
     * @Description 获取playload中的值
     * @Params
     * @Return
     * @Throws
     * @Author Lion
     * @Date 2022/03/07 16:47
     */
    public static String getClaim(String token,String param){
        try{
            return verifyToken(token).getClaim(param).asString();
        }catch (JWTDecodeException ex){
            throw new RuntimeException("Token已过期！");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}
