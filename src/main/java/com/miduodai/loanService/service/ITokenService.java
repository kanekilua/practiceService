package com.miduodai.loanService.service;

import com.miduodai.loanService.beans.entity.TokenModel;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午3:44 18-1-15
 */
public interface ITokenService {
    TokenModel createToken(String phone);

    boolean checkToken (TokenModel token);

    TokenModel getToken(String authentication) ;

    boolean deleteToken (String phone);
}
