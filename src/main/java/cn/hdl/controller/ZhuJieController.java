package cn.hdl.controller;

import cn.hdl.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用的注解
 */
@Controller
@RequestMapping("/zhujie")
@SessionAttributes(value={"msg"})   // Model底层只会把数据存在request域中,所以想把msg=美美存入到session域对中
public class ZhuJieController {


    /**
     * 当请求参数名与处理方法名不一致的时候,用@RequestParam将请求参数赋值给处理参数
     * 下面的例子就是将请求参中的name参数,封装到处理参数username(其实请求参数名与处理方法名一致的时候就可以直接封装)
     * @return
     */

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name="name") String username){
        System.out.println("执行了...");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取到请求体的内容
     * 不能直接写String body 是因为会让它以为你是想接收名为body的请求参数,所以想要整个请求体的话,就得加@requestbody
     * @return
     */

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){     /*不能直接写String body 是因为会让它以为你是想接收名为body的请求参数,所以想要整个请求体的话,只能加@requestbody*/
        System.out.println("执行了...");
        System.out.println(body);   /*username=hdl&age=12 也就是key=value形式*/
        return "success";
    }

    /**
     * PathVariable注解 获取请求链接中的值 比如<a href="zhujie/testPathVariable/10">
     * @return
     */
    @RequestMapping(value="/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name="sid") String id){
        System.out.println("执行了...");
        System.out.println(id);
        return "success";
    }



    /**
     * 获取请求头的值
     * 下面的例子是获取请求头中Accept的内容,用的比较少
     * @param header
     * @return
     */
    @RequestMapping(value="/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value="Accept") String header){
        System.out.println("执行了...");
        System.out.println(header);
         return "success";
        // response.sendRedirect(request.getContextPath()+"/anno/testCookieValue");
        //return "redirect:/param.jsp";
    }



    /**
     * 获取Cookie的值,用的比较少
     * @return
     */
    @RequestMapping(value="/testCookieValue")
    public String testCookieValue(@CookieValue(value="JSESSIONID") String cookieValue){
        System.out.println("执行了...");
        System.out.println(cookieValue);
        return "success";
    }


    /**
     * @ModelAttribute注解,加在方法上,那意味着这个会优先于任何的处理方法执行,参数与表单参数保持一致的时候也可以直接接收参数
     * 主要的应用场景:当表单提交数据不是完整的实体类数据时,保证没有提交数据的字段使用数据库对象原来的数据
     *下面演示的是 @ModelAttribute 加在方法上,且有返回值
     * @return
     */
    @RequestMapping(value="/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);      /* User{uname='123', age=12, date=Sun Jan 12 15:50:34 CST 2020}*/
        return "success";
    }

    @ModelAttribute
    public User showUser(String uname){
        System.out.println("showUser执行了...");
        // 通过用户查询数据库（模拟数据库通过uname查询记录）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }


    /**
    * 主要的应用场景:当表单提交数据不是完整的实体类数据时,保证没有提交数据的字段使用数据库对象原来的数据
     *下面演示的是 @ModelAttribute 加在方法上,且没有返回值时候怎么处理,这个时候需要引进一个map
     * @return
     */

    @RequestMapping(value="/testModelAttribute1")
    public String testModelAttribute1(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void showUser(String uname, Map<String,User> map){
        System.out.println("showUser执行了...");
        // 通过用户查询数据库（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(10);
        user.setDate(new Date());
        map.put("abc",user);
    }


    /**
     * SessionAttributes的注解,只能写在类上,用于把指定的值放入session域中,实现数据共享
     * @return
     */
    @RequestMapping(value="/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes...");
        // 底层会存储到request域对象中,想要存到session域中还需要在类上加注解 @SessionAttributes(value={"msg"})
        model.addAttribute("msg","美美");
        return "success";
    }

    /**
     * 获取session中的值,使用ModelMap,当没有某个值时,session也不会报错,只会是null
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除session域中的值,使用SessionStatus
     * @param status
     * @return
     */
    @RequestMapping(value="/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("getSessionAttributes...");
        status.setComplete();  /*删除session域中全部内容*/
        return "success";
    }

}














