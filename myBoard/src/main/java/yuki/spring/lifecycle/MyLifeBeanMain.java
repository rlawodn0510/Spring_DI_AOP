package yuki.spring.lifecycle;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class MyLifeBeanMain {
	public static void main(String[] args) {
		FileSystemResource resource = new FileSystemResource("src/main/resources/applicationContext.xml");
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		factory.addBeanPostProcessor(new CustomBeanPostProcessor());
		MyLifeBean bean = (MyLifeBean) factory.getBean("myLifeBean");
		bean.sayHello();
		factory.destroyBean("myLifeBean", bean);
	}
}
