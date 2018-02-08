package com.miduodai.loanService.service.Impl;

import com.miduodai.loanService.beans.entity.TokenModel;
import com.miduodai.loanService.service.ITokenService;
import com.miduodai.loanService.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午3:48 18-1-15
 */
@Service
public class TokenService implements ITokenService {

    private RedisTemplate redis;

    @Autowired
    @Qualifier("redisTemplate")
    public void setRedis (RedisTemplate redis) {
        this.redis = redis;
        redis.setKeySerializer(new JdkSerializationRedisSerializer());
    }


    @Override
    public TokenModel createToken(String phone) {
        String token = UUID.randomUUID ().toString ().replace ("-", "");
        TokenModel tokenModel = new TokenModel ();
        tokenModel.setPhone(phone);
        tokenModel.setToken(token);
        redis.boundValueOps (phone).set (token, Constants.TOKEN_EXPIRES_MIN, TimeUnit.MINUTES);
        return tokenModel;
    }

    @Override
    public boolean checkToken(TokenModel tokenModel) {
        if (tokenModel == null) {
            return false;
        }
        String token = (String)redis.boundValueOps (tokenModel.getPhone()).get ();
        if (token == null || !token.equals (tokenModel.getToken ())) {
            return false;
        }
        redis.boundValueOps (tokenModel.getPhone()).expire (Constants.TOKEN_EXPIRES_MIN, TimeUnit.MINUTES);
        return true;
    }

    @Override
    public TokenModel getToken(String authentication) {
        TokenModel tokenModel = new TokenModel();
        if (authentication == null || authentication.length () == 0) {
            return null;
        }
        String [] param = authentication.split ("_");
        if (param.length != 2) {
            return null;
        }
        String phone = param [0];
        String token = param [1];
        tokenModel.setPhone(phone);
        tokenModel.setToken(token);
        return tokenModel;
    }

    @Override
    public boolean deleteToken(String phone) {
        redis.delete (phone);
        return true;
    }
}
