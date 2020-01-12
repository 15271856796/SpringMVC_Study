<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--请求参数绑定到基本类型,也就是用处理方法的基本类型参数来接收请求参数--%>

<a href="param/testParam?username=hehe&password=123">请求参数绑定到处理方法的基本类型上举例</a>
<br/>
<br/>
<br/>

<%--把请求数据封装到处理方法的Account类参数中--%>
<form action="param/saveAccount" method="post">
    姓名：<input type="text" name="username" /><br/>
    密码：<input type="text" name="password" /><br/>
    金额：<input type="text" name="money" /><br/>
    用户姓名：<input type="text" name="user.uname" /><br/>
    用户年龄：<input type="text" name="user.age" /><br/>
    <input type="submit" value="提交" />
</form>
<br/>
<br/>
<br/>

<%--把数据封装Account类中，类中存在list和map的集合属性--%>
<form action="param/saveAccount1list" method="post">
    姓名：<input type="text" name="username" /><br/>
    密码：<input type="text" name="password" /><br/>
    金额：<input type="text" name="money" /><br/>

    用户姓名：<input type="text" name="list[0].uname" /><br/>
    用户年龄：<input type="text" name="list[0].age" /><br/>

    用户姓名：<input type="text" name="map['one'].uname" /><br/>
    用户年龄：<input type="text" name="map['one'].age" /><br/>
    <input type="submit" value="提交" />
</form>
<br/>
<br/>
<br/>


<%--自定义类型转换器,前端传过来的参数都是String类型,springmvc会将大部分字符串转换成其余类型,
比如整型,但是有时候遇到Date类型的就无法转化成功,"2019/12/20"可以转化成功,但是"2019-12-20"就不一定转化的成功了--%>
<form action="param/saveUser" method="post">
    用户姓名：<input type="text" name="uname" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    用户生日：<input type="text" name="date" /><br/>
    <input type="submit" value="提交" />
</form>
<br/>
<br/>

<%--使用原生的API,HttpServletRequest request, HttpServletResponse response--%>
<a href="param/testServlet">ServerLet原生API使用,HttpServletRequest与HttpServletResponse</a>



</body>
</html>
