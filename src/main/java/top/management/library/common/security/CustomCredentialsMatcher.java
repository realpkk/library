package top.management.library.common.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import top.management.library.common.utils.MD5Util;


public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo){

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String inputpsw = String.valueOf(usernamePasswordToken.getPassword());
        Object encodepsw = MD5Util.encode(inputpsw);
        Object credential = authenticationInfo.getCredentials();
        return equals(encodepsw,credential);
    }
}
