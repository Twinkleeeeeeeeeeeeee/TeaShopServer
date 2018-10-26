package com.hmjy.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TokenProccessor {

    private TokenProccessor() {
    }


    private static final TokenProccessor instance = new TokenProccessor();

    public static TokenProccessor getInstance() {

        return instance;
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public SecretKey generalKey() {
        byte[] encodedKey = Base64.decode(Constant.JWT_SECRET);

        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 创建token
     */
    public String createToken(String openId) {
        //签发时间
        Date iaDate = new Date();
        //过期时间 - 1分钟过期
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 10);
        Date expiresDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = null;
        try {
            token = JWT.create()
                    .withHeader(map)//头信息
                    .withClaim("openId", openId)
                    .withExpiresAt(expiresDate)//设置过期时间
                    .withIssuedAt(iaDate)//签发时间
                    .sign(Algorithm.HMAC256(Constant.JWT_SECRET));//加密
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 解密token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) throws UnsupportedEncodingException {
        DecodedJWT jwt = null;
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Constant.JWT_SECRET)).build();
        jwt = verifier.verify(token);

        return jwt.getClaims();
    }


}