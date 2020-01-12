# springmvc-
springmvc独立完整配置,包括pom.xml,web.xml,springmvc.xml,还包含类型转化器的配置
还包含springmvc中前端页面参数的接收和常用注解的说明
      ①index.jsp 和 HelloController 是为了测试springmvc是否配置成功
      ②jiecan.jsp和JieCanController 是为了讲解后端如何接收前端参数 直接项目跑起来后 url后面加jiecan.jsp看效果,因为jiecan.jsp直接放在了webapp下
      ③zhujie.jsp和ZhuJieControler  是为了讲解springmvc中常用注解  直接项目跑起来后 url后面加zhujie.jsp看效果,因为zhujie.jsp直接放在了webapp下
**注意:在复制springmvc的时候要注意,因为我配置了类型转换器,所以复制<mvc:annotation-driven conversion-service="conversionService"/>时,务必要
把src\main\java\cn\hdl\utils\StringToDate.java也复制到项目中,不然的话他不认识conversionService,如果不加类型转化器的话 就改成<mvc:annotation-driven/> 也行,这个时候就可以不复制StringToDate.java
