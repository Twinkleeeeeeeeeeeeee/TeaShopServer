package com.hmjy.service;

import com.auth0.jwt.interfaces.Claim;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface CheckTokenService {
    Map<String, Claim> checkToken(String token) throws UnsupportedEncodingException;
}
