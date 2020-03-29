package moe.cnkirito.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xujingfeng on 2017/9/26.
 */
public class MyIpAuthenticationProvider implements AuthenticationProvider {


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        MyIpAuthenticationToken tokenAuth = (MyIpAuthenticationToken) authentication;
        String token = tokenAuth.getToken();
        System.out.println("mytoken");
        if(token == null){
            return null;
        }
        return new MyIpAuthenticationToken(token, Arrays.asList(new SimpleGrantedAuthority("My")));
    }

    //只支持IpAuthenticationToken该身份
    @Override
    public boolean supports(Class<?> authentication) {
        return (MyIpAuthenticationToken.class
                .isAssignableFrom(authentication));
    }
}
