package cn.sxt.shiro;


import junit.framework.Assert;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;
public class TestShiro {
	
	@Test
	public void testAuthentication(){
		//初始化ini配置文件 并且创建SecurityManager工厂
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//通过SecurityManager工厂获取SecurityManager
		SecurityManager securityManager = factory.getInstance();
		//通过SecurityUtils将securityManager设置到运行环境中
		SecurityUtils.setSecurityManager(securityManager);
		//通过SecurityUtils得到主体对象
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "1111");
		subject.login(token);
		//isAuthenticated判断是否通过认证
		Assert.assertEquals(true, subject.isAuthenticated());
	}
}
