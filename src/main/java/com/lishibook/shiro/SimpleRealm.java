package com.lishibook.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.lishibook.entity.User;
import com.lishibook.service.UserService;

public class SimpleRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName = (String)principals.fromRealm(getName()).iterator().next();
		
		User user = userService.getUserByEmail(userName);
		if(user != null){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			if(user.getAdmin() == 1)
				info.addRole("admin");
			
			return info;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
		
		UsernamePasswordToken userToken = (UsernamePasswordToken)token;
		String userName = userToken.getUsername();
		String password = String.valueOf(userToken.getPassword());
		
		User user = userService.getUserByEmail(userName);
		if(user == null){
			throw new AuthenticationException("No such user.");
		}
		if(password.isEmpty() || !password.equals(user.getPassword())){
			throw new AuthenticationException("Password incorrect.");
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName, password.toCharArray(), getName());
		return info;
	}
}
