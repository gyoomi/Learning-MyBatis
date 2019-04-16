/**
 * Copyright © 2019, LeonKeh
 * <p>
 * All Rights Reserved.
 */

package com.gyoomi.note.reflector;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;

/**
 * ObjectWrapper
 *     是对对象封装，抽象了对象的属性信息。通常用于查询的属性信息和更新对象属性信息
 *
 * @author Leon
 * @version 2019/4/16 11:10
 */
public class Main08ObjectWrapper {

    public static void main(String[] args) throws Exception {
        User user = new User();
        Order order = new Order();
        order.setId(11111);
        order.setOrderName("order111111");
        user.setOrder(order);
        MetaObject metaObject = MetaObject.forObject(user, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(), new DefaultReflectorFactory());
        Object value = metaObject.getValue("order.id");
        System.out.println(value);
        metaObject.setValue("order.id", 2222222);
        System.out.println(user);
    }

    static class User {
        private int id;
        private String name;
        private int age;
        private Order order;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }
    }

    static class Order {
        private int id;
        private String orderName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderName() {
            return orderName;
        }

        public void setOrderName(String orderName) {
            this.orderName = orderName;
        }
    }
}



















