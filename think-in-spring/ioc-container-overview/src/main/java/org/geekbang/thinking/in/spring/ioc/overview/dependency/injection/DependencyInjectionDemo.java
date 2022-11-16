package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *依赖查找示例
 * 通过名称的方式来查找
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);
//        System.out.println(userRepository.getUsers());
        System.out.println(userRepository.getBeanFactory());
        System.out.println(beanFactory);
        System.out.println(userRepository.getBeanFactory().equals(beanFactory));
    }
}
