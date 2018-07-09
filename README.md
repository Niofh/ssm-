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
