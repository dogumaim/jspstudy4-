package yong.hello3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloApp {

	public static void main(String[] args) {
		
		Resource resource=
				new ClassPathResource("applicationContext.xml");
		
		BeanFactory factory=new XmlBeanFactory(resource); //비디오가게
		
		MessageBean bean=(MessageBean)factory.getBean("messageBean");

		bean.sayHello("스프링");
	}

}
