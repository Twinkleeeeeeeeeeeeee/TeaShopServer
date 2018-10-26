package com.hmjy.service.impl;

import com.auth0.jwt.interfaces.Claim;
import com.hmjy.service.CheckTokenService;
import com.hmjy.util.TokenProccessor;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Map;
@Service
public class CheckTokenServiceImpl implements CheckTokenService {
    @Override
    public Map<String, Claim> checkToken(String token) throws UnsupportedEncodingException {
         return TokenProccessor.verifyToken(token);
    }
}
