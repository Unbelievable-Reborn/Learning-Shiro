package info.unbelievable9.shiro.authentication.basic;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

/**
 * Created on : 2018/7/9
 * Author     : Unbelievable9
 **/
@CommonsLog
class MultiRealmsLoginTest {

    @Test
    void shouldLogin() {
        // Initiate Security Manager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro/authentication/basic/shiro-multi-realms.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // Setup Username & Password
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("Gia", "19910130");

        // Login
        try {
            subject.login(token);
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            Supplier<String> supplier = () -> e.getClass().toString() + " - Login Failed.";

            log.error(supplier);
        }

        Assertions.assertTrue(subject.isAuthenticated());

        // Logout
        subject.logout();
    }
}
