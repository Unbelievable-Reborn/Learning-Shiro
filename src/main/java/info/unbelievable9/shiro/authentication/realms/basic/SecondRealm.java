package info.unbelievable9.shiro.authentication.realms.basic;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created on : 2018/7/9
 * Author     : Unbelievable9
 **/
public class SecondRealm implements Realm {

    @Override
    public String getName() {
        return "second_realm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        String credentials = new String((char[])  authenticationToken.getCredentials());

        if (!principal.equals("Gia")) {
            throw new UnknownAccountException();
        }

        if (!credentials.equals("19910130")) {
            throw new IncorrectCredentialsException();
        }

        return new SimpleAuthenticationInfo(principal, credentials, getName());
    }
}
