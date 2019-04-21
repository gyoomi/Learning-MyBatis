## 绑定模块
### MapperRegister和MapperProxyFactory
- MapperRegister实现对所有的Mapper接口的管理
- 每个Mapper接口对应一个MapperProxyFactory。其中MapperProxyFactory用于生成相关的Mapper的代理实现类
（MapperProxy类）。
### MapperProxy
- 其实就是代理的invokerHandler接口的具体实现
### MapperMethod 
- 无状态，可以在多个对象之间共享
- 封装了Mapper接口中对应的方法信息，以及对应的SQL.
- MapperMethod可以看做Mapper接口和对应XML文件的桥梁
- MapperMethod -> SqlCommand (name、SqlCommandType) 
               -> MethodSignature(mapKey、ParamNameResolver:处理实参和形参之间的对应)

```
MapperRegister -> (config ,Map<Class<?>, MapperProxyFactory<?>> knownMappers)

MapperProxyFactory -> (Class<T> mapperInterface, Map<Method, MapperMethod> methodCache) MapperProxy


MapperMethod -> (SqlCommand (name、SqlCommandType) )
             -> (MethodSignature(mapKey、ParamNameResolver:处理实参和形参之间的对应))

             -> execute(SqlSession sqlSession, Object[] args)方法。
```

