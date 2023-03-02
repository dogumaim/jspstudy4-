package yong.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		
		String location[]= {"applicationContext.xml"};
		ApplicationContext factory=new ClassPathXmlApplicationContext(location);
		
		MessageBean bean=(MessageBean)factory.getBean("messageBean");
		
		bean.sayHello();
	}
	

}
