package org.geekbang.thinking.in.spring.ioc.overview.dependency.lookup;

import org.geekbang.thinking.in.spring.ioc.overview.annotation.Super;
import org.geekbang.thinking.in.spring.ioc.overview.demain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 *依赖查找示例
 * 通过名称的方式来查找
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-lookup-context.xml");
        lookupInRealTime(beanFactory);
        lookupInLazy(beanFactory);
        //按照类型查找
        lookupByType(beanFactory);
        //按类型查找集合对象
        lookupCollectionByType(beanFactory);
        //通过注解查找对象
        lookupByAnnotationType(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注@Super的用户"+users);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有User集合"+users);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找："+user);
    }

    private static void lookupInLazy(BeanFactory beanFactory){
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找："+user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory){
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找："+user);
    }

}
