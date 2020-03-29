package moe.cnkirito.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by xujingfeng on 2017/9/26.
 */
public class MyIpAuthenticationToken extends AbstractAuthenticationToken {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public MyIpAuthenticationToken(String token) {
        super(null);
        this.token = token;
        super.setAuthenticated(false);//注意这个构造方法是认证时使用的
    }

    public MyIpAuthenticationToken(String token, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.token = token;
        super.setAuthenticated(true);//注意这个构造方法是认证成功后使用的

    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.token;
    }

}
