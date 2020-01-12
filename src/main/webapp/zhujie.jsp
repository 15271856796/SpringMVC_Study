<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>
<body>

<%--常用的注解之RequestParam--%>
<a href="zhujie/testRequestParam?name=哈哈">RequestParam的使用</a>
</br>
</br>
</br>



RequestBody的使用
<%--常用的注解之RequestBody 获取请求体中的内容,也就是适用于post请求,不适用与get请求,get请求没有请求体--%>
<form action="zhujie/testRequestBody" method="post">
    用户姓名：<input type="text" name="username" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    <input type="submit" value="提交" />
</form>
</br>
</br>
</br>


<%--常用的注解之PathVariable 获取请求链接中值,这个值要和@requestmap去匹配的
 不能是这样<a href="zhujie/testRequestParam?age=10"> --%>
<a href="zhujie/testPathVariable/10">testPathVariable</a>
</br>
</br>
</br>


<%--常用的注解之RequestHeader,获取请求头中的内容,用的比较少--%>
<a href="zhujie/testRequestHeader">RequestHeader</a>
</br>
</br>
</br>


<%--常用的注解之CookieValue,获取浏览器中cookie的值,用的比较少--%>
<a href="注解/testCookieValue">CookieValue</a>
</br>
</br>
</br>

<%--常用的注解之ModelAttribute 模拟注解写在方法上,且有返回值--%>
<form action="zhujie/testModelAttribute" method="post">
    用户姓名：<input type="text" name="uname" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    <input type="submit" value="提交" />
</form>
</br>
</br>
</br>

<%--常用的注解之ModelAttribute 模拟注解写在方法上,且没有返回值--%>
<form action="zhujie/testModelAttribute1" method="post">
    用户姓名：<input type="text" name="uname" /><br/>
    用户年龄：<input type="text" name="age" /><br/>
    <input type="submit" value="提交" />
</form>
</br>
</br>
</br>

<%--常用的注解之SessionAttributes 往session中放值,不借助与severlet--%>
<a href="zhujie/testSessionAttributes">testSessionAttributes</a>
</br>
</br>
</br>
<%--获取session中的值--%>
<a href="zhujie/getSessionAttributes">getSessionAttributes</a>

<%--手动删除session中的值--%>
<a href="zhujie/delSessionAttributes">delSessionAttributes</a>


</body>
</html>
