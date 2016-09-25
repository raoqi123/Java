package rq;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Created by raoqi on 16/9/25.
 */
@WebServlet(name="hello",urlPatterns="/hello")
public class HelloServlet extends javax.servlet.http.HttpServlet {

    //这里的先后顺序不一样,如果是先创建HelloServlet对象,在读取
    //@Resource(name="person")
    private Person person;

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
//      ApplicationContext applicationContext = (ApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());

        response.getWriter().write(applicationContext.hashCode()+" \n");
        this.person = (Person) applicationContext.getBean("person");
        response.getWriter().write(this.person.toString());
    }



    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }
}
