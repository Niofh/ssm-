### ssm模板

##### 配置数据库事务，json转换，文件上传，mysql连接，mybatis

* interceptor 全局拦截器  https://www.cnblogs.com/daimajun/p/7172208.html
* converter 转换器 接受参数时候的转换  https://www.cnblogs.com/bignew/p/6627658.html
* model 实体类
* service 业务层
* controller 控制层
* dao 数据库层
* vo 包装结构

##### mapper 与dao名字要一样，自动映射，实现类不用写
* mybatis  https://blog.csdn.net/zjf280441589/article/details/50760236

##### 文件上传 
https://www.cnblogs.com/com-itheima-crazyStone/p/6739862.html

##### jsp/common.jsp 获取项目根路径

```xml
  <!--web.xml配置-->
<jsp-config>
        <jsp-property-group>
            <url-pattern>*.jsp</url-pattern>
            <!--引入根路径到jsp文件里 ${basePath}获取项目根路径-->
            <include-prelude>/WEB-INF/jsp/common.jsp</include-prelude>
        </jsp-property-group>
    </jsp-config>
```