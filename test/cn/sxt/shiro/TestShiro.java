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
		//��ʼ��ini�����ļ� ���Ҵ���SecurityManager����
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//ͨ��SecurityManager������ȡSecurityManager
		SecurityManager securityManager = factory.getInstance();
		//ͨ��SecurityUtils��securityManager���õ����л�����
		SecurityUtils.setSecurityManager(securityManager);
		//ͨ��SecurityUtils�õ��������
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "1111");
		subject.login(token);
		//isAuthenticated�ж��Ƿ�ͨ����֤
		Assert.assertEquals(true, subject.isAuthenticated());
	}
}
