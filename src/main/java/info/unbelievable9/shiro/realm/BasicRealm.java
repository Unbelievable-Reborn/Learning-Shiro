package info.unbelievable9.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Copyright 2018 (C) Yunjian-VC
 * Created on : 2018/7/6
 * Author     : Unbelievable9
 **/
public class BasicRealm implements Realm {

    @Override
    public String getName() {
        return "basic_realm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principle = (String) authenticationToken.getPrincipal();
        String credentials = new String((char[]) authenticationToken.getCredentials());


        if (!principle.equals("Jack")) {
            throw new UnknownAccountException();
        }

        if (!credentials.equals("88888888")) {
            throw new IncorrectCredentialsException();
        }

        return new SimpleAuthenticationInfo(principle, credentials, getName());
    }
}
