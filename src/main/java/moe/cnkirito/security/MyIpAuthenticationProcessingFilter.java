package moe.cnkirito.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xujingfeng on 2017/9/26.
 */
public class MyIpAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    //使用/ipVerify该端点进行ip认证
    MyIpAuthenticationProcessingFilter() {
        super(new AntPathRequestMatcher("/token/**"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        //获取host信息
        String token = request.getHeader("token");
        //交给内部的AuthenticationManager去认证，实现解耦
        return getAuthenticationManager().authenticate(new MyIpAuthenticationToken(token));
    }
}
