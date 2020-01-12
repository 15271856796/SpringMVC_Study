package cn.hdl.controller;


import cn.hdl.domain.Account;
import cn.hdl.domain.Account1;
import cn.hdl.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class JieCanController {

    /**
     * 将请求参数绑定到基本类型,只需要处理方法的参数名与请求参数名保持一致就行
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("执行了...");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        return "success";
    }



    /**
     * 请求参数绑定把数据封装到JavaBean的类中,会将请求参数中与属性名一致的进行赋值
     * Javabean中也可以有对象属性,同样可以进行赋值
     * 比如Account中有User属性,同样进行了赋值,可以看一下前端表单如何命名的 <input type="text" name="user.age" />
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("执行了...");
        System.out.println(account);
        return "success";
    }



    /**
     * 请求参数绑定把数据封装到JavaBean的类中,
     * Account1 类中有list与map类型时,如何将数据封装到集合中呢?
     * 可以看一下前端表单如何命名的 <input type="text" name="list[0].uname" /><br/>
     *                              <input type="text" name="list[0].age" /><br/>
     *                              <input type="text" name="map['one'].uname" /><br/>
     *                              <input type="text" name="map['one'].age" /><br/>
     *
     * @return
     */
    @RequestMapping("/saveAccount1list")
    public String saveAccountlist(Account1 account){
        System.out.println("执行了...");
        System.out.println(account);
        return "success";
    }



    /**
     * 自定义类型转换器,User中有一个属性是Date类型,
     * 前端传过来都是字符串型,springmvc基本实现所有的数据转换,比如字符串类型转整型,
     * 但是如果前端是"2019/12/20"可以正确的转换成Date,但是其余形式,比如"2019-12-20"不一定可以成功转换
     * 在springmvc.xml中加了一个类型转换器,并将其开启
     *
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("执行了...");
        System.out.println(user);
        return "success";
    }



    /**
     * 原生的API
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了...");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);

        System.out.println(response);
        return "success";
    }

}
