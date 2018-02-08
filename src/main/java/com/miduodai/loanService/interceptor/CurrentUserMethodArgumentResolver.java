package com.miduodai.loanService.interceptor;

import com.miduodai.loanService.annotation.CurrentUser;
import com.miduodai.loanService.beans.entity.User;
import com.miduodai.loanService.dao.UserMapper;
import com.miduodai.loanService.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * @Author: Kane
 * @Description:
 * @Date: Create in 下午3:29 18-1-25
 */
@Component
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean supportsParameter (MethodParameter parameter) {
        // 如果参数类型是 User 并且有 CurrentUser 注解则支持
        if (parameter.getParameterType ().isAssignableFrom (User.class) &&
                parameter.hasParameterAnnotation (CurrentUser.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument (MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // 取出鉴权时存入的登录用户 Id
        String userPhone = webRequest.getAttribute (Constants.CURRENT_USER_PHONE, RequestAttributes.SCOPE_REQUEST).toString();
        if (userPhone != null) {
            // 从数据库中查询并返回
            return userMapper.selectByPhone(userPhone);
        }
        throw new MissingServletRequestPartException(Constants.CURRENT_USER_PHONE);
    }
}
