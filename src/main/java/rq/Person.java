package rq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by raoqi on 16/9/25.
 */
@Scope("prototype")
@Component("person")
public class Person {
    @Value("戴佳鑫")
    private String name;

    @Value("12")
    private int age;

    @Resource(name="book")
    private Book book;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", book=" + book +
                '}';
    }


    @PostConstruct
    public void init(){
        System.out.println("person 初始化!");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("person 销毁!");
    }
}
