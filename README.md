### ssm模板

##### 配置数据库事务，json转换，文件上传，mysql连接，mybatis

* interceptor 全局拦截器  https://www.cnblogs.com/daimajun/p/7172208.html
* converter 转换器 接受参数时候的转换  https://www.cnblogs.com/bignew/p/6627658.html
* common 公共类和方法
* model 实体类
* service 业务层
* controller 控制层
* filter 过滤器
* dao 数据库层 
* vo 值对象   与form表单的属性一直
* dto 数据传输对象 用于给dao做参数
* task 定时任务的封装

##### mapper 与dao名字要一样，自动映射，实现类不用写
* mybatis  https://blog.csdn.net/zjf280441589/article/details/50760236

##### vo,dto,dao之间的关系
* https://blog.csdn.net/wangxin1982314/article/details/51954264

##### 对象合并BeanUtils.copyProperties，但是有个缺点null也一起合并进来
BeanUtils.copyProperties(oldBean,newBean);

解决合并null的方法
```
public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void copyPropertiesIgnoreNull(Object src, Object target){
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }
    
```


##### @JsonInclude(JsonInclude.Include.NON_NULL) 注解
bean对象的null值属性不返回出去

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

##### JSR30验证传递值  
https://blog.csdn.net/yangshangwei/article/details/79381009

#### 解决get中文乱码的问题
tomcat config/server.xml文件 找到 Connector 添加属性 URIEncoding="UTF-8"

#### mysql一些基础sql
https://blog.csdn.net/youyou_yo/article/details/48678143

#### idea控制台乱码解决 
https://www.cnblogs.com/fanlinglong/p/6717515.html

#### log4j2 详细配置
https://blog.csdn.net/vbirdbest/article/details/71751835

#### log4j2配合mybatis打印sql语句
https://blog.csdn.net/honghailiang888/article/details/52594014

#### spring调度任务（定时任务）Task 简单版的Quartz
https://www.cnblogs.com/hongwz/p/5642497.html

#### 国际化语言配置
https://blog.csdn.net/x_iya/article/details/71335917 针对页面
https://blog.csdn.net/yangshangwei/article/details/77075833  针对controller

#### 分页效果 StudentController

#### mybatis教程(七) 分页教程
https://blog.csdn.net/yuchao2015/article/details/55001182

####  @ResponseBody返回字符串乱码解决
@RequestMapping(value = "/xxx", produces = "application/json; charset=utf-8")

#### common/BaseEntity  每一个model实体类都要继承基础数据，而且数据库每张表都要定义基础数据
https://blog.csdn.net/baidu_32682229/article/details/76822826 MySQL--创建时间和更新时间字段