package com.miduodai.loanService.interceptor;

import com.miduodai.loanService.annotation.Authorization;
import com.miduodai.loanService.beans.entity.TokenModel;
import com.miduodai.loanService.service.ITokenService;
import com.miduodai.loanService.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午3:04 18-1-25
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter{

    @Autowired
    private ITokenService iTokenService;

    public boolean preHandle (HttpServletRequest request,
                              HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod ();

        // 获取方法上方的注解
        Authorization authorizationAnnotation = method.getAnnotation(Authorization.class);
        if(authorizationAnnotation == null) {
            return true;
        }
        // 从 header 中得到 token
        String authorization = request.getHeader (Constants.AUTHORIZATION);
        // 验证 token
        TokenModel model = iTokenService.getToken (authorization);
        if (iTokenService.checkToken (model)) {
            // 如果 token 验证成功，将 token 对应的用户 id 存在 request 中，便于之后注入
            request.setAttribute (Constants.CURRENT_USER_PHONE, model.getPhone());
            return true;
        }
        // 如果验证 token 失败，并且方法注明了 Authorization，返回 401 错误
        if (method.getAnnotation (Authorization.class) != null) {
            response.setStatus (HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
