## Transaction事务
### 同样使用了工厂方法设计模式进行设计
### JDBCTransaction和JDBCTransactionFactory
适用jdbc自身的事务管理配置
### ManagedTransaction和ManagedTransactionFactory
其实commit、rollback都是空实现。其实其对事务的管理通过容器来管理的。比如
spring.

```
public interface TransactionFactory {
  
  // 配置TransFactory对象，一般紧跟在创建完成之后。完成对TransFactory的自定义配置
  void setProperties(Properties props);

  // 在指定的连接上创建Transaction对象
  Transaction newTransaction(Connection conn);
   
  // 从指定的数据源中获取数据库连接，并在此连接上设置事务级别及其他一些特性
  Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);

}
```

DBCTransactionFactory、ManagedTransactionFactory就是实现上述接口，创建了对应的对象。